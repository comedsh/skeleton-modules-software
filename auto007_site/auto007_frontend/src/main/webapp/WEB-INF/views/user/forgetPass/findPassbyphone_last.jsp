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
<!--头部-->
<div class="Retrieve_password clearfix">
    <p class="clearfix">
        <label>已有账号？<a href="/secure/login/">马上登录</a></label>
    </p>
  
    <!--手机找回密码-->
    <div class="border_div">
        
        <div class="ipone_three" >
            <span class="progress_bar progress_bar1 progress_bar2"></span>
            <ul class="progress_ul clearfix">
                <li class="active_color">填写资料</li>
                <li class="left_li active_color">修改密码</li>
                <li class="progress_li last_il active_color">找回成功</li>
            </ul>
            <div class="form_div clearfix">
                <div class="icon_div">
                    <img src="<%=request.getContextPath() %>/resources/imgs/success.png" alt=""/>
                </div>
                <div class="left">
                    <label style="color:#2ca63d;font-size: 28px">找回成功</label>
                    <span style="font-size: 16px;color:#666" id="qq">
                        欢迎您，
                        <a href="###" style="color:#ff8d02">${message}</a>
                    </span>
                    <span style="font-size: 12px;color: #989898">立即开始您的汽车零件选购吧！</span>
                </div>
                <a href="/secure/login/" class="btn_login btn_login2">立即去登录</a>
            </div>
        </div>
    </div>
</div>
<!--尾部-->
</body>
</html>