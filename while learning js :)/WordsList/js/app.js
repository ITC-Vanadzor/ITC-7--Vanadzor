var words = [];
function addWord() {
    var newWord = $('#newWord').val();
    words.push(newWord.toLowerCase());
    var ul = document.getElementById('list');
    var span = $("<span id='listSpan'></span>").text(newWord);
    var li = $("<li class='listItem'></li>");
    var removingButton = $("<button type='button' onclick='removeWord(this)' id='deleteButton'></button>");
    $(li).append(span);
    $(li).append(removingButton);
    $(ul).append(li);
    cleanInputBox();
}

function removeWord(element){
    var removingElement = $(element).prev().text();
    var index = words.indexOf(removingElement);
    if (index > -1) {
        words.splice(index, 1);
        $.unique(words.slice()).toString()
    }
    $(element).parent('li').remove();
}

function cleanInputBox(){
    $('#newWord').val("");
}

function showUniqueWordsList() {
    document.getElementById("demo").innerHTML =  $.unique(words.slice()).toString();
}