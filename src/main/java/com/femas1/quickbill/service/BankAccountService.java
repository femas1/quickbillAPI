package com.femas1.quickbill.service;

import com.femas1.quickbill.model.BankAccount;
import com.femas1.quickbill.model.Company;
import com.femas1.quickbill.repository.BankAccountRepository;
import com.femas1.quickbill.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository, CompanyRepository companyRepository){
        this.bankAccountRepository = bankAccountRepository;
        this.companyRepository = companyRepository;
    }

    public BankAccount createBankAccount(BankAccount bankAccount, Integer companyId){
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        bankAccount.setCompany(company);
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount getBankAccount(Integer id){
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not found"));
    }

    public BankAccount updateBankAccount(BankAccount bankAccountDetails, Integer id){
        BankAccount existingBankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not found"));

        existingBankAccount.setAccountHolder(bankAccountDetails.getAccountHolder());
        existingBankAccount.setBankName(bankAccountDetails.getBankName());
        existingBankAccount.setIban(bankAccountDetails.getIban());
        existingBankAccount.setBic(bankAccountDetails.getBic());

        return bankAccountRepository.save(existingBankAccount);
    }

    public void deleteBankAccount(Integer id){
        if(!bankAccountRepository.existsById(id)){
            throw new RuntimeException("Bank account not found");
        }
        bankAccountRepository.deleteById(id);
    }
}



















