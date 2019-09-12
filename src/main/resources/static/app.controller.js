var app = angular.module("Hotel");

app.controller("appController", AppController);

function AppController(appService, toastr) {

	var self = this;
	// this.startDay = 0;
	// this.endDay = 0;

	// ********************Book hotel********************/
	this.bookHotel = function() {
		if (this.startDay && this.endDay) {
			var bookingOrder = {
				"startDay" : this.startDay,
				"endDay" : this.endDay
			}
			appService.bookHotel(bookingOrder).then(function(data) {
				// debugger;
				console.log(data);
				if (data.message.includes("successfully")) {
					toastr.success(data.message, 'Success');
				} else {
					toastr.info(data.message, 'Information');
				}

			});
		} else {
			toastr.error("All fields are mandatory.", 'Failure');
		}
	}

}
