package com.femas1.quickbill.service;

import com.femas1.quickbill.model.TaxRate;
import com.femas1.quickbill.repository.TaxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxRateService {
    private final TaxRateRepository taxRateRepository;

    @Autowired
    public TaxRateService(TaxRateRepository taxRateRepository){
        this.taxRateRepository = taxRateRepository;
    }

    public TaxRate createTaxRate(TaxRate rate){
        return taxRateRepository.save(rate);
    }

    public TaxRate getTaxRate(int id){
        return taxRateRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tax rate not found"));
    }
    public TaxRate updateTaxRate(int id, TaxRate rateDetails){
        TaxRate existingTaxRate = taxRateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tax rate not found."));
        existingTaxRate.setRate(rateDetails.getRate());
        return taxRateRepository.save(existingTaxRate);
    }
    public void deleteTaxRate(int id){
        if(!taxRateRepository.existsById(id)){
            throw new RuntimeException("Tax rate not found");
        }
        taxRateRepository.deleteById(id);
    }
}
