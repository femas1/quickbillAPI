package com.femas1.quickbill.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "invoice_items")
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceItemId;
    @Min(1)
    private int quantity;
    @Pattern(regexp = "^(pcs|l|ml)$", message = "Unit can be 'pcs', 'l', 'ml'")
    private String unit;
    @PositiveOrZero(message = "Price cannot be negative")
    private double unitPrice;
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonBackReference
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public InvoiceItem(){}

    public InvoiceItem(int invoiceItemId, int quantity, String unit, double unitPrice, Invoice invoice, Product product){
        this.invoiceItemId = invoiceItemId;
        this.quantity = quantity;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.invoice = invoice;
        this.product = product;
    }

    public int getInvoiceItemId(){
        return this.invoiceItemId;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getUnit(){
        return this.unit;
    }
    public double getUnitPrice(){
        return this.unitPrice;
    }
    public Invoice getInvoice(){
        return this.invoice;
    }
    public Product getProduct(){
        return this.product;
    }

    public void setInvoiceItemId(int invoiceItemId){
        this.invoiceItemId = invoiceItemId;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    public void setProduct(Product product){
        this.product = product;
    }
}
