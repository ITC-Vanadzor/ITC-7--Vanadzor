var words = [];
function addWord() {
    var newWord = $('#newWord').val();
    words.push(newWord.toLowerCase());
    var ul = document.getElementById('list');
    var span = $("<span></span>").text(newWord);
    var li = $("<li></li>");
    var removingButton = $("<button type=\"button\" onclick=\"removeWord(this)\" >X</button>");
    $(li).append(span);
    $(li).append(removingButton);
    $(ul).append(li);
    cleanInputBox();
}

function removeWord(element){
    var removingElement = $(element).prev().text();
    for(var i=0; i<words.length;i++ )
    {
        if(words[i]==removingElement)
        {
            words.splice(i,1);
            break;
        }
    }
    $(element).parent('li').remove();
}

function cleanInputBox(){
    $('#newWord').val("");
}

function showUniqueWordsList() {
    var uniqueWords = [];
    $.each(words, function(i, word){
        if($.inArray(word, uniqueWords) === -1) uniqueWords.push(word);
    });
    document.getElementById("demo").innerHTML = uniqueWords.toString();
}