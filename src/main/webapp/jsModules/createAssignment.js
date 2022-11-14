document.getElementById("languages").addEventListener("keyup", function(event) {
   //Add the small divs of languages
    if (event.key == " " ||
        event.code == "Space" ||
        event.keyCode == 32 ) {
        var language = document.getElementById("languages").value;
        language = language.trim();
        var languageDiv = document.createElement("div");
        languageDiv.className = "languageDiv";
        //Append the  div to the div of languages
        languageDiv.innerHTML = language;
        document.getElementById("languages_container").appendChild(languageDiv);
        //Style the div
        languageDiv.style.display = "inline-block";
        languageDiv.style.paddingInline = "8px";
        languageDiv.style.paddingBlock = "5px";
        languageDiv.style.marginLeft = "5px";
        languageDiv.style.marginTop = "5px";
        languageDiv.style.backgroundColor = "#EAEAEA";
        languageDiv.style.border = "round";
        languageDiv.style.borderRadius = "5px";
        languageDiv.style.cursor = "pointer";
        document.getElementById("languages").value = "";
        //add to the input thats going to be send to the server
        document.getElementById("invisible_language_input").value += language + " ";
    }
})

//remove the elemnet when clicked
document.querySelectorAll(".languageDiv").forEach(function (languageDiv) {
    console.log("in");
    languageDiv.addEventListener("click", function (event) {
        event.target.remove();
        document.getElementById("invisible_language_input").value = document.getElementById("invisible_language_input").value.replace(event.target.innerHTML + " ", "");
    })
})
