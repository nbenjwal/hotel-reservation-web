package com.sap.web.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sap.web.entity.BookingEntity;

@Repository
public interface BookingRepo extends CrudRepository<BookingEntity, Integer> {

}
