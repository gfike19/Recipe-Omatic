//let counter = 1;
//let limit = 30;
//function addInput(divName){
//    if(counter == limit){
//        alert("You have reached the limit of " + counter + " ingredients");
//    }
//    else{
//        let newDiv = document.createElement('div');
//        document.getElementById(divName).appendChild(newDiv);
////        document.getElementById(quantity).appendChild(newDiv);
////        document.getElementById(measurement).appendChild(newDiv);
////        document.getElementById(ingredient).appendChild(newDiv);
//        counter++;
//    }
//}

//let button = document.getElementById("dynamicInput");
//button.addEventListener("click", function (event)){
//    let counter = 1;
//    let limit = 30;
//        if(counter == limit){
//            alert("You have reached the limit of " + counter + " ingredients");
//        }
//         else{
//            let newDiv = document.createElement('div');
//            document.getElementById(divName).appendChild(newDiv);
//            document.getElementById(quantity).appendChild(newDiv);
//            document.getElementById(measurement).appendChild(newDiv);
//            document.getElementById(ingredient).appendChild(newDiv);
//            counter++;
//    }
//    event.stopPropagation();
//}

//var i = 0;
//
//function duplicate() {
//    var original = document.getElementById('duplicator' + i);
//    var clone = original.cloneNode(true); // "deep" clone
//   clone.id = "duplicator" + ++i; // there can only be one element with an ID
//    clone.onclick = duplicate; // event handlers are not cloned
//    original.parentNode.appendChild(clone);
//}

//var i = 0;
//var original = document.getElementById('duplicator');
//
//function duplicate() {
//    var clone = original.cloneNode(true); // "deep" clone
//    clone.id = "duplicator" + ++i;
//    original.parentNode.appendChild(clone);
//}

//    let button = document.getElementById("duplicator");
//    button.addEventListener("click", function (event) {
//        console.log("button clicked");
//    });

//(function() {
//   var button=document.getElementById("add-more");
//   button.addEventListener('click', function(event) {
//      event.preventDefault();
//      var cln = document.getElementsByClassName("item")[0].cloneNode(true);
//      document.getElementById("items").insertBefore(cln,this);
//      return false;
//   });
//})();

//var counter = 0;
//
//function moreFields() {
//	counter++;
//	var newFields = document.getElementById('dynamicInput').cloneNode(true);
//	newFields.id = '';
//	newFields.style.display = 'block';
//	var newField = newFields.childNodes;
//	for (var i=0;i < newField.length; i++) {
//		var theName = newField[i].name
//		if (theName)
//			newField[i].name = theName + counter;
//	}
//	var insertHere = document.getElementById('writeroot');
//	insertHere.parentNode.insertBefore(newFields,insertHere);
//}
//
////window.onload = moreFields;