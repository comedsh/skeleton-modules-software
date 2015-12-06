<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品列表</title>

</head>
<body ng-app="seller-app" ng-controller="sellerController">
  <div style="margin-top: 20px">
   <span>OE/商品名称/SKU 编号<input type="text"  ng-model=productName
   ><button type="button" ng-click="query()">搜索</button>
   </span>
  </div>
   <div style="margin-top: 20px">
      <span>发布时间
    <select ng-options="option.id as option.name for option in selectedDate" 
       ng-model="publishTime" ng-change="query()">
     </select>
     </span>
      <span>商品类目
    <select ng-options="option.id as option.name for option in selectedCatalog" 
       ng-model="catalogId" ng-change="query()">
     </select>
     </span>
      <span>商品状态
    <select ng-options="option.id as option.name for option in selectedStatus" 
       ng-model="productStatus" ng-change="query()">
     </select>
     </span>
   </div>
  <table>
   <tr>
     <td>发布时间</td>
     <td>商品详情</td>
     <td>商品类目</td>
     <td>SKU编号</td>
     <td>单价</td>
     <td>商品状态</td>
     <td>操作</td>
   <tr>
 <tr ng-repeat="item in items">
   <td>{{item.createTime}}</td>
   <td>
     <span><img src="{{item.url}}"></span>
     <span>{{item.brand}} / {{item.name}}</span>
     <span> OE号: {{item.defaultOe}}</span>
     <a href="#" ng-click="queryOe(item.id)" ng-show="{{item.oeSize>1}}">更多OE...</a>         
     </td>
    <td>
    <span ng-repeat=" it in item.catalogList">
     {{it}}
    </span>
  
     </td>
      <td>{{item.skuNo}}</td>
        <td>{{item.price}}</td>
         <td>{{item.statusName}}</td>
          <td>
          <!-- 上架状态不能编辑 -->
          <a href="#" ng-show="{{item.status != 2 && item.status !=4}}">编辑</a><br/>    
          <!-- 删除商品不能上架 -->     
          <a href="#" ng-show="{{item.status != 4 && item.status !=2}}" ng-click="upShelf(item)">上架</a><br/>
          <!-- 上架商品 能下架 -->
          <a href="#" ng-show="{{item.status == 2 && item.status !=4}}" ng-click="downShelf(item)">下架</a><br/>
          <!-- 上架商品不能删除 -->
          <a href="#"  ng-show="{{item.status != 2 && item.status !=4}}" ng-click="deleteItem(item)">删除</a></td>
 </tr>
  </table>
  
  
  <div>
  <h3>OE列表显示：</h3>
  <table>
   <tr ng-repeat="item in oeListItems">
    <td>{{item.brand}}</td>
     <td ng-repeat="it in item.oeItems"> 
     {{it.oe}}
     </td>   
   </tr>
  </table>
  
  </div>
<script type="text/javascript"src="/resources/javaScript/angular/angular.min.js"></script>
<script type="text/javascript"src="/resources/javaScript/jQuery/jquery-1.11.1.min.js"></script>
 <script type="text/javascript">
 angular.module('seller-app', [])
 .controller('sellerController', function($scope,$http) {      	
	   $scope.getQuery=  function(url,callback){
		  $http.get(url).success(function(data){ 
			  callback(data);
        });
	   };
	   
	  
	   $scope.getQuery('/product/dropmenu/date/',function(data){	   
		   $scope.selectedDate = data;
	   });
	   
      $scope.getQuery('/product/dropmenu/status/',function(data){		   
		   $scope.selectedStatus = data;
	   });
      
      $scope.getQuery('/product/dropmenu/catalog/',function(data){		
		   $scope.selectedCatalog = data;
	   });
      
      $scope.getQuery('/product/manage/query/',function(data){		
    	  $scope.items = data;
	   });

			  
       $scope.publishTime='';
	   $scope.productStatus='';
	   $scope.catalogId='';
	   $scope.productName='';
	   $scope.query=function(){
		   $http.get('/product/manage/query',
				   {params:{name:$scope.productName,publishTime:$scope.publishTime,
					   catalogId:$scope.catalogId,
					   status: $scope.productStatus}}
		   ).success(function(data){ 
			   $scope.items = data;
	        });
	   };
	   
	   
	   $scope.queryOe =function(id){
		   $http.get('/productOe/'+id
		   ).success(function(data){ 
			   $scope.oeListItems = data;
	        });
		  
	   };
	   
	   $scope.upShelf=function(item){
		   var ids=[];
		   ids.push(item.id);
		   $http.post('/product/shelfUp/',
   				{
   					'ids' :ids
   				},
   				{
   					headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
   					transformRequest: function(data){
   						return $.param(data);
   					}
   				}
   		)
   		.success(function(data){
   			alert(data.messages[0].message);
   		})
	   };
	   $scope.downShelf=function(item){
		   var ids=[];
		  
		   ids.push(item.id);
		   $http.post('/product/shelfDown/',
   				{
   					'ids' :ids
   				},
   				{
   					headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
   					transformRequest: function(data){
   						return $.param(data);
   					}
   				}
   		)
   		.success(function(data){
   			alert(data.messages[0].message);
   		})
	   };
	   $scope.deleteItem=function(item){
		   var ids=[];
		   ids.push(item.id);
		   $http.post('/product/delete/',
   				{
   					'ids' : ids
   				},
   				{
   					headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
   					transformRequest: function(data){
   						return $.param(data);
   					}
   				}
   		)
   		.success(function(data){
   			alert(data.messages[0].message);
   		})
	   };
	   
 });
 
 </script>
</body>
</html>