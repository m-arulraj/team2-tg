function setSessionUser(){
	 var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 201) {
	    	sessionStorage.setItem("username", this.response);
	    	console.log(sessionStorage.getItem("username"));
	    }
	  };
   xhttp.open("GET", "/user", true);
   xhttp.send();
}
setSessionUser(); 