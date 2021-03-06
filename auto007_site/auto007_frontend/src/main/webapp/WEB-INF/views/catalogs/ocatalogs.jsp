<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<style type="text/css">
div{overflow: hidden;}
.fl{float: left;}
.bd{border: 1px solid #ddd;}
.p10{padding: 10px;}
.show{display: block;}.hidden{display: none;}

ul li{float: left;}

ul.ocatalogsUL{}
ul.ocatalogsUL li{width: 100px;height: 100px;margin: 5px 5px 0 0;border: 1px solid #ddd;}
ul.ocatalogsUL li div{text-align: center;}
ul.ocatalogsUL li:hover{border: 1px solid green;cursor: pointer;}
ul.modelUl{overflow: hidden;}
ul.modelUl li{padding: 5px;background: #eee;margin: 1px;border: 1px solid #eee;}
ul.modelUl li:hover{border: 1px solid green;cursor: pointer; color:green;}

.modelTable{}
.modelTable thead{}
.modelTable tbody{}
.modelTable tbody tr{}
.modelTable tbody tr:hover{cursor: pointer; color:green; background: #eee;}

.oNav{overflow: hidden;clear: both;padding: 0 5px;margin: 0 0 10px 0;}
.oNav div{padding: 10px 5px;border: 1px solid #ccc;margin: 5px;float: left;}
.oNav div.on{border-color: red;color: red;}
.oNav div.on:hover{cursor: pointer; }

.brandNav {overflow: hidden;clear: both;}
.brandNav li{float: left;margin: 0 10px;}
.brandNav li:hover{cursor: pointer;color: red;}


#modelContent{height: 300px;overflow-y: auto;}

/**/
.content{
 background:none!important;
}
</style>

<link rel="stylesheet" href="/resources/css/login.css">
<div class="w">

	<div class="oNav bd">
		<div class="brandNav on">原厂目录：</div>
		<div class="modelNav on">选择品牌<b id="selectedBrand"></b></div>
		<div id="modelLayerNav" style="padding: 0px; margin: 0px; border: 0px none;">
		
		</div>
	</div>

	<div style="margin: 0px 0px 10px 0px;" >

		<div id="brandListDiv" class="model bd p10 show">
			<ul class="brandNav">
				<li>A</li><li>B</li><li>C</li><li>D</li><li>E</li><li>F</li><li>G</li><li>H</li>
				<li>I</li><li>J</li><li>K</li><li>L</li><li>M</li><li>N</li><li>O</li><li>P</li><li>Q</li>
				<li>R</li><li>S</li><li>T</li><li>U</li><li>V</li><li>W</li><li>X</li><li>Y</li><li>Z</li>
			</ul>
		
			<ul class="ocatalogsUL">
				<c:forEach items="${brandList}" var="brand">
					<li>
						<img alt="${brand.brand_zh}" src="http://www.auto007.com${brand.img_path}">
						<div brand="${brand.brand}" sets="${brand.sets_zh}">${brand.brand_zh}</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="modelContent" class="model bd p10 hidden" layer_id="1">
			加载中......
		</div>
	
	</div>

	<div id="systemPartsContainer" class="easyui-tabs" style="height:500px">
		<div title="About" style="padding:10px">
			<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
			<ul>
				<li>easyui is a collection of user-interface plugin based on jQuery.</li>
				<li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
				<li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
				<li>complete framework for HTML5 web page.</li>
				<li>easyui save your time and scales while developing your products.</li>
				<li>easyui is very easy but powerful.</li>
			</ul>
		</div>
	</div>

</div>


<script type="text/javascript">

</script>


