<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:errors path="*"/>
<form:form modelAttribute="user" action="loginform" method="post">
Login page
<br>
<br>
Username: <form:input path="username" id="username"/><form:errors path="username"/>
<br>
<br>
Password: <form:input path="password" id="password"/><form:errors path="password"/>
<br>
<br>
${error}
<br>
<input type="submit" value="login"/>
</form:form>
</body>
</html>