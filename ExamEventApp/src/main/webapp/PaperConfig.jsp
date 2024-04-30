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
        <form onSubmit="return validate()" action="ExamEventPaperDetails/update">
            <div class="row my-2">
                <div class="col-md-2">Select Paper *</div>
                <div class="col-md-10">
                    <select class="form-select" name="papers" id="papers">
                    	<option value="">none</option>
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
                    	<option value="">none</option>
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
                    <input type="radio" name="iq" id="iq1" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="iq" id="iq2" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Identical Item Sequence to all Candidate</div>
                <div class="col-md-8">
                    <input type="radio" name="is" id="is1" value="true">
                    <label for="yes">Yes(No Randomization)</label>
                    <input type="radio" name="is" id="is2" value="false">
                    <label for="no">No(Randomization)</label>
                </div>
            </div>
            <div class="alert alert-secondary my-2">
                Exam Screen Settings
            </div>
            <div class="row my-2">
                <div class="col-md-4">Option Randomization</div>
                <div class="col-md-8">
                    <input type="radio" name="or" id="or1" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="or" id="or2" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="alert alert-secondary my-2">
                Exam Interface Control Settings
            </div>
            <div class="row my-2">
                <div class="col-md-4">Disable Pallet Navigation</div>
                <div class="col-md-8">
                    <input type="radio" name="pn" id="pn1" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="pn" id="pn2" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Skip Question</div>
                <div class="col-md-8">
                    <input type="radio" name="sq" id="sq1" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="sq" id="sq2" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Answer Option Can be changed after attempt</div>
                <div class="col-md-8">
                    <input type="radio" name="ao" id="ao1" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="ao" id="ao2" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Show Reset Answer Option</div>
                <div class="col-md-8">
                    <input type="radio" name="sr" id="sr1" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="sr" id="sr2" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-4">Show Notepad</div>
                <div class="col-md-8">
                    <input type="radio" name="sn" id="sn1" value="true">
                    <label for="yes">Yes</label>
                    <input type="radio" name="sn" id="sn2" value="false">
                    <label for="no">No</label>
                </div>
            </div>
            <div class="row">
            	<b id="error" class="text-success">All is well</b>
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
    <script>
		function validate(){

			let p = $("#papers").val();
			let e = $("#examType").val();
			let a = $("#attempts").val();

			if(p=="" || e=="" || a==""){
				
				/* $("#error").text("select paper, exam type and attempts"); */
				
				let error = document.getElementById("error");
				error.innerText = "select paper, exam type and attempts";
				error.classList.remove("text-success");
				error.classList.add("text-danger");
				return false;
			}
			let iq = "";
			if($("#iq1").is(":checked"))iq=$("#iq1").val();
			if($("#iq2").is(":checked"))iq=$("#iq2").val();

			let is = "";
			if($("#is1").is(":checked"))is=$("#is1").val();
			if($("#is2").is(":checked"))is=$("#is2").val();
			
			let or = "";
			if($("#or1").is(":checked"))or=$("#or1").val();
			if($("#or2").is(":checked"))or=$("#or2").val();

			let pn = "";
			if($("#pn1").is(":checked"))pn=$("#pn1").val();
			if($("#pn2").is(":checked"))pn=$("#pn2").val();

			let sq = "";
			if($("#sq1").is(":checked"))sq=$("#sq1").val();
			if($("#sq2").is(":checked"))sq=$("#sq2").val();

			let ao = "";
			if($("#ao1").is(":checked"))ao=$("#ao1").val();
			if($("#ao2").is(":checked"))ao=$("#ao2").val();

			let sr = "";
			if($("#sr1").is(":checked"))sr=$("#sr1").val();
			if($("#sr2").is(":checked"))sr=$("#sr2").val();

			let sn = "";
			if($("#sn1").is(":checked"))sn=$("#sn1").val();
			if($("#sn2").is(":checked"))sn=$("#sn2").val();
			

			if(iq=="" || is=="" || or=="" || pn=="" || sq=="" || ao=="" || sr=="" || sn==""){
				let error = document.getElementById("error");
				error.innerText = "All fields are mandatory";
				error.classList.remove("text-success");
				error.classList.add("text-danger");
				return false;
			}
			
			
			return true;
		}
    </script>
</body>
</html>