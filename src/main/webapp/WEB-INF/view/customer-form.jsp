<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Save Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/add-customer-style.css" />


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM-Customer Relation Manager</h2>

		</div>

	</div>
	<div id="container">
		<h2>Save Customer</h2>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label> First Name:</label></td>
						<td><form:input path="first_name" /></td>
					</tr>
					<tr>
						<td><label> Last Name:</label></td>
						<td><form:input path="last_name" /></td>
					</tr>
					<tr>
						<td><label> Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label> </label></td>
						<td><input type="submit" value="save" class="save"></td>
					</tr>
				</tbody>
			</table>
		</form:form>

<div style="clear;both;"></div>
<p>
<a href="${pageContext.request.contextPath}/customer/list" > Back to list</a>

</p>

	</div>

</body>
</html>