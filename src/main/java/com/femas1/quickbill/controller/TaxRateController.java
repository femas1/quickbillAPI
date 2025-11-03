package com.femas1.quickbill.controller;

import com.femas1.quickbill.model.TaxRate;
import com.femas1.quickbill.repository.TaxRateRepository;
import com.femas1.quickbill.service.TaxRateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/taxrates")
public class TaxRateController {
    private final TaxRateService taxRateService;

    public TaxRateController(TaxRateService taxRateService) {
        this.taxRateService = taxRateService;
    }

    @PostMapping
    public TaxRate createTaxRate(@RequestBody TaxRate rate){
        return taxRateService.createTaxRate(rate);
    }

    @GetMapping("/{id}")
    public TaxRate getTaxRate(@PathVariable int id){
        return taxRateService.getTaxRate(id);
    }

    @PutMapping("/{id}")
    public TaxRate updateTaxRate(@PathVariable int id, @RequestBody TaxRate rate){
        return taxRateService.updateTaxRate(id, rate);
    }

    @DeleteMapping("/{id}")
    public void deleteTaxRate(@PathVariable int id){
        taxRateService.deleteTaxRate(id);
    }
}
