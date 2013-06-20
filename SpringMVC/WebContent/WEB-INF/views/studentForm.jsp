<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<form:form method="post" modelAttribute="student" action="registration">
<div>
	Student No: <form:input path="studentNo"/>
	Student Name: <form:input path="name"/>
	Subject Name: <form:input path="subject"/>
</div>
<div><input type="submit"/></div>
</form:form>
</body>
</html>