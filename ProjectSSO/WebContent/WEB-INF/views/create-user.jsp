<%@ include file="inc/include_jsp_lib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PCCW OAUTH2 Provider</title>
<%@ include file="inc/html-js-css.jsp"%>

</head>
<body class="text-center">

		<form:form action="sign-up" method="post" modelAttribute="user"
			cssClass="form-signin">

			<form:hidden path="userId" />

			<form:input path="username" cssClass="form-control" placeholder='Username' type="text" />
			<form:errors path="username"   cssClass="error" />
			<form:label path="username" cssClass="sr-only ">Enter  User Name:</form:label>


			<form:input path="password" cssClass="form-control" placeholder='password' type="password" />
			<form:errors path="password"   cssClass="error" />
			<form:label path="password" cssClass="sr-only ">Enter  Password:</form:label>
			
			
				<form:input path="repassword" cssClass="form-control" placeholder='password' type="password" />
			<form:errors path="repassword"   cssClass="error" />
			<form:label path="password" cssClass="sr-only ">Enter  Password:</form:label>
			
			
		    <form:input path="userProfile.firstname" cssClass="form-control"
				placeholder='Firstname' />
			<form:label path="userProfile.firstname" cssClass="sr-only ">Enter  Firstname:</form:label>


			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>


		</form:form>
	<br />
</body>
</html>