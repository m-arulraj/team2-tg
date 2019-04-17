 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html><head>
<title>The Gamer</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="/js/user.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-green.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src=""></script>
<link href="https://fonts.googleapis.com/css?family=Sofia" rel="stylesheet">
<style>
  .main-body-wrapper{
    width:80%;
	margin:auto;
  }
  .main-body-wrapper .w3-top, .main-body-wrapper .w3-button{
    position:unset;
  }
  .mid-wrapper{
   margin:20px 0;
  }
  .mid-col{
      background-color:white;
	  position: relative;
      min-height: 1px;
      padding-right: 15px;
      padding-left: 15px;
	  width:32.33%;
	  display:inline-block;
  }
  .mid-col.sec{
   margin-left:1%;
   margin-right:1%;
  }
  
  @media (min-width: 768px)
  .mid-col{
    float:left;
  }
  
 .err-msg{
         
    display: none;
    font-weight: bold;
    position: absolute;
    top: auto;
    color: red;
    left: 7%;
    border: 1px solid red;
    background-color: ghostwhite;
    border-radius: 23%;
    padding: 16px;
  }
      .input-title{
        display: inline-block;
        padding: 14px 25px;
        width: 40%;
        background-color: darkseagreen;
		    margin-left: 27px;
      }
     input,select{
        padding: 12px 16px;
        display: inline-block;
        width: 50%;
     }
     .form-container{
      width: 60%;
      margin: auto;
      background-color: darkcyan;
      padding: 15px 0px 0px;
         
    }
    .contest-btn{
          padding: 16px;
          background-color: floralwhite;
          border: none;
         color: black;
        text-align: center;
    text-decoration: none;
    transition-duration: 0.4s;
    cursor: pointer;
    margin: auto;
    border: 2px solid #4CAF50;
    width: 50%;
    display: block;
    }

