<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div class="w">

<div style="overflow: hidden;clear: both;">
<div class ="fl" >原厂目录：</div> <div class ="fl">选择品牌</div>
</div>
	

<style type="text/css">
.fl{float: left;}
ul.ocatalogsUL{}
ul.ocatalogsUL li{
float: left;width: 100px;
height: 100px;
margin: 5px 5px 0 0;border: 1px solid #ddd;
}
ul.ocatalogsUL li:hover{
border: 1px solid green;cursor: pointer;
}
</style>

	<ul class="ocatalogsUL">
		<c:forEach items="${brandList}" var="brand">
			<li>
				<img alt="${brand.brand_zh}" src="http://www.auto007.com${brand.img_path}">
				<div>${brand.brand_sets_zh}/${brand.brand}/${brand.brand_zh}</div>
			</li>
		</c:forEach>
	</ul>



</div>