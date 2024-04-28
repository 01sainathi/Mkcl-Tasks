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
        <form action="/ExamEventApp/SchedulePaperAssociation/save" class="form-control">
        	<div class="row my-4">
	            <div class="col-md-4">
	                Exam Event *
	            </div>
	            <div class="col-md-8">
	                <select name="event" id="event" class="form-select" onchange="loadSchedules(this)">
	                    <option value="none">Select Exam Event</option>
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
	            <div class="row">
	                <h6 id="curr_date">
	                    Date: 
	                </h6>
	            </div>
	            <div class="alert alert-success">
	                <h6>You can schedule unlimited paper</h6>
	            </div>
	
	            <table class="table table-bordered">
	                <thead>
	                    <tr>
	                        <th>Display Category</th>
	                        <th>Paper</th>
	                        <th>Add More</th>
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
	                        <td>
	                            <button class="btn btn-success rounded-pill px-4">Add More</button>
	                        </td>
	                    </tr>
	                </tbody>
	            </table>
	            <div class="d-flex justify-content-center">
	                <input type="submit" class="btn btn-success rounded-pill px-4" value="Schedule"/>
	        	</div>
        </form>
        <%-- <div class="my-2">
            <h6>Already Defined Schedule</h6>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Display Category</th>
                        <th>Paper</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Date: Ape 12, 2024, 12:34 PM - Dec 30, 2024, 4:00 PM</td>
                        <td>English</td>
                        <td>${examEvent.name }</td>
                    </tr>
                </tbody>
            </table>
        </div> --%>
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
			 
			/* loadPapers(selectedEvent.value); */
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

		function changeDate(selectedDate){
			console.log("inside changeDate");
			let ele = document.getElementById("curr_date");
			
			for(let i=0; i<list.length; i++){
				if(list[i].id == selectedDate.value){
					ele.innerText = "Date: "+list[i].date;
				}
			}	
		}
    </script>
</body>
</html>