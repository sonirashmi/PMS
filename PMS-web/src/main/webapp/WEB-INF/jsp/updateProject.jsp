<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="editProject.do" method="POST"
			modelAttribute="project">
			<div align="left" >
			<table  height="150px" width="400px"
				cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">Project ID</td>
					<td align="center"><form:input path="pNo" id="pNo" readonly="true"/></td>
				<td style="color: red;">
				<span> 
					 <form:errors path="client">
							</form:errors> 
					</span>
					</td>
				</tr>
				<tr>
					<td align="center">Client Name</td>
					<td align="center"><form:input path="client" id="client" /></td>
				<td style="color: red;">
				<span> 
					 <form:errors path="client">
							</form:errors> 
					</span>
					</td>
				</tr>
				<tr>
					<td align="center">Project Name</td>
					<td align="center"><form:input path="projectName" id="projectName" /></td>
					<td style="color: red;"><span> 
					 <form:errors path="projectName">
							</form:errors> 
					</span></td>
				<tr>
					<td align="center">Start Date</td>
					<td align="center"><form:input path="startDate" id="startDate" /></td>
				<td style="color: red;"><span> 
					 <form:errors path="startDate">
							</form:errors> 
					</span></td>
				</tr>
				<tr>
					<td align="center">End Date</td>
					<td align="center"><form:input path="endDate" id="endDate" /></td>
					<td style="color: red;"><span> 
					 <form:errors path="endDate">
							</form:errors>
					</span></td>
				</tr>
				<tr><td colspan="2" align="center">
				<input type="submit" value="Update" /></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>