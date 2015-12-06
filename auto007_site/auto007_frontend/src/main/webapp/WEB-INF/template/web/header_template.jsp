<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div id="header-shortcut">	
	<tiles:insertAttribute name="shortcut" />
</div>

<div class="w">
	<div id="logo">
		<tiles:insertAttribute name="logo" />
	</div>
	<div id="search">
		<tiles:insertAttribute name="search" />
	</div>
	<div id="shopcat" class="dorpdown">
		<tiles:insertAttribute name="shopcat" />
	</div>
	<span class="clr"></span>
</div>