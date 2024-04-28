<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.app.daos.*" %>
<%@ page import="com.app.models.*" %>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	
        <script>

		function loadStates(){
			var a = document.getElementById("state");

            var helper = new XMLHttpRequest();
            helper.onreadystatechange = function(){

				if(helper.readyState == 4 && helper.status==200){
					var data = this.responseText;
					var states = JSON.parse(data);
					let ui = '<option value="none">Choose a state</option>';
					for (let i = 0; i < states.length; i++) {
						  ui += '<option value="'+states[i].name+'">'+states[i].name+'</option>';
					}  
					a.innerHTML = ui;
					
				}
			}
            helper.open("GET", "http://localhost:8080/UserApp/getStates");
			helper.send();
		}
        function loadCities(){
            var a = document.getElementById("state");
            var b = document.getElementById("city");

            var helper = new XMLHttpRequest();

			helper.onreadystatechange = function(){

				if(helper.readyState == 4 && helper.status==200){
					var data = this.responseText;
					var cities = JSON.parse(data);

					console.log(cities);
					let ui = "";
					for (let i = 0; i < cities.length; i++) {
						  ui += '<option value="'+cities[i].city_name+'">'+cities[i].city_name+'</option>';
					}  
					b.innerHTML = ui;
					
				}
			}
			helper.open("GET", "http://localhost:8080/UserApp/getCities/"+a.value);
			helper.send();
  
        }
    </script>
    </head>
    <body onload="loadStates()">
<form action="submit">
	<div class="container">
		<h2>Candidate Sign up</h2>
		<table class="table w100-table">
			<tr>
				<td>Id : </td>
				<td><input id="id" type="number" name="id"> </td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><input id="name" type="text" name="name"> </td>
			</tr>
			<tr>
				<td>Email : </td>
				<td><input id="email" type="text" name="email"> </td>
			</tr>
			<tr>
				<td><label for="state">Choose a State:</label></td>
				<td>
					<select class="form-control" name="state" id="state" onchange="loadCities()">
				        
	    			</select>
				</td>
			</tr>
			<tr>
				<td><label for="cars">Choose a City:</label></td>
	
			    <td>
			    	<select class="form-control" name="city" id="city">
						<option value="none">-----------------------</option>
			    	</select>
			    </td>
			</tr>
			<tr>
				<td rowspan=2><button class="btn btn-primary" type="submit">Save</button></td>
			</tr>
		</table>
	</div>
</form>	
		<div class="container">
		<table class="table table-bordered">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>State</th>
			<th>City</th>
		</tr>
		<%
			UserDao uDao = new UserDao();
			StateDao sDao = new StateDao();
			CityDao cDao = new CityDao();
			
			List<User> list = uDao.findAll();
			for(int i=0; i<list.size(); i++){
				User u = list.get(i);
				String state = sDao.getName(u.getSid());
				String city = cDao.getName(u.getCid());
		%>
				<tr>
					<td><%= u.getName() %></td>
					<td><%= u.getEmail() %></td>
					<td><%= state%></td>
					<td><%= city%></td>
				</tr>
		<%
			}
		%>
		</table>
	</div>
    </body>
</html>
