<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
 <%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html ng-app="forgotpwd">
<head lang="en">
    <title>找回密码</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content=""/>
    <!--<meta http-equiv="X-UA-Compatible" content="IE=7"/>-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/Common_top_tail.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/Forgotpwd_style.css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/timer.js"></script>
    <link rel="icon" href=""/>
    <!--<link rel="icon" href="http://www.jd.com/favicon.ico" mce_href="http://www.jd.com/favicon.ico" type="image/x-icon">-->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--[if lte IE 7]>
    <script src="../js/json2.js"></script>
    <![endif]-->
    <!--[if IE 6]>
    <script type="text/javascript">
        document.execCommand("BackgroundImageCache", false, true);
    </script>
    <![endif]-->
    <style type="text/css">
        *{
            margin:0;
            padding:0;
            font-family: 'microsoft yahei',Verdana,Arial,Helvetica,sans-serif;
        }
    </style>
</head>
<%
String userName = request.getParameter("userName");
%>
<body>
<!--头部-->
<div class="header_login">
    <div class="header_ul clearfix">
        <ul class="header_ul_left clearfix">
            <li class="city_div clearfix"><label>所在地 :<span>成都</span></label><img src="<%=request.getContextPath() %>/resources/imgs/arrow.png"/>
                <div id="show_div">
                    <ul class="clearfix">
                        <li><a href="javascript:void(0)">四川</a></li>
                        <li><a href="javascript:void(0)" class="active">四川</a></li>
                        <li><a href="javascript:void(0)">四川川</a></li>
                        <li><a href="javascript:void(0)">四川川</a></li>
                        <li><a href="javascript:void(0)">四川</a></li>
                        <li><a href="javascript:void(0)">四川</a></li>
                        <li><a href="javascript:void(0)">四川川</a></li>
                        <li><a href="javascript:void(0)">四川</a></li>
                        <li><a href="javascript:void(0)">四川</a></li>
                    </ul>
                </div>
            </li>
            <li class="ipone_li">
                400-616-6666
            </li>
        </ul>
        <ul class="header_ul_right clearfix">
            <li><a href="">首页</a></li>
            <li class="li">|</li>
            <li><a href="">原厂目录</a></li>
            <li class="li">|</li>
            <li><a href="">品牌件</a></li>
            <li class="li">|</li>
            <li><a href="">帮助中心</a></li>
        </ul>
    </div>
    <div class="logo_div">
        <div class="logo_img clearfix">
            <a href="" class="clearfix">
                <img src="<%=request.getContextPath() %>/resources/imgs/icon.png" alt=""/>
            </a>
        </div>
    </div>
</div>
<div class="Retrieve_password clearfix">
    <div sytle="height: 560px;border:1px solid #eceae8;">
        <div class="email_three" ng-hide="boolen3">
            <div class="form_div clearfix">
                <div class="icon_div">
                    <img src="<%=request.getContextPath() %>/resources/imgs/success.png" alt=""/>
                </div>
                <div class="left">
                    <label style="color:#2ca63d;font-size: 28px">注册成功</label>
                    <span style="font-size: 16px;color:#666">
                        欢迎您，
                        <a href="###" style="color:#ff8d02">${userName}</a>
                    </span>
                    
                    <span class="timer" style="font-size: 12px;color: #989898">10秒内,自动跳转到首页开始您的汽车零件选购</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!--尾部-->
<div class="fooder">
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
</body>
</html>
