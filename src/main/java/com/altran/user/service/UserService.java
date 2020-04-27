package com.altran.user.service;

import com.altran.user.dto.FlightBooking;
import com.altran.user.model.Flight;
import com.altran.user.model.Flights;
import com.altran.user.model.Reservation;
import com.altran.user.model.User;
import com.altran.user.repository.FlightBookingRepository;
import com.altran.user.repository.FlightRepository;
import com.altran.user.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 4013707 on 4/16/2020.
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    public User registration(User user){
        return userRepository.save(user);
    }

    public User getUserDetails(String userName){
        return userRepository.findByUserName(userName);
    }

    //	public List<Flight> getAllFlights() {
//		return flightRepository.findAll();
//	}

    public Flights getFlightByDepartureTime(Date departureTime) throws ParseException {
        Date departureTimeStart = departureTime;
        Calendar c = Calendar.getInstance();
        c.setTime(departureTime);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        Date departureTimeEnd = c.getTime();
        List<Flight> flightsList = flightRepository.findByDepartureTimeBetween(departureTimeStart,departureTimeEnd);
        List<Flight> resultFlightsList = new ArrayList<Flight>();
        flightsList.parallelStream().forEach(k ->
        {
            if((k.getDepartureTime().getDay()==0)||(k.getDepartureTime().getDay()==6)){
                k.setPrice(k.getPrice()*2);
            }
            resultFlightsList.add(k);
        });
        Flights flights = new Flights(resultFlightsList);
        return flights;
    }

    public FlightBooking bookFlight(FlightBooking flightBooking) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(flightBooking, reservation);
        Flight flight = flightRepository.findByNumber(reservation.getFlightNumber().getNumber());
        FlightBooking resultFlightBooking = new FlightBooking();
        if (flightBooking.getPassengers().size()<=flight.getSeatsLeft()){
            BeanUtils.copyProperties(flightBookingRepository.save(reservation),resultFlightBooking);
            flight.setSeatsLeft(flight.getSeatsLeft()-flightBooking.getPassengers().size());
            flightRepository.save(flight);
        }

        return resultFlightBooking;
    }
}
