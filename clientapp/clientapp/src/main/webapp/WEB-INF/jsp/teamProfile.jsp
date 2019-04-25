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
  
  .sec{
   margin-left:1%;
   margin-right:1%;
  }
   .avtar{
    display: block;
    width: 50%;
    margin:auto;
  }
/*   img{
    width: 100%; 
    height: 100%; 
    object-fit: contain;
  } */ 
  
  .row .column5{
    width:40%;
  }
  .row .column7{
    width:56%;
  }
  .row .column5,.row .column7{
      background-color:lavenderblush;
	  position: relative;
      min-height: 1px;
      padding-right: 15px;
      padding-left: 15px;
	  display:inline-block;
  }

.field{
  margin:10px 0;
   background-color:aquamarine;
  
}

@media (min-width: 768px)
  .column5,.column7{
    float:left;
  }
  

  
  th,td {
    text-align: center;
    padding: 15px;
}

  .part{
    margin: 10% 0;
    text-align: -webkit-center;
    background-color: aquamarine;
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
     <div class="container-fluid">
        <div class="row">
         <div class="col-sm-5" style="">
         <div style="text-align:center"><h3 id="player" style="display:inline-block;color:green;padding-right:10px;">Abhishek Sinha</h3><h4 style="color:black;display:inline-block;">(01-03-1989)</h4></div>
         
         <div class="conent-wrapper">
         
             <div class="avtar-container">
               <div class="avtar"><img alt="" src="/images/cricketer_avtar.jfif"></div>
             </div>
             <div class="profile-info-container">
<!--                 <div class="container-fluid"> -->
                  <div class="row">
                     <div class="column5 mar">
                        <h4 class="field">Matches Played:</h4>
                        <h4 class="field">Total Wins:</h4>
                        <h4 class="field">Total Defeated</h4>
                        <h4 class="field">No Results:</h4>
                        <h4 class="field">Points:</h4>
                     </div>
                     <div class="column7 performance-container">
                       
                     </div>
                  </div>
<!--                 </div> -->
             </div>
         
         </div>
         </div>
         <div class="col-sm-6 sec" style="">
         <h4 style="color:green;text-align:center">Players:</h4>
         <div class="content-wrapper">
            <div class="summary">
               <div class="batting part">  
                 <div>
                   <table class="team-details-container">
                     
                   </table>
                 </div>
               </div>
           
            </div>
         </div>
         </div>
        </div>
     </div>
  </div>
</div>
<div></div>
<script>
let loc=window.location.href;
var url = new URL(loc);
var id = url.searchParams.get("tId");
var cid=url.searchParams.get("cId");
console.log(cid,id);
function loadTeam(){

	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     allPlayers = JSON.parse(this.response);
		 setTeam(allPlayers);
	    }
	  };
	xhttp.open("get","http://localhost:7070/api/team/playersBasedOnTeam?id="+id,true);
	xhttp.send();
}

function setTeam(allPlayers){
	elements=document.getElementsByClassName("team-details-container")[0];
	allPlayers.forEach(function(player){
		elements.innerHTML+="<tr><th><a href='/player?pid="+player.id+"&cid="+cid+"'>"+player.playerName+"</a></th></tr>"
	})
}
loadTeam();

function loadPerformance(){
	let loc=window.location.href;
	var url = new URL(loc);
	var id = url.searchParams.get("tId");
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	performance = JSON.parse(this.response);
	    	setPerformance(performance);
	    }
	  };
	xhttp.open("get","http://localhost:7070/api/scoreboard/matchscore/team-performance/"+id,true);
	xhttp.send();
}

function setPerformance(performance){
	elements=document.getElementsByClassName("performance-container")[0];
		elements.innerHTML+="<h4 class='field'>"+performance.matchesPlayed+"</h4>"+
		                     "<h4 class='field'>"+performance.win+"</h4>"+
		                     "<h4 class='field'>"+performance.loss+"</h4>"+
		                     "<h4 class='field'>"+performance.noResult+"</h4>"+
		                     "<h4 class='field'>"+performance.points+"</h4>"
}

loadPerformance();

</script>

</body></html>