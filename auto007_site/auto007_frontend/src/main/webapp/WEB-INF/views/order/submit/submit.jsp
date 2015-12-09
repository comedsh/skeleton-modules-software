<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<script type="text/javascript" src="/resources/js/lib/fenghua.lib.min.js"></script>
<c:choose>
   <c:when test="${errorMsg == null}">  
<div align="center" id="div_order_submit"
	style="min-height: 200px;padding-top: 50px; padding-left: 50px; min-width: 400px;max-width: 990px; display: none}}"
	ng-app="shoppingCartApp" ng-controller="shoppingCartListController">
	<div ng-repeat="errorMsg in errorMessages" align="left">
		<h2>错误信息：</h2>
		<ul>
			<li>
				<h3 style="color: red">{{errorMsg}}</h3>
			</li>
		</ul>
	</div>
	<div ng-repeat="msg in messages" align="left">
		<h2>普通消息：</h2>
		<ul>
			<li>
				<h3 style="color: blue">{{msg}}</h3>
			</li>
		</ul>
	</div>
	<div id="address_edit_div" style="display: {{!!editUserAddress ? 'block':'none'}}">
		<h2>编辑地址：</h2>
		<strong>别名</strong><input type="text" ng-model="address.alias" style="width: 200px;"><br>
		<strong>收货联系人</strong><input type="text" ng-model="address.receiverName" style="width: 200px;"><br>
		<strong>电话</strong><input type="text" ng-model="address.receiverMobile" style="width: 200px;"><br>
		<strong>省份</strong>
   	    <select ng-change="findCity()" ng-model="address.provinceId" 
   	   		ng-options="o.id as o.name for o in provinceList">
        </select>
		<strong>城市</strong>
		<select ng-change="findArea()" ng-model="address.cityId" 
    	   	ng-options="o.id as o.name for o in cityList">
        </select>
           	   <br>
		<strong>行政区</strong>
		<select ng-model="address.areaId" 
    	   	ng-options="o.id as o.name for o in areaList">
        </select><br>
		<strong>详细地址</strong><input type="text" ng-model="address.detailAddr" style="width: 200px;"><br>
		
		<a href="#" ng-click="saveAddress()">保存</a>
	</div>
	<div align="left">
		<h2>收货人信息：<a href="#" ng-click="addAddress()">添加新地址</a></h2>
		<ul>
			<li ng-repeat="addressItem in addressList" >
				<table width="100%">
					<tr>
						<td width="15%"><label><input type="radio" name="userAddressId" ng-model="orderSubmitObj.userAddressId" value="{{addressItem.id}}">
						<strong>{{!!addressItem.defaultAddr ? addressItem.alias+'【默认】' : addressItem.alias}}</strong></label></td>
						<td width="15%">{{addressItem.receiverName}}</td>
						<td width="50%">{{addressItem.address}}  {{addressItem.receiverMobile}}</td>
						<td width="20%">
							<a href="#" ng-click="defaultAddress(addressItem.id)" style="display: {{!!addressItem.defaultAddr ? 'none':'block' }}">设为默认</a>
							<a href="#" ng-click="editAddress(addressItem.id)">编辑</a>
							<a href="#" ng-click="deleteAddress(addressItem.id)">删除</a>
						</td>
					</tr>
				</table>
			</li>
		</ul>
	</div>
	<div align="left">
		<h2>支付方式：</h2>
		<ul>
			<li ng-repeat="payMethodItem in paymentTypeList" >
				<label><input type="radio" value="{{payMethodItem.id}}" name="paymentType" ng-model="orderSubmitObj.paymentType"><strong>{{payMethodItem.typename}}</strong>    {{payMethodItem.description}}</label> <br>
			</li>
		</ul>
	</div>
	<div align="left">
		<h2>发票信息：</h2>
		<label><input type="checkbox" name="invoiceFlag" ng-model="orderSubmitObj.invoiceFlag" ng-change="clickInvoice()">需要发票信息</label>
		<div style="display: {{!!orderSubmitObj.orderInvoice ? 'block':'none'}}">
			<strong>{{orderSubmitObj.orderInvoice.invoiceType == 1 ? '普通发票（纸质）': '增值税发票'}}</strong>  
			{{orderSubmitObj.orderInvoice.title}}  {{orderSubmitObj.orderInvoice.content}}  <a ng-href="" ng-click="editInvoice()">修改</a>
		</div>
		<div style="display: {{isEditingInvoice ? 'block':'none'}}">
			<ul>
				<li>
					<label>
						<input type="radio" ng-change="invoiceTypeChange(1)" value="1" name="orderSubmitObj.orderInvoice.invoiceType" ng-model="orderSubmitObj.orderInvoice.invoiceType">
						<strong>普通发票</strong>
					</label>
				</li>
				<li>
					<label>
						<input type="radio" value="2" ng-change="invoiceTypeChange(2)" name="orderSubmitObj.orderInvoice.invoiceType" ng-model="orderSubmitObj.orderInvoice.invoiceType">
						<strong>增值税发票</strong>
					</label>
				</li>
			</ul>
			<div style="display: {{ orderSubmitObj.orderInvoice.invoiceType == 1 ? 'block':'none'}}">
				<ul>
					<li ng-repeat="invTitle in invoiceTitleList">
						<table>
							<tr>
								<td>
									<label ng-click="selectInvoiceTitle(invTitle)" 
										style="{{orderSubmitObj.orderInvoice.title == invTitle.title ? 'background-color: blue;color: white;' : ''}};display: {{ invTitle.editing ? 'none':'block'}}">
										<strong>{{invTitle.title}}</strong>
									</label>
									<input style="display: {{ !!invTitle.editing ? 'block':'none'}}" ng-model="invTitle.title" type="text">
								</td>
								<td nowrap="nowrap">
									<a style="display: {{ invTitle.title == '个人' ? 'none':'block'}}"
										ng-href="" ng-click="deleteInvoiceTitle(invTitle,$index)">删除</a>
									<a style="display: {{ invTitle.editing || invTitle.title == '个人' ? 'none':'block'}}"
										ng-href="" ng-click="editInvoiceTitle(invTitle)">编辑</a>
									<a style="display: {{ invTitle.title == '个人' ? 'none':'block'}}"
										ng-href="" ng-click="saveInvoiceTitle(invTitle)">保存</a>
								</td>
							</tr>
						</table>
					</li>
				</ul>
				<a ng-href="" ng-click="newInvoiceTitle()">新增发票抬头</a>
			</div>
			<div style="display: {{ orderSubmitObj.orderInvoice.invoiceType == 2 ? 'block':'none'}}">
				<label style="display: {{!!vatInvoiceObj ? 'none':'block'}}">您没有审核通过的增值税发票信息</label>
				<table style="display: {{!!vatInvoiceObj ? 'block':'none'}}">
					<tr>
						<th align="right">所在部门：</th>
						<td align="left">{{vatInvoiceObj.companyName}}</td>
					</tr>
					<tr>
						<th align="right">纳税人识别码：</th>
						<td align="left">{{vatInvoiceObj.taxpayerNumber}}</td>
					</tr>
					<tr>
						<th align="right">注册地址：</th>
						<td align="left">{{vatInvoiceObj.registerAddress}}</td>
					</tr>
					<tr>
						<th align="right">注册电话：</th>
						<td align="left">{{vatInvoiceObj.registerPhone}}</td>
					</tr>
					<tr>
						<th align="right">开户银行：</th>	
						<td align="left">{{vatInvoiceObj.bankName}}</td>
					</tr>
					<tr>
						<th align="right">银行账户：</th>
						<td align="left">{{vatInvoiceObj.bankAccount}}</td>
					</tr>
					<tr>
						<th align="right">收票联系人：</th>
						<td align="left"><input ng-model="orderSubmitObj.orderInvoice.recContact"></td>
					</tr>
					<tr>
						<th align="right">收票联系电话：</th>
						<td align="left"><input ng-model="orderSubmitObj.orderInvoice.recContactPhone"></td>
					</tr>
					<tr>
						<th align="right">地址：</th>
						<td align="left"><input ng-model="orderSubmitObj.orderInvoice.recAddress"></td>
					</tr>
					<tr>
						<th align="right">邮编：</th>
						<td align="left"><input ng-model="orderSubmitObj.orderInvoice.recZipcode"></td>
					</tr>
				</table>
			</div>
			<ul>
				<li>
					<label>
						<input type="radio" value="1" ng-change="changeContent('明细')" name="orderSubmitObj.orderInvoice.contentType" ng-model="orderSubmitObj.orderInvoice.contentType">
						<strong>明细</strong>
					</label>
				</li>
				<li>
					<label>
						<input type="radio" value="2" ng-change="changeContent('汽车配件')" name="orderSubmitObj.orderInvoice.contentType" ng-model="orderSubmitObj.orderInvoice.contentType">
						<strong>汽车配件</strong>
					</label>
				</li>
			</ul>
			<button ng-click="saveInvoice()">保存</button>
		</div>
	</div>
	<div>
		<table width="100%">
			<thead style="background-color: gray;color: white;">
				<th align="left">配送方式</th>
				<th align="left">商品信息</th>
			</thead>
			<tbody ng-repeat="orderHeader in orderSubmitObj.orderHeaders">
				<tr>
					<td width="15%" valign="top" align="left">
						<label><input type="radio" name="deliveryMethod{{$index}}" value="1"  ng-model="orderHeader.deliveryMethod"><strong>送货上门</strong></label><br>
						<label><input type="radio" name="deliveryMethod{{$index}}" value="2" ng-model="orderHeader.deliveryMethod"><strong>上门自提</strong></label><br>
						<strong>添加订单备注：</strong> <br>
						<textarea rows="5" cols="" style="width: 100%" ng-model="orderHeader.remark">
							
						</textarea>
					</td>
					<td width="85%" valign="top">
						<table width="100%">
						  <thead style="background-color: gray;color: white;">
					  		<th align="center">商品详情</th>
					  		<th align="left">单价/元 </th>
					  		<th align="left">数量</th>
					  		<th align="left">总价</th>
					  	 </thead>
					  	 <tbody>
					  	 	<tr>
							    <th align="left" colspan="6">
							    	<strong>卖家：{{orderHeader.seller.name}}</strong>  
							    </th>
							 </tr>
							 <tr ng-repeat="item in orderHeader.items">
							 	<td align="left">
							 		<table>
									  <tr>
									    <td>
									    	<a href="/product/{{item.sku.id}}" target="_blank">
									    		<img alt="" src="{{item.skuIcon}}">
									    	</a>
									    </td>
									    <td>
									    	品牌：<strong>{{item.brand}}</strong> <br>
									    	名称：<strong>{{item.skuCode}} {{item.skuName}}</strong><br>
									    	OE码：<strong>{{item.skuCode}} {{item.skuCode}} {{item.skuCode}} {{item.skuCode}} </strong>
									    </td>
									  </tr>
									</table>
							 		
							 	</td>
							 	<td align="left">
							 		{{item.tradePrice}}
							 	</td>
							 	<td align="left">
							 		{{item.qty}}
							 	</td>
							 	<td align="left">
							 		{{item.totalAmount}}
							 	</td>
							 </tr>
					  	 </tbody>
					  	</table>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<table width="100%">
			<tr>
	  			<td  align="right" width="70%"><strong>商品数量：</strong></td>
	  			<td> {{orderSubmitObj.totalQty}} </td>
	  		</tr>
	  		<tr>
				<td align="right" width="70%"><strong>商品总金额：</strong></td>
				<td>￥ {{orderSubmitObj.totalAmount.toFixed(2)}} </td>
			</tr>
	  		<tr>
				<td align="right" width="70%"><strong>优惠金额：</strong></td>
				<td> ￥{{orderSubmitObj.discountAmount.toFixed(2)}} </td>
			</tr>
	  		<tr>
				<td align="right" width="70%"><strong>运费：</strong></td>
				<td> ￥{{orderSubmitObj.transportAmount.toFixed(2)}} </td>
			</tr>
	  		<tr>
				<td align="right" width="70%"><strong>应付总金额：</strong></td>
				<td> ￥{{orderSubmitObj.needPayAmount.toFixed(2)}} </td>
			</tr>
	  		<tr>
	  			<td  align="right" valign="middle" width="70%">
	  				<strong>应付总金额：</strong>￥{{orderSubmitObj.needPayAmount.toFixed(2)}}
	  			</td>
	  			<td align="left" width="30%">
	  			<a href="#" ng-click="submitOrder()">
	  				<div style="background-color: red;color: white;min-width: 100px;min-height: 80px;" align="center">
	  					<h2>提交订单</h2>
	  				</div>
	  			</a>
	  			</td>
	  		</tr>
		</table>
	</div>
</div>

<script type="text/javascript">
   angular.module('shoppingCartApp', [])
      .controller('shoppingCartListController', function($scope,$http) {   
	   $scope.editUserAddress = false;  	
       $scope.orderSubmitObj = {};
       $scope.provinceList = [];
       $scope.cityList = [];
       $scope.areaList = [];
       $scope.errorMessages = [];
       $scope.messages = [];
       $scope.addressList = [];
       $scope.address = {};
       $scope.paymentTypeList = [];
       $scope.isEditingInvoice = false;
   	   $scope.init = function() {
           var orderMTO = ${orderSubmitDTOJson};
           $scope.errorMessages = orderMTO.errorMessages;
           $scope.messages = orderMTO.messages;
           if(orderMTO.success) {
        	   $scope.orderSubmitObj = orderMTO.data.masterSubmit;
        	   $scope.addressList = orderMTO.data.addressList;
        	   $scope.paymentTypeList = orderMTO.data.paymentTypeList;
           }
           $("#div_order_submit").show();
       };
       $scope.init();
       
       $scope.submitOrder = function() {
    	   console.log("submitOrder "+$scope.orderSubmitObj);
    	   $http({
	   			method:'POST',
	   			url:"/order/submit",
	   			data: $scope.orderSubmitObj,
	   			headers: {'Content-Type': 'application/json'}
  			}).success(function(data){
  				if(data.success) {
  					var masterNo = "";
  					angular.forEach(data.data, function(masterOrder){
  						masterNo = masterNo+","+masterOrder.masterOrderNo
  					});
  					alert("提交成功，主订单号："+masterNo);
  					console.log("submitOrder "+data.data.length +" "+data.data[0].paymentType);
  					if(data.data.length == 1 && data.data[0].paymentType == 1) {
  						console.log( "/finance/payment/gen?orderId="+data.data[0].masterOrderId);
  						window.location = "/finance/payment/gen?orderId="+data.data[0].masterOrderId;
  					} else {
  						window.location = "/order/list";
  					}
  				} else {
  					alert("提交失败！");
  				}
  			});
       }
       
       $scope.clickInvoice = function(){
    	   console.log("clickInvoice "+$scope.orderSubmitObj.invoiceFlag);
    	   if($scope.orderSubmitObj.invoiceFlag) {
    		   $scope.orderSubmitObj.orderInvoice = {invoiceType: 1, contentType: 2, title: '个人', content:"汽车配件"};
    	   } else {
    		   $scope.orderSubmitObj.orderInvoice = null;
    	   }
       }
       
       $scope.findPtInvoice = function() {
    	   $scope.orderSubmitObj.orderInvoice.valueAddId = null;
    	   $scope.invoiceTitleList = [];
    	   $http({
	   			method:'GET',
	   			url:"/order/invoice/title",
	   			headers: {'Content-Type': 'application/json'}
			}).success(function(data){
				if(data.success) {
					$scope.invoiceTitleList = data.data;
  				} else {
  					alert(data.errorMsg);
  				}
			});
       };
       
       $scope.findVatInvoice = function() {
    	   $scope.vatInvoiceObj = null;
    	   $http({
	   			method:'GET',
	   			url:"/order/invoice/vat",
	   			headers: {'Content-Type': 'application/json'}
			}).success(function(data){
				if(data.success) {
					$scope.vatInvoiceObj = data.data;
					if(!!data.data) {
						$scope.orderSubmitObj.orderInvoice.valueAddId = $scope.vatInvoiceObj.id;
						$scope.orderSubmitObj.orderInvoice.title = $scope.vatInvoiceObj.companyName;
					}
  				} else {
  					alert(data.errorMsg);
  				}
			});
       };
       
       $scope.invoiceTypeChange = function(invType) {
    	   $scope.orderSubmitObj.orderInvoice.invoiceType = invType;
    	   if($scope.orderSubmitObj.orderInvoice.invoiceType == 1) {
    		   $scope.findPtInvoice();
    	   } else {
    		   $scope.findVatInvoice();
    	   }
       };
       $scope.editInvoice = function() {
    	   $scope.isEditingInvoice = true;
    	   $scope.invoiceTypeChange($scope.orderSubmitObj.orderInvoice.invoiceType);
       };
       
       $scope.selectInvoiceTitle = function(invTitle) {
    	   $scope.orderSubmitObj.orderInvoice.title = invTitle.title;
       };
       $scope.changeContent = function(content) {
    	   $scope.orderSubmitObj.orderInvoice.content = content;
       };
       $scope.saveInvoice = function() {
    	   $scope.isEditingInvoice = false;
       };
       $scope.deleteInvoiceTitle = function(invTitle, index) {
    	   if(!!!invTitle.id) {
    		   $scope.invoiceTitleList.splice(index,1);
    	   } else {
    		   $http({
   	   			method:'DELETE',
   	   			url:"/order/invoice/title?titleId="+invTitle.id,
   	   			headers: {'Content-Type': 'application/json'}
	   			}).success(function(data){
	   				if(data.success) {
	   					$scope.invoiceTitleList.splice(index,1);
	   				} else {
	   					alert(data.errorMsg);
	   				}
	   			});
    	   }
       };
       $scope.editInvoiceTitle = function(invTitle) {
    	   invTitle.editing = true;
       };
       $scope.saveInvoiceTitle = function(invTitle) {
    	   if(!!invTitle.title) {
    		   $http({
      	   			method:'POST',
      	   			url:"/order/invoice/title",
      	   			data:invTitle,
      	   			headers: {'Content-Type': 'application/json'}
   	   			}).success(function(data){
   	   				if(data.success) {
   	   					if(!!data.data.id && data.data.id > 0) {
   	   						invTitle.id = data.data.id;
   	   						invTitle.editing = false;
   	   						$scope.orderSubmitObj.orderInvoice.title =invTitle.title;
   	   					}
   	   				} else {
   	   					alert(data.errorMsg);
   	   				}
   	   			});
    	   }
       };
       $scope.newInvoiceTitle = function() {
    	   if(!!!$scope.invoiceTitleList) {
    		   $scope.invoiceTitleList = [];
    	   }
    	   if($scope.invoiceTitleList.length >= 10) {
    		   alert("超出了发票抬头数量上线 10 条，不能新增发票抬头！");
    	   } else {
    		   $scope.invoiceTitleList.push({title:"",editing:true});
    	   }
       };
       $scope.findProvince = function() {
    	   $http({
	   			method:'GET',
	   			url:"/cityArea/selectProvince",
	   			headers: {'Content-Type': 'application/json'}
 			}).success(function(data){
 				$scope.provinceList = data;
 				$scope.cityList= [];
 			});
       }
       $scope.findCity = function() {
    	   $http({
	   			method:'GET',
	   			url:"/cityArea/selectCity?parentId="+$scope.address.provinceId,
	   			headers: {'Content-Type': 'application/json'}
			}).success(function(data){
		        $scope.cityList = data;
		        $scope.areaList = [];
			});
       }
       
		$scope.findArea = function() {
			$http({
	   			method:'GET',
	   			url:"/cityArea/selectArea?parentId="+$scope.address.cityId,
	   			headers: {'Content-Type': 'application/json'}
			}).success(function(data){
		        $scope.areaList =data;
			});
        }
		$scope.findCityArea = function() {
    	   $http({
	   			method:'GET',
	   			url:"/cityArea/selectProvince",
	   			headers: {'Content-Type': 'application/json'}
 			}).success(function(data){
 				$scope.provinceList = data;
 				$scope.cityList= [];
 				$http({
 		   			method:'GET',
 		   			url:"/cityArea/selectCity?parentId="+$scope.address.provinceId,
 		   			headers: {'Content-Type': 'application/json'}
 				}).success(function(data){
 			        $scope.cityList = data;
 			        $scope.areaList = [];
 			       $http({
 			   			method:'GET',
 			   			url:"/cityArea/selectArea?parentId="+$scope.address.cityId,
 			   			headers: {'Content-Type': 'application/json'}
 					}).success(function(data){
 				        $scope.areaList =data;
 					});
 				});
 			});
       }
        $scope.addAddress = function() {
        	$scope.findProvince();
        	$scope.address = {};
        	$scope.editUserAddress = true;  	
        }
       
		$scope.editAddress = function(addressId) {
        	$scope.address = {};
        	$http({
	   			method:'GET',
	   			url:"/order/address/"+addressId,
	   			headers: {'Content-Type': 'application/json'}
			}).success(function(data){
				if(data.success) {
					$scope.address = data.data;
					$scope.editUserAddress = true;  
					$scope.findCityArea();
				} else {
					$scope.address = {};
					$scope.editUserAddress = false;  
					alert(data.errorMessage);
				}
			});
		}
		       
		$scope.deleteAddress = function(addressId) {
			$http({
	   			method:'GET',
	   			url:"/order/address/delete/"+addressId,
	   			headers: {'Content-Type': 'application/json'}
			}).success(function(data){
				if(data.success) {
					$scope.addressList = data.data;
				} else {
					alert(data.errorMessage);
				}
			});
		}
		$scope.defaultAddress = function(addressId) {
			$http({
	   			method:'GET',
	   			url:"/order/address/default/"+addressId,
	   			headers: {'Content-Type': 'application/json'}
			}).success(function(data){
				if(data.success) {
					$scope.addressList = data.data;
				} else {
					alert(data.errorMessage);
				}
			});
		}
		$scope.saveAddress = function() {
			$http({
	   			method:'POST',
	   			url:"/order/address",
	   			data:$scope.address,
	   			headers: {'Content-Type': 'application/json'}
			}).success(function(data){
				if(data.success) {
					$scope.addressList = data.data;
					$scope.address = {};
					$scope.editUserAddress = false; 
				} else {
					alert(data.errorMessage);
				}
			});
		}
       
      });
</script>
   </c:when>
   <c:otherwise> 
   		<h1 style="color: red;">
   			${errorMsg }
   		</h1>
   </c:otherwise>
</c:choose>
