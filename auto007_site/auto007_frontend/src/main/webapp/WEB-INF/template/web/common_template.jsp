<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta property="qc:admins" content="2413327512615470076375" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</style>
	<link rel="stylesheet" href="/resources/css/sprite.css">
<script type="text/javascript" src='/resources/js/lib/fenghua.lib.min.js'></script>
</head>
<body>
	<div class="header">
		<tiles:insertAttribute name="header" />
	</div>
	
	<div class="content">
		<tiles:insertAttribute name="body" />
	</div>
	
	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>