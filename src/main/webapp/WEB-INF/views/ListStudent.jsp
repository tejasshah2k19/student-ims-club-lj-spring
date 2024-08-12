<%@page import="com.bean.StudentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Student</title>
</head>
<body>
	<h2>List Student</h2>
	<%
	List<StudentBean> students = (List<StudentBean>) request.getAttribute("students");
	%>
	
	
	<table border="1">
		<tr>
			<td>StudentId</td>
			<td>StudentName</td>
			<td>JoiningDate</td>
			<td>Action</td>
		</tr>
		
		<%for(StudentBean s:students){ %>
			<tr>
				<td><%=s.getStudentId() %></td>
				<td><%=s.getName() %></td>
				<td><%=s.getJoiningDate() %></td>
				<td><a href="deletestudent?studentId=<%=s.getStudentId() %>">Delete</a></td>
			</tr>
		<%} %>
	</table>
	
</body>
</html>