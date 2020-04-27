package com.altran.user.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_no")
    private long orderNumber;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "flightId")
    private Flight flight;

    @OneToMany(
            mappedBy = "reservation",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Passenger> passengers;

    public Reservation() {
    }

    public Reservation(Set<Passenger> passengers, Flight flightNumber) {
        this.passengers = passengers;
        this.flight = flightNumber;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Flight getFlightNumber() {
        return flight;
    }

    public void setFlightNumber(Flight flight) {
        this.flight = flight;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }
}
