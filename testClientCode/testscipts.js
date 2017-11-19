function compare(a,b) {
  if (a.score < b.score)
    return 1;
  if (a.score > b.score)
    return -1;
  return 0;
}


function whytho(event){  
 	// event.preventDefault();
	var formData = new FormData($('#uploadForm')[0]);
	        var obj =[]; 
	$.ajax({
	    url: "http:localhost:8080/api",
	    type: "POST",
	    dataType: 'text',
	    contentType: false,
	    processData: false,
	    cache: false,
	    data: formData,
	    success: function(response) {
	        alert("success"); 
	        var js = JSON.parse(response); 
	        var allresults = js.images[0].classifiers[0].classes; 
	        	for(var i=0; i<allresults.length; i++){ 
	        		obj.push({score: allresults[i].score, prodName : allresults[i].class });  
	        	}   
	       obj.sort(compare); 
	       for(var j = 0; j<obj.length; j++){
	       		alert("score is: " + obj[j].score + " , name is: " + obj[j].prodName);
	       } 
	    },
	    error: function(err) {
	    	alert("no"); 
	    }
	});  
}


function tryme(){
	$.get("https://backflipp.wishabi.com/flipp/items/search?locale=en-ca&postal_code=N6G1A1&sid=4296250855351882&q=lays", 
		function(data){ 
			// alert(data);
			$("#update").html(Object.keys()); 
	})		
}

