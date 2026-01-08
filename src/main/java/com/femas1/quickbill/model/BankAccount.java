package com.femas1.quickbill.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankAccountId;
    @NotBlank(message = "Insert a valid name")
    @Size(min = 3, max = 255)
    private String accountHolder;
    @NotBlank(message = "Insert a valid name")
    @Size(min = 3, max = 255)
    private String bankName;
    @NotBlank(message = "Insert a valid IBAN number")
    @Size(min= 22, max = 34)
    private String iban;
    @NotBlank(message = "Insert a valid IBAN number")
    @Size(min= 8, max = 11)
    private String bic;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public BankAccount(){}
    public BankAccount(int bankAccountId, String accountHolder, String bankName, String iban, String bic,
                       Company company) {
        this.bankAccountId = bankAccountId;
        this.accountHolder = accountHolder;
        this.bankName = bankName;
        this.iban = iban;
        this.bic = bic;
        this.company = company;
    }

    public String getAccountHolder(){
        return this.accountHolder;
    }
    public String getBankName(){
        return this.bankName;
    }
    public String getIban(){
        return this.iban;
    }
    public String getBic(){
        return this.bic;
    }
    public Company getCompany(){
        return this.company;
    }
    public void setBankAccountId(int bankAccountId){
        this.bankAccountId = bankAccountId;
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    public void setBankName(String bankName){
        this.bankName = bankName;
    }
    public void setIban(String iban){
        this.iban = iban;
    }
    public void setBic(String bic){
        this.bic = bic;
    }
    public void setCompany(Company company){
        this.company = company;
    }
}

