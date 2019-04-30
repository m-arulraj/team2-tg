<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Sign Up</title>
</head>
<body>
	<style>
.main-body-wrapper {
	width: 80%;
	margin: auto;
}

.main-body-wrapper .w3-top, .main-body-wrapper .w3-button {
	position: unset;
}

.mid-wrapper {
	margin: 20px 0;
}

.mid-col {
	background-color: white;
	position: relative;
	min-height: 1px;
	padding-right: 15px;
	padding-left: 15px;
	width: 32.33%;
	display: inline-block;
}

.mid-col.sec {
	margin-left: 1%;
	margin-right: 1%;
}

@media ( min-width : 768px) .mid-col {
	float
	:left
	;
	
  
}

.err-msg {
	color: azure;
	display: none;
	font-weight: bold;
	padding: 8px 0;
}

.input-title {
	display: block;
	padding: 8px 16px;
	background-color: darkseagreen;
}

input, select {
	width: -webkit-fill-available;
	padding: 12px 16px;
}

.form-container {
	width: 30%;
	margin: auto;
	background-color: darkcyan;
	padding: 15px 0px 0px;
}

.btn {
	padding: 16px;
	background-color: floralwhite;
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
					<a
						class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1"
						href="javascript:void(0)" onclick="w3_open()"><i
						class="fa fa-bars"></i></a> <a href="#"
						class="w3-bar-item w3-button w3-theme-l1">Logo</a> <a href="#"
						class="w3-bar-item w3-button w3-hide-small w3-hover-white">Teams</a>
					<a href="#"
						class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contests</a>
					<a href="#"
						class="w3-bar-item w3-button w3-hide-small w3-hover-white">Rankings</a>
					<a href="#"
						class="w3-bar-item w3-button w3-hide-small w3-hover-white">Plyaers</a>
					<a href="#"
						class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Schedule</a>

				</div>
			</div>
		</div>

		<div class="mid-wrapper">
			<div>
				<div class="form-container">
						<form:form method="post" action="/signup"
							modelAttribute="userRole">
							<h3 style="color: white; text-align: center">Sign Up</h3>

							<label class="input-title" for="name">Name:</label>
							<form:input class="req form-data" type="textbox"
								path="user.userName" placeholder="Enter your name" />
							<span class="err-msg">Name is required</span>

							<label class="input-title" for="email">Email Id:</label>
							<form:input class="req email form-data" type="email"
								path="user.email" placeholder="Enter your email id" />
							<span class="err-msg">Email is required</span>

							<label class="input-title" for="mobile">Contact No:</label>
							<form:input class="req mob form-data" type="textbox"
								path="user.mobileNumber" placeholder="Enter your mobile no"
								onkeypress="onlyNumber(event)" />
							<span class="err-msg">Enter 10 digits number</span>

							<label class="input-title" for="dob">Date of Birth:</label>
							<form:input class="req form-data" type="date" path="user.userDob"
								placeholder="Enter Date of Birth" />
							<span class="err-msg">Date is not valid</span>

							<label class="input-title" for="address">address</label>
							<form:input class="req form-data" type="textbox"
								path="user.address" placeholder="Enter address" />
							<span class="err-msg">address requied</span>

							<label class="input-title" for="role">Role</label>
							<form:select path="role">
								<form:options items="${userRoleList}" />
							</form:select>

							<span class="err-msg">role is requied</span>

							<label class="input-title" for="password">Password</label>
							<form:input id="pass" class="req form-data" type="textbox"
								path="user.password" placeholder="Enter password" />
							<span class="err-msg">Password required</span>

							<input type="submit" class="btn" value="Register">

						</form:form>
			
				</div>
				<div style="padding: 40px 0;"></div>
			</div>
</div>

			<script>
				
			</script>
</body>
</html>