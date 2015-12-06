<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品列表</title>

</head>
<body>
   <h3> <a href="/product/manage/">商品管理</a></h3>

  <table>
   <c:forEach items="${items}" var="item">
    <tr>
    <td><img src=${item.url}>${item.name}</td>
    <td><a href="/product/${item.id}">查看商品详情</a></td>
    </tr>
   
    
  </c:forEach>
  
  </table>
 
</body>
</html>