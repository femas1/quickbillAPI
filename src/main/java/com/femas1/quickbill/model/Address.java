package com.femas1.quickbill.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    @NotBlank(message = "Insert a valid street name")
    @Size(min=3, max=255)
    private String street;
    @NotBlank(message = "Insert a valid postal code")
    @Size(min=4)
    private String postalCode;
    @NotBlank(message = "Insert a valid location name")
    @Size(min=3, max=255)
    private String location;
    @NotBlank(message = "Insert a valid country name")
    @Size(min=3, max=255)
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