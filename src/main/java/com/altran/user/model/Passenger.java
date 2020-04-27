package com.altran.user.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "passenger")
public class Passenger {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column
    private int age;

    @Column
    private String gender;

    @Column(unique = true)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reservation reservation;


    public Passenger() {
    }


    public Passenger(String firstname, String lastname, int age, String gender, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Reservation getReservations() {
        return reservation;
    }


    public void setReservations(Reservation reservations) {
        this.reservation = reservations;
    }

}
