package com.example.batch.models;

public class ContactDetails {
    private String phoneNumber;
    private String email;
    private String alternatePhone;

    // Constructors
    public ContactDetails() {}
    public ContactDetails(String phoneNumber, String email, String alternatePhone) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.alternatePhone = alternatePhone;
    }

    // Getters & Setters
}