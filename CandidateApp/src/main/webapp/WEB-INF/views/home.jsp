<%@ page import="com.app.CandidateApp.models.Candidate"%>
<%@ page import="com.app.CandidateApp.sources.DataStore" %>
<%@ page import="java.util.*"%>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	
	<script>

		function validate(){
			
			var i = document.getElementById("id");
			var f = document.getElementById("fName");
			var l = document.getElementById("lName");
			var e = document.getElementById("email");
			var m = document.getElementById("mob");
			if(i.value=="" || f.value=="" || l.value=="" || e.value=="" || m.value==""){
				alert("All fields are mandatory");
				return false;
			}
			else{
				if(f.value.length<2 || f.value.length>15){
					alert("name should contain 5-15 characters");
					return false;
				}
				if(l.value.length<2 || l.value.length>15){
					alert("name should contain 5-15 characters");
					return false;
				}
				if(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(e.value))){
					alert("email is not in proper format");
					return false;
				}
				if(m.value.length != 10){
					alert("mobile number should contain 10 digits")
					return false;
				}
				if(!(m.value.match(/^\d{10}$/))){
					alert("mobile number is not valid.")
					return false;
				}
				true;
			}
		}

		function validateEmail(){
			var e = document.getElementById("email");
			var error = document.getElementById("error");
			if(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(e.value))){
				error.innerHTML = "Enter a valid email!!";
			}
			else{
				error.innerHTML = "<p style='color:green'>Sounds good!!</p>";
			}
		}
		
	</script>
	
</head>
<body>
<form onSubmit="return validate()" action="submit">
	<div class="container">
		<h2>Candidate Sign up</h2>
		<table class="table w100-table">
			<tr>
				<td>Id : </td>
				<td><input id="id" type="number" name="id"> </td>
			</tr>
			<tr>
				<td>First Name : </td>
				<td><input id="fName" type="text" name="fName"> </td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><input id="lName" type="text" name="lName"> </td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><input id="email" type="text" name="email" onkeydown="validateEmail()"> </td>
			</tr>
			<tr>
				<td>Mob : </td>
				<td><input id="mob" type="text" name="mob"> </td>
			</tr>
			<tr>
				<td rowspan=2><button class="btn btn-primary" type="submit">Save</button></td>
			</tr>
		</table>
		<p id="error" style="color:red">Hell</p>
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
			for(int i=0; i<DataStore.list.size(); i++){
				Candidate c = DataStore.list.get(i);
		%>
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
		%>
		</table>
	</div>
</body>
</html>
