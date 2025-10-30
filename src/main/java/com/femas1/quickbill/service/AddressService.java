package com.femas1.quickbill.service;

import com.femas1.quickbill.model.Address;
import com.femas1.quickbill.model.Company;
import com.femas1.quickbill.repository.AddressRepository;
import com.femas1.quickbill.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, CompanyRepository companyRepository){
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Address getAddress(Integer id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found."));
    }

    public Address updateAddress(Integer id, Address address){
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found."));

        existingAddress.setStreet(address.getStreet());
        existingAddress.setLocation(address.getLocation());
        existingAddress.setPostalCode(address.getPostalCode());
        existingAddress.setCountry(address.getCountry());
        return addressRepository.save(existingAddress);
    }

    public void deleteAddress(Integer id){
        if(!addressRepository.existsById(id)){
            throw new RuntimeException("Address not found.");
        }
        List<Company> companiesUsingAddress = companyRepository.findByAddress_AddressId(id);

        if (!companiesUsingAddress.isEmpty()) {
            throw new RuntimeException("Cannot delete address: It is still in use by "
                    + companiesUsingAddress.size() + " companies.");
        }
        addressRepository.deleteById(id);
    }
}
