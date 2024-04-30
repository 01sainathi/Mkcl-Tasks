<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <div class="container mt-3 main">
        <div class="row p-4 border shadow-sm">
            <h1 class="display-6">Exam Event - Add Paper</h1>
            <div class="alert alert-primary my-2" role="alert">
                <div class="row my-2">
                    <div class="col-md-3 col-12 fw-bold">
                        Exam event
                    </div>
                    <div class="col-md-9 col-12 ">
                        ${examEvent.name}
                        
                    </div>
                </div>
                <div class="row my-2">
                    <div class="col-md-6 col-12 ">
                        <div class="row">
                            <div class="col-6 fw-bold">Event Start Date</div>
                            <div class="col-6">${examEvent.startDate}</div>
                        </div>
                    </div>
                    <div class="col-md-6 col-12 ">
                        <div class="row">
                            <div class="col-6 fw-bold">Event End Date</div>
                            <div class="col-6">${examEvent.endDate}</div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- alert ended  -->

            <div class="row text-end">
                <div class="col-12 col-md-6 text-start">
                    <button class="btn btn-primary" onclick="showModal()">View Paper <span id="counter"
                            class="bg-white text-black rounded px-1 fw-bold">0</span></button>
                </div>

                <div class="col-12 col-md-6 ">
                    <div class="row text-end">
                        <div class="col-md-10 text-end m-0 p-0 w-50">
                            <input type="text" class=" form-control rounded-end rounded-pill">
                        </div>
                        <div class="col-md-2 p-0 m-0 text-start">
                            <input type="text" class="btn btn-success rounded-start rounded-pill  px-0" value="GO!">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="alert alert-success text-primary fw-bold my-3 "
                style="border: 1px solid rgb(2, 2, 96);color: rgb(2, 2, 96)!important;">Latest Published Paper List
            </div>
        </div>
        <div class="table-responsive">
            
            <table class="table table-hover">
                <thead>
                    <th>Paper Code </th>
                    <th>Paper Name </th>
                    <th>Paper Abbrevation</th>
                    <th>Add</th>
                </thead>
                
                <tbody id="newdata">
                    <tr>
                        <td>Papers</td>
                        <td>will</td>
                        <td>come</td>
                        <td>here</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="row text-center">
            <div class="col">
                <a href="http://localhost:8080/ExamEventApp/" class="btn btn-secondary rounded-pill px-4">Back</a>
                <button class="btn btn-success rounded-pill px-4" onclick="savePapers()">Save</button>
                <a href="http://localhost:8080/ExamEventApp/PaperConfig.jsp" class="btn btn-success rounded-pill px-4">Proceed</a>
            </div>
        </div>
    </div>
        <div id="mod" class="modal" tabindex="-1"> 
            <div class="modal-dialog"> 
                <div class="modal-content"> 
                    <div class="modal-header"> 
                        <h5 class="modal-title"> 
                            Paper Details 
                        </h5> 
                        <button type="button" 
                                class="btn-close"
                                data-bs-dismiss="modal" 
                                aria-label="Close"> 
                        </button> 
                    </div> 
                    <div class="modal-body"> 
                        <table class="table">
                        	<thead>
	                        	<tr>
	                        		<th>Sr.No.</th>
	                        		<th>Paper Name</th>
	                        		<th>Remove Paper</th>
	                        	</tr>
                        	</thead>
                        	<tbody id="selectedPapers">
                        		
                        	</tbody>
                        </table> 
                    </div> 
                    <div class="modal-footer"> 
                        <button type="button" 
                                class="btn btn-secondary" 
                                data-bs-dismiss="modal"> 
                            Close 
                        </button> 
                    </div> 
                </div> 
            </div> 
        </div>
		
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
    	let counter=0;
    	let list = [];
    	let toRemove = [0];
    	let toAdd = [0];
         $(document).ready(function () {

        	 $.ajax({
                 method: 'GET',
                 url: 'http://localhost:8080/ExamEventApp/papers/some',
                 contentType: 'application/json',
                 success: function (result) {
                 	let data = JSON.parse(result);
                    console.log(data);
                   
                    for(let i=0; i<data.length; i++){

                    	let obj = {"id": data[i].paperID, 
    							"name": data[i].name};
						list.push(obj);
                    }
						
						rerenderPapers(); 
                 },
                 error: function ajaxError(jqXHR) {
                     console.error('Error: ', jqXHR.responseText);
                 }
             });
             	
                $.ajax({
                    method: 'GET',
                    url: 'http://localhost:8080/ExamEventApp/papers',
                    contentType: 'application/json',
                    success: function (result) {
                        /*let data = result.substring(1, result.length-1);
                        let arr = data.split(",");*/
                        let data = JSON.parse(result);
                        console.log(data);
                        let html = ``;
                        for(let i=0; i<data.length; i++){
                        	html += '<tr id='+data[i].paperID+'>';
                            html += '<td>'+data[i].code+'</td>';
                            html += '<td>'+data[i].name+'</td>';
                            html += '<td>'+data[i].code+'</td>';
                            let counter = 0;
                            for(let j=0; j<list.length; j++){
								if(list[j].id != data[i].paperID){
									counter++;
								}
                            }
                            if(counter == list.length){
                                html += '<td>'+'<input onchange="paperSelected(this)" type="checkbox" class="checkbox" id="'+data[i].paperID+'" name="p'+data[i].paperID+'" value="'+data[i].name+'">'+'</td>'; 
                            }
                            else{
                                html += '<td>'+'<input onchange="paperSelected(this)" type="checkbox" class="checkbox" id="'+data[i].paperID+'" name="p'+data[i].paperID+'" value="'+data[i].name+'" checked>'+'</td>'
                                
                            }
                            
                            
                            html += '</tr>'
                        }
						
						document.getElementById("newdata").innerHTML = html;
						hideSelected();	
                    },
                    error: function ajaxError(jqXHR) {
                        console.error('Error: ', jqXHR.responseText);
                    }
                });

            })
            
            let modal = new bootstrap.Modal(document.getElementById("mod"));
         	function showModal(){
				modal.show();
            }

			function hideSelected(){
				for(let i=0; i<list.length; i++){
					$("#"+list[i].id).hide();
				}
			}
            function paperSelected(checkboxEle){

				if(checkboxEle.checked){
					
					let obj = {"id": checkboxEle.id, 
							"name": checkboxEle.value};
					list.push(obj);
					toAdd.push(obj.id);
					$(checkboxEle).parent().parent().hide();
					
					rerenderPapers();
                    
                    console.log(list);
				}
				else{
					counter--;
					document.getElementById("counter").innerText=counter;
				}
            }
            
            function rerenderPapers(){

            	document.getElementById("counter").innerText=list.length;
            	let a = document.getElementById("selectedPapers");
            	a.innerHTML = "";

				
				let html = "";
            	for(let i=0; i<list.length; i++){
            		let id=i+1;
					html += '<tr>';
					html += '<td>'+id+'</td>';
					html += '<td>'+list[i].name+'</td>';
					html += '<td><button id="'+list[i].id+'" class="btn btn-danger" onclick="remove(this)">remove</button></td>';
					html += '</tr>';
                }
                a.innerHTML = html;
            }

			
            function remove(removedEle){
            	toRemove.push(removedEle.id);
				for(let i=0; i<list.length; i++){
					if(list[i].id === removedEle.id){

						$('#'+list[i].id).show(); 
						let checkbox = document.getElementsByClassName("checkbox");
						
						checkbox[list[i].id-1].checked = false;
						list.splice(i,1);
					}
				}
				for(let i=0; i<toAdd.length; i++){
					if(toAdd[i] == removedEle.id){
						toAdd.splice(i,1);
					}
				}
				document.getElementById("counter").innerHTML = list.length;
				rerenderPapers();
            }

            function savePapers(){

				var papers = [0];
				for(let i=0; i<list.length; i++){
					papers.push(list[i].id);
				}
				console.log(papers);
				console.log("To remove :-");
				console.log(toRemove);
				console.log("To Add");
				console.log(toAdd);

				//deleting papers marked for deletion (which are in the toRemove[])
				$.ajax({
					method: 'POST',
					url: 'http://localhost:8080/ExamEventApp/ExamEventPaperDetails/delete',
					contentType: 'application/json',
					data: toRemove.toString(),
					success: function(result){
						console.log(result);
						//saving paper which are in the toAdd[]
						$.ajax({
							method: 'POST',
							url: 'http://localhost:8080/ExamEventApp/ExamEventPaperDetails/save',
							contentType: 'application/json',
							data: toAdd.toString(),
							success: function(result){
								toAdd = [0];
								alert("Papers added successfully");
								location.reload();
							},
							error: function(error){
								console.log(error)
							}
						})  
					},
					error: function(error){
						console.log(error)
					}		
				}) 
				
            }
            
    </script>

</body>

</html>