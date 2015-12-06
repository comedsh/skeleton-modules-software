<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div style="padding:4px 4px 4px 4px">
	
	<c:forEach var="spittle" items="${spittles}">
	
	<div style="padding:10px 10px 10px 10px">the Speical Spittle < <span style="color:gray;">id:</span><span>${spittle.id}</span> > information as below:</div> 
	
	<div style="padding:10px 10px 10px 10px">
		
		<span style="color:gray">username: </span><span><c:out value="${spittle.username}"></c:out></span> 
		
		adds a spittle    
		
		<span style="color:gray;margin-right:4px">at the time:</span><span style="margin-right:20px"><fmt:formatDate value="${spittle.time}" pattern="yyyy-HH-dd hh:mm:ss"/></span>
		
		<div> and the content as below </div>
		
		<div> </div><span style="color:gray">spittle content: </span><span style="margin-right:12px;color:green"><c:out value="${spittle.text}"></c:out></span> </div>
	
	</div>
	
	</c:forEach>
	
</div>