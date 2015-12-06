
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

  <head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title><tiles:getAsString name="title"/></title>
    
	<style type="text/css">
		.error{ color:red }
	</style>
  
  </head>

  <body>
   
    <table style="BORDER-COLLAPSE: collapse" borderColor=#000000 height=auto cellPadding=1 width=1000 border=1 >
      
      <tr>
        <td colspan="2">
          <tiles:insertAttribute name="header" />
        </td>
      </tr>
      
      <tr>
        <td width="10%" align=center>
          <tiles:insertAttribute name="menu" />
        </td>
        <td>
          <tiles:insertAttribute name="body" />
        </td>
      </tr>
      
      <tr>
        <td colspan="2">
          <tiles:insertAttribute name="footer" />
        </td>
      </tr>
      
    </table>

  </body>
</html>