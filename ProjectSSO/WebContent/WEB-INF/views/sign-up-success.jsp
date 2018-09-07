<%@ include file="inc/include_jsp_lib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PCCW OAUTH2 Provider</title>
<%@ include file="inc/html-js-css.jsp"%>

</head>
<body class="text-center">
	
		<div class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Sign up Success!</h1>
        <p>Username : ${user.getUsername()}</p>
         
         <div>
          <a class="d-inline btn btn-primary btn-sm" href="./logout" role="button">Sign in</a>
        
         </div>
		</div>
		
	<br />
</body>
</html>