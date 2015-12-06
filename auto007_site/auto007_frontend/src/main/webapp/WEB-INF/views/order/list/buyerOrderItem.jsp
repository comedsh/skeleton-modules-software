<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div align="center"
	style="min-height: 200px; padding-top: 50px; padding-left: 50px; min-width: 400px; max-width: 990px;"
	ng-app="buyerOrderItem" ng-controller="buyerOrderItemController">
	
	{{buyerOrderMaster}}
	
</div>
<script type="text/javascript">
	angular.module('buyerOrderItem', []).controller('buyerOrderItemController',function($scope, $http) {
			$scope.buyerOrderMaster = ${buyerOrderMasterVO};
	}) ;
</script>