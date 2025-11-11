package com.femas1.quickbill.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private String description;
    private double unitPrice;
    @JoinColumn(name = "tax_rate_id")
    @ManyToOne
    private TaxRate taxRate;

    public Product(){}

    public Product(int productId, String name, String description, double unitPrice, TaxRate taxRate){
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.taxRate = taxRate;
    }

    public int getProductId(){
        return this.productId;
    }
    public String getName(){
        return this.name;
    }
    public double getUnitPrice(){
        return this.unitPrice;
    }
    public TaxRate getTaxRate(){
        return this.taxRate;
    }
    public void setProductId(int productId){
        this.productId = productId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }
    public void setTaxRate(TaxRate taxRate){
        this.taxRate = taxRate;
    }
}
