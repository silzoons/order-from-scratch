package com.switchfully.orderfromscratch.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String streetName;
    private String StreetNumber;
    private String postalCode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String streetName, String streetNumber, String postalCode, String city, String country) {
        this.streetName = streetName;
        StreetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        StreetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
