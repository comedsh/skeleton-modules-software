<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center"
	style="min-height: 200px; padding-top: 50px; padding-left: 50px; min-width: 400px; max-width: 990px;"
	ng-app="buyerOrderList" ng-controller="buyerOrderListController">
	<font color="red">${buyerOrderMasterVOs}</font>
	<table width="100%" border="1" cellspacing="0">
		<thead style="background-color: gray; color: white;">
			<tr>
				<th align="left">商品信息</th>
				<th align="center">售后</th>
				<th align="left">金额</th>
				<th align="left">收货人</th>
				<th align="left">物流信息</th>
				<th align="left">操作</th>
			</tr>
		</thead>
		<tbody ng-repeat="orderMasterVO in orderMasterVOs">
			<tr>
				<td colspan="6">{{orderMasterVO.orderMaster.createTime}}
					订单号：{{orderMasterVO.orderMaster.masterOrderNo}}</td>
			</tr>
			<tr>
				<td colspan="6">收货人：{{orderMasterVO.receiver}}
					订单金额：{{orderMasterVO.totalAmount}}
					订单状态：{{orderMasterVO.orderMaster.status}}</td>
			</tr>
			<tr ng-repeat="buyerOrderHeaderVO in orderMasterVO.buyerOrderHeaderVOs">
				<td td colspan="6">
					<table width="100%" border="1" cellspacing="0">
						<tr>
							<td>{{buyerOrderHeaderVO.orderHeader.createTime}}
								订单号：{{buyerOrderHeaderVO.orderHeader.orderNo}}
								卖家：{{buyerOrderHeaderVO.orderHeader.sellerName}}</td>
						</tr>
						<tr ng-repeat="orderItemVO in buyerOrderHeaderVO.orderItemVOs">
							<table width="100%" border="1" cellspacing="0">
								<tr ng-repeat="orderItemVO in buyerOrderHeaderVO.orderItemVOs">
									<td ><img alt="商品图片" src="{{orderItemVO.sku.url}}" > {{orderItemVO.sku.title}}</td>
									<td ><a href="">申请退款</a></td>
									<td >
										{{orderItemVO.orderItem.tradePrice}}*{{orderItemVO.orderItem.qty}}=
										{{orderItemVO.orderItem.tradePrice*orderItemVO.orderItem.qty}}元
										<br />
										(含运费:xxx元)
									</td>
									<td >收货人:{{orderMasterVO.receiver}}</td>
									<td >{{buyerOrderHeaderVO.orderTransport.status}}<br> 
									<a href="/buyerOrder/item?orderType=2&orderId={{orderMasterVO.orderMaster.id}}">订单详情</a></td>
									<td >过期时间:{{buyerOrderHeaderVO.orderHeader.receiveExpireTime}}<br> <img alt="确认收货" src=""><td>
								</tr>
							</table>
						</tr>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<script type="text/javascript">
	angular.module('buyerOrderList', []).controller('buyerOrderListController',
			function($scope, $http) {
				$http({
					method : 'POST',
					url : "buyerOrder/listData",
				}).success(function(data) {
					if (data.success) {
						$scope.initData(data.data);
					} else {
						if (data.errorMessage) {
							angular.forEach(data.errorMessages, function(msg) {
								alert(msg);
							});
						}
					}
				});
				$scope.initData = function(data) {
					$scope.orderMasterVOs = data;
				}
			});
</script>