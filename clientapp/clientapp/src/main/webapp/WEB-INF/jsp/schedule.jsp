<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
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
     .schedule{
        width: -webkit-fill-available;
        padding: 22px 20px;
     }
     .form-container{
      width: 50%;
      margin: auto;
      background-color: darkcyan;
      padding: 15px ;
         
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
#mod{
 top:55px;
}
 tr{
    border: 1px solid black;
  }
  
  th,td {
    text-align: center;
    padding:12px;
    border: 1px solid black;
    color:aliceblue
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
  
  
  <div class="mid-wrapper">
       <div class="all-schedules">
        <!--  <div class="form-container">
           <span class="schedule">Venue</span>
           <span class="schedule">Match Date</span>
           <span class="schedule">Team  One</span>
           <span class="schedule">Teaam Two</span>
          </div>
          <div class="form-container">
           <span class="schedule">Dr.Dy.Ptil Stadium</span>
           <span class="schedule">30.10.2020</span>
           <span class="schedule">Kochi kings</span>
           <span class="schedule">Pune Perfects</span>
          </div> -->
          <div class="form-container">
          <table class="schedule-container">
           <tbody><tr>
              <th>Venue</th><th>Match Date</th><th>Team  One</th><th>Teaam Two</th><th>Other</th>
           </tr>
           
          </tbody></table>
          </div>
                <button class="btn" style="width:50%;margin:auto;display:block;margin-top:20px" onclick="openModal()">Add Schedule</button>
                 
       </div>

   <div style="padding:40px 0;"></div>
</div>

<div id="mod" class="modal">
  <div>
     <div class="form-container">
        <form method="post" action="#">
          <span style="color:white;text-align:center;width:80%;display:inline-block">Add Schedule</span>  
          <span style="color:red;font-weight:bold;font-size:26px;" onclick="closeModal()">X</span>                  
          <label class="input-title" for="venue">Match Venue:</label>
          <input class="req" type="textbox" name="venue" placeholder="Enter Venue">
          <label class="input-title" for="date">Match Date:</label>
          <input class="req" type="date" name="date" placeholder="Enter match date">
          <label class="input-title" for="one">Team One:</label>
          <input class="req" type="textbox" name="one" placeholder="Enter first team">	  
		  <label class="input-title" for="two">Team Two:</label>
          <input class="req" type="textbox" name="two" placeholder="Enter second team">
          <input type="submit" class="contest-btn" value="Add schedule">
        </form> 
     </div>
   </div>
</div>
</div>
<script>
     function openModal(e,schedule){
    	 document.getElementById("mod").style.display="block";
    	  if(schedule){
    		  els=document.getElementsByClassName("req");
    		  els[0].value=schedule.venue;
    		  els[1].value=schedule.matchDate;
    		  els[2].value=schedule.teamOne;
    		  els[3].value=schedule.teamTwo;
    	  }
     }
     
     function closeModal(){
    	 document.getElementById("mod").style.display="none";
     }
     

     
    	 function loadSchedules(){
    		let xhttp=new XMLHttpRequest();
    		xhttp.onreadystatechange = function() {
    		    if (this.readyState == 4 && this.status == 200) {
    		    	allSchedules = JSON.parse(this.response);
    		     setSchedules(allSchedules);
    		    }
    		  };
    		xhttp.open("get","http://10.5.113.66:8090/api/schedule",true);
    		xhttp.send();
    	}

    	function setSchedules(allSchedules){
    		elements=document.getElementsByClassName("schedule-container")[0];
    		elements.innerHTML="";
    		allSchedules.forEach(function(schedule){
    			elements.innerHTML+="<tr><td>"+schedule.venue+"</td><td>"+schedule.matchDate+"</td><td>"+schedule.teamOneName+
    			                    "</td><td>"+schedule.teamTwoName+"</td><td>"+
    			                    "<button class='btn' style='margin:auto;display:block;margin-top:20px'onclick='openModal(true,"+JSON.stringify(schedule)+")'>"+
    			                    "Update</button></td></tr>"
    		})
    	}

    	loadSchedules();
</script>

</body></html>