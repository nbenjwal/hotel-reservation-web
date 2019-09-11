package com.sap.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sap.web.entity.APIException;
import com.sap.web.entity.BookingResponse;

@Service
public class APIServiceImpl implements APIService {

	@Value("${hotel.room.count}")
	private int roomCount;

	@Value("${hotel.max.day}")
	private int maxDay;

	private int[][] db = new int[0][0];

	/**
	 * This method is responsible for booking the room(s).
	 * 
	 * @param s
	 *            booking start day.
	 * @param e
	 *            booking end day.
	 * @return availability (Accept/Decline).
	 */
	public BookingResponse bookRooms(int s, int e) {
		if (s < 0 || e < 0 || e < s || e > 365) {
			throw new APIException("Invalid input");
		}
		/** One time initilization. */
		if (db.length == 0) {
			int max = maxDay + 1;
			db = new int[roomCount][max];
		}
		int dayCount = e - s + 1;
		List<String> list = new ArrayList<>();
		/** Check in each room. */
		for (int i = 0; i < roomCount; i++) {
			int count = 0;
			for (int j = s; j <= e; j++) {
				if (checkAvailibility(i, j)) {
					++count;
					String token = i + "_" + j;
					list.add(token);
				}
			}
			if (dayCount == count) {
				reserveRoom(list);
				return new BookingResponse("Room" + i + " booking confirmed. from Day" + s + " to Day" + e);
			}
			count = 0;
			list = new ArrayList<>();
		}
		if (list.size() == 0) {
			throw new APIException("Rooms are not available");
		}
		throw new APIException("Rooms are not available");
	}

	/**
	 * This method check the availability of rooms.
	 * 
	 * @param i
	 *            room number;
	 * @param j
	 *            reservation date;
	 * @return true/false if room is available.
	 */
	private boolean checkAvailibility(int i, int j) {
		if (db[i][j] == 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method reserve the room for given days.
	 * 
	 * @param data
	 *            list of room and day String "_" separated. e.g. ("0_1","0_2").
	 */
	private void reserveRoom(List<String> data) {
		for (String token : data) {
			int i = Integer.parseInt(token.split("_")[0]);
			int j = Integer.parseInt(token.split("_")[1]);
			db[i][j] = 1;
		}
	}

}
