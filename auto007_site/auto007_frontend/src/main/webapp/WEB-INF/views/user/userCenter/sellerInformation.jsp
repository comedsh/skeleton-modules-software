<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head lang="en" ng-app="sellerInformation">
    <title>卖家-个人信息</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content=""/>
    <!--<meta http-equiv="X-UA-Compatible" content="IE=7"/>-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/Common_top_tail.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/Common_top_tail2.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/User_style.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/Seller_information.css"/>
    <link rel="icon" href=""/>
	<script type="text/javascript" src="/resources/js/lib/fenghua.lib.min.js"></script>

	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/placeholder.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/sellerinformation.js"></script>
	<script type="text/javascript">
	
	</script>
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
        body{
            background-color: #f0f2f4;
        }
    </style>
</head>
<body>
<!--头部-->
<div class="header_login">
    <div class="header_ul clearfix">
        <ul class="header_ul_left clearfix">
            <li class="city_div clearfix"><label>所在地 :<span>成都</span></label><img src="../imgs/arrow.png"/>
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
            <li><span>欢迎您</span><a href="#" style="color: #0782d8"><sec:authentication property="name"></sec:authentication></a><a href="">, 退出</a></li>
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
            <img src="../imgs/icon.png" alt=""/>
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
<div class="content_login clearfix" ng-controller="informationConcroller">
    <div class="content_left">
        <p style="color: #333">个人中心</p>
        <ul>
            <li class="heder">订单中心</li>
            <li>订单记录</li>
            <li>订单评价记录</li>
            <li>取消订单记录</li>
            <li>退换货</li>
            <li>对账查询</li>
        </ul>
        <ul>
            <li class="heder">设置</li>
            <li style="color: #0281d4">个人信息</li>
            <li>SKU管理和发布</li>
            <li>库存管理中心</li>
            <li>价格策略</li>
        </ul>
        <ul>
            <li class="heder">消息中心</li>
        </ul>
    </div>
    <div class="content_right">
        <div class="contact_infor clearfix">
            <p class="p_active">联系人信息</p>
            <p>企业信息</p>
        </div>
        <!--联系人信息-->
        <div class="contact_information">
            <!--<p>-->
                <!--服务须知：修改*部分内容，，平台需要审核。我们的审核时限为24小时(工作日)，遇法定节假日顺延-->
            <!--</p>-->
            <div class="name_pwd">
                <div class="clearfix chren_div">
                    <label><span style="color:red">*</span>用户名</label>
                    <div class="input_d no_text">
                        阿凡提
                    </div>

                </div>
                <div class="clearfix chren_div">
                    <label><span style="color:red">*</span>登录密码</label>
                    <div class="input_d no_text">
                        **********
                    </div>
                    <a href="###">修改登录密码</a>
                </div>
                <div class="clearfix chren_div">
                    <label><span style="color:red">*</span>联系人姓名</label>
                    <div class="input_d">
                        <input type="text" class="pwd_agin"  value="阿凡提"/>
                    </div>
                </div>
                <div class="clearfix chren_div">
                    <label><span style="color:red">*</span>所在部门</label>
                    <div class="input_d input_select">
                    <span>
                            12321321
                        </span>
                        <ul style="display: none;">
                            <li>
                                safsaf
                            </li>
                            <li>
                                12321321
                            </li>
                            <li>
                                aaaaaaaa
                            </li>
                        </ul>
                    </div>

                </div>
                <div class="clearfix chren_div">
                    <label><span style="color:red">*</span>固定电话</label>
                    <div class="input_d">
                        <input type="text" class="pwd_agin"  value="021-5433243"/>
                    </div>
                </div>
                <div class="clearfix chren_div">
                    <label><span style="color:red">*</span>手机号码</label>
                    <div class="input_d no_text">
                        213243213
                    </div>
                    <a href="###">修改手机号码</a>
                </div>
                <div class="clearfix chren_div">
                    <label><span style="color:red">*</span>邮箱地址</label>
                    <div class="input_d no_text">
                       1034432432@qq.com
                    </div>
                    <a href="###">修改邮箱地址</a>
                </div>
                <a class="btn_a" href="javascript:void(0)">确定修改</a>
            </div>
            </div>
        <!--企业信息-->
        <div class="enterprise_information">
            <p>
                服务须知：修改<span style="color:red">*</span>部分内容，平台需要审核。我们的审核时限为24小时(工作日)，遇法定节假日顺延
            </p>
            <div class="name_pwd">
                <div class="clearfix chren_div">
                    <label><span style="color:red">*</span>公司名称</label>
                    <div class="input_d">
                        <input type="text" class="pwd_agin"  value="阿凡提"/>
                    </div>
                </div>
                <div class="clearfix chren_div company_d">
                    <label><span style="color:red">*</span>公司所在地</label>
                    <div class="input_d input_select select_province">
                        <span>请选择</span>
                        <ul>
                            <li>
                                四川省
                            </li>
                            <li>
                                12321321
                            </li>
                            <li>
                                aaaaaaaa
                            </li>
                        </ul>
                    </div>
                    <p>省</p>
                    <div class="input_d input_select select_city">
                        <span>请选择</span>
                        <ul>
                            <li>
                                上海市
                            </li>
                            <li>
                                12321321
                            </li>
                            <li>
                                aaaaaaaa
                            </li>
                        </ul>
                    </div>
                    <p>市</p>
                    <div class="input_d input_select select_area">
                        <span>请选择</span>
                        <ul>
                            <li>
                                武侯区
                            </li>
                            <li>
                                12321321
                            </li>
                            <li>
                                aaaaaaaa
                            </li>
                        </ul>
                    </div>
                    <p>区</p>

                </div>
                <div class="clearfix chren_div">
                    <label><span style="color:red">*</span>公司地址</label>
                    <div class="input_d" style="width: 430px">
                        <input type="text" class="pwd_agin"  value="阿凡提"  style="width: 415px"/>
                    </div>
                </div>
                <div class="clearfix chren_div">
                    <label><span style="color:red"></span>公司人数</label>
                    <div class="input_d input_select">
                    <span>
                            1-49
                        </span>
                        <ul style="display: none;">
                            <li>
                                1-49
                            </li>
                            <li>
                                50-99
                            </li>
                            <li>
                                100-499
                            </li>
                            <li>
                                500以上
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="clearfix chren_div thumbnail_div">
                    <label><span style="color:red">*</span>营业执照</label>
                    <div class="thumbnail">
                        <img src="" title=""/>
                    </div>
                    <div class="input_d file_div" style="border: 1px solid blue;color: #fff">
                        营业执照修改
                        <input type="file">
                    </div>
                    <div class="user_error1" style="display:block">
                        图片限定大小
                    </div>
                </div>
                <div class="clearfix chren_div thumbnail_div" style="width: 760px;margin-left: 120px;">
                    <label style="width: 100px;"><span style="color:red">*</span>纳税人资格证</label>
                    <div class="thumbnail">
                        <img src="" title=""/>
                    </div>
                    <div class="input_d file_div" style="border: 1px solid blue;color: #fff">
                        纳税人资格证修改
                        <input type="file">
                    </div>
                    <div class="user_error1" style="display:block">
                        图片限定大小
                    </div>
                </div>
                <div class="clearfix chren_div">
                    <label  data="0"><span style="color:red">*</span>支付方式</label>
                    <div class="input_d check_box clearfix">
                        <span class="Remember_pwd"></span>
                        <label>
                            申请账期支付 <span>需要平台审核，验证资质后，可使用此支付方式</span>
                        </label>
                    </div>
                </div>
                <div class="clearfix chren_div radio_div" style="margin-top: 15px">
                    <label>&nbsp;</label>
                    <div class="input_d check_radio1 radio_r radio_r1 radio_r2" data="0">
                        月结
                    </div>
                    <div class="input_d check_radio2 radio_r radio_r1" data="0">
                        季结
                    </div>
                </div>
                <a class="btn_a" href="/user/updateUser">确定修改</a>
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