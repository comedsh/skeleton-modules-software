<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="success">
	<div class="success-b">
		<h3>商品已成功加入购物车！</h3>
	</div>
	<span id="initCart_next_go"> 
		<a class="btn-1" href="//cart.jd.com/cart?r=0.5488165151327848" id="GotoShoppingCart">去购物车结算</a>
		<span class="ml10">您还可以 
			<a class="ftx-05" href="javascript:history.back();">继续购物</a>
			<a class="ftx-05" href="/shoppingCart/list">我的购物车</a>
		</span>
	</span>
</div>
