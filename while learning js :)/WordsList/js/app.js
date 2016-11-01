var words = [];
var listItemId;
listItemId = 0;

function addWord() {
    var newWord = $('#newWord').val();
    words.push(newWord.toLowerCase());
    var ul = document.getElementById('list');
    var li = document.createElement("LI");
    li.appendChild(document.createTextNode(newWord));
    li.setAttribute('id',listItemId);
    var removingButton = document.createElement("BUTTON");
    var text = document.createTextNode("X");
    removingButton.appendChild(text);
    removingButton.setAttribute("onclick", 'removeWord(\'' +listItemId+'\')');
    listItemId++;
    li.appendChild(removingButton);
    ul.appendChild(li);
    cleanInputBox();
}

function removeWord(id){ //This function should be updated

    var removingElement;
   removingElement = document.getElementById("#"+id).textContent;
    // alert(removingElement);
    // for(var i=0; i<words.length;i++ )
    //     {
    //         if(words[i]==removingElement)
    //         {
    //             words.splice(i,1);
    //             break;
    //         }
    //     }
   // $("#"+id).remove();
    alert(removingElement);

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
