<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
 <%@page import="java.util.Enumeration"%>   
<!DOCTYPE html>
<html ng-app="registerApp">
<head lang="en">
    <title>注册</title>
    <meta charset="UTF-8">
    <meta name="keywords" content="" />
    <meta name="description" content=""/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/base.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/head.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common/simpleFooter.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/user/register.css"/>
    <link rel="icon" href=""/>
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
<div class="header" ng-controller="headerController">
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
<!--内容区-->
<div class="content clearfix" ng-controller="registerController as reCtrl">
    <p class="tab-wrap clearfix">
        <a class="tab-item" ng-click="changePanel(0)" ng-class="{'current':currentRegisterType==0}" href="javascript:void(0)">个人注册</a>
        <a class="tab-item" ng-click="changePanel(1)" ng-class="{'current':currentRegisterType==1}" href="javascript:void(0)">企业注册</a>
        <a class="tab-item" ng-click="changePanel(2)" ng-class="{'current':currentRegisterType==2}" href="javascript:void(0)">商家注册</a>
        <label>已有账号？<a href="Login.html">马上登录</a></label>
    </p>
    <!--企业注册-->
    <div class="content-enterprise" ng-controller="enterpriseRegisterController as enCtrl" ng-show="currentRegisterType==1">
        <div class="head-remind">服务须知：我们的审核时限为24小时(工作日)，遇法定节假日顺延。</div>
        <h3>账户信息</h3>
        <div class="text-box">
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>用户名</label>
                <div class="text-wrapper">
                    <input type="text" class="name"  placeholder="请输入用户名"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    4-20位字符，支持汉子、字母、数字的组合,不能以数字开头
                </div>
                <div class="error-prompt">
                    用户名错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>设置密码</label>
                <div class="text-wrapper">
                    <input type="password" class="pwd" placeholder="请输入密码"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    6-20位字符,以字母开头,只包含字符、数字和下划线
                </div>
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>确认密码</label>
                <div class="text-wrapper">
                    <input type="password" class="pwd_agin"  placeholder="请再次输入密码"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    请确认输入密码
                </div>
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
        </div>
        <h3>联系人信息</h3>
        <div class="text-box" style="height:460px">
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>联系人姓名</label>
                <div class="text-wrapper">
                    <input type="text" class="username"  placeholder="请输入联系人姓名"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    4-20位字符，支持汉字、字母、数字的组合,不能以数字开头
                </div>
                <div class="error-prompt">
                    联系人姓名错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>所在部门</label>
                <div class="text-wrapper select-box">
                    <span>请选择</span>
                    <ul>
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
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>固定电话</label>
                <div class="text-wrapper">
                    <input type="text" class="Fixed_telephone"  placeholder="请输入固定电话"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    请输入固定电话
                </div>
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>验证手机</label>
                <div class="text-wrapper">
                    <input type="text" class="telephone"  placeholder="请输入手机号"/>
                    <i class="clear-ico">clear</i>
                </div>
                <a class="phone-code-btn" href="javascript:void(0)">获取手机验证码</a>
                <div class="warning-prompt">
                    请输入手机号
                </div>
                <div class="error-prompt">
                    错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>短信验证码</label>
                <div class="text-wrapper" style="width: 150px">
                    <input type="text" class="telephone_code"  placeholder="请输入短信验证码"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    请输入短信验证码
                </div>
                <div class="error-prompt">
                    错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><span style="color:red"></span>联系人邮箱</label>
                <div class="text-wrapper">
                    <input type="text" class="email_e"  placeholder="请输入邮箱"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    请输入邮箱
                </div>
                <div class="error-prompt">
                    错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
        </div>
        <h3>公司信息</h3>
        <div class="text-box" style="height:460px">
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>公司名称</label>
                <div class="text-wrapper" style="width: 330px">
                    <input style="width: 300px" type="text" class="company"  placeholder="公司名称和营业执照名称一致，否则审核不通过"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    公司名称不能空
                </div>
                <div class="error-prompt">
                    用户名错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item company_d">
                <label><i class="mustfill">*</i>公司所在地</label>
                <div class="text-wrapper select-box select_province">
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
                <div class="text-wrapper select-box select_city" >
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
                <div class="text-wrapper select-box select_area" >
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
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>公司地址</label>
                <div class="text-wrapper" style="width: 330px">
                    <input style="width: 300px" type="text" class="address"  placeholder="公司地址和营业执照地址一致，否则审核不通过"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    <!--含有汉字、数字、字母、下划线-->
                    公司地址不能为空
                </div>
                <div class="error-prompt">
                    错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label>公司人数</label>
                <div class="text-wrapper select-box">
                    <span>请选择</span>
                    <ul>
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
                            500-999
                        </li>
                        <li>
                            1000以上
                        </li>
                    </ul>
                </div>
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label>&nbsp;</label>
                <div class="text-wrapper file_div">
                    营业执照上传
                    <input type="file"/>
                </div>
                <div class="warning-prompt" style="display:block">
                    图片限定大小
                </div>
            </div>
            <div class="clearfix text-item">
                <label>&nbsp;</label>
                <div class="text-wrapper file_div">
                    纳税人资格证上传
                    <input type="file"/>
                </div>
                <div class="warning-prompt" style="display:block">
                    图片限定大小
                </div>
            </div>
        </div>
        <h3>支付信息</h3>
        <div class="text-box"  style="height:300px">
            <div class="clearfix text-item">
                <label class="remember_pwd" data="0"></label>
                <div class="text-wrapper check_box">
                    申请账期支付<span>需要平台审核，验证资质后，可使用此支付方式</span>
                </div>
            </div>
            <div class="clearfix text-item radio_div" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="text-wrapper check_radio1 radio_r radio_r1 radio-checked" data="0">
                    月结
                </div>
                <div class="text-wrapper check_radio2 radio_r radio_r1" data="0">
                    季结
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>验证码</label>
                <div class="text-wrapper" style="width: 115px">
                    <input type="text" class="code" ng-model="code" style="width: 95px"/>
                </div>
                <img  src="<%=request.getContextPath() %>/resources/imgs/code.png" alt="" title="换一张" class="img_code"/>
                <span class="change-code-box">看不清楚？<a href="javascript:void(0)">换一张</a></span>
                <div class="warning-prompt">
                    不能为空
                </div>
                <div class="error-prompt">
                    用户名错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="text-wrapper radio_r radio_r1 radio-checked" data="0">
                    我已阅读并同意
                </div>
                <div class="text-wrapper radio_r radio_r3 js-protocol">
                    《Auto007用户协议》
                </div>
            </div>
            <input type="hidden" value="1">
            <div class="clearfix text-item" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="text-wrapper submit_btn" ng-click="submit_two">
                    立即注册
                </div>

            </div>
        </div>
    </div>
    <!--个人注册-->
    <div class="content-personal" ng-controller="personalRegisterController as peCtrl"  ng-show="currentRegisterType==0">
        <div class="text-box" style="height: 700px">
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>用户名</label>
                <div class="text-wrapper" ng-class="{'wrong-border':isWrong.name,'correct-border':isCorrect.name,'tip-border': isTip.name}">
                    <input text type="text" othercheck="$scope.checkUserName()" class="name" ng-model="user.name" name="name"  placeholder="请输入用户名" tip="4-20位字符,支持汉字、字母、数字的组合,不能以数字开头"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div ng-class="{'tip': isTip.name, 'wrong': isWrong.name, 'correct': isCorrect.name}" ng-show="isShowMsg.name">{{ err_name.name }}</div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>设置密码</label>
                <div class="text-wrapper" ng-class="{'wrong-border':isWrong.pwd,'correct-border':isCorrect.pwd,'tip-border':isTip.pwd}">
                    <input text type="password" name="pwd" class="pwd" ng-model="user.pwd" placeholder="请输入密码" tip="6-20位字符，建议字母、数字、特殊符号两种以上组合" />
                    <i class="clear-ico">clear</i>
                </div>
                <div ng-class="{'tip': isTip.pwd, 'wrong': isWrong.pwd, 'correct': isCorrect.pwd}" ng-show="isShowMsg.pwd">{{ err_name.pwd }}</div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>确认密码</label>
                <div class="text-wrapper"  ng-class="{'wrong-border':isWrong.pwdRepeat,'correct-border':isCorrect.pwdRepeat,'tip-border': isTip.pwdRepeat}">
                    <input text type="password" class="pwd_agin" name="pwdRepeat" ng-model="user.pwdRepeat" placeholder="请再次输入密码"  tip="请再次输入密码"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div ng-class="{'tip': isTip.pwdRepeat, 'wrong': isWrong.pwdRepeat, 'correct': isCorrect.pwdRepeat}" ng-show="isShowMsg.pwdRepeat">{{ err_name.pwdRepeat }}</div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>邮箱地址</label>
                <div class="text-wrapper" ng-class="{'wrong-border':isWrong.email,'correct-border':isCorrect.email,'tip-border': isTip.email}">
                    <input text type="text" class="email_e" name="email" ng-model="user.email" placeholder="请输入邮箱" tip="请输入邮箱"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div ng-class="{'tip': isTip.email, 'wrong': isWrong.email, 'correct': isCorrect.email}" ng-show="isShowMsg.email">{{ err_name.email }}</div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>手机号码</label>
                <div class="text-wrapper" ng-class="{'wrong-border':isWrong.phone,'correct-border':isCorrect.phone,'tip-border': isTip.phone}">
                    <input text  name="phone" type="text" name="phone" class="telephone" ng-model="user.phone"  placeholder="请输入手机号" tip="请输入手机号"/>
                    <i class="clear-ico">clear</i>
                </div>
                <a class="phone-code-btn" href="javascript:void(0)" ng-click="getPhoneCode()">获取手机验证码</a>
                <div ng-class="{'tip': isTip.phone, 'wrong': isWrong.phone, 'correct': isCorrect.phone}" ng-show="isShowMsg.phone">{{ err_name.phone }}</div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>短信验证码</label>
                <div class="text-wrapper" ng-class="{'wrong-border':isWrong.phoneCode,'correct-border':isCorrect.phoneCode,'tip-border': isTip.phoneCode}" style="width: 150px">
                    <input text type="text" name="phoneCode" class="telephone_code" ng-model="user.phoneCode" placeholder="请输入短信验证码" tip="请输入短信验证码"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div ng-class="{'tip': isTip.phoneCode, 'wrong': isWrong.phoneCode, 'correct': isCorrect.phoneCode}" ng-show="isShowMsg.phoneCode">{{ err_name.phoneCode }}</div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>验证码</label>
                <div class="text-wrapper" ng-class="{'wrong-border':isWrong.code,'correct-border':isCorrect.code,'tip-border': isTip.code}" style="width: 115px">
                    <input text type="text" class="code" name="code" ng-model="user.code" style="width: 95px" tip="请输入验证码"/>
                </div>
                <img  ng-src="{{imageCodeSrc}}" alt="" title="换一张" class="img_code"/>
                <span class="change-code-box">看不清楚？<a href="javascript:void(0)" ng-click="changeImageCode()">换一张</a></span>
                <div ng-class="{'tip': isTip.code, 'wrong': isWrong.code, 'correct': isCorrect.code}" ng-show="isShowMsg.code">{{ err_name.code }}</div>
            </div>
            <div class="clearfix text-item" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="text-wrapper radio_r radio_r1 " ng-class="{'radio-checked':user.isAgreeProtol}" ng-click="user.isAgreeProtol=!user.isAgreeProtol">
                    我已阅读并同意
                </div>
                <div class="text-wrapper  radio_r radio_r3 js-protocol">
                    《Auto007用户协议》
                </div>
            </div>
            <div class="clearfix text-item" style="margin-top: 15px">
                <label>&nbsp;</label>
                <input type="hidden" class="sub1" value="1">
                <div class="text-wrapper submit_btn" ng-class="{'disable':!user.isAgreeProtol}" ng-click="submit()">
                    立即注册
                </div>
            </div>
        </div>
    </div>
    <!--商家注册-->
    <div class="content-merchant" ng-controller="merchantRegisterController as meCtrl"  ng-show="currentRegisterType==2">
        <div class="head-remind">服务须知：我们的审核时限为24小时(工作日)，遇法定节假日顺延。</div>
        <h3>账户信息</h3>
        <div class="text-box">
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>用户名</label>
                <div class="text-wrapper">
                    <input type="text" class="name"  placeholder="请输入用户名"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    不能以数字开头、限制为4-16个字符
                </div>
                <div class="error-prompt">
                    用户名错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>设置密码</label>
                <div class="text-wrapper">
                    <input type="password" class="pwd" placeholder="请输入密码"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    以字母开头，6-20位字符，包含字符、数字和下划线
                </div>
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>确认密码</label>
                <div class="text-wrapper">
                    <input type="password" class="pwd_agin"  placeholder="请再次输入密码"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    请确认输入密码
                </div>
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
        </div>
        <h3>联系人信息</h3>
        <div class="text-box" style="height:460px">
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>联系人姓名</label>
                <div class="text-wrapper">
                    <input type="text" class="username"  placeholder="请输入联系人姓名"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    不能以数字开头、限制为4-16个字符
                </div>
                <div class="error-prompt">
                    联系人姓名错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>所在部门</label>
                <div class="text-wrapper select-box">
                    <span>请选择</span>
                    <ul>
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
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>固定电话</label>
                <div class="text-wrapper">
                    <input type="text" class="Fixed_telephone"  placeholder="请输入固定电话"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    请输入固定电话
                </div>
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>验证手机</label>
                <div class="text-wrapper">
                    <input type="text" class="telephone"  placeholder="请输入手机号"/>
                    <i class="clear-ico">clear</i>
                </div>
                <a class="phone-code-btn" href="javascript:void(0)">获取手机验证码</a>
                <div class="warning-prompt">
                    请输入手机号
                </div>
                <div class="error-prompt">
                    错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>短信验证码</label>
                <div class="text-wrapper" style="width: 150px">
                    <input type="text" class="telephone_code"  placeholder="请输入短信验证码"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    请输入短信验证码
                </div>
                <div class="error-prompt">
                    错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>邮箱地址</label>
                <div class="text-wrapper">
                    <input type="text" class="email_e"  placeholder="请输入邮箱"/>
                    <i class="clear-ico">clear</i>
                </div>
                <div class="warning-prompt">
                    请输入邮箱
                </div>
                <div class="error-prompt">
                    错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
        </div>
        <h3>公司信息</h3>
        <div class="text-box" style="height:650px">
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>公司名称</label>
                <div class="text-wrapper" style="width: 330px">
                    <input style="width: 300px" type="text" class="company"  placeholder="公司名称和营业执照名称一致，否则审核不通过"/>
                </div>
                <div class="remove_d" style="left: 415px;">
                    <img src="<%=request.getContextPath() %>/resources/imgs/remove.jpg"/>
                </div>
                <div class="warning-prompt">
                    不能以数字开头、限制为4-16个字符
                </div>
                <div class="error-prompt">
                    用户名错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item company_d">
                <label><i class="mustfill">*</i>公司所在地</label>
                <div class="text-wrapper select-box select_province">
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
                <div class="text-wrapper select-box select_city" >
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
                <div class="text-wrapper select-box select_area" >
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
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>公司地址</label>
                <div class="text-wrapper" style="width: 330px">
                    <input style="width: 300px" type="text" class="address"  placeholder="公司地址和营业执照地址一致，否则审核不通过"/>
                </div>
                <div class="remove_d" style="left: 415px;">
                    <img src="<%=request.getContextPath() %>/resources/imgs/remove.jpg"/>
                </div>
                <div class="warning-prompt">
                    <!--含有汉字、数字、字母、下划线-->
                    不能以下划线开头和结尾
                </div>
                <div class="error-prompt">
                    错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>公司人数</label>
                <div class="text-wrapper select-box">
                    <span>请选择</span>
                    <ul>
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
                            500-999
                        </li>
                        <li>
                            1000以上
                        </li>
                    </ul>
                </div>
                <div class="error-prompt">
                    请输入用户名请输入用户名请输入用户名请输入用户名
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item">
                <label>&nbsp;</label>
                <div class="text-wrapper file_div">
                    营业执照上传
                    <input type="file"/>
                </div>
                <div class="warning-prompt" style="display:block">
                    图片限定大小
                </div>
            </div>
            <div class="clearfix text-item">
                <label>&nbsp;</label>
                <div class="text-wrapper file_div">
                    纳税人资格证上传
                    <input type="file"/>
                </div>
                <div class="warning-prompt" style="display:block">
                    图片限定大小
                </div>
            </div>
            <div class="clearfix text-item">
                <label><i class="mustfill">*</i>验证码</label>
                <div class="text-wrapper" style="width: 115px">
                    <input type="text" class="code" ng-model="code" style="width: 95px"/>
                </div>
                <img  src="<%=request.getContextPath() %>/resources/imgs/code.png" alt="" title="换一张" class="img_code"/>
                <span class="change-code-box">看不清楚？<a href="javascript:void(0)">换一张</a></span>
                <div class="warning-prompt">
                    不能为空
                </div>
                <div class="error-prompt">
                    用户名错误
                </div>
                <div class="correct-prompt">
                    输入正确
                </div>
            </div>
            <div class="clearfix text-item" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="text-wrapper radio_r radio_r1">
                    我已阅读并同意
                </div>
                <div class="text-wrapper radio_r radio_r3 js-protocol">
                    《Auto007用户协议》
                </div>
            </div>
            <div class="clearfix text-item" style="margin-top: 15px">
                <label>&nbsp;</label>
                <div class="text-wrapper submit_btn">
                    立即注册
                </div>

            </div>
        </div>
    </div>
</div>
<!--灰色蒙版-->
<div class="gray_mask js-protocol-layer" ></div>
<!--协议弹出层-->
<div class="pop_up js-protocol-layer">
    <p class="clearfix">
        <label>Auto007用户协议</label>
        <img src="<%=request.getContextPath() %>/resources/imgs/close.png" class="close_img js-close-protocol-btn" title="关闭"/>
    </p>
    <div class="content_d">
        sadsadsadsadsadsadsadsadsadsaddnsfdhs年第三方vdsffjdsf仿佛看见回复肯定是会计师对回复
        sadsadsadsadsadsadsadsadsadsaddnsfdhs年第三方vdsffjdsf仿佛看见回复肯定是会计师对回复
        sadsadsadsadsadsadsadsadsadsaddnsfdhs年第三方vdsffjdsf仿佛看见回复肯定是会计师对回复
    </div>
    <a class="js-close-protocol-btn" href="javascript:void(0);">同意并继续</a>
</div>
<!--尾部-->
<div class="footer">
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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/tools.js"></script>
<script type="text/javascript" src="/resources/js/lib/fenghua.lib.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/placeholder.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/register.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/head.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/uploadify/ajaxfileupload.js"></script>
</body>
</html>
<script type="text/javascript">
	function changePicture() {
		ajaxFileUpload();
	}
	function ajaxFileUpload() {
		$.ajaxFileUpload({
			url : '/user/upload/', //需要链接到服务器地址
			secureuri : false,
			fileElementId : 'houseMaps', //文件选择框的id属性
			dataType : 'json', //服务器返回的格式，可以是json, xml
			success : function(data, status) //相当于java中try语句块的用法
			{
				$('.licence .user_error3').show();
				$('.licence .user_error1').hide();
				$('.licence .user_error2').hide();
			},
			error : function(data, status, e) //相当于java中catch语句块的用法
			{
				$('.licence user_error2').show();
				$('.licence user_error1').hide();
				$('.licence user_error3').hide();
			}
		});
	}
	function changePictures() {
		ajaxFileUploads();
	}
	function ajaxFileUploads() {
		$.ajaxFileUpload({
			url : '/user/uploads/', //需要链接到服务器地址
			secureuri : false,
			fileElementId : 'houseMapss', //文件选择框的id属性
			dataType : 'json', //服务器返回的格式，可以是json, xml
			success : function(data, status) //相当于java中try语句块的用法
			{
				$('.taxpayer .user_error3').show();
				$('.taxpayer .user_error1').hide();
				$('.taxpayer .user_error2').hide();
			},
			error : function(data, status, e) //相当于java中catch语句块的用法
			{
				$('.taxpayer user_error2').show();
				$('.taxpayer user_error1').hide();
				$('.taxpayer user_error3').hide();
			}
		});
	}
</script>
