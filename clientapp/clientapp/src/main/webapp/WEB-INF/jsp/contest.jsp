<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
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
<script src="/js/user.js"></script>
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
  
  img{
   
  }
  .form-container{
      width: 50%;
      margin: auto;
      background-color: darkcyan;
      padding: 15px ;
         
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
	<a href="/login" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Log In</a>
  </div>
  </div>
  </div>
  
  <div class="mid-wrapper">
    <div class="form-container">
      <table class="team-container">
        <tbody><tr><th>Team Name</th><th>Points</th></tr>
      </tbody></table>
    </div>
  </div>
</div>
<div></div>
<script>
let loc=window.location.href;
var url = new URL(loc);
var id = url.searchParams.get("id");
function loadContest(){
	
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     allTeam = JSON.parse(this.response);
		 setContests(allTeam);
	    }
	  };
	 xhttp.open("get","http://localhost:7070/api/team/"+id,true); 
	xhttp.send();
}

function setContests(allTeam){
	elements=document.getElementsByClassName("team-container")[0];
	allTeam.forEach(function(team){
		elements.innerHTML+="<tr><td><a href='/contest/team?cId="+id+"&tId="+team.id+"'>"+team.teamName+"("+team.introducedOn+")</a></td><td>"+""+"</td></tr>"
	})
}
loadContest();
</script>

</body></html>