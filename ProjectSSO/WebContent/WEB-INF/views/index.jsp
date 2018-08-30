<%@ include file="inc/include_jsp_lib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PCCW OAUTH2 Provider</title>
<%@ include file="inc/html-js-css.jsp"%>
</head>
<body>
	<h1>Welcome User</h1>
	<h2>${message}</h2>
	<p>Your details:</p>
	<p>Username: </p>
	<p>Authorities:</p>

<c:if test="${empty user.getAuthorities()}">
	<table>
		<c:forEach items="${user.getAuthorities()}" var="authotiry">
			<tr>
				<td>${authotiry.getAuthority()}</td>

			</tr>
		</c:forEach>
	</table>
</c:if>


	<form action='<spring:url value="/logout"/>' method="post">
		<input value="Logout" type="submit">
	</form>
</body>
</html>