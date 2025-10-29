package com.femas1.quickbill.model;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String street;
    private String postalCode;
    private String location;
    private String country;

    public Address(){};
    public Address (int addressId, String street, String postalCode, String location, String country){
        this.addressId = addressId;
        this.street = street;
        this.postalCode = postalCode;
        this.location = location;
        this.country = country;
    }

    // GETTERS
    public int getAddressId(){
        return this.addressId;
    }
    public String getStreet(){
        return this.street;
    }
    public String getPostalCode(){
        return this.postalCode;
    }
    public String getLocation(){
        return this.location;
    }
    public String getCountry(){
        return this.country;
    }
    // SETTERS
    public void setAddressId(int addressId){
        this.addressId = addressId;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setCountry(String country){
        this.country = country;
    }
}