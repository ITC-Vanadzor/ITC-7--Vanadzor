$( document ).ready(function() {
    $("#myForm").validate({
        rules: {
            username: 'required',
            password: 'required'
        },
        messages: {
            username: 'Please specify username',
            password: 'Please specify your password'
        },
        errorElement: 'div'
    });
});

function showGreetingMessage() {
    if ($("#myForm").valid()) {
    var username = $.trim($('#uName').val());
    $(".hidden-element").hide();
        var greetingText = $("#greetingText");
        $(greetingText).html( 'Welcome ' + username);
        $(greetingText).css('display', 'block');
    }
}