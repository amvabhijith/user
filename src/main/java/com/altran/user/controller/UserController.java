package com.altran.user.controller;

import com.altran.user.dto.FlightBooking;
import com.altran.user.model.Flights;
import com.altran.user.model.User;
import com.altran.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by 4013707 on 4/16/2020.
 */

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody User user) {
        return ResponseEntity.ok(userService.registration(user));
    }

    @GetMapping("/getUserDetails/{userName}")
    public ResponseEntity<User> getUserDetails(@PathVariable String userName) {
        return ResponseEntity.ok(userService.getUserDetails(userName));
    }

    /*	@GetMapping
	public @ResponseBody List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}*/

    /*
     * @GetMapping("/{flight-id}") public @ResponseBody Flight
     * getFlightById(@PathVariable("flight-id") long flightId) { return
     * flightService.getFlightById(flightId); }
     */

    @GetMapping("/{departureTime}")
    public @ResponseBody Flights getFlightByDepartureTime(@PathVariable("departureTime")@DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date departureTime) {
        Flights flights;
        try {
            flights = userService.getFlightByDepartureTime(departureTime);
        } catch (ParseException e) {
            flights = new Flights();
            e.printStackTrace();
        }
        return flights;
    }

    @PostMapping("/complete-reservation")
    public ResponseEntity<FlightBooking> completeReservation(@RequestBody FlightBooking flightBooking) {
        return ResponseEntity.ok(userService.bookFlight(flightBooking));
    }
    
}
