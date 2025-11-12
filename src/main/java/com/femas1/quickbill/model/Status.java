package com.femas1.quickbill.model;

import jakarta.persistence.*;

@Entity
@Table(name = "statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statusId;
    private String name;

    public Status(){}

    public Status(int statusID, String name){
        this.statusId = statusID;
        this.name = name;
    }

    public int getStatusId(){
        return this.statusId;
    }
    public String getName(){
        return this.name;
    }

    public void setStatusId(int statusId){
        this.statusId = statusId;
    }
    public void setName(String name){
        this.name = name;
    }
}
