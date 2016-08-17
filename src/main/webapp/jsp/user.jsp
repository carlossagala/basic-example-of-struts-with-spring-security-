<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Page</title>
</head>
<body>
	<h1>Hello ${pageContext.request.userPrincipal.name}</h1>
	<a href="logout">Logout</a>
</body>
</html>