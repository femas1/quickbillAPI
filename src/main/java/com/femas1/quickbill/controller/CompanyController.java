package com.femas1.quickbill.controller;

import com.femas1.quickbill.model.Company;
import com.femas1.quickbill.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "http://localhost:5173")
public class CompanyController{
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company){
        return companyService.createCompany(company);
    }

     /**
     * Handles: PUT /api/companies/{id}
     *
     * @PathVariable reads the {id} from the URL.
     * @RequestBody reads the JSON update data from the request body.
     */
    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Integer id, @RequestBody Company companyDetails){
        return companyService.updateCompany(id, companyDetails);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
