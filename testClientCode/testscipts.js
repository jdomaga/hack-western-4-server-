function whytho(){ 
// 	$.get("http:localhost:8080" , function( data ) {
// 		alert();
//   $( ".result" ).html( data );
//   alert( "Load was performed." );
// });
 
	var formData = new FormData($('#uploadForm')[0]);
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
	        alert(response);
	    },
	    error: function(err) {
	    	alert("sadeface");
	        // alert(err.responseText);
	    }
	}); 
	alert();
}


