<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<div class="header">
		<div class="header-top">
			<p class="header-top-left">
				<em>所在地：</em>
				<a href="#" class="header-city">成都<i class="icon-arrow_down"></i></a>
				<div class="header-phone"><i class="icon-phone"></i>400-616-6666</div>
			</p>
			<!--顶部右边菜单，如不需某个菜单项，直接删除dom即可-->
			<ul class="quick-menu">
				<li><a href="/">首页</a></li>
				<li>|</li>
				<li><a href="/ocatalogs">原厂目录</a></li>
				<li>|</li>
				<li><a href="#">品牌件</a></li>
				<li>|</li>
				<li>欢迎您，<span class="user-name">杨志</span>&nbsp;&nbsp;&nbsp;<a href="#">退出</a></li>
				<li>|</li>
				<li><a href="#">订单记录</a></li>
				<li>|</li>
				<li><i class="icon-circle"></i><a href="#">个人中心</a><i class="icon-arrow_down"></i></li>
				<li>|</li>
				<li><a href="#">帮助中心</a></li>
				<li>|</li>
			</ul> 
			<ul class="all-city-panel" style="display:none;">
				<li><a href="#">成都555</a></li>
				<li class="current"><a href="#">成都</a></li>
				<li><a href="#">成都</a></li>
				<li><a href="#">成都</a></li>
				<li><a href="#">成都</a></li>
				<li><a href="#">成都</a></li>
			</ul>
		</div>
		<div class="header-content-wrap">
			<div class="header-content">
				<h1 class="logo-wraper">
					<img src="/resources/old/img/logo.png" alt="logo">
				</h1>
				<div class="search-box">
					<div class="search-text-box">
						<input type="text" placeholder="商品名称/VIN编号/OE编号/品牌" class="search-text">
					</div><a href="#" class="search-btn">搜 索</a>
				</div> 
				<div class="cart-box">
					我的购物车
					<i class="icon-cart"></i>
					<i class="icon-arrow_right"></i>
					<i class="icon-numbackground cart-num">100</i>
				</div>
				<div class="cart-list-box" style="display:none;">
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
			</div>
		</div>
	</div>