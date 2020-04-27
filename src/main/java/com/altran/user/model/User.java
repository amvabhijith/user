package com.altran.user.model;


import javax.persistence.*;

/**
 * Created by 4013707 on 4/16/2020.
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String userName;

    private String password;

    @Transient
    private String passwordConfirm;

    private String firstName;

    private String lastName;


    public User() {
    }

    public User(long userId, String userName, String password, String passwordConfirm, String firstName, String lastName) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUserId() != user.getUserId()) return false;
        if (getUserName() != null ? !getUserName().equals(user.getUserName()) : user.getUserName() != null)
            return false;
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        return !(getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getUserId() ^ (getUserId() >>> 32));
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getPasswordConfirm() != null ? getPasswordConfirm().hashCode() : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }
}
