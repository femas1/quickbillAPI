package com.femas1.quickbill.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer(){}

    public Customer(int customerId, String firstName, String lastName, String email, Address address){
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address= address;
    }

    public int getCustomerId(){
        return this.customerId;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }
    public Address getAddress(){
        return this.address;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(Address address){
        this.address = address;
    }
}
