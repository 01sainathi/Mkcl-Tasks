<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.app.service.HomeService"%>
<%@ page import="java.util.*"%>
<%@ page import="com.app.models.ExamEvent" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
    
</head>
<body onload="loadLangs()">
    <div class="container">
        <h2>Exam Event Details</h2>
        <div class="alert alert-success top">
            Licensed End Date       20/06/2024 00:00
        </div>
        <div>
        <h3>Add new event</h3></div>
        <form onSubmit="return validate()" class="form-control" action="submit">
            <div class="container">
                <table class="table">
                    <tr>
                        <td><b class="text-success">Exam Event Name</b></td>
                        <td><input type="text" name="name" id="ename" class="form-control" required></td>
                    </tr>
                    <tr>
                        <td><b class="text-success">Exam Event Code</b></td>
                        <td><input type="text" name="code" id="ecode" class="form-control"></td>
                    </tr>
                    <tr>
                        <td><b class="text-success">Default Language</b></td>
                        <td>
                            <select name="language" id="lang" class="form-control">
                                
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><b class="text-success">Start Date</b></td>
                        <td><input type="datetime-local" name="start_date" id="sdate" class="form-control"></td>
                    </tr>
                    <tr>
                        <td><b class="text-success">End Date</b></td>
                        <td><input type="datetime-local" name="end_date" id="edate" class="form-control"></td>
                    </tr>
                    <tr>
                        <td><input class="btn btn-primary" type="submit" value="Submit"></td>
                       
                    </tr>
                </table>
            </div>
        </form>
        <div>
        	<b id="error" class="text-success">All is well</b>
        </div>
    </div>
    <div class="container">
    	<h3>Proceed with existing event</h3>
    	<table class="table">
    		<thead>
    			<tr>
	    		<th>Event name</th>
	    		<th>Event code</th>
	    		<th>Default Language</th>
	    		<th>Start Date</th>
	    		<th>End Date</th>
    		</tr>
    		</thead>
    		<tbody>
    				
	    		<jsp:useBean id="hServ" class="com.app.service.HomeService"/>
	    		<c:set var="list" value="${hServ.findAll() }"/>
	    		<c:forEach var="e" items="${list }">
	    			<tr>
	    				<td>${e.name }</td>
	    				<td>${e.examEventCode }</td>
	    				<td>${e.defaultLanguageID }</td>
	    				<td>${e.startDate }</td>
	    				<td>${e.endDate }</td>
	    				<td><a href="proceed/${e.examEventID }"class="btn btn-primary">Proceed</a></td>
	    			</tr>
	    		</c:forEach>
    		</tbody>
    	</table>
    </div>
</body>
<script>
        function loadLangs(){
            var helper = new XMLHttpRequest();

            helper.onreadystatechange = function(){
                if(helper.readyState==4 && helper.status==200){
                	console.log(helper.responseText);
                    let data = helper.responseText.substring(1, helper.responseText.length-1);
                    console.log(data);

                    let langs = data.split(",");
                    let html = '<option value="">none</option>';
                    for(let i=0; i<langs.length; i++){
                        let str = langs[i].trim();
                        let line = '<option value="'+str+'">'+str+'</option>'
                        html = html+line;
                    }

                    let langEle = document.getElementById("lang");
                    langEle.innerHTML = html;
                }
            }

            helper.open("GET", "http://localhost:8080/ExamEventApp/langs");
            helper.send();
        }

        function validate(){

			let n = document.getElementById("ename");
			let c = document.getElementById("ecode");
			let l = document.getElementById("lang");
			let s = document.getElementById("sdate");
			let e = document.getElementById("edate");
			let error = document.getElementById("error");
			
			if(n.value=="" || c.value=="" || l.value=="" || s.value=="" || e.value==""){
				error.classList.remove("text-success");
				error.classList.add("text-danger");
				error.innerText = "All fields are mandatory";
				return false;
			}

			
			var DateStart = new Date(s.value);
			var DateEnd = new Date(e.value);
			if (DateEnd < DateStart) {
				error.classList.remove("text-success");
				error.classList.add("text-danger");
				error.innerText = "End date cannot be less than Start date.";
		    	return false;
			}
			if(DateStart <= new Date()){
				error.classList.remove("text-success");
				error.classList.add("text-danger");
				error.innerText = "Event Cannot start prior today";
				return false;
			}
			return true;
        }
    </script>
</html>