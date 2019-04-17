<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>

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
<script src="/js/user.js"></script>
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
	<a href="/contest/create" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Create Contest</a>
	<a href="/login" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Log In</a>
  </div>
  </div>
  </div>
  
  <div class="mid-wrapper">
     <div class="container-fluid">
        <div class="row">
         <div class="mid-col" style=""><h4 style="color:green">Latest News</h4></div>
         <div class="mid-col sec" style="">
            <h4>Contests</h4>
            <table class="contest-container">
               <tbody><tr>
                 <th><a href="/contest?id=2">IPL(T20)</a></th><th>21st Jun</th><th>To</th><th>31st July</th>
               </tr>
            </tbody></table>
         
         </div>
         <div class="mid-col" style="">
             <h4>Top Scorer</h4>
           <!--   <div class="avtar-container">
               <div class="avtar"><img alt="" src="/images/cricketer_avtar.jfif"></div>
             </div> -->
         
         </div>
        </div>
     </div>
  </div>
</div>
<div></div>
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
	xhttp.open("get","http://10.5.113.66:8090/api/contest",true);
	xhttp.send();
}

function setContests(allContest){
	elements=document.getElementsByClassName("contest-container")[0];
	elements.innerHTML="";
	allContest.forEach(function(contest){
		elements.innerHTML+="<tr><th><a href='/contest?id="+contest.id+"'>"+contest.contestName+"</a></th><th>"+contest.startingDate+"</th><th>To</th><th>"+contest.completionDate+"</th></tr>"
	})
}

loadContest();
</script>

</body>
</body>
</html>