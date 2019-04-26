 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
<script src=""></script>
<link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>
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
        color:azure;
        display:none;
        font-weight:bold;
        padding:8px 0;
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
    .btn{
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

/* .contest-btn:hover {
  background-color: #4CAF50;
  color: white;
} */
</style>
</head>
<body style="background-color: aliceblue;">
<%-- <sec:authentication property="principal"/>
 Welcome Mr. ${principal.username} --%>
 <div class="main-body-wrapper">
   <div class="nav-container">
   <div class="">
   <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
   <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1"
		href="javascript:void(0)" onclick="w3_open()"><i
		class="fa fa-bars"></i></a> <a href="#"
		class="w3-bar-item w3-button w3-theme-l1">Logo</a> 
		<a href="/logout"class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white w3-right">Log Out</a>
  </div>
  </div>
  </div>
 <h3 >Welcome  <security:authentication property="principal.userName" /></h3>
  <div class="mid-wrapper">
   
    <div class="form-container">
        <form method="post" action="" onsubmit="formSubmission(event)">
            <h3 style="color:white;text-align:center">Player Updation</h3>                    
          <label class="input-title" for="playerName">Player Name:</label>
          <input class="req"  name="playerName" placeholder="Enter player name"/>
          <span class="err-msg">Team Name is required</span>          
          
           <label class="input-title" for="playerRole">player Role:</label>
          <input class="req"  name="playerRole" placeholder="Enter player Role in a team"/>
          <span class="err-msg">player Role year is required</span>
          
        <label class="input-title" for="playerDob">Date of Birth:</label>
							<input class="req form-data" type="date" path="user.userDob"
								placeholder="Enter Date of Birth" />
							<span class="err-msg">Date is not valid</span>

          
          <label class="input-title" for="birthPlace">player birthPlace:</label>
          <input class="req"  name="birthPlace" placeholder="Enter player birthPlace in a team"/>
          <span class="err-msg">player Role year is required</span>
          
          <label class="input-title" for="battingStyle">player batting Style:</label>
          <input class="req"  name="battingStyle" placeholder="Enter player battingStyle in a team"/>
          <span class="err-msg">player battingStyle  is required</span>
          
           <label class="input-title" for="bowlingStyle">player bowling Style:</label>
          <input class="req"  name="bowlingStyle" placeholder="Enter player bowlingStyle in a team"/>
          <span class="err-msg">player bowlingStyle  is required</span>
          
          <label class="input-title" for="team">TeamId:</label>
          <input class="contest-id"  value ="${tid}" disabled/>
           
          <input type="submit" class="btn" value="Update player"  />
        </form> 
     </div>
</div>
</div>
<script>
let loc=window.location.href;
var url = new URL(loc);
var tId = url.searchParams.get("tId");
var id = url.searchParams.get("id");

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
   
   function formSubmission(event){
	   event.preventDefault();
	   inputs=document.getElementsByTagName("input");
	   let t = {id:inputs[6].value}
	   let player={playerName:inputs[0].value,playerRole:inputs[1].value,playerDob:inputs[2].value,birthPlace:inputs[3].value,battingStyle:inputs[4].value,bowlingStyle:inputs[5].value,team:t};
	   console.log(JSON.stringify(player));
	   console.log(id);
	   window.location.assign("/teamplayer?tid="+t.id);
   	 let request=new XMLHttpRequest();
	   request.open("put","/update-player/"+id,true);
	   request.setRequestHeader("Content-type", "application/json");
	   request.send(JSON.stringify(player));
   }
   function loadPlayer(){
		
		let xhttp=new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	 inputs=document.getElementsByTagName("input");
		    	
/* 		  	   let team={teamName:inputs[0].value,introducedOn:inputs[1].value,contestId:inputs[2].value,teamManagerId:inputs[3].value};
*/		    let p = JSON.parse(this.response);
			 inputs[0].value=p.playerName;
			inputs[1].value= p.playerRole;
			inputs[2].value= p.playerDob;
			inputs[3].value= p.birthPlace;
			inputs[4].value= p.battingStyle;
			inputs[5].value= p.bowlingStyle;
			
		    console.log(p);
		    }
		  };
		 xhttp.open("get","http://localhost:7070/api/team/player/"+id,true); 
		xhttp.send();
	}
 
  loadPlayer();
   </script>
</body>
</html>