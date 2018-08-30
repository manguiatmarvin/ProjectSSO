<%@ include file="inc/include_jsp_lib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PCCW OAUTH2 Provider</title>
<%@ include file="inc/html-js-css.jsp"%>

</head>
<body class="text-center">

	<form class="form-signin" action='<spring:url value="/loginAction"/>'
		method="post">
		<h1 class="h3 mb-3 font-weight-normal">Sign in</h1>


		<c:if test="${not empty error}">
			<div class="text-danger shadow-none p-3 mb-5 bg-light rounded">${error}</div>
			<br />
		</c:if>

		<input name="username" type="text" id="username" class="form-control"
			placeholder="Username" required autofocus> <label
			for="inputEmail" class="sr-only">Email address</label> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="password" id="inputPassword"
			class="form-control" placeholder="Password" required>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me"
				name="remember-me"> Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<small>No Account ? <a href="<c:url value="/sign-up" />">
				Sign Up</a></small>
		<p class="mt-5 mb-3 text-muted">&copy; ProjectSSO 2017-2018</p>
	</form>
	<br />
</body>
</html>