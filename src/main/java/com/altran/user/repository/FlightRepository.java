package com.altran.user.repository;

import com.altran.user.model.Flight;
import com.altran.user.model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface FlightRepository  extends CrudRepository<Flight,Long> {

    Flight findByFlightId(long flightId);

    List<Flight> findByDepartureTimeBetween(Date departureTimeStart, Date departureTimeEnd);

    Flight findByNumber(String flightNumber);
}
