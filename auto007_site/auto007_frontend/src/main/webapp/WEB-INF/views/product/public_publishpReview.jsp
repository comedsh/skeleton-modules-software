<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html  ng-app="fileUpload" >
  <head>
    <title>SKU发布</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="<%=request.getContextPath() %>/resources/css/common/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/resources/css/common/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/resources/css/common/styles.css" type="text/css" rel="stylesheet"/>
 <link rel="icon" href=""/>
       <link rel="icon" href=""/>

   <script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/angular/angular.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/placeholder.js"></script>

	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/uploadify/ajaxfileupload.js"></script>
   <script src="/resources/javaScript/upload/ng-file-upload-shim.js"></script>
  <script src="/resources/javaScript/upload/ng-file-upload.js"></script>
    <script type="text/javascript">

   
		
    </script>
  </head>
  <body>
 <div>

      <div >
          SKU编号 <input id="code" name="code" type="text" value="${sku.code }" readonly="readonly"/>
      </div>
	  <div>
   		    商品标题： <input id="title" name="title" type="text" value="${sku.title}"/>
      </div>
 	  <div>
                            商品品牌： <input id="brand" type="text" name="brand" value="${sku.brand }"/>
         <select id="sku_type" name="type">
          <option value="2" <c:if test="${sku.type eq  '2'}">selected="selected"</c:if> >原厂件</option>
          <option value="3" <c:if test="${sku.type eq  '3'}">selected="selected"</c:if>>品牌件</option>
        </select>
      </div>
       <div >
       		库存量： <input id="stockCount" type="text" name="stockCount" value="${skuStock.stockCount}"/>
      </div>
       <td >
    	    现价<input id="salePrice" name="salePrice" type="text" value="${sku.salePrice }"/>
    	    原价<input id="price" name="price" type="text" value="${sku.price }"/>   
      </td>
      <div>
     	<td>适配性</td>
		<td>
			<label><input type="radio" value="0" name="check"  <c:if test="${fn:length(oeList) eq 0}">checked="checked"</c:if>/>通用配型</label>
			<label><input type="radio" value="1" name="check" <c:if test="${fn:length(oeList) gt 0}">checked="checked"</c:if> />专用车型 </label>
		</td>
		</div>
		<div>
		 <c:forEach items="${oeList}" var="oeList"> 
		<td>
			 <select id="oebrand1" name="oebrand">
	          <option  value="1" <c:if test="${oeList.oebrand eq  '1'}">selected="selected"</c:if>>车品牌1</option>
	          <option value="2" <c:if test="${oeList.oebrand eq  '2'}">selected="selected"</c:if>>车品牌2</option>
	     	 </select>
	       
	      	 OE号 <input id="oeCode1" name="oeCode" type="text" value="${oeList.oeCode }"/>
        </td> 
         </c:forEach>
        </div>
        <div>
        <td>
        商品属性：
   <c:forEach items="${aTttrList}" var="aTttrList">     
         <div >
        <select name="attr_name">
          <option  value="长度" <c:if test="${aTttrList.attrName eq  '长度'}">selected="selected"</c:if> >长度</option>
          <option value="宽度" <c:if test="${aTttrList.attrName eq  '宽度'}">selected="selected"</c:if>>宽度</option>
          <option value="高度" <c:if test="${aTttrList.attrName eq  '高度'}">selected="selected"</c:if>>高度</option>
          <option value="厚度" <c:if test="${aTttrList.attrName eq  '厚度'}">selected="selected"</c:if>>厚度</option>
          <option value="体积（立方厘米）" <c:if test="${aTttrList.attrName eq  '体积（立方厘米）'}">selected="selected"</c:if>>体积（立方厘米）</option>
          <option value="容量（立方厘米）" <c:if test="${aTttrList.attrName eq  '容量（立方厘米）'}">selected="selected"</c:if>>容量（立方厘米）</option>
          <option value="直径（厘米）" <c:if test="${aTttrList.attrName eq  '直径（厘米）'}">selected="selected"</c:if>>直径（厘米）</option>
          <option value="重量（克）" <c:if test="${aTttrList.attrName eq  '重量（克）'}">selected="selected"</c:if>>重量（克）</option>
          <option value="热值（卡）" <c:if test="${aTttrList.attrName eq  '热值（卡）'}">selected="selected"</c:if>>热值（卡）</option>
          <option value="电阻（欧姆）" <c:if test="${aTttrList.attrName eq  '电阻（欧姆）'}">selected="selected"</c:if>>电阻（欧姆）</option>
          <option value="等级" <c:if test="${aTttrList.attrName eq  '等级'}">selected="selected"</c:if>>等级</option>
          <option value="颜色" <c:if test="${aTttrList.attrName eq  '颜色'}">selected="selected"</c:if>>颜色</option>
          <option value="材质" <c:if test="${aTttrList.attrName eq  '材质'}">selected="selected"</c:if>>材质</option>
          <option value="其他" <c:if test="${aTttrList.attrName eq  '其他'}">selected="selected"</c:if>>其他</option>
        </select>
          <input id="u78_input" type="text" value="${aTttrList.attrContent }" name="attr_contents"/>
      </div>
      </c:forEach>
        </td>
        </div>

</div>

 <div>
 商品图片：
<c:forEach items="${imageSmalls}" var="imageSmalls">
 <img style="width: 85px ; height: 85px;" class="img " src="<%=basePath%>/${imageSmalls}"/>
 </c:forEach>
 </div>
 <div>
 商品描述：
 <input type='text' width="3000px" name="contentsHtml"  height="2000px" value="${skuImageHtml.contentsHtml }"/>
 </div>    
<td>
 <input id="update" type="submit" onclick="problemUpdate('${sku.id }');window.close();" value="有问题修改"/>
 <input id="push" type="submit" value="立即发布" onclick="publishImedite('${sku.id }'); $('#pushForm').submit();window.opener.close();"/>

</td>
 <form action="/product/publishUp/" method="post" id="pushForm">
 <input type="hidden" name="skuId" value="${sku.id}">
  
  </form>
  </body>
<script type="text/javascript">
function problemUpdate(skuId){
//设置父窗口中age属性值
 window.opener.document.getElementById("skuId").value=skuId;
}
function publishImedite(skuId){
//设置父窗口中age属性值
 window.opener.document.getElementById("skuId").value=skuId;
}
</script>
</html>
