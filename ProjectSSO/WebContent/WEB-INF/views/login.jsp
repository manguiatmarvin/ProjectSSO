<%@ include file="inc/include_jsp_lib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PCCW OAUTH2 Provider</title>
    <link href="<c:url value="/resources/css/dashboard/dashboard.css" />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>

</head>
<body class="text-center">

	<form class="form-signin" action='<spring:url value="/loginAction"/>'
		method="post">
		<h3 class="h3 mb-3 font-weight-normal text-muted">Sign in</h3>


		<c:if test="${not empty error}">
			<div class="text-danger shadow-none p-1 mb-5 bg-light rounded"><small>${error}</small></div>
			<br />
		</c:if>
		
		

		<input name="username" type="text" id="username" class="form-control form-control-sm"
			placeholder="Username" required autofocus> <label
			for="inputEmail" class="sr-only">Email address</label> <label
			for="inputPassword" class="sr-only">Password</label> 
		<input
			type="password" name="password" id="inputPassword"
			class="form-control form-control-sm" placeholder="Password" required>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me"
				name="remember-me"> Remember me
			</label>
		</div>
		
		
		<p></p>
			
          <button class="d-inline btn btn-primary btn-sm" type="submit" >Sign In</button>
          <button class="d-inline btn btn-secondary btn-sm" type="reset">Reset</button>
          <p></p>
          
		<small>No Account ? <a href="<c:url value="/sign-up" />">
				Sign Up</a></small>
		<h6 class="mt-5 mb-3 text-muted">&copy; ProjectSSO 2017-2018</h6>
	</form>
	<br />
</body>
</html>