<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.app.service.PaperService" %>
<%@ page import="com.app.models.Paper" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div class="container mt-3">
        <div class="row">
            <h3>Exam Event - Paper Configuration details</h3>
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
        <form action="ExamEventPaperDetails/update">
            <div class="row my-2">
                <div class="col-md-2">Select Paper *</div>
                <div class="col-md-10">
                    <select class="form-select" name="papers" id="papers">
                    	/* adding the papers of this event in the dropdown*/
                        <jsp:useBean id="pServ" class="com.app.service.PaperService"></jsp:useBean>
                        <c:set var="papers" value="${pServ.getSomePapers(examEvent.examEventID) }"/>
                       	<c:forEach var="p" items="${papers}">
                       		<option value="${p.getPaperID()}">${p.getName()}</option>
                       	</c:forEach>
                    </select>
                    <small><i>Papers which has no access to you are in disabled state</i></small>
                </div>
            </div>
            <div class="alert alert-secondary my-2">
                General Settings
            </div>
            <div class="row my-2">
                <div class="col-md-4">
                    Exam Type 
                </div>
                <div class="col-md-8">
                    <select class="form-select" name="examType" id="examType">
                        <option value="Main">Main</option>
                        <option value="Practice">Practice</option>
                    </select>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">No. of Attempts</div>
                <div class="col-md-8">
                    <input class="form-control" type="text" name="attempts" id="attempts">
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Identical Question Paper to all Candidate</div>
                <div class="col-md-8">
                    <input type="radio" name="iq" id="yes" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="iq" id="no" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Identical Item Sequence to all Candidate</div>
                <div class="col-md-8">
                    <input type="radio" name="is" id="yes" value="true">
                    <label for="yes">Yes(No Randomization)</label>
                    <input type="radio" name="is" id="no" value="false">
                    <label for="no">No(Randomization)</label>
                </div>
            </div>
            <div class="alert alert-secondary my-2">
                Exam Screen Settings
            </div>
            <div class="row my-2">
                <div class="col-md-4">Option Randomization</div>
                <div class="col-md-8">
                    <input type="radio" name="or" id="yes" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="or" id="no" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="alert alert-secondary my-2">
                Exam Interface Control Settings
            </div>
            <div class="row my-2">
                <div class="col-md-4">Disable Pallet Navigation</div>
                <div class="col-md-8">
                    <input type="radio" name="pn" id="yes" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="pn" id="no" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Skip Question</div>
                <div class="col-md-8">
                    <input type="radio" name="sq" id="yes" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="sq" id="no" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Answer Option Can be changed after attempt</div>
                <div class="col-md-8">
                    <input type="radio" name="ao" id="yes" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="ao" id="no" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Show Reset Answer Option</div>
                <div class="col-md-8">
                    <input type="radio" name="sr" id="yes" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="sr" id="no" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Show Notepad</div>
                <div class="col-md-8">
                    <input type="radio" name="sn" id="yes" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="sn" id="no" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-4">
                <div class="col-md-4"></div>
                <div class="col-md-8">
                    <a href="http://localhost:8080/ExamEventApp/proceed/${examEvent.examEventID}"+ class="btn btn-outline-secondary rounded-pill px-4">Back</a>
                    <input type="submit" value="Save" class="btn btn-outline-info rounded-pill px-4">
                    <a href="http://localhost:8080/ExamEventApp/Schedule.jsp" class="btn btn-outline-info rounded-pill px-4">Proceed</a>
                </div>
            </div>
        </form>

    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>