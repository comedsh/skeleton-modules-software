<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="w">
	<div id="focus">
		<div style="line-height: 200px; text-align: center;border: 1px solid #ddd;font-size: 30px;">
			<!--<spring:message code="index.banner" />-->
			<%=request.getAttribute("index.banner") %>
		</div>
	</div>
</div>

<div class="w">
	<div id="content">
		<div style="line-height: 200px; text-align: center; border: 1px solid #eee;font-size: 30px;">
			<spring:message code="index.content" />
		</div>
	</div>
</div>