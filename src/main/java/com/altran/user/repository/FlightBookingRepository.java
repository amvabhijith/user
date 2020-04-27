package com.altran.user.repository;

import com.altran.user.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface FlightBookingRepository  extends CrudRepository<Reservation,Long> {


}
