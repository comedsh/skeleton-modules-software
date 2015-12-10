<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@page import="java.util.Enumeration"%>
 <!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>auto007-找回密码</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/sprite.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/findpassword.css">
</head>
<body>
	<!--页面头部-->
	<%-- <div class="header">
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
				<li><a href="#">首页</a></li>
				<li>|</li>
				<li><a href="#">原厂目录</a></li>
				<li>|</li>
				<li><a href="#">品牌件</a></li>
				<li>|</li>
				<li><a href="#">帮助中心</a></li>
				<li>|</li>
			</ul> 
		</div>
		<div class="header-content-wrap">
			<div class="header-content">
				<h1 class="logo-wraper">
					<img src="<%=request.getContextPath() %>/resources/img/logo.png" alt="logo">
				</h1>
			</div>
		</div>
	</div> --%>

	<!--页面内容-->
	<div class="content">
		<!--手机找回密码-->
		<div class="phone-findpwd js-findpwd-item">
			<div class="progress-box">
			 	<div class="progress-bar"></div>
			 	<ul class="progress-desc clear">
			 		<li class="current">填写资料</li>
			 		<li>修改密码</li>
			 		<li>找回成功</li>
			 	</ul>
			</div>
			<div class="form-box">
				<table class="phone-validate">
					<tbody>
						<tr>
							<td class="label"><label for="telphone">手机号码:</label></td>
							<td class="text">
								<input class="telphone" type="text" name="telphone" id="telphone">
								<div class="prompt-box">
									<i class="icon-error"></i>
									<span>手机号格式错误</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="label"><label for="code">验证码:</label></td>
							<td class="text">
								<input class="code" type="text" name="code" id="code"><img src="<%=request.getContextPath() %>/resources/img/test_code.jpg" class="js-code-img" alt="验证码">
								<input class="code" type="text" name="code" id="code"><img src="<%=request.getContextPath() %>/resources-old/img/test_code.jpg" class="js-code-img" alt="验证码">
								看不清楚？
								<a class="btn change-code-btn" href="#">换一张</a>
								<div class="prompt-box">
									<i class="icon-error"></i>
									<span>手机号格式错误</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="label"><label for="telphonecode">短信验证码:</label></td>
							<td class="text">
								<input class="telphonecode" type="text" name="telphonecode" id="telphonecode">
								<a href="#" class="main-btn js-send-phonecode-btn">获取手机验证码</a>
								<div class="prompt-box">
									<i class="icon-error"></i>
									<span>手机号格式错误</span>
								</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td class="submit">
								<a href="#" class="vice-btn phone-submit-btn">下一步</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<!--邮箱找回密码-->
		<div class="email-findpwd js-findpwd-item" style="display:none;">
			<div class="progress-box">
			 	<div class="progress-bar"></div>
			 	<ul class="progress-desc clear">
			 		<li class="current">验证邮箱</li>
			 		<li>修改密码</li>
			 		<li>找回成功</li>
			 	</ul>
			</div>
			<!--验证邮箱表单-->
			<div class="form-box">
				<table class="email-validate">
					<tbody>
						<tr>
							<td class="label"><label for="email">邮箱:</label></td>
							<td class="text">
								<input class="email" type="text" name="email" id="email">
								<div class="prompt-box">
									<i class="icon-error"></i>
									<span>手机号格式错误</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="label"><label for="emailcode">验证码:</label></td>
							<td class="text">
								<input class="code" type="text" name="code" id="emailcode"><img src="<%=request.getContextPath() %>/resources/img/test_code.jpg" class="js-code-img" alt="验证码">
								<input class="code" type="text" name="code" id="emailcode"><img src="<%=request.getContextPath() %>/resources-old/img/test_code.jpg" class="js-code-img" alt="验证码">
								看不清楚？
								<a class="btn change-code-btn" href="#">换一张</a>
								<div class="prompt-box">
									<i class="icon-error"></i>
									<span>手机号格式错误</span>
								</div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td class="submit">
								<a href="#" class="vice-btn email-submit-btn">下一步</a>
								<a href="#" class="vice-btn phone-submit-btn">下一步</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<!--邮件发送成功后显示信息-->
			<div class="send-email-success"  style="display:none;">
				<p class="title">
					用户激活电子邮件已发送至：
					<span class="email-address js-email-address">20140209001@126.com</span>
				</p>
				<p class="tip-desc">
					（请立即完成验证，邮箱验证不通过则修改邮箱失败）<br>
					验证邮件24小时内有效，请尽快登录您的邮箱点击验证链接完成验证<br><br>
					请你注意查收。如您未收到邮件，请点击下方的按钮重新发送<br><br><br>
					<a class="btn" href="findPassword.html" id="sendEmailAgain">
						重新发送激活邮件
					</a>
				</p>
			</div>
		</div>
		
		<!--选项卡-->
		<ul class="tab-box js-tab-box">
			<li class="current">手机找回密码</li>
			<li>邮箱找回密码</li>
		</ul>

		<!--去登录按钮-->
		 <div class="login-link">
		 	<span>又想起密码了？</span>
		 	<a href="#">马上登录</a>
		 </div>
	</div>

	<!--页面底部-->
	<!-- <div class="footer">
		<p class="about-us">
			<a href="#">关于我们</a>
			<em>|</em>
			<a href="#">联系我们</a>
			<em>|</em>
			<a href="#">人才招聘</a>
		</p>
		<p class="copyright">备案号：新ICP备12057998号-1 新疆丰华神州汽车配件有限公司版权所有</p>
	</div> -->
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/lib/fenghua.lib.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/findpassword.js"></script>
</body>
</html>