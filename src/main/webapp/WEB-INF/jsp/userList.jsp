<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserList</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 60%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>
</head>
<body style="background-color: #FFFFE0;">

	<div style="margin-top: 50px; margin-left: 200px; height: 50px;">
		<h2>User List</h2>
	</div>
	<table style="margin-top: 0px; margin-left: 100px;">
		<tr>
			<th>UserID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile Number.</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.uid }</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.mobileNumber}</td>
				<td>
					<form action="/users/edit?id=${user.uid}" method="post">
						<input type="submit" value="EDIT" style="background: none; border: 0px; cursor: pointer;" />
					</form>
				</td>
				<td>
					<form action="/users/delete?id=${user.uid}" method="post">
						<input type="submit" value="DELETE" style="background: none; border: 0px; cursor: pointer;" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="/">HOME</a></li>
		</ul>
	</div>
</body>
</html>