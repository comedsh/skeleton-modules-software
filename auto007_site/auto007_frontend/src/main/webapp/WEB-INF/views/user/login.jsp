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
<html ng-app="loginApp">
<head lang="en">
	<spring:message code="auto007.css_location"/>
    <title></title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content=""/>
    <!--<meta http-equiv="X-UA-Compatible" content="IE=7"/>-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/base.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/head.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/simpleFooter.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/login.css"/>
    <link rel="icon" href=""/>
    
    <!--<link rel="icon" href="http://www.jd.com/favicon.ico" mce_href="http://www.jd.com/favicon.ico" type="image/x-icon">-->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--[if lte IE 7]>
    <script src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
    <![endif]-->
    <!--[if IE 6]>
    <script type="text/javascript">
        document.execCommand("BackgroundImageCache", false, true);
    </script>
    <![endif]-->
    </head>
<body>
<!--头部-->
<div style="display: none" class="header" ng-controller="headerController">
    <div class="header_box clearfix">
        <ul class="header_left clearfix">
            <li class=" city_wrap clearfix" ng-class={'active':isCityActive} ng-mouseenter="mouseOver()" ng-mouseleave="mouseLeave()"><label>所在地 :<span>{{currentCity.cityName}}</span></label><img src="<%=request.getContextPath() %>/resources/imgs/arrow.png"/>
                <div class="city-wrap-allcity">
                    <ul class="clearfix">
                        <li ng-repeat="item in allCity"><a ng-class={'current':currentCity.id==item.id} href="javascript:void(0)" ng-click="changCurrentCity($index)">{{item.cityName}}</a></li>
                    </ul>
                </div>
            </li>
            <li class="phone">
                400-616-6666
            </li>
        </ul>
        <ul class="header_right clearfix">
            <li><a href="">首页</a></li>
            <li class="li">|</li>
            <li><a href="">原厂目录</a></li>
            <li class="li">|</li>
            <li><a href="">品牌件</a></li>
            <li class="li">|</li>
            <li><a href="">帮助中心</a></li>
        </ul>
    </div>
    <div class="logo_wrap">
        <div class="logo_img clearfix">
           <a href="" class="clearfix">
               <img src="<%=request.getContextPath() %>/resources/imgs/icon.png" alt=""/>
           </a>
        </div>
    </div>
</div>
<div class="content_login clearfix" ng-controller="loginController">
    <div class="img_login clearfix">
        <img src="<%=request.getContextPath() %>/resources/imgs/img_login.png" alt=""/>
    </div>
    <div class="right_login">
        <h1>欢迎登录<span>还没有账号？<a href="/secure/register">免费注册</a></span></h1>
        <div class="prompt-box">
            <div ng-show="errorMessage.isError" class="prompt" ng-bind="errorMessage.errorDesc"></div>
        </div>
        <div class="text-box">
            <input ng-model="user.name" ng-focus="setError()" ng-blur="validateName()" type="text" class="name" placeholder="用户名/手机/邮箱号"/>
        </div>
        <div class="text-box pwd">
            <input ng-model="user.pwd"  ng-focus="setError()" type="password" placeholder="请输入你的密码"/>
        </div>
        <div class="remember_box clearfix">
            <div class="remember_pwd" ng-class="{'checked':user.isRememberPwd}" ng-model="user.isRememberPwd" ng-click="toggleRemenmmberPwd()">记住密码</div>
            <a ng-href="/user/findPassbyphoneOrEmail/">忘记密码</a>
        </div>
        <div class="imgcode-box">
            <input type="text" ng-model="user.code">
            <img title="换一张"  ng-click="changeImgeCode()" class="img_code" ng-src="{{imgeCodeSrc}}">
            <a href="javascript:void(0)" ng-click="changeImgeCode()">看不清楚换一张</a>
        </div>
        <a class="login_btn" enter ng-click="logins()" ng-bind="loginBtnText">登 录</a>
        <div class="thirdparty-box">
            <label>使用合作网站账号登录</label>
            <a href="<%=request.getContextPath() %>/auth/qq">QQ</a>&nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="<%=request.getContextPath() %>/auth/weixin">微信</a>
        </div>
    </div>
</div>
<!--尾部-->
<div style="display: none" class="footer">
   <div class="tail_description">
       <ul class="clearfix">
           <li><a href="">关于我们</a></li>
           <li>|</li>
           <li><a href="">联系我们</a></li>
           <li>|</li>
           <li><a href="">人才招聘</a></li>
       </ul>
       <p>备案号： 新ICP备12057998号-1 新疆丰华神州汽车配件有限公司版权所有</p>
   </div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/angular/angular.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/placeholder.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/login.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/head.js"></script>
</body>
</html>
