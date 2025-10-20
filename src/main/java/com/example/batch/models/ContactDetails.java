package com.example.batch.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContactDetails {

    private String phoneNumber;
    private String email;
    private String alternatePhone;

    // --- Constructors ---
    public ContactDetails() {}


    // --- Getters and Setters ---
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }


}