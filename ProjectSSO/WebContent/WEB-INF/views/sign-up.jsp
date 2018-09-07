<%@ include file="inc/include_jsp_lib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PCCW OAUTH2 Provider</title>
<%@ include file="inc/html-js-css.jsp"%>
<style>
.form-signin input[type="password"] {
    
    margin: 0 0 0 0;!important
}
</style>
</head>
<body class="text-center">
	
		<form:form action="sign-up" method="post" modelAttribute="user"
			cssClass="form-signin">
<h1 class="h3 mb-3 font-weight-normal">Sign up</h1>
			<form:hidden path="userId" />

			<form:input path="username" cssClass="form-control form-control-sm" placeholder='Username' type="text" maxlength="45" />
			<form:errors path="username"   cssClass="error" />
			<form:label path="username" cssClass="sr-only ">Enter  User Name:</form:label>


			<form:input path="password" cssClass="form-control form-control-sm" placeholder='Password' type="password" maxlength="45" />
			<form:errors path="password"   cssClass="error" />
			<form:label path="password" cssClass="sr-only ">Enter  Password:</form:label>
			
			
		    <form:input path="repassword" cssClass="form-control form-control-sm" placeholder='Confirm password' type="password" maxlength="45" />
			<form:errors path="repassword"   cssClass="error" />
			<form:label path="password" cssClass="sr-only ">Enter  Password:</form:label>
			
			<br/>
		    <form:input path="userProfile.firstname" cssClass="form-control form-control-sm" placeholder='Firstname' maxlength="45" />
			<form:label path="userProfile.firstname" cssClass="sr-only ">Enter  Firstname:</form:label>
			
			
			<form:input path="userProfile.lastname" cssClass="form-control form-control-sm" placeholder='Lastname' maxlength="45" />
			<form:label path="userProfile.lastname" cssClass="sr-only ">Enter  Lastname:</form:label>
			
			<form:input path="userProfile.middlename" cssClass="form-control form-control-sm" placeholder='Middle' maxlength="45" />
			<form:label path="userProfile.middlename" cssClass="sr-only ">Enter  Middle:</form:label>
			
			<form:input path="userProfile.emailAddress" cssClass="form-control form-control-sm" placeholder='Email Address' maxlength="150" />
			<form:label path="userProfile.emailAddress" cssClass="sr-only ">Enter Email Address:</form:label>

             <p></p>
            <button class="d-inline btn btn-primary btn-sm" type="submit" >Sign Up</button>
            <a class="d-inline btn btn-secondary btn-sm" href="./" role="button">Cancel</a>
		</form:form>
	<br />
</body>
</html>