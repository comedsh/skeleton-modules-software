<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html ng-app="userCenter">
<head lang="en">
    <title>用户中心</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content=""/>
    <!--<meta http-equiv="X-UA-Compatible" content="IE=7"/>-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/Common_top_tail.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/Common_top_tail2.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/User_style.css"/>
    <link rel="icon" href=""/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/angular/angular.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/placeholder.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/usercenter.js"></script>
	<script type="text/javascript">
	
	</script>
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
    <style type="text/css">
        *{
            margin:0;
            padding:0;
            font-family: 'microsoft yahei',Verdana,Arial,Helvetica,sans-serif;
        }
        body{
            background-color: #f0f2f4;
        }
    </style>
</head>
<body>
<!--头部-->
<div style="display: none" class="header_login">
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
            <li><span>欢迎您</span><a href="#" style="color: #0782d8"><sec:authentication property="name"></sec:authentication></a><a href="<c:url value="/logout" />">, 退出</a></li>
            <li class="li">|</li>
            <li><a href="">订单记录</a></li>
            <li class="li">|</li>
            <li class="user_center"><a href="">个人中心</a></li>
            <li class="li">|</li>
            <li><a href="">帮助中心</a></li>
        </ul>
    </div>
    <div class="logo_div">
        <div class="logo_img">
            <img src="<%=request.getContextPath() %>/resources/imgs/icon.png" alt=""/>
            <div class="search_div clearfix">
                <div class="input_div">
                    <input type="text" placeholder="商品名称/VIN编号/OE编号/品牌"/>
                    <a href="javascript:void(0)">搜 索</a>
                </div>
                <div class="shopping">
                    我的购物车
                </div>
            </div>
        </div>
    </div>
</div>
<!--content-->
<div class="content_login clearfix" ng-controller="centerContent">
    <div class="content_left">
        <p>个人中心</p>
        <ul>
            <li class="heder">订单中心</li>
            <li>我的订单</li>
            <li>评价订单</li>
            <li>取消订单记录</li>
        </ul>
        <ul>
            <li class="heder">客户服务</li>
            <li>退换货</li>
            <li>质保</li>
        </ul>
        <ul>
            <li class="heder">设置</li>
            <li><a href="/user/sellerInformation">个人信息</a></li>
            <li>收货地址</li>
            <li>增票资质</li>
        </ul>
        <ul>
            <li class="heder">消息中心</li>
        </ul>
    </div>
    <div class="content_right">
        <div class="content_right_header clearfix">
            <div class="portrait">
                <img src=""/>
            </div>
            <div class="user_d">
                <a href="###">喜欢干啥是</a>
                <span>普通注册用户</span>
            </div>
            <div class="user_d user_ul">
                <ul class="clearfix">
                    <li><a href="###">等待付款 <span>1</span></a></li>
                    <li><a href="###">等待收货 <span>0</span></a></li>
                    <li><a href="###">等待评价 <span>0</span></a></li>
                    <li><a href="###">申请换货 <span>2</span></a></li>
                    <li><a href="###">申请退货 <span>0</span></a></li>
                    <li><a href="###">申请质保 <span>0</span></a></li>
                </ul>
            </div>
            <div class="buyers">
                <p>账户安全</p>
                <div>
                    <span class="span_active">
                        已绑定手机号
                    </span>
                    <a href="javascript:void(0)">
                        改手机号
                    </a>
                </div>
                <div>
                    <span>
                        未绑定邮箱
                    </span>
                    <a href="javascript:void(0)">
                        绑定邮箱
                    </a>
                </div>
            </div>
        </div>
        <div class="order">
            <div class="order_header clearfix">
                <label>我最近的订单记录</label>
                <label class="lab_right"><a href="###">查看全部订单</a></label>
            </div>
            <ul class="tab_header clearfix">
                <li class="one_li">
                    品牌名
                </li>
                <li class="two_li">
                    商品名
                </li>
                <li class="three_li">
                    OE码
                </li>
                <li class="four_li">
                    商品操作
                </li>
                <li class="five_li">
                    实付款(元)
                </li>
                <li class="six_li">
                    收货人
                </li>
                <li class="seven_li">
                    交易操作
                </li>
            </ul>
            <!--有数据显示-->
            <div class="data">
                <div class="tab_order">
                    <p>
                        <span>2015-10-29 11:26:50</span>订单号：<span>20140220001</span>卖家：<span>丰华神州</span>
                    </p>
                    <ul class=" clearfix">
                        <li class="one_li">
                            <span> <a href="###">油泵 Oil Pump 油泵 Oi泵  Pump1</a> </span>
                        </li>
                        <li class="two_li">
                            <span><a href="###">商品名商品名商品名</a></span>
                        </li>
                        <li class="three_li">
                            <span>MD185960</span>
                        </li>
                        <li class="four_li">
                            <span>商品操作</span>
                        </li>
                        <li class="five_li">
                            <span>实付款(元)</span>
                        </li>
                        <li class="six_li">
                            <span>收货人</span>
                        </li>
                        <li class="seven_li">
                            <span>交易操作</span>
                        </li>
                    </ul>

                </div>
                <div class="tab_order">
                    <p>
                        <span>2015-10-29 11:26:50</span>订单号：<span>20140220001</span>卖家：<span>丰华神州</span>
                    </p>
                    <ul class=" clearfix">
                        <li class="one_li">
                            <span> <a href="###">油泵 Oil Pump 油泵 Oi泵  Pump1</a> </span>
                        </li>
                        <li class="two_li">
                            <span><a href="###">商品名商品名商品名</a></span>
                        </li>
                        <li class="three_li">
                            <span>MD185960</span>
                        </li>
                        <li class="four_li">
                            <span>商品操作</span>
                        </li>
                        <li class="five_li">
                            <span>实付款(元)</span>
                        </li>
                        <li class="six_li">
                            <span>收货人</span>
                        </li>
                        <li class="seven_li">
                            <span>交易操作</span>
                        </li>
                    </ul>

                </div>
                <div class="tab_order">
                    <p>
                        <span>2015-10-29 11:26:50</span>订单号：<span>20140220001</span>卖家：<span>丰华神州</span>
                    </p>
                    <ul class=" clearfix">
                        <li class="one_li">
                            <span> <a href="###">油泵 Oil Pump 油泵 Oi泵  Pump1</a> </span>
                        </li>
                        <li class="two_li">
                            <span><a href="###">商品名商品名商品名</a></span>
                        </li>
                        <li class="three_li">
                            <span>MD185960</span>
                        </li>
                        <li class="four_li">
                            <span>商品操作</span>
                        </li>
                        <li class="five_li">
                            <span>实付款(元)</span>
                        </li>
                        <li class="six_li">
                            <span>收货人</span>
                        </li>
                        <li class="seven_li">
                            <span>交易操作</span>
                        </li>
                    </ul>

                </div>
            </div>
            <!--没有数据显示-->
            <div class="No_data">
                <img src="<%=request.getContextPath() %>/resources/images/no_data.png"/>
                <p>您买的东西太少了,这里都是空空的,快去挑选合适的商品吧!</p>
            </div>
        </div>
    </div>
    
</div>
<!--尾部-->
<div style="display: none" class="fooder">
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