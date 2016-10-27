$(document).ready(function() {

	addReviewForm= function() { 
		
			$("#newComment").attr("style", "display: block")
	 		} 
	 
	hideAddForm= function(){
		$("#newComment").attr("style", "display: none")
	} 	   
	
	commentAdd = function(){
		//$("#newComment").attr("style", "display: block")
		var dataToSend = JSON.stringify(serializeObject($('#reviewForm')));
		$.ajax({
				  url: '/Loot_Bazar/addReviews',
				 type: 'POST',
				  dataType: "json",  
				  data:dataToSend,
				  contentType: 'application/json', 
				  success: function(review){
					  
					  alert("Thank You!!!"+review.name);
					  location.reload(true);
					  },
					  error: function(jqXHR, textStatus, exception ){
						  alert(dataToSend),
						  alert("please try again!! errors occure"+exception);
					   }

		})
		
		function serializeObject (form)
		{
		    var jsonObject = {};
		    var array = form.serializeArray();
		    $.each(array, function() {
		         	jsonObject[this.name] = this.value;
		    });
		    return jsonObject;

		}
	}
	
	deletReview = function(rewiewId) {
		$.ajax({
			url:  'removeReviewById/' + rewiewId,
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
})