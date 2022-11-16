document.querySelectorAll("#edit").forEach((edit) => {
    edit.addEventListener("click", (e) => {
          document.getElementById("overlay3").style.display = "block";
          document.getElementById("form_container3").style.display = "block";
            console.log(e.target.getAttribute("data-id"));
            document.getElementById("form").getAttribute("class").concat(e.target.getAttribute("data-id"));

    })


});

document.getElementById("overlay3").addEventListener("click", (e) => {
    document.getElementById("overlay3").style.display = "none";
    document.getElementById("form_container3").style.display = "none";
});