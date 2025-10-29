package com.femas1.quickbill.service;

import com.femas1.quickbill.model.Address;
import com.femas1.quickbill.model.Company;
import com.femas1.quickbill.repository.AddressRepository;
import com.femas1.quickbill.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(AddressRepository addressRepository, CompanyRepository companyRepository) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
    }

    public Company createCompany(Company company){
        Address address = company.getAddress();
        Address savedAddress = addressRepository.save(address);
        company.setAddress(savedAddress);
        return companyRepository.save(company);
    }

    public Company getCompany(Integer id){
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found."));
        return existingCompany;
    }

    public Company updateCompany(Integer id, Company companyDetails){
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found."));
        Address existingAddress = existingCompany.getAddress();
        Address newAddressData = companyDetails.getAddress();
        existingAddress.setStreet(newAddressData.getStreet());
        existingAddress.setPostalCode(newAddressData.getPostalCode());
        existingAddress.setLocation(newAddressData.getLocation());
        existingAddress.setCountry(newAddressData.getCountry());

        addressRepository.save(existingAddress);

        existingCompany.setName(companyDetails.getName());
        existingCompany.setEmail(companyDetails.getEmail());
        existingCompany.setVatNr(companyDetails.getVatNr());
        existingCompany.setCountry(companyDetails.getCountry());

        return companyRepository.save(existingCompany);
    }

    public void deleteCompany(Integer id){
        if(!companyRepository.existsById(id)) {
            throw new RuntimeException("Company not found with id " + id);
        }
        companyRepository.deleteById(id);
    }
}
