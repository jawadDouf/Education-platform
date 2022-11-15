// display the adding  forms
document.getElementById("addingUserButton").addEventListener("click",()=>{
        document.getElementById("form_container").style.display = "block";
        document.getElementById("overlay").style.display = "block";
})
//Shut down the adding forms
document.getElementById("overlay").addEventListener("click",()=>{
        document.getElementById("form_container").style.display = "none";
        document.getElementById("overlay").style.display = "none";
})

// display the assign  forms
document.querySelectorAll("#assign_form_button").forEach((button)=>{
        button.addEventListener("click",()=>{
                console.log("assign button clicked");
                document.getElementById("assign_form_container").style.display = "block";
                document.getElementById("overlay_2").style.display = "block";
                document.getElementById("assign_form_container").setAttribute("data-user",button.parentElement.getAttribute("id"));
        })
})






// Shut down the assign forms
document.getElementById("overlay_2").addEventListener("click",()=>{
        document.getElementById("assign_form_container").style.display = "none";
        document.getElementById("overlay_2").style.display = "none";
})