function showGreetingMessage() {

    $("#myform").validate({
        rules: {
            username: "required",
            password: "required"
        },
        messages: {
            username: "Please specify username",
            password: "Please specify your password"

        },
        errorElement: 'div'
});

    if ($("#myform").valid()) {

    var username = document.getElementById('uname').value;
    username = $.trim(username);
    $("label").hide();
    $("input").hide();
    $("button").hide();
    var paragraph = document.createElement("p");
    var node = document.createTextNode("Welcome " + username);
    paragraph.appendChild(node);
    var element = document.getElementById("container");
    element.appendChild(paragraph);
}
}