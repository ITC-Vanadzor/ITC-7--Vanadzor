function showGreetingMessage() {
   var name = document.getElementById('uname').value;
   name = $.trim(name);
   document.write("Welcome" + name);
}