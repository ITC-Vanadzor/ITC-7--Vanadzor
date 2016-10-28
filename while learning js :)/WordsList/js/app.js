var words = [];
var uniqueWords = [];
i=0;
function addWord() {
    var newWord = document.getElementById('newWord').value;
    words.push(newWord);
    var ul = document.getElementById("list");
    var li = document.createElement("li");
    li.appendChild(document.createTextNode(newWord));
    ul.appendChild(li);
    cleanInputBox();
    updateUniqueWordsList(newWord);
}

function cleanInputBox(){
    $('#newWord').val("");
}

function removeWord() {

}

function updateUniqueWordsList(word) {
    $.each(words, function(i, word){
        if($.inArray(word, uniqueWords) === -1) uniqueWords.push(word);
    })
}

function showUniqueWordsList() {
    document.getElementById("demo").innerHTML = uniqueWords;
}
