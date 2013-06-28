<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My First SpringMVCRest</title>
</head>
<body>

<div id="studentListDiv">
 <table id="studListTb" border="1" cellpadding="5">
 </table>
</div>

	<table id="origStudTb" border="1" cellpadding="5">
	<c:forEach items="${studentList}" var="student">
		<tr>
			<td><c:out value="${student.studentNo}" /></td>
			<td><c:out value="${student.name}" /></td>
			<td><c:out value="${student.subject.subj_name}" /></td>
			<td><input type="radio" id="number" value="${student.studentNo}" name="number"/></td>
		</tr>
	</c:forEach>
	</table>
	
<div><input type="button" id="deleteStudent" value="Delete Student"/></div>
<br>

<div id="studentDetailResp"></div>

<br>
<div>
<form:form id="studentForm" method="post" modelAttribute="student"> 
	Student No: <form:input path="studentNo" size="3"/>
	Student Name: <form:input path="name"/>
	Subject Name: <form:input path="subject.subj_name"/>	
	<input type="submit" id="addStududent" value="Add Student"/>
</form:form>
</div>

<input type="hidden" id="ctx" value="<%=request.getContextPath() %>"/>

<script type="text/javascript" src="<c:url value="/resources/jquery-1.10.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/student.js"/>"></script>
</body>
</html>