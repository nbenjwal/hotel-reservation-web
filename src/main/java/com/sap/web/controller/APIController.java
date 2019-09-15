package com.sap.web.controller;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sap.web.entity.APIException;
import com.sap.web.entity.Booking;
import com.sap.web.entity.BookingRequest;
import com.sap.web.entity.BookingResponse;
import com.sap.web.service.APIService;

@RestController
public class APIController {
	@Autowired
	private APIService service;

	@RequestMapping(value = "/api/hotel", method = RequestMethod.POST)
	public BookingResponse bookHotel(@RequestBody @Valid BookingRequest request, BindingResult bindingResult) {
		StringJoiner errorFields = new StringJoiner(",");
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				errorFields.add(error.getDefaultMessage());
			}
		}

		if (errorFields.length() > 0) {
			throw new APIException(errorFields.toString());
		}
		return service.bookRooms(request.getStartDay(), request.getEndDay());

	}

	@RequestMapping(value = "/api/hotel/{id}", method = RequestMethod.GET)
	public Optional<Booking> getBooking(@PathVariable("id") int id) {
		return service.getBookingById(id);
	}

	@RequestMapping(value = "/api/hotel/all", method = RequestMethod.GET)
	public Iterable<Booking> getAllBookings() {
		return service.getAllBookings();
	}
}
