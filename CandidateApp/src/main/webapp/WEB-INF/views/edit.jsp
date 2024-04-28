<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Edit Candidate</h1>
	<form action="update" method="post">
	<div class="container">
		<table class="table w100-table">
			<tr>
				<td>Id : </td>
				<td><input type="number" name="id" value="${Candidate.id}" required> </td>
			</tr>
			<tr>
				<td>First Name : </td>
				<td><input id="fName" type="text" name="fName" value="${Candidate.getfName()}" required> </td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><input type="text" name="lName" value="${Candidate.getlName()}" required> </td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><input type="text" name="email" value="${Candidate.email}" required> </td>
			</tr>
			<tr>
				<td>Mob : </td>
				<td><input type="text" name="mob" value="${Candidate.mob}" required> </td>
			</tr>
			<tr>
				<td rowspan=2><input class="btn btn-primary" onClick="validate()" type="submit" value="Update"></td>
			</tr>
		</table>
		<h1 id="texting">Hello</h1>
	</div>
</form>
</body>
</html>