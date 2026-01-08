package com.femas1.quickbill.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    @NotBlank(message = "Insert a valid name")
    @Size(min = 3, max = 255)
    private String name;
    @Email
    private String email;
    @NotBlank(message = "A VAT number can be 9 to 12 digits long")
    @Size(min = 9, max = 12)
    private String vatNr;
    @NotBlank(message = "Insert a valid country name")
    @Size(min = 3, max = 255)
    private String country;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Company(){};
    public Company (int companyId, String name, String email, String vatNr, String country, Address address){
        this.companyId = companyId;
        this.name = name;
        this.email = email;
        this.vatNr = vatNr;
        this.country = country;
        this.address = address;
    }

    // GETTERS
    public int getCompanyId(){
        return this.companyId;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getVatNr(){
        return this.vatNr;
    }
    public String getCountry(){
        return this.country;
    }
    public Address getAddress(){
        return this.address;
    }
    // SETTERS
    public void setCompanyId(int companyId){
        this.companyId = companyId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setVatNr(String vatNr){
        this.vatNr = vatNr;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setAddress(Address address){
        this.address = address;
    }
}

