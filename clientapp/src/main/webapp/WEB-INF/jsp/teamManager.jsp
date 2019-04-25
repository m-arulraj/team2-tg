<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
 --%>
<!DOCTYPE html>
<html>
<head>
<title>The Gamer</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-green.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>
<style>
  .main-body-wrapper{
    width:100%;
margin:auto;
  }
  .main-body-wrapper .w3-top, .main-body-wrapper .w3-button{
    position:unset;
  }
  .mid-wrapper{
   margin:20px ;
  }
  .mid-col{
      background-color:white;
  position: relative;
      min-height: 1px;
      padding-right: 15px;
      padding-left: 15px;
  width:50%;
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
   th,td {
    text-align: center;
    padding: 10px;
    color:blue
}
.avtar{
    display: block;
    width: 50%;
    margin:auto;
  }
  .register-btn{
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
   
    }
      .err-msg{
        color:azure;
        display:none;
        font-weight:bold;
        padding:8px 0;
      }
      .input-title{
        display:block;
        padding:8px 16px;
        background-color: darkseagreen;
      }
     input,select{
        width: -webkit-fill-available;
        padding: 12px 16px;
     }
     .form-container{
      width: 30%;
      margin: auto;
      background-color: darkcyan;
      padding: 15px 0px 0px;
         
    }
    .btn{
       padding:16px;
       background-color:floralwhite; 
       border: none;
       color: black;
       text-align: center;
       text-decoration: none;
       transition-duration: 0.4s;
       cursor: pointer;
       border: 2px solid #4CAF50;
    }

.btn:hover {
  background-color: #4CAF50;
  color: white;
}
    
  
  img{
   
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
  </div>
  </div>
  </div>
  
  <div class="mid-wrapper">
     <div class="container-fluid">
        <div class="row">
<!--          <div class="mid-col" style=""><h4 style="color:green">Latest News</h4></div>
 -->         <div class="mid-col " style="">
            <h4>Contests</h4>
            <table class="contest-container">    </table>
              <div id="myDIV" style ="display:none">

 <div class="form-container">
        <form  action="http://localhost:7070/api/team" method="post" enctype="application/x-www-form-urlencoded" >
            <h3 style="color:white;text-align:center">Team Registration</h3>        
            
          <label class="input-title" for="teamName">Team Name:</label>
          <input class="req" type="textbox" name="teamName" placeholder="Enter Team name"/>
          <span class="err-msg">Team Name is required</span>
          
           <label class="input-title" for="introducedOn">Introduced Year:</label>
          <input class="req" type="textbox" name="introducedOn" placeholder="Enter introduced year of team"/>
          <span class="err-msg">introduced year is required</span>
          <label class="input-title" for="contestId">Contest Id:</label>
          <input class="contest-id"  value ="contestId" disabled/>
                    <label class="input-title" for="contestId">Team Manager Id:</label>
          
          <input class="manager-id"  value ="213" disabled/>


          <input type="submit" class="btn" value="Register"/>

        </form> 
     </div>
</div>
        
                       
       
         </div>

         
        <!--  <div class="mid-col" style="">
             <h4>Top Scorer</h4>
             <div class="avtar-container">
               <div class="avtar"><img alt="" src="/images/cricketer_avtar.jfif"></div>
             </div>
         
         </div> -->
        </div>
     </div>
  </div>
</div>
<div ></div>
<script>
let allContest;
function loadContest(){
let xhttp=new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     allContest = JSON.parse(this.response);
setContests(allContest);
    }
  };
xhttp.open("get","http://localhost:7070/api/contest",true);
xhttp.send();
}

function setContests(allContest){
elements=document.getElementsByClassName("contest-container")[0];
elements.innerHTML="";
allContest.forEach(function(contest){
elements.innerHTML+="<tr><th><a href='/contest?id="+contest.id+"'>"+contest.contestName+"</a></th><th>"+contest.startingDate+"</th>"+
		            "<th>To</th><th>"+contest.completionDate+"</th><th><button class ='register-btn' onclick='myFunction("+contest.id+")'>Register Team</button></th></tr>"
}
)
}

loadContest();
function myFunction(contestId) {
	elements= document.getElementsByClassName("contest-id")[0];
	elements.value=contestId;
	  var x = document.getElementById("myDIV");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	    
	  } else {
	    x.style.display = "none";
	  }
	}
function checkError(event){
    let inputName=event.target.name;
     if(inputName=="teamName")
       checkName(event);
     else if(inputName=="introducedOn")
    	 checkName(event);
  }

   var inputs=document.getElementsByTagName("input");
   for(let i=0;i<inputs.length;i++){
     inputs[i].addEventListener("focusout",checkError);
   }
   function checkName(event){
	   let errorElement=event.target.nextElementSibling;
	   if(!event.target.value)
	   errorElement.style.display="inline-block";
	   else
	    errorElement.style.display="none";
	  }
   
   function teamSubmission(event){
	   event.preventDefault();
	   inputs=document.getElementsByTagName("input");
	   data={teamName:inputs[0].value,introducedOn:inputs[1].value,contestId:inputs[2].value,teamManagerId:inputs[3].value};
       let request=new XMLHttpRequest();
	   request.open("post","http://localhost:7070/api/team",false);
	   request.setRequestHeader("Content-type", "application/json");
	   request.send(JSON.stringify(contest));
   }
</script>
</body>
</html>