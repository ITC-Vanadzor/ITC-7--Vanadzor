var words = [];
var listItemId;
listItemId = 0;

function addWord() {
    var newWord = $('#newWord').val();
    words.push(newWord.toLowerCase());
    var ul = document.getElementById('list');
    var li = document.createElement("LI");
    li.appendChild(document.createTextNode(newWord));
    li.setAttribute('class',listItemId);
    var removingButton = document.createElement("BUTTON");
    var text = document.createTextNode("X");
    removingButton.appendChild(text);
    removingButton.setAttribute("onclick", 'removeWord(\'' +listItemId+'\')');
    listItemId++;
    li.appendChild(removingButton);
    ul.appendChild(li);
    cleanInputBox();
}

function removeWord(id){ //Tins function should be updated 
    $("."+id).remove();
    if (id > -1) {
        words.splice(id, 1);
    }
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
