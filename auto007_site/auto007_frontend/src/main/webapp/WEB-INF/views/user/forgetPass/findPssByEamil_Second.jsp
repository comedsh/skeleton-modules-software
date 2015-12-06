<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
 <%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html ng-app="forgotpwd_app">
<head lang="en">
    <title>找回密码</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content=""/>
    <!--<meta http-equiv="X-UA-Compatible" content="IE=7"/>-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/Common_top_tail.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/Forgotpwd_style.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/Login_style.css"/>
    <link rel="icon" href=""/>
   <script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/angular/angular.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/placeholder.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/forgotpwd.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/uploadify/ajaxfileupload.js"></script>
       <style type="text/css">
        *{
            margin:0;
            padding:0;
            font-family: 'microsoft yahei',Verdana,Arial,Helvetica,sans-serif;
        }
        body{
            background-color: #f0f2f4;
            height: 100%;
        }
        html{
            height: 100%;
        }
    </style>
</head>
<body>

<div class="Retrieve_password clearfix">
    <p class="clearfix">
        <label>已有账号？<a href="/login.jsp">马上登录</a></label>
    </p>
    <!--邮箱找回密码-->
    <div class="border_div">
        <div class="email_one" >
            <span class="progress_bar"></span>
            <ul class="progress_ul clearfix">
                <li class="active_color">邮箱验证</li>
                <li class="left_li">修改密码</li>
                <li class="progress_li last_il">找回成功</li>
            </ul>
       
            <div class="email_success" >
                <p>用户激活电子邮件已发送至：<strong id="emailcontent"></strong></p>
                <span>
                    （请立即完成验证，邮箱验证不通过则修改邮箱失败）<br/>验证邮件24小时内有效，请尽快登录您的邮箱点击验证链接完成验证
                </span>
                <span>请您注意查收。如您未收到邮件，请点击下方的按钮重新发送。</span>
                <a href="" onclick="reSendEail()">重新发送激活邮件</a>
            </div>
        </div>
    </div>
</div>
<!--尾部-->

</body>
</html>