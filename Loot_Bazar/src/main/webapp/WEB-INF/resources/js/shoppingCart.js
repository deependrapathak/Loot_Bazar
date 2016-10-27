$(document).ready(function() {
	
 
	
	addToShoppingCart = function(productId){
			$.ajax({
		 		url: 'addShoppingCart/' + productId,
		 		type: 'PUT',
				dataType: "json",
				success: function(response){
	 		 		alert("Product Successfully added to the Cart!");

				},
				error: function(){						
					alert('Error while request..');
				}
			});
		}

	removeFromShoppingCart = function(shoppingCartId) {
			$.ajax({
				url:  'removeShoppingCart/' + shoppingCartId,
		 		type: 'PUT',
				dataType: "json",
			 	 success: function (response) {
		 		 		location.reload(true);
					},
					error: function(){						
						alert('Error while processing..');
			 	 } 
		   });
	   }
	deleteAllCarts = function(){
		$.ajax({
			url:  'removeAllShoppingCart/',
	 		type: 'PUT',
			dataType: "json",
		 	 success: function (response) {
	 		 		location.reload(true);
				},
				error: function(){						
					alert('Error while processing..');
		 	 } 
	   });
	}
	
	   
	 
});

  