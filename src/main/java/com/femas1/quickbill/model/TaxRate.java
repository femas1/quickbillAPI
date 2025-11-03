package com.femas1.quickbill.model;

import jakarta.persistence.*;

@Entity
@Table(name="tax_rates")
public class TaxRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_rate_id")
    private int rateId;
    private int rate;

    public TaxRate(){}

    public TaxRate(int rateId, int rate){
        this.rateId = rateId;
        this.rate = rate;
    }

    public int getRateId(){
        return this.rateId;
    }
    public int getRate(){
        return this.rate;
    }
    public void setRateId(int rateId){
        this.rateId = rateId;
    }
    public void setRate(int rate){
        this.rate = rate;
    }
}
