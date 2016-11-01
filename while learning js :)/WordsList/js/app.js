var words = [];
var uniqueWords = [];
listItemId=0;

function addWord() {
    var newWord = $('#newWord').val();
    words.push(newWord.toLowerCase());
    var ul = document.getElementById('list');
    var li = document.createElement("LI");
    li.appendChild(document.createTextNode(newWord));
    li.setAttribute('id',listItemId);
    var image = document.createElement("IMG");
    image.setAttribute("src", "../resources/img/delete.jpg");
    image.setAttribute("alt", "Delete Icon");
    image.setAttribute("padding-top","1px");
    var removingButton = document.createElement("BUTTON");
    removingButton.setAttribute("id", listItemId);
    removingButton.setAttribute("onclick", 'removeWord(event)');
    listItemId++;
    removingButton.appendChild(image);
    li.appendChild(removingButton);
    ul.appendChild(li);
    cleanInputBox();
    updateUniqueWordsList(newWord);
}

function removeWord(event){
   // alert("***" + event);
}

function cleanInputBox(){
    $('#newWord').val("");
}

function updateUniqueWordsList(word) {
    $.each(words, function(i, word){
        if($.inArray(word, uniqueWords) === -1) uniqueWords.push(word);
    })
}

function showUniqueWordsList() {
    document.getElementById("demo").innerHTML = uniqueWords;
}
