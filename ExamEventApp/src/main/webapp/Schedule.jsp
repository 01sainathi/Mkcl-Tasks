<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.app.models.ScheduleMaster" %>
<%@ page import="com.app.service.ScheduleMasterService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container mt-3">
        <h3>Schedule</h3>
        <div class="row">
            <div class="alert alert-primary">
                <div class="row">
                    <div class="col-md-3 fw-bold">Exam Event</div>
                    <div class="col-md-9">${examEvent.name}</div>
                </div>
                <div class="row">
                    <div class="col-md-3 fw-bold">
                        Event Start Date
                    </div>
                    <div class="col-md-3">
                        ${examEvent.startDate}
                    </div>
                    <div class="col-md-3 fw-bold">
                        Event End Date
                    </div>
                    <div class="col-md-3">
                        ${examEvent.endDate}
                    </div>
                </div>
            </div>
        </div>
        <form onSubmit="return validate()" action="ScheduleMaster/save" class="form-control">
            <div class="row my-2">
                <div class="col-md-4">
                    Schedule Type *
                </div>
                <div class="col-md-8">
                    <select class="form-select" name="schedule" id="schedule">
                    	<option value="">none</option>
                    	<option value="CUSTOM">CUSTOM</option>
                        <option value="DAY">DAY</option>
                        <option value="WEEK">WEEK</option>          
                    </select>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">
                    Max no. of paper(s) that can be schedule *
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" name="noOfPapers" id="nop" value="0">
                </div>
                <div class="col-md-4">
                    <small class="text-muted">
                        <span class="fw-bold ">Note</span>
                        :If Kept 0 then unlimited paper(s) will be allowed for schedule.
                    </small> 
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Start Date *</div>
                <div class="col-md-4">
                    <input class="form-control" type="datetime-local" name="startDate" id="sdate">
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">End Date *</div>
                <div class="col-md-4">
                    <input class="form-control" type="datetime-local" name="endDate" id="edate">
                </div>
            </div>
            <div class="row ">
            	<b id="error" class="text-success">All is well</b>
            </div>
            <div class="row my-2">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <a href="http://localhost:8080/ExamEventApp/PaperConfig.jsp" class="btn btn-outline-secondary rounded-pill 4px">Back</a>
                    <input type="submit" value="Save Schedule" class="btn btn-outline-success rounded-pill 4px">
                    <a href="http://localhost:8080/ExamEventApp/ActivateEE.jsp" class="btn btn-outline-success rounded-pill 4px">Proceed</a>
                </div>
                <div class="col-md-4"></div>
            </div>
        </form>
        <hr>
        <div class="row my-2">
            <div class="col-md-4 fw-bold">
                Already attached Schedule Types
            </div>
        </div>
        <hr>
        <table class="table table-responsive">
            <thead>
                <tr>
                    <th>Schedule Type</th>
                    <th>Starting From</th>
                    <th>Ending On</th>
                    <th>No. of Schedule(s) Created</th>
                    <th>Update</th>
                    <th>Delete</th>
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
                		<td>
                			<a href="/ExamEventApp/ScheduleMaster/edit/${s.scheduleID }" class="btn btn-warning">Update</a>
                		</td>
                		<td>
                			<a href="/ExamEventApp/ScheduleMaster/delete/${s.scheduleID }" class="btn btn-danger"+>Delete</a>
                		</td>
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
    <script>
		function validate(){
			let schedule = document.getElementById("schedule");
			let papers = document.getElementById("nop");
			let s = document.getElementById("sdate");
			let e = document.getElementById("edate");
			let error = document.getElementById("error");
			
			if(schedule.value=="" || papers.value=="" || s.value=="" || e.value==""){
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
</body>
</html>