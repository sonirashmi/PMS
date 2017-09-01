<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BaseLayout</title>
</head>
<body>
 <table border="1" height="500" width="1000" cellpadding="0" cellspacing="0" bgcolor="#5DADE2">
    <tr height="5%">
      <td colspan="2"  align="left" ><tiles:insertAttribute name="header" />
      </td>
    </tr>
     <tr height="5%">
      <td colspan="2"  align="left"><tiles:insertAttribute name="menu" />
      </td>
    </tr>
    <tr height="85%">
    <td align="center"> 
    	 <tiles:insertAttribute name="body" />
    </td>
   </tr>
    <tr height="5%">
      <td colspan="2" align="left"><tiles:insertAttribute name="footer" />
      </td>
    </tr>
  </table>
</body>
</html>