package com.altran.user.dto;

import com.altran.user.model.Reservation;


public class PassengerDto {

    private String id;

    private String firstname;

    private String lastname;

    private int age;

    private String gender;

    private String phone;

    private Reservation reservation;




    public PassengerDto(String firstname, String lastname, int age, String gender, String phone) {
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
