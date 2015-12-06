<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
.rightside {
    float: right;
}
</style>
<div class="w">
	<div class="rightside">
			<div class="inner auth">
				<a class="auth__login login_icon inline" href="<%=request.getContextPath() %>/i18nView"> 语言模版切换Demo</a> 
				|
				<a class="auth__login login_icon inline" href="<%=request.getContextPath() %>/global/i18n?langType=zh"> 中文</a> 
				<a class="auth__login login_icon inline" href="<%=request.getContextPath() %>/global/i18n?langType=en"> English</a> 
				<a class="auth__login login_icon inline" href="<%=request.getContextPath() %>/global/i18n?langType=ru"> русский</a> 
				 | 
				<a class="auth__login login_icon inline" href="/secure/login"> 
					<spring:message code="login.page.sign"/>
				</a> 
				<a class="auth__reg inline" href="/registration.html">
					<spring:message code="login.page.register" />
				</a>
			</div>
	</div>
</div>