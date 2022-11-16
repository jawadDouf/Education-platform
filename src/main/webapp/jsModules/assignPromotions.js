
document.querySelectorAll("li").forEach((promotion)=>{

        promotion.addEventListener("click",()=>{
                console.log("promotion clicked");
                document.getElementById("promoToAssignInput").value = promotion.innerHTML;
                document.querySelectorAll("#invisible").forEach((lista)=>{
                        lista.innerHTML += " " + document.getElementById("assign_form_container").getAttribute("data-user");
                })
                console.log(promotion.parentElement.children[1].innerHTML);
                let valueOfInput = "";
                promotion.parentElement.children[1].innerHTML.split(" ").forEach((word)=>{
                        if(word.length>0){
                                console.log(word);
                                valueOfInput += word + " ";
                        }


                });
                console.log(valueOfInput);
                document.getElementById("invisibleInputForNakedEye").value = valueOfInput.trim();
                console.log(document.getElementById("invisibleInputForNakedEye").value);

        })
})

