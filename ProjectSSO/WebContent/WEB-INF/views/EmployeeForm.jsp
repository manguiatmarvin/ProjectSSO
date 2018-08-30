<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" />
<style>
html, body {
	height: 100%;
}

body {
	display: -ms-flexbox;
	display: flex;
	-ms-flex-align: center;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	width: 100%;
	max-width: 340px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 8px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

</head>
<body class="text-center">
	<div align="center">
		<h1>New/Edit Employee</h1>
		<form:form action="saveEmployee" method="post"
			modelAttribute="employee" cssClass="form-signin">

			<form:hidden path="id" />

			<form:input path="name" cssClass="form-control" placeholder='name' />
			<form:label path="name" cssClass="sr-only ">Enter  name:</form:label>


			<form:input path="email" cssClass="form-control" placeholder='email' />
			<form:label path="email" cssClass="sr-only ">Enter  name:</form:label>



			<form:input path="address" cssClass="form-control"
				placeholder='address' />
			<form:label path="address" cssClass="sr-only">Enter  name:</form:label>


			<form:input path="telephone" cssClass="form-control"
				placeholder='telephone' />
			<form:label path="telephone" cssClass="sr-only">Enter  name:</form:label>


			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>


		</form:form>
	</div>
</body>
</html>