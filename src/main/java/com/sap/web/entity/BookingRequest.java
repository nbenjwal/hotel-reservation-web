package com.sap.web.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class BookingRequest {

	@Min(value = 0, message = "Start Day must be equal or greater than 0")
	@Max(value = 365, message = "Start Day must be equal or less than 365")
	private int startDay;

	@Min(value = 0, message = "End Day must be equal or greater than 0")
	@Max(value = 365, message = "End Day must be equal or less than 365")
	private int endDay;

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
}
