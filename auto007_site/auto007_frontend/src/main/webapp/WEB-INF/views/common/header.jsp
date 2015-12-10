<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<!--页面头部-->
	<div class="header">
		<div class="header-top">
			<div class="header-top-left js-header-city">
				<em>所在地：</em>
				<a href="#" class="header-city"><span class="js-header-current-city" data-id="1">成都</span><i class="icon-arrow_down"></i></a>
				
				<ul class="all-city-panel js-all-city-panel" style="display:none;">
					<li class="current"><a href="#" data-id="1">成都</a></li>
					<li><a href="#" data-id="2">重庆</a></li>
					<li><a href="#" data-id="3">北京</a></li>
					<li><a href="#" data-id="4">上海</a></li>
					<li><a href="#" data-id="5">华盛顿</a></li>
					<li><a href="#" data-id="6">洛杉矶</a></li>
					<li><a href="#" data-id="3">北京</a></li>
					<li><a href="#" data-id="4">上海</a></li>
					<li><a href="#" data-id="5">华盛顿</a></li>
					<li><a href="#" data-id="6">洛杉矶</a></li>
				</ul>
			</div>
			<div class="header-phone"><i class="icon-phone"></i>400-616-6666</div>
			<!--顶部右边菜单，如不需某个菜单项，直接删除dom即可-->
			<ul class="quick-menu">
				<li><a href="/">首页</a></li>
				<li>|</li>
				<li><a href="/ocatalogs">原厂目录</a></li>
				<li>|</li>
				<li><a href="#">品牌件</a></li>
				<li>|</li>
				<!--
				<li>欢迎您，<span class="user-name">杨志</span>&nbsp;&nbsp;&nbsp;<a href="#">退出</a></li>
				<li>|</li>
				<li><a href="#">订单记录</a></li>
				<li>|</li>
				<li><i class="icon-circle"></i><a href="#">个人中心</a><i class="icon-arrow_down"></i></li>
				<li>|</li>
				-->
				<li><a href="#">帮助中心</a></li>
				<li>|</li>
			</ul> 
			
		</div>
		<div class="header-content-wrap">
			<div class="header-content">
				<h1 class="logo-wraper">
					<img src="../resources/img/logo.png" alt="logo">
				</h1>
				<!--搜索框 -->
				<!--
				<div class="search-box">
					<div class="search-text-box">
						<input type="text" placeholder="商品名称/VIN编号/OE编号/品牌" class="search-text">
					</div><a href="#" class="vice-btn search-btn">搜 索</a>
				</div> 
				-->

				<!--购物车框-->
				<!---
				<div class="cart-box">
					我的购物车
					<i class="icon-cart"></i>
					<i class="icon-arrow_right"></i>
					<i class="icon-numbackground cart-num">100</i>
				</div>
				-->
				<!--购物车列表-->
				<!--
				<div class="cart-list-box">
					<ul class="cart-list">
						<li>
							<a class="product-title" href="#">雷贝斯/RAYBESTOS众EA211专用金火花塞雷贝斯/RAYBESTOS众EA211专用金火花塞</a>
							<p class="product-para">MD01931870302983409</p>
							<p class="product-price"><em class="num">￥1760</em> X 1</p>
							<a href="#" class="delete-btn">删除</a>
						</li>
						<li>
							<a class="product-title" href="#">雷贝斯/RAYBESTOS众EA211专用金火花塞雷贝斯/RAYBESTOS众EA211专用金火花塞</a>
							<p class="product-para">MD01931870302983409</p>
							<p class="product-price"><em class="num">￥1760</em> X 1</p>
							<a href="#" class="delete-btn">删除</a>
						</li>
						<li>
							<a class="product-title" href="#">雷贝斯/RAYBESTOS众EA211专用金火花塞雷贝斯/RAYBESTOS众EA211专用金火花塞</a>
							<p class="product-para">MD01931870302983409</p>
							<p class="product-price"><em class="num">￥1760</em> X 1</p>
							<a href="#" class="delete-btn">删除</a>
						</li>
						<li>
							<a class="product-title" href="#">雷贝斯/RAYBESTOS众EA211专用金火花塞雷贝斯/RAYBESTOS众EA211专用金火花塞</a>
							<p class="product-para">MD01931870302983409</p>
							<p class="product-price"><em class="num">￥1760</em> X 1</p>
							<a href="#" class="delete-btn">删除</a>
						</li>
						<li>
							<a class="product-title" href="#">雷贝斯/RAYBESTOS众EA211专用金火花塞雷贝斯/RAYBESTOS众EA211专用金火花塞</a>
							<p class="product-para">MD01931870302983409</p>
							<p class="product-price"><em class="num">￥1760</em> X 1</p>
							<a href="#" class="delete-btn">删除</a>
						</li>
						
					</ul>
					<div class="cart-total">
						<span>共<em class="product-num">5</em>件商品</span>
						<span>共计 <em class="product-num">￥2450.00</em></span>
						<a href="#" class="go-cart-btn">去购物车</a>
					</div>
				</div>
				-->
			</div>
		</div>
	</div>