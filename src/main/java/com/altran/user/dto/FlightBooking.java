package com.altran.user.dto;

import com.altran.user.model.Flight;
import com.altran.user.model.Passenger;

import java.util.Set;

public class FlightBooking {
    private String orderNumber;

    private Flight flightNumber;

    private Set<PassengerDto> passengers;

    public FlightBooking(Set<PassengerDto> passengers, Flight flightNumber) {
        this.passengers = passengers;
        this.flightNumber = flightNumber;
    }

    public FlightBooking() {

    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Flight getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Flight flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Set<PassengerDto> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<PassengerDto> passengers) {
        this.passengers = passengers;
    }
}
