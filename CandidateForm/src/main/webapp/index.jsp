<%@ page import="com.app.models.Candidate"%>
<%@ page import="com.app.daos.CandidateDao"%>
<%@ page import="java.util.*"%>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<form action="submit">

	<div class="container">
		<h2>Candidate Sign up</h2>
		<table class="table w100-table">
			<tr>
				<td>Id : </td>
				<td><input type="number" name="id"> </td>
			</tr>
			<tr>
				<td>First Name : </td>
				<td><input type="text" name="fName"> </td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><input type="text" name="lName"> </td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><input type="text" name="email"> </td>
			</tr>
			<tr>
				<td>Mob : </td>
				<td><input type="text" name="mob"> </td>
			</tr>
			<tr>
				<td rowspan=2><input class="btn btn-primary" type="submit" value="Save"></td>
			</tr>
		</table>
	</div>
</form>
	<div class="container">
		<table class="table table-bordered">
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Mobile no.</th>
		</tr>
		<%
			try(CandidateDao cDao = new CandidateDao()){
				List<Candidate> list = cDao.findAll();
				for(Candidate c: list){  %>
					<tr>
				        <td><%= c.getfName() %></td>
				        <td><%= c.getlName() %></td>
				        <td><%= c.getEmail() %></td>
				        <td><%= c.getMob() %></td>
				        <td><a href="delete/<%= c.getId() %>"class="btn btn-danger">delete</a></td>
				        <td><a href="edit/<%=c.getId() %>"class="btn btn-warning">edit</a></td>
			        </tr>
		<%
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		%>
		</table>
	</div>
</body>
</html>