.contest-btn:hover {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body style="background-color: aliceblue;">

 <div class="main-body-wrapper">
   <div class="nav-container">
   <div class="">
   <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
    <a href="#" class="w3-bar-item w3-button w3-theme-l1">Logo</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Teams</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contests</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Rankings</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Plyaers</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Schedule</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">News</a>
	<a href="#" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Photos</a>
	<a href="#" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">More</a>
  </div>
  </div>
  </div>
<%--   <security:authorize ifAnyGranted="ROLE_ADMIN">
    
</security:authorize>  --%>
 <h3 >Welcome Mr. <security:authentication property="principal.username" /></h3>

  <div class="mid-wrapper">
     <div>
     <div class="form-container">
        <form method="post" action="" onchange="valueCheck()" onsubmit="formSubmission(event)">
            <h3 style="color:white;text-align:center">Create Contest</h3>        
            
          <label class="input-title" for="contest">Contest Name:</label>
          <input class="req" type="textbox" name="contest" onkeypress="numNotAllowed(event)" placeholder="Enter Contest name">
          <span class="err-msg">Contest Name is required</span>

          <label class="input-title" for="start">Starting Date:</label>
          <input id="start" type="date" name="start" onfocus="isErrorDate(event)" placeholder="Enter Contest start Date">
          <span class="err-msg"></span>

          <label class="input-title" for="complete">Completion Date:</label>
          <input id="complete" type="date" name="complete" placeholder="Enter Contest completion Date">
          <span class="err-msg">Start date must be lesser<br> than completion date</span>
		  
		  <label class="input-title" for="type">Contest Type:</label>
          <select>
		     <option value="1">One Day</option>
			 <option value="1">Long Term</option>
		  </select>
          <span class="err-msg"></span>
		  
		  <label class="input-title" for="size">Contest size</label>
          <input class="req" type="number" name="size" placeholder="Enter Contest size">
          <span class="err-msg"></span>

          <input type="submit" disabled="" class="contest-btn" value="Create Contest">

        </form> 
     </div>
   </div>
   <div style="padding:40px 0;"></div>
</div>
</div>
<script>
 function numNotAllowed(event){
	
	 if((event.charCode>=48&&event.charCode<=57)){
		 event.preventDefault();
	 }
 }

  function formSubmission(event){
	  let elements=event.target.elements;
	  event.preventDefault();
	  let contest={contestName:elements[0].value,startingDate:elements[1].value,completionDate:elements[2].value,contestType:elements[3].value,contestSize:elements[4].value}
	   if(valueCheck()){
		  //window.location.assign("/schedule?id=2");
		  let xhttp=new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 201) {
			    	loc = xhttp.getResponseHeader("Location");
			    	openSchedule(loc);
			    }
			  };
	      
		  xhttp.open("post","http://10.5.113.66:8090/api/contest",true);
		  xhttp.setRequestHeader("Content-type", "application/json");
		  xhttp.send(JSON.stringify(contest)); 
	  } 

  }
  function openSchedule(loc){
	   var numberPattern = /\d+/g;
	     id=loc.match( numberPattern ) 
	     /* var url = new URL("http://10.5.113.66:8092"+loc);
	 	 var id = url.searchParams.get("id"); */
	 	 console.log(id);
	     window.location.assign("/schedule?id="+id);

  }
  
  function valueCheck(){
	  let btn=document.getElementsByClassName("contest-btn")[0];
	  btn.removeAttribute("disabled");
	  let returnValue=true;
	  let formData=document.getElementsByTagName("form")[0];
	  for(let i=0;i<formData.length;i++){
		  console.log(formData.elements[i].value);
		  if(!formData.elements[i].value){
			  btn.setAttribute("disabled","");
			  returnValue=false;
			  break;
		  }
	  }
	  return returnValue;
  }

     function checkError(event){
      let inputName=event.target.name;
    
      if(inputName=="complete")
         checkDate(event);
      if(inputName=="start")
          checkDate(event,true);
      else if(inputName=="contest")
         checkContest(event);
      else if(inputName=="size")
         checkMob(event);
    }

     var inputs=document.getElementsByTagName("input");
     for(let i=0;i<inputs.length;i++){
       inputs[i].addEventListener("focusout",checkError);
     }

     function isErrorDate(event){
    	 let completeDate=document.getElementById("complete");
    	 console.log(completeDate.value);
    	 if(completeDate.value){
    		 completeDate.nextElementSibling.style.display="none";
    		 
    	 }
     }
   

   function checkDate(event,isStart){
	   let stratingDate=new Date(document.getElementById("start").value);
	      let completeDate=new Date(document.getElementById("complete").value);
	      let errorElement=event.target.nextElementSibling;
	   if(isStart){
		   errorElement=document.getElementById("complete").nextElementSibling;		   
	   }
	    	  
      
      if(isStart)
    	  errorElement=document.getElementById("complete").nextElementSibling;
         console.log(stratingDate.getTime(),completeDate.getTime());
      if(stratingDate.getTime()<=completeDate.getTime()){
       errorElement.style.display="none";
      } 
      else{
       errorElement.style.display="inline-block";
      }
  }
   
/*    function getDateinNumber(date){
       let days=date.getDate();
       let months=date.getMonth()+1;
       let years=date.getFullYear();
       return ((years*365)+(months*12)+(days*24));
} */
   

function checkContest(event){
 let errorElement=event.target.nextElementSibling;
 if(!event.target.value)
 errorElement.style.display="inline-block";
 else
  errorElement.style.display="none";
}


function checkMob(event){
 let errorElement=event.target.nextElementSibling;
 length=event.target.value.split("").length;
console.log(length);
 if(length!=10)
 errorElement.style.display="inline-block";
 else
  errorElement.style.display="none";
}

function onlyNumber(e){
    if(!(e.charCode>=48&&e.charCode<=57)){
      console.log("done");
      e.preventDefault();
}
     
}
 
       function matchPasswords(event){
           if(document.querySelector("#pass").value!=event.target.value)
             event.target.nextElementSibling.style.display="inline-block";
           else
             event.target.nextElementSibling.style.display="none";
        }
       console.log(sessionStorage.getItem("username"));
       setSessionUser();
       document.getElementById("user").innerHTML+=sessionStorage.getItem("username");
       
       
   </script>

</body></html>