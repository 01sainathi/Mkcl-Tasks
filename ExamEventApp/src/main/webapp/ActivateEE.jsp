<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.app.service.ScheduleMasterService" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</head>

<body onload="loadData()">
    <div class="container">
        <div class="d-flex justify-content-between my-4">
            <h3>Activate Exam Event</h3>
            <div class="d-flex">
                <button class="btn btn-success rounded-start-pill px-4">Expand All</button>
                <button class="btn btn-success rounded-end-pill px-4">Collapse All</button>
            </div>
        </div>
        <div class="accordion" id="accordionFlushExample">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                        Exam Event Details
                    </button>
                </h2>
                <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                    <div class="row m-4">
                        <div class="col-md-4">
                            Exam Event Code
                        </div>
                        <div class="col-md-8">
                            ${examEvent.examEventCode }
                        </div>
                    </div>
                    <div class="row m-4">
                        <div class="col-md-4">
                            Exam Event Name
                        </div>
                        <div class="col-md-8">
                            ${examEvent.name }
                        </div>
                    </div>
                    <div class="row m-4">
                        <div class="col-md-4">
                            Default Language
                        </div>
                        <div class="col-md-8">
                            ${examEvent.defaultLanguageID }
                        </div>
                    </div>
                    <div class="row m-4">
                        <div class="col-md-3">
                            Start Date
                        </div>
                        <div class="col-md-3">
                            ${examEvent.startDate }
                        </div>
                        <div class="col-md-3">
                            End Date
                        </div>
                        <div class="col-md-3">
                            ${examEvent.endDate }
                        </div>
                    </div>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                        Paper Details
                    </button>
                </h2>
                <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                    <table class="table table-responsive">
                        <thead>
                            <tr>
                                <th>Sr. No.</th>
                                <th>Paper ID</th>
                                <th>Paper Code</th>
                                <th>Paper Name</th>
                                <th>Paper Total Marks</th>
                                <th>The maximum time during which paper continues</th>
                            </tr>
                         </thead> 
                         <tbody id="papers">
                            
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                        Schedule
                    </button>
                </h2>
                <div id="flush-collapseThree" class="accordion-collapse collapse"
                    data-bs-parent="#accordionFlushExample">
                    <table class="table table-responsive">
				        <thead>
				            <tr>
				                <th>Schedule Type</th>
				                <th>Starting From</th>
				                <th>Ending On</th>
				                <th>No. of Schedule(s) Created</th>
				            </tr>
				        </thead>
				        <tbody>
				            <jsp:useBean id="smServ" class="com.app.service.ScheduleMasterService"/>
                			<c:set var="schedules" value="${smServ.getSome(examEvent.examEventID) }"/>
               	 			<c:forEach var="s" items="${schedules }">
               	 				<tr>
			                		<td>${s.scheduleType }</td>
			                		<td>${s.scheduleStart }</td>
			                		<td>${s.scheduleEnd }</td>
			                		<td>i</td>
			                	</tr>
			                	<tr>
				                    <td></td>
				                    <td colspan="2"><small><i>Allow Schedule Extension  No</i></small></td>
				                    <td colspan="3"><small><i>Max No. of paper(s) that can be schedule:<span class="text-danger">${s.maxNumberOfPapers }</span></i></small></td>
				                </tr>
               	 			</c:forEach>
				        </tbody>
				    </table>
                </div>
            </div>
        </div>
        <div class="text-center my-4">
            <button class="btn btn-dark rounded-pill px-4">Back</button>
            <button class="btn btn-success rounded-pill px-4" onclick="activateExamEvent()">Activate Exam Event</button>
            <a href="http://localhost:8080/ExamEventApp/ListOfExamEvents.jsp" class="btn btn-success rounded-pill px-4">Proceed</a>
        </div>
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
function loadData(){

    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/ExamEventApp/papers/some',
        contentType: 'application/json',
        success: function(result){
            console.log(result);
            let papers = JSON.parse(result);
			let html = '';
			let counter=1;
            for(let i=0; i<papers.length; i++){
				html += '<tr>';
                html += '<td>'+counter+'</td>';
                html += '<td>'+papers[i].paperID+'</td>';
                html += '<td>'+papers[i].code+'</td>';
                html += '<td>'+papers[i].name+'</td>';
                html += '<td>000</td>';
                html += '<td>000</td>';
                html += '</tr>';
                counter++;
            }

            let pTable = document.getElementById("papers");
            pTable.innerHTML = html;
        },
        error: function(error){
            console.log("Something went wrong");
        }
    })
}

function getSessionData(){
	$.ajax({
		method: "GET",
		url: "http://localhost:8080/ExamEventApp/getSession",
		contentType: "application/json",
		success: function(result){
			console.log(result);
		}
	});
}
function activateExamEvent(){
	$.ajax({
		method: "GET",
		url: "http://localhost:8080/ExamEventApp/activate",
		contentType: "application/json",
		success: function(result){
			alert(result);
			console.log(result);
		},
		error: function(error){
			console.log(error);
		}
	});
}
</script>
</html>