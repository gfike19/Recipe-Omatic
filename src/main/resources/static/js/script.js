let counter = 1;
let limit = 30;
function addInput(divName){
    if(counter == limit){
        alert("You have reached the limit of " + counter + " ingredients");
    }
    else{
        let newDiv = document.createElement('div');
        newDiv.innerHTML = "Ingredient " + (counter + 1) + '<br><input type="text" placeholder="Ingredient" name="myIngredients[]">';
        document.getElementById(divName).appendChild(newDiv);
        counter++;
    }
}
let button = document.getElementById();
button.addEventListener("click", function (event)){
  event.stopPropagation();
}