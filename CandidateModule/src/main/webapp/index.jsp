<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h5>
			Welcome !
		</h5>
		<form id="form" action="submit">
	    <div class="row">
	      <div class="col-2"></div>
	    
	      <div class="col-8">
	        <div class="container">
	         <h1>Candidate SignUp</h1>
	          <table class="table w100-table">
	           <tr>
	            <td>Id : </td>
	            <td><input type="number" name="id" id="id"></td>
	          </tr>
	          <tr>
	            <td>Name : </td>
	            <td><input type="text" name="name" id="name"></td>
	          </tr>
	          <tr>
	            <td>Username : </td>
	            <td><input type="text" name="uname" id="uname"></td>
	          </tr>
	          <tr>
	            <td>Password : </td>
	            <td><input type="text" name="pass" id="pass"></td>
	          </tr>
	          <tr>
	            <td>Description : </td>
	            <td><textarea name="desc" id="desc" cols="23" rows="3"></textarea></td>
	          </tr>
	          <tr>
	            <td>Gender : </td>
	            <td>
	              <input type="radio" name="gender" id="gender1" value="Male"> Male</input>
	              <br>
	              <input type="radio" name="gender" id="gender2" value="Female"> Female</input>
	              <br>
	              <input type="radio" name="gender" id="gender3" value="Other"> Other</input>
	            </td>
	          </tr>
	          <tr>
	            <td>Skills : </td>
	            <td>
	              <input type="checkbox" id="skill1" name="react" value="React">
	              <label for="skill"> React</label><br>
	              <input type="checkbox" id="skill2" name="mysql" value="MySQL">
	              <label for="skill"> MySQL</label><br>
	              <input type="checkbox" id="skill3" name="spring" value="Spring Boot">
	              <label for="skill"> Spring boot</label>
	            </td>
	          </tr>
	          <tr>
	            <td>Standard</td>
	            <td>
	              <select class="form-control" name="standard" id="standard">
	                <option value="First">First</option>
	                <option value="Second">Second</option>
	                <option value="Third">Third</option>
	                <option value="Fourth">Fourth</option>
	              </select>
	            </td>
	          </tr>
	          <tr>
	            <td>Preferred Programming Languages : </td>
	            <td>
	              <input type="checkbox" id="lang1" name="java" value="Java">
	              <label for="lang"> Java</label><br>
	              <input type="checkbox" id="lang2" name="cpp" value="CPP">
	              <label for="lang"> CPP</label><br>
	              <input type="checkbox" id="lang3" name="js" value="JavaScript">
	              <label for="lang"> JavaScript</label>
	            </td>
	          </tr>
	          <tr>
	            <td>Last Year Report Card : </td>
	            <td>
	              <input type="file" name="report" id="report">
	            </td>
	          </tr>
	          <tr>
	            <td><input id="reset" class="btn btn-secondary" type="reset" value="reset"></td>
	            <td><input id="submit" class="btn btn-primary" type="submit" value="Save"></td>
	          </tr>
	        </table>
	    </div>
	    </div>
	    <div class="col-2"></div>
	    
	    </div>
  </form>
	</div>

<script>
    $("#submit").click(function(event){
        event.preventDefault();
        
        let id = $("#id").val();
        let name = $("#name").val();
        let uname = $("#uname").val();
        let pass = $("#pass").val();
        let desc = $("#desc").val();
        let standard = $("#standard").val();

        let gender;
        if($("#gender1").is(":checked"))gender=$("#gender1").val();
        if($("#gender2").is(":checked"))gender=$("#gender2").val();
        if($("#gender3").is(":checked"))gender=$("#gender3").val();

        let skills = new Array();
        if($("#skill1").is(":checked"))skills.push($("#skill1").val());
        if($("#skill2").is(":checked"))skills.push($("#skill2").val());
        if($("#skill3").is(":checked"))skills.push($("#skill3").val());
        
        let langs = new Array();

        if($("#lang1").is(":checked"))langs.push($("#lang1").val());
        if($("#lang2").is(":checked"))langs.push($("#lang2").val());
        if($("#lang3").is(":checked"))langs.push($("#lang3").val());


        let data = {
            cid : id,
            name : name,
            uname : uname,
            pass : pass,
            desc : desc,
            gender :gender,
            skills : skills.toString(),
            standard : standard,
            langs : langs.toString()
        };

        $.ajax(
            {
                url: "http://localhost:8080/CandidateModule/submit",
                type: "GET",
                dataType: 'application/json',
                data:data,
                success: function(result){
                    console.log("success");
                    console.log(result);
                },
            	error: function(error){
                	if(error.status=200){
                		console.log(error.responseText);	
                    }
                	else{
                		console.log("error");
                	}
                }
            }
        );

        console.log(data);
    })
</script>
</body>
</html>