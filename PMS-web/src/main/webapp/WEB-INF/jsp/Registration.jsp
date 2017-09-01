<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form:form method="POST" action="checkRegister.do"
		modelAttribute="UserLogin">
			<table   bordercolor="blue" height="200px"
				width="400px" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">First Name</td>
					<td align="center"><form:input path="fName" id="fName" /></td>
					<td style="color: red;"><span> <form:errors path="fName">
							</form:errors>
					</span></td>
				</tr>
				<tr>
					<td align="center">Last Name</td>
					<td align="center"><form:input path="lName" id="lName" /></td>
					<td style="color: red;"><span> <form:errors
								path="lName">
							</form:errors>
					</span></td>
				</tr>
				<tr>
					<td align="center">Mail Id</td>
					<td align="center"><form:input path="mailId" id="mailId" /></td>
					<td style="color: red;"><span><form:errors
								path="mailId"></form:errors> </span></td>
				</tr>
				<tr>
					<td align="center">Password</td>
					<td align="center"><form:password path="pass" id="pass" /></td>
					<td style="color: red;"><span> <form:errors path="pass"></form:errors></span></td>
				</tr>
				<tr>
					<td align="center">Mobile No.</td>
					<td align="center"><form:input path="mob" id="mob" /></td>
					<td style="color: red;"><span> <form:errors path="mob"></form:errors></span></td>
				</tr>
				<tr>
					<td align="center">Address</td>
					<td align="center">
						<form:input path="address.address" id="address"/>
					</td>
					<%-- <td style="color: red;"><span> <form:errors path="mob"></form:errors></span></td> --%>
				</tr>
				<tr>
					<td colspan="2" align="center" height="50px" width="100px"><input
						type="submit" value="Submit" /></td>
				</tr>
			</table>
	</form:form>
</body>
</html>