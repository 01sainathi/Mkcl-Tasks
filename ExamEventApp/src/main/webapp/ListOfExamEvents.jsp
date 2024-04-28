<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
    <div class="container">
        <div class="d-flex justify-content-between my-4">
            <h3>Manage Exam Event</h3>
            <a href="http://localhost:8080/ExamEventApp/index.jsp" class="btn btn-success rounded-pill px-4">Add Exam Event</a>
        </div>

        <table class="table table-responsive">
            <thead>
                <tr>
                    <th>Exam Event Id</th>
                    <th>Exam Event Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Completion Status</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <jsp:useBean id="hServ" class="com.app.service.HomeService"/>
                <c:set var="list" value="${hServ.findAll() }"/>
                <c:forEach var="e" items="${list}">
                	<tr>
                		<td><c:out value="${e.examEventID}"/></td>
	                    <td>${e.name}</td>
	                    <td>${e.startDate }</td>
	                    <td>${e.endDate }</td>
	                    <td>
	                    	<c:choose>
	                    		<c:when test="${e.isActiveEvent }">
	                    			<i class="fa fa-check-circle text-success" style="font-size:20px"></i>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<i class="fa fa-close text-warning" style="font-size:20px"></i>
	                    		</c:otherwise>
	                    	</c:choose>
	                    </td>
	                    <td>
	                        <a href="" class="btn btn-success rounded-pill px-4">Update</a>
	                    </td>
                	</tr>
                </c:forEach>
                <tr>
                    <th>Exam Event Id</th>
                    <th>Exam Event Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Completion Status</th>
                    <th>Update</th>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>