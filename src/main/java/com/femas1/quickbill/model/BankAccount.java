package com.femas1.quickbill.model;

public class BankAccount {
    private int bankAccountId;
    private String accountHolder;
    private String bankName;
    private String iban;
    private String bic;
    private Company company;

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

