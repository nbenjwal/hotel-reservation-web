(function() {
	var app = angular.module("Hotel");

	app.service("appService", function($location, $http) {

		var url = $location.absUrl() + "hotel/api/book";

		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		this.bookHotel = function(bookingOrder) {
			var promise1 = $http.post(url, bookingOrder, config)
            .then(function activateOk(response) {
            	return response.data;
            })
            .catch(function activateError(error) {
            	return error.data;
            });
			return promise1;
		}
	});

})();