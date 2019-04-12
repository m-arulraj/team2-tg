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
  
  tr{
    border: 1px solid black;
  }
  
  th,td {
    text-align: center;
    padding: 5px;
    border: 1px solid black;
}

.part{
      margin: 10% 0
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
                        <h4 class="field">Birth Place:</h4>
                        <h4 class="field">Known As:</h4>
                        <h4 class="field">Batting Style:</h4>
                        <h4 class="field">Bowling Style:</h4>
                     </div>
                     <div class="column7">
                        <h4 class="field">Ranchi</h4>
                        <h4 class="field">Batsman</h4>
                        <h4 class="field">Right Handed</h4>
                        <h4 class="field">Right Handed</h4>
                     </div>
                  </div>
<!--                 </div> -->
             </div>
         
         </div>
         </div>
         <div class="col-sm-6 sec" style="">
         <h4 style="color:green;text-align:center">Player Summary</h4>
         <div class="content-wrapper">
            <div class="summary">
               <div class="batting part">
                 <h3>Batting Summary:</h3>
                 <div>
                   <table>
                     <tr>
                       <th>Matches</th><th>Runs Scored</th><th>Balls Faced</th><th>Average</th><th>Strike Rate</th><th>4'S</th><th>6'S</th><th>50'S</th><th>100'S</th><th>Best Score</th>
                     </tr>
                     <tr>
                       <td>10</td><td>500</td><td>740</td><td>50</td><td>82</td><td>75</td><td>30</td><td>3</td><td>2</td><td>183</td>
                     </tr>
                   </table>
                 </div>
               </div>
               <div class="bowling part">
                 <h3>Bowling Summary:</h3>
                 <div>
                   <table>
                     <tr>
                       <th>Matches</th><th>Overs Bowled</th><th>Wickets</th>
                     </tr>
                     <tr>
                       <td>5</td><td>50</td><td>15</td>
                     </tr>
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
<div ></div>
<script>


</script>
</body>
</html>