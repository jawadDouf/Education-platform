// display the assign  forms
document.querySelectorAll("#assign_form_button2").forEach((button)=>{
    button.addEventListener("click",()=>{
        console.log("assign button clicked");
        document.getElementById("assign_form_container2").style.display = "block";
        document.getElementById("overlay_22").style.display = "block";
        document.getElementById("assign_form_container2").setAttribute("data-user",button.parentElement.parentElement.children[0].textContent + " " + button.parentElement.parentElement.children[1].textContent);
    })
})

// Shut down the assign forms
document.getElementById("overlay_22").addEventListener("click",()=>{
    document.getElementById("assign_form_container2").style.display = "none";
    document.getElementById("overlay_22").style.display = "none";
})