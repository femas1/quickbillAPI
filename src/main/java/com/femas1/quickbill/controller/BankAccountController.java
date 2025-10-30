package com.femas1.quickbill.controller;

import com.femas1.quickbill.model.BankAccount;
import com.femas1.quickbill.model.Company;
import com.femas1.quickbill.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bankaccounts")
@CrossOrigin(origins = "http://localhost:5173")
public class BankAccountController {
    private final BankAccountService bankAccountService;
    @Autowired
    public BankAccountController(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

    @PostMapping ("/company/{companyId}")
    public BankAccount createBankAccount(@RequestBody BankAccount bankAccount, @PathVariable Integer companyId){
        return bankAccountService.createBankAccount(bankAccount, companyId);
    }
    @GetMapping("/{id}")
    public BankAccount getBankAccount(@PathVariable Integer id){
        return bankAccountService.getBankAccount(id);
    }

    @PutMapping("/{id}")
    public BankAccount updateBankAccount(@RequestBody BankAccount bankAccount, @PathVariable Integer id){
        return bankAccountService.updateBankAccount(bankAccount, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable Integer id){
        bankAccountService.deleteBankAccount(id);
    }
}
