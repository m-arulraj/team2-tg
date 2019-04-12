
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
     <div>
     <div class="form-container">
        <form method="post" action="#">
            <h3 style="color:white;text-align:center">Sign Up</h3>        
            
          <label class="input-title" for="name">Name:</label>
          <input class="req" type="textbox" name="name" placeholder="Enter your name"/>
          <span class="err-msg">Name is required</span>

          <label class="input-title" for="email">Email Id:</label>
          <input class="req email" type="email" name="email" placeholder="Enter your email id"/>
          <span class="err-msg">Email is required</span>

          <label class="input-title" for="mobile">Contact No:</label>
          <input class="req mob" type="textbox" name="mobile" placeholder="Enter your mobile no" onkeypress="onlyNumber(event)"/>
          <span class="err-msg">Enter 10 digits number</span>

          <label class="input-title" for="dob">Date of Birth:</label>
          <input class="req" type="date" name="dob" placeholder="Enter Date of Birth"/>
          <span class="err-msg">Date is not valid</span>

          <label class="input-title" for="address">address</label>
          <input class="req" type="textbox" name="address" placeholder="Enter address"/>
          <span class="err-msg">address requied</span>

          <label class="input-title" for="role">Role</label>
          <select>
            <option value="1">Team Owner</option>
            <option value="2">Contest Owner</option>
          </select>
          <span class="err-msg">role is requied</span>

          <label class="input-title" for="password">Password</label>
          <input id="pass" class="req" type="textbox" name="password" placeholder="Enter password"/>
          <span class="err-msg">Password required</span>

          <label class="input-title" for="confirm">Confirm Password</label>
          <input class="req" type="textbox" name="confirm" placeholder="Confirm" onchange="matchPasswords(event)"/>
          <span class="err-msg">Passwords mismatch</span>

          <input type="submit" class="btn" value="Register"/>

        </form> 
     </div>
   </div>
   <div style="padding:40px 0;"></div>
</div>
<script>
     function checkError(event){
      let inputName=event.target.name;
      if(inputName=="email")
         checkEmail(event);
      else if(inputName=="dob")
         checkDob(event);
      else if(inputName=="name")
         checkName(event);
      else if(inputName=="mobile")
         checkMob(event);
    }

     var inputs=document.getElementsByTagName("input");
     for(let i=0;i<inputs.length;i++){
       inputs[i].addEventListener("focusout",checkError);
     }

     function checkEmail(event){
          let email=event.target.value;
         let errorElement=event.target.nextElementSibling;
         if(email==""){
            errorElement.style.display="inline-block";
            errorElement.innerHTML="Email is required";
         }
         else if(!validateEmail(email)){
            errorElement.style.display="inline-block";
            errorElement.innerHTML="Enter valid email";
        }
         else
             errorElement.style.display="none";  
      }

    function validateEmail(email) {
         if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
           return (true)
         }
          return (false)
       }

   function checkDob(event){
      let currentDate=new Date();
      let inputDate=new Date(event.target.value);
      let errorElement=event.target.nextElementSibling;
      if(isValidDate(currentDate,inputDate)){
       errorElement.style.display="none";
      } 
      else{
       errorElement.style.display="inline-block";
      }
  }
   
function isValidDate(currDate,inDate){
       if(currDate.getFullYear()<inDate.getFullYear())
           return false;
       else if(currDate.getFullYear()==inDate.getFullYear()&&currDate.getMonth()<inDate.getMonth())
           return false;
       else if(currDate.getFullYear()==inDate.getFullYear()&&currDate.getMonth()==inDate.getMonth()&&currDate.getDate()<inDate.getDate())
           return false;
       else return true;
}

function checkName(event){
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
   </script>
</body>
</html>