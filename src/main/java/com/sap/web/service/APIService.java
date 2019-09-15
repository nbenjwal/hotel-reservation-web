package com.sap.web.service;

import java.util.Optional;

import com.sap.web.entity.Booking;
import com.sap.web.entity.BookingResponse;

public interface APIService {
	public BookingResponse bookRooms(int s, int e);

	public Optional<Booking> getBookingById(int id);

	public Iterable<Booking> getAllBookings();
}
