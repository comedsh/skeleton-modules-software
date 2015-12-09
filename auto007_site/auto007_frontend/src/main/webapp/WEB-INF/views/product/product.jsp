<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品详情</title>
	<style type="text/css">

/* box */
.box {
	width: 610px;
	margin: 100px auto;
}

.tb-pic a {
	display: table-cell;
	text-align: center;
	vertical-align: middle;
}

.tb-pic a img {
	vertical-align: middle;
}

.tb-pic a {
	*display: block;
	*font-family: Arial;
	*line-height: 1;
}

.tb-thumb {
	margin: 10px 0 0;
	overflow: hidden;
}

.tb-thumb li {
	background: none repeat scroll 0 0 transparent;
	float: left;
	height: 42px;
	margin: 0 6px 0 0;
	overflow: hidden;
	padding: 1px;
}

.tb-s310, .tb-s310 a {
	height: 310px;
	width: 310px;
}

.tb-s310, .tb-s310 img {
	max-height: 310px;
	max-width: 310px;
}

.tb-s310 a {
	*font-size: 271px;
}

.tb-s40 a {
	*font-size: 35px;
}

.tb-s40, .tb-s40 a {
	height: 40px;
	width: 40px;
}

.tb-booth {
	border: 1px solid #CDCDCD;
	position: relative;
	z-index: 1;
}

.tb-thumb .tb-selected {
	background: none repeat scroll 0 0 #C30008;
	height: 40px;
	padding: 2px;
}

.tb-thumb .tb-selected div {
	background-color: #FFFFFF;
	border: medium none;
}

.tb-thumb li div {
	border: 1px solid #CDCDCD;
}

div.zoomDiv {
	z-index: 999;
	position: absolute;
	top: 0px;
	left: 0px;
	width: 200px;
	height: 200px;
	background: #ffffff;
	border: 1px solid #CCCCCC;
	display: none;
	text-align: center;
	overflow: hidden;
}

div.zoomMask {
	position: absolute;
	background: url("images/mask.png") repeat scroll 0 0 transparent;
	cursor: move;
	z-index: 1;
}

ul {
    list-style: none;
    padding: 0;
    margin: 0;
}
li {
    float: left;
    border: 1px solid #000;
    border-bottom-width: 0;
    margin: 3px 3px 0px 3px;
    padding: 5px 5px 0px 5px;
    background-color: #CCC;
    color: #696969;
}
#mainView {
    border: 1px solid black;
	clear: both;
	padding: 0 1em;
}
.active {
    background-color: #FFF;
    color: #000;
}
</style>
	<script type="text/javascript" src="/resources/js/lib/fenghua.lib.min.js"></script>

	<script type="text/javascript"src="/resources/javaScript/JQuery/jquery.imagezoom.js"></script>
</head>
<body ng-app="productApp"  ng-controller="productController">

  <div  >
  <table>
		<tr>
			<td>
				<div class="box" >

	<div class="tb-booth tb-pic tb-s310">
		<a href="images/01.jpg"><img src="images/01_mid.jpg" alt="美女" rel="images/01.jpg" class="jqzoom" /></a>
	</div>

	<ul class="tb-thumb" id="thumblist" > 	  
	      <li ng-repeat="item in picItems" ng-class="">	        
			<div class="tb-pic tb-s40"><a href="#" ng-click="imgClick()">
			  <img  src="{{item.url}}" mid="{{item.url}}" big="{{item.url}}"></a>
		    </div>
		  </li>    
	
	</ul>
	
</div>

		</td>
			<td rowspan="10">
				<div>${product.name}&nbsp;&nbsp;&nbsp;&nbsp;累计销量{{stock.saledCount}}:&nbsp;&nbsp;&nbsp;累计评价：{{comment.comtotal}}</div>
				<div>原价：￥${product.price}</div>
				<div>现价：￥${product.salePrice}</div>
				<div>品牌:${product.brand}</div>
				<div>配送方式:由丰华神州发货  并提供售后服务</div>
				<div>数量:<input id="min" name="" type="button" value="-" ng-click="reduce()">
						<input id="num" readonly="true" ng-model="nums">
						<input id="add" name="" type="button" value="+" ng-click="add()">
				</div>
				<div>库存：{{stock.stockAvailability}}</div>
				<div>				
					<a href="/order?pid=${product.id}&num={{nums}}">立即购买</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/order/cart/add?pid=${product.id}&num={{nums}}">加入购物车</a>
				</div>
			</td>
			<tr>
	</table>
  </div>

 <div><h3>商品描述</h3></div>
  <div><h3>商品属性</h3></div>
     <div ng-repeat="item in attrs">	        
		  {{item.name}}    {{item.contents}}
	</div>    
		  
  <div><h3>适配车型OE</h3></div>
  <div><h3>商品评论</h3>
  <div>
    <p>好评度:{{commentInfo.precent}}  本商品{{stock.saledCount}}人 购买  {{comment.comtotal}}人评价
  </div>
  <div>
   <p>用户评论信息
   <h3 ng-repeat="item in commentDetail">
   用户名： {{item.name}}  评论时间：{{item.createTime}} 评论内容：{{item.comtent}} 评论星级：{{item.star}}
  </h3>
  </div>
 
  <div>
  </div>
  </div>

	<script type="text/javascript">
	   angular.module('productApp', [])
       .controller('productController', function($scope,$http) {      	
    	 
    	   $scope.init = function() {
               $scope.nums = "1";
           };
           $scope.init();

    	   
    	   var id = ${product.id};

    	   $scope.getPro =  function(url,callback){
    		  $http.get(url).success(function(data){ 
    			  callback(data);
            });
    	   };
    	   
    	   
    	   
     	   //商品图片
    	   $scope.getPro("/productPic/"+id,function(data){
    		   $scope.picItems=data.items;
    	   });	   	  
    	   
    	   //库存
    	   $scope.getPro("/stock/"+id,function(data){
    		   $scope.stock=data;
    	   });
    	   
    	   //评论总数
    	   $scope.getPro("/comment/"+id,function(data){
    		   $scope.comment=data;
    	   });
    	   
    	   //attrs 属性
    	      $scope.getPro("/skuExtendAttrs/product/"+id,function(data){
    		   $scope.attrs=data.attrs;
    	   });
    	   
    	   //评论
    	      $scope.getPro("/comment/praise/"+id,function(data){
    		   $scope.commentInfo=data;
    	   });
    	   
    	   //获取评论信息
    	    $scope.getPro("/comment/detail/"+id,function(data){
    		   $scope.commentDetail=data.result;
    	   });
    	  
    	   $scope.imgClick = function(){
    	   };
    	   
    	   $scope.reduce =function(){
    		   $scope.nums =  parseInt($scope.nums) -1;
    	   }
    	   
           $scope.add =function(){
        	   
        	  $scope.nums =   parseInt($scope.nums) +1;
    	   } 	   
       });
	   
	   
	</script>
	
	
</body>
</html>