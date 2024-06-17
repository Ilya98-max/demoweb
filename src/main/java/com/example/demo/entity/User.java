package com.example.demo.entity;

import java.util.Arrays;
import java.util.Objects;

public class User extends AbstractEntity {
    private String phoneNumber;
    private String lastName;
    private String password;
    private String email;
    private byte[] photo;

    public User(String phoneNumber, String lastName, String password, String email, byte[] photo) {
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.photo = photo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + (photo != null ? "Present" : "Not present") + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Arrays.equals(photo, user.photo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(phoneNumber, lastName, password, email);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }
}





