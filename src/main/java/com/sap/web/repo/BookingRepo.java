package com.sap.web.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sap.web.entity.Booking;

@Repository
public interface BookingRepo extends CrudRepository<Booking, Integer> {

}
