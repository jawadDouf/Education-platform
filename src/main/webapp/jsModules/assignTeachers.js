document.querySelectorAll("li").forEach((promotion)=>{
    console.log(promotion);
    promotion.addEventListener("click",()=>{
        console.log("promotion clicked");
        document.getElementById("promoToAssignInput").value = promotion.innerHTML;
        document.getElementById("invisibleInputForNakedEye").value = promotion;
        document.querySelectorAll("#invisible").forEach((input)=>{
            input.value +=" " + document.getElementById("assign_form_container2").getAttribute("data-user");
            input.name += "chosenPromotion";
        })

    })
})