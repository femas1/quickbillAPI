package com.femas1.quickbill.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;
    @NotBlank(message = "Insert a valid invoice number (min 3 characters).")
    @Size(min = 3, max = 255)
    private String invoiceNr;
    @PastOrPresent(message = "Invoice date cannot be in the future.")
    private Date date;
    @Future(message = "Due date must be in the future.")
    private Date dueDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<InvoiceItem> items = new ArrayList<>();

    public Invoice(){}

    public Invoice(int invoiceId, String invoiceNr, Date date, Date dueDate, Status status, Customer customer, Address address, Company company, List<InvoiceItem> items){
        this.invoiceId = invoiceId;
        this.invoiceNr = invoiceNr;
        this.date = date;
        this.dueDate = dueDate;
        this.status = status;
        this.customer = customer;
        this.address = address;
        this.company = company;
        this.items = items;
    }

    public int getInvoiceId(){
        return this.invoiceId;
    }
    public String getInvoiceNr(){
        return this.invoiceNr;
    }
    public Date getDate(){
        return this.date;
    }
    public Date getDueDate(){
        return this.dueDate;
    }
    public Status getStatus(){
        return this.status;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public Address getAddress(){
        return this.address;
    }
    public Company getCompany(){
        return this.company;
    }
    public List<InvoiceItem> getItems(){
        return this.items;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }
    public void setInvoiceNr(String invoiceNr) {
        this.invoiceNr = invoiceNr;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }
}
