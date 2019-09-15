package com.sap.web.service;

import java.util.List;

import com.sap.web.entity.BookingEntity;
import com.sap.web.entity.BookingResponse;

public interface APIService {
	public BookingResponse bookRooms(int s, int e);

	public BookingEntity getBookingById(int id);

	public List<BookingEntity> getAllBookings();
}
