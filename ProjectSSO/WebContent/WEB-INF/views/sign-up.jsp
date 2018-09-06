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
<h1 class="h3 mb-3 font-weight-normal">Sign up</h1>
			<form:hidden path="userId" />

			<form:input path="username" cssClass="form-control form-control-sm" placeholder='Username' type="text" />
			<form:errors path="username"   cssClass="error" />
			<form:label path="username" cssClass="sr-only ">Enter  User Name:</form:label>


			<form:input path="password" cssClass="form-control form-control-sm" placeholder='password' type="password" />
			<form:errors path="password"   cssClass="error" />
			<form:label path="password" cssClass="sr-only ">Enter  Password:</form:label>
			
			
				<form:input path="repassword" cssClass="form-control form-control-sm" placeholder='password' type="password" />
			<form:errors path="repassword"   cssClass="error" />
			<form:label path="password" cssClass="sr-only ">Enter  Password:</form:label>
			
			
		    <form:input path="userProfile.firstname" cssClass="form-control form-control-sm"
				placeholder='Firstname' />
			<form:label path="userProfile.firstname" cssClass="sr-only ">Enter  Firstname:</form:label>

             <p></p>
			
          <button class="d-inline btn btn-primary btn-sm" type="submit" >Sign Up</button>
          <a class="d-inline btn btn-secondary btn-sm" href="./" role="button">Cancel</a>
		</form:form>
		
	<br />
</body>
</html>