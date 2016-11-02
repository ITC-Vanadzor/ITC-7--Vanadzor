var words = [];
var listItemId;
listItemId = 0;
function addWord() {
    var newWord = $('#newWord').val();
    words.push(newWord.toLowerCase());
    var ul = document.getElementById('list');
    var span = $("<span></span>").text(newWord);
    var li = $("<li id='" +listItemId+"'></li>");
    var removingButton = document.createElement("BUTTON");
    var text = document.createTextNode("X");
    removingButton.appendChild(text);
    removingButton.setAttribute('onclick', 'removeWord(\'' +listItemId+'\')');
    removingButton.setAttribute('type', 'button');
    listItemId++;
    $(li).append(span);
    $(li).append(removingButton);
    listItemId++;
    $(ul).append(li);
    cleanInputBox();
}

function removeWord(id){
    var removingElement;
    removingElement =  $("#"+id+' span').text();
    for(var i=0; i<words.length;i++ )
        {
            if(words[i]==removingElement)
            {
                words.splice(i,1);
                break;
            }
        }
    $("#"+id).remove();
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
