function showGreetingMessage() {
   if(validateForm()){
   var username = document.getElementById('uname').value;
      username = $.trim(username);
   $("label").hide();
   $("input").hide();
   $("button").hide();
   var paragraph = document.createElement("p");
   var node = document.createTextNode("Welcome " + username);
      paragraph.appendChild(node);
   var element = document.getElementById("container");
   element.appendChild(paragraph);}
}

function validateForm() {
   var username = document.forms["form"]["uname"].value;
   var password = document.forms["form"]["psw"].value;
   if (username == null || username == "" || password==null || password=="") {
      alert("The credentials of the user must be filled out");
      return false;
   }
   return true;
}