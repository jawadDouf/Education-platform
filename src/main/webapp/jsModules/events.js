
document.getElementById("form_container").style.display = "none"
document.getElementById("overlay").style.display = "none";
// display the adding Teacher form
document.getElementById("addingUserButton").addEventListener("click",()=>{
        document.getElementById("form_container").style.display = "block";
        document.getElementById("overlay").style.display = "block";
})

document.getElementById("overlay").addEventListener("click",()=>{
        document.getElementById("form_container").style.display = "none";
        document.getElementById("overlay").style.display = "none";
})