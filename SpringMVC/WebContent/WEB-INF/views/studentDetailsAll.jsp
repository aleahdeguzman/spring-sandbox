<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
</head>
<body>
<h1>Student Details</h1>
	<c:forEach var="student" items="${studentList}">
		<div><b>Student No:</b> ${student.studentNo}</div>
		<div><b>Student Name:</b> ${student.name}</div>
		<div><b>Subject:</b> ${student.subject}</div>
		<br>
	</c:forEach>
</body>
</html>