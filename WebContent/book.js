/**
 * 
 */

function getDetails(){
	jQuery.ajax({
        url: "http://localhost:8080/book_service/rest/books/" + $("#id").val(),
        type: "GET",
        contentType: "application/json",  
        dataType:'json',
        success: function(data, textStatus, errorThrown) {
            //here is your json.
              // process it
        	  $("#title").text(data.title);
        	  $("#price").text(data.price);

        },
        error : function(jqXHR, textStatus, errorThrown) {
        		$("#title").text("Sorry! Book not found!");
        		$("#price").text("");
        },
        timeout: 120000,
    });
};

function addBook() {
	jQuery.ajax({
        url: "http://localhost:8080/book_service/rest/books/add",
        type: "POST",
        data: {
        		"name": $("#name").val(),
        		"price": $("#price").val()
        },
        success: function(data, textStatus, errorThrown) {
        	  $("#addBookResult").text("Added");
        },
        error : function(jqXHR, textStatus, errorThrown) {
      	  $("#addBookResult").text("Unable to add");
        },
        timeout: 120000,
    });
}