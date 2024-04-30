<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container my-4">
        <h3>Schedule Test</h3>
        <form onSubmit="return validate()" action="/ExamEventApp/SchedulePaperAssociation/save" class="form-control">
        	<div class="row my-4">
	            <div class="col-md-4">
	                Exam Event *
	            </div>
	            <div class="col-md-8">
	                <select name="event" id="event" class="form-select" onchange="loadSchedules(this)">
	                    <option value="">Select Exam Event</option>
	                    <jsp:useBean id="hServ" class="com.app.service.HomeService"/>
	                    <c:set var="events" value="${hServ.findAll() }"/>
	                    <c:forEach var="e" items="${events }">
	                    	<option value="${e.examEventID }">${e.name }</option>
	                    </c:forEach>
	                </select>
	            </div>
	        </div>
	        <div class="row my-4">
	            <div class="col-md-4">
	                Date
	            </div>
	            <div class="col-md-8">
	                <select name="date" id="dates" class="form-select" onchange="loadPapers(this)">
	                    <option value="">none</option>
	                    
	                </select>
	            </div>
	        </div>
	            <table class="table table-bordered">
	                <thead>
	                    <tr>
	                        <th>Display Category</th>
	                        <th>Paper</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr>
	                        <td>English</td>
	                        <td>
	                            <select name="paper" id="papers" class="form-select my-2">
	                                <option value="">none</option>
	                            </select>
	                        </td>
	                    </tr>
	                </tbody>
	            </table>
	            <div id="error" class="alert alert-success">
	                <h6>You can schedule paper</h6>
	            </div>
	            <div class="d-flex justify-content-center">
	                <input type="submit" class="btn btn-success rounded-pill px-4" value="Schedule"/>
	        	</div>
        </form>
        <table class="table table-hover">
        	<thead>
        		<tr>
        			<th>Sr. no</th>
        			<th>Exam Event</th>
        			<th>Paper Name</th>
        			<th>Start Date</th>
        			<th>End Date</th>
        		</tr>
        	</thead>
        	<tbody>
        		<jsp:useBean id="pserv" class="com.app.service.PaperService"/>
        		<c:set var="papers" value="${pserv.getScheduledPapers()}"/>
        		<c:set var="i" value="1"/>
        		<c:forEach var="p" items="${papers }">
        			<tr>
        				<td>${i}</td>
        				<td>${p.getEname()}</td>
        				<td>${p.getPname()}</td>
        				<td>${p.getSdate()}</td>
        				<td>${p.getEdate()}</td>
        			</tr>
        			<c:set var="i" value="${i+1}"/>
        		</c:forEach>
        	</tbody>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>

		let list = [];
		let eeId;
		function loadSchedules(selectedEvent){
			eeId = selectedEvent.value;
			 $.ajax({
				method: "GET",
				url: "http://localhost:8080/ExamEventApp/ScheduleMaster/getSome/"+eeId,
				contentType: "application/json", 
				success: function(result){
					console.log(result);
					let schedules = JSON.parse(result);
					console.log(schedules);

					let html = '<option value="">none</option>';
					for(let i=0; i<schedules.length; i++){
						let obj = {
								"id": schedules[i].scheduleID,
								"date": schedules[i].scheduleStart+"  To  "+schedules[i].scheduleEnd
								}
						list.push(obj); 
						html += '<option value="'+schedules[i].scheduleID+'">'+schedules[i].scheduleStart+"  To  "+schedules[i].scheduleEnd+'</option>';
					}

					document.getElementById("dates").innerHTML = html;
				}
			});
		}

		function loadPapers(schedule){
			console.log("inside loadPapers");
			
			$.ajax({
				method: "GET",
				url: 'http://localhost:8080/ExamEventApp/papers/notScheduled/'+eeId+','+schedule.value,
				contentType: "application/json",
				success: function(result){
					console.log(result);
					let papers = JSON.parse(result);
					console.log(papers);

					let html = '<option value="">none</option>';
					for(let i=0; i<papers.length; i++){
						html += '<option value="'+papers[i].paperID+'">'+papers[i].name+'</option>';
					}
					document.getElementById("papers").innerHTML = html;
				}
		});
			
		}

		function validate(){
			let e = $("#event").val();
			let d = $("#dates").val();
			let p = $("#papers").val();
			let error = document.getElementById("error");
			
			if(e=="" || d=="" || p==""){
				error.classList.remove("alert-success");
				error.classList.add("alert-danger");
				error.innerHTML = "<h6>All fields are mandatory</h6>";
				return false;
			}
			error.classList.remove("alert-danger");
			error.classList.add("alert-success");
			error.innerHTML = "<h6>All is well</h6>";
		}
    </script>
</body>
</html>