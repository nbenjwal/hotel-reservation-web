package com.sap.web.service;

import com.sap.web.entity.BookingResponse;

public interface APIService {
	public BookingResponse bookRooms(int s, int e);
}
