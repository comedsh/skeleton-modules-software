<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/WEB-INF/taglib/page.tld" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分页demo</title>
</head>
<body>
<table>
   <c:forEach items="${requestScope.param.content}" var="item">
    <tr>
    <td>${item.id}</td>
    <td>${item.name}"</td>
    <td>${item.email}"</td>
    <td>${item.mobilephone}"</td>
    </tr>
  </c:forEach>
  </table>
<page:page url="/user/allUser" totalPages="${requestScope.param.totalPages}"  curpage="${requestScope.param.number}" /> 
</body>
</html>