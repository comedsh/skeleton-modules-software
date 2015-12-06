<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta property="qc:admins" content="2413327512615470076375" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<style type="text/css">
body {
	font: 12px/150% "Microsoft Yahei";
	color: #666;
	background: #FFF none repeat scroll 0% 0%;
}

a, address, b, big, blockquote, body, center, cite, code, dd, del, div,
	dl, dt, em, fieldset, font, form, h1, h2, h3, h4, h5, h6, html, i,
	iframe, img, ins, label, legend, li, ol, p, pre, small, span, strong, u,
	ul, var {
	margin: 0px;
	padding: 0px;
}
a {
    color: #666;
    text-decoration: none;
}
#header-shortcut {
	width: 100%;
	height: 30px;
	line-height: 30px;
	background: #F1F1F1 none repeat scroll 0% 0%;
}

.w {
	width: 1210px;margin: 0px auto;overflow: hidden;
}

#logo {
    position: relative;
    z-index: 12;
    float: left;
    width: 362px;
    height: 60px;
    padding: 20px 0px;
}

#logo .logo {
    display: block;
    width: 270px;
    height: 60px;
    background: transparent url("./../../../resources/image/logo.png") no-repeat scroll 0px 0px;
    text-indent: -20000px;
}

#search {
    position: relative;
    z-index: 11;
    float: left;
    width: auto;
    margin-top: 25px;
}

#search .form {
    width: auto;
    height: 36px;
}

#search .text {
    float: left;
    width: 446px;
    height: 24px;
    line-height: 24px;
    color: #999;
    padding: 4px;
    margin-bottom: 4px;
    border-width: 2px 0px 2px 2px;
    border-color: #B61D1D;
    border-style: solid;
    outline: 0px none;
    font-size: 14px;
    font-family: "microsoft yahei";
}

#search .button {
    float: left;
    width: 82px;
    height: 36px;
    background: #B61D1D none repeat scroll 0% 0%;
    border: medium none;
    line-height: 1;
    color: #FFF;
    font-family: "Microsoft YaHei";
    font-size: 16px;
    cursor: pointer;position: relative;
}

#shopcat {
    float: right;
    z-index: 11;
    height: 36px;
    margin-top: 25px;margin-right: 65px;
}
.dorpdown {
    position: relative;
}

#shopcat .cw-icon {
    width: 75px;
    height: 34px;
    border: 1px solid #DFDFDF;
    padding: 0px 28px 0px 36px;
    background: #F9F9F9 none repeat scroll 0% 0%;
    text-align: center;
    line-height: 34px;
}
.cw-icon {
    position: relative;
    cursor: default;
}

#nav-menu {
    height: 44px;
    border-bottom: 2px solid #B1191A;
}
#focus,#content {
    position: relative;height: 200px;
}

#footer {
    position: relative;padding: 30px 0 50px 0;
    background: #004098 none repeat scroll 0% 0%;
}
</style>
<script type="text/javascript" src="/resources/javaScript/angular/angular.js"></script>
<script type="text/javascript" src="/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
</head>
<body>
	
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	
	<div>
		<tiles:insertAttribute name="menu" />
	</div>
	
	<div id="body">
		<tiles:insertAttribute name="body" />
	</div>

	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
	
</body>
</html>