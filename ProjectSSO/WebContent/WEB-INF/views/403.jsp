<%@ include file="inc/include_jsp_lib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PCCW OAUTH2 Provider</title>
<%@ include file="inc/html-js-css.jsp"%>
</head>
<body>
	<h1>HTTP Status 403 - Forbidden</h1>
	<p>
		Sorry <b> ${user.getName().toUpperCase()} </b> but you don't have
		access to this resource
	</p>
</body>
</html>