<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.app.models.Candidate"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Candidate c = (Candidate)request.getAttribute("data"); 
	out.print(c.getfName()+" "+c.getlName());
	out.print(" this candidate is added");
	%>
</body>
</html>