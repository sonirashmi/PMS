<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<a href="register.do"><h4><spring:message code="label.register" /></h4></a>
<a href="project.do"><h4><spring:message code="label.projects" /></h4></a>

	<form:form method="POST" action="checkLogin.do"
		modelAttribute="UserLogin">
		<table  border="0" bordercolor="blue" cellpadding="1" cellspacing="0" >
			<tr>
				<td align="center"><label><spring:message code="label.mailId" /></label></td>
				<td align="center"><form:input path="mailId" id="mailId" /></td>
				<td><span style="color:red"><form:errors path="mailId">
				</form:errors></span></td>
			</tr>
			<tr>
				<td align="center"><label><spring:message code="label.password" /></label></td>
				<td align="center"><form:password path="pass" id="password" /> </td>
				<td><span style="color:red;"><form:errors path="pass" ></form:errors></span></td>
			</tr>
			<tr>
			<spring:message code="label.submit" var="labelSubmit"></spring:message>
				<td align="center" colspan="2"><input type="submit" value="${labelSubmit }" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>