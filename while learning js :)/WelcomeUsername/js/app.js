function showGreetingMessage() {
   var name = document.getElementById('uname').value;
   name = $.trim(name);
   $("label").hide();
   $("input").hide();
   $("button").hide();
   var para = document.createElement("p");
   var node = document.createTextNode("Welcome " + name);
   para.appendChild(node);
   var element = document.getElementById("container");
   element.appendChild(para);
}