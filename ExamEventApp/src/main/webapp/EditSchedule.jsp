<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ page import="com.app.models.ScheduleMaster" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	<h3>Edit Schedule Page</h3>
	<h6>For Schedule Having ID : ${ScheMast.scheduleID}</h6>
	<form action="/ExamEventApp/ScheduleMaster/update" class="form-control">
            <div class="row my-2">
                <div class="col-md-4">
                    Schedule Type *
                </div>
                <div class="col-md-8">
                    <select class="form-select" name="schedule" id="schedule" value="${ScheMast.scheduleType }">
                    	<option value="CUSTOM" 
                    		<c:set var="type" value="CUSTOM"/>
                    		<c:choose>
                    		<c:when test="${(ScheMast.scheduleType == type) }">
                    		selected
                     		</c:when>
                    		<c:otherwise>
                    		</c:otherwise>
                    		</c:choose>
                    	>Custom</option>
                        <option value="DAY"
                        	<c:set var="type" value="DAY"/>
                    		<c:choose>
                    		<c:when test="${(ScheMast.scheduleType == type) }">
                    		selected
                    		</c:when>
                    		<c:otherwise>
                    		</c:otherwise>
                    		</c:choose>
                        >Day</option>
                        <option value="WEEK"
                        	<c:set var="type" value="WEEK"/>
                    		<c:choose>
                    		<c:when test="${ScheMast.scheduleType == type }">
                    		selected
                    		</c:when>
                    		<c:otherwise>
                    		</c:otherwise>
                    		</c:choose>
                        >Week</option>          
                    </select>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">
                    Max no. of paper(s) that can be schedule *
                </div>
                <div class="col-md-4">
                    <input class="form-control" type="text" name="noOfPapers" id="nop" value="${ScheMast.maxNumberOfPapers }">
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
                    <input class="form-control" type="datetime-local" name="startDate" id="sDate" value="${ScheMast.scheduleStart}">
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">End Date *</div>
                <div class="col-md-4">
                    <input class="form-control" type="datetime-local" name="endDate" id="eDate" value="${ScheMast.scheduleEnd}">
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <a href="http://localhost:8080/ExamEventApp/Schedule.jsp" class="btn btn-outline-secondary rounded-pill 4px">Back</a>
                    <input type="submit" value="Update Schedule" class="btn btn-outline-success rounded-pill 4px">
                </div>
                <div class="col-md-4"></div>
            </div>
        </form>
	</div>
</body>
</html>