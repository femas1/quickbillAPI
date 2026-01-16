package com.femas1.quickbill.service;

import com.femas1.quickbill.model.Address;
import com.femas1.quickbill.model.Company;
import com.femas1.quickbill.model.Customer;
import com.femas1.quickbill.repository.AddressRepository;
import com.femas1.quickbill.repository.CompanyRepository;
import com.femas1.quickbill.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, CompanyRepository companyRepository,
                          CustomerRepository customerRepository){
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Address getAddress(int id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found."));
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public Address updateAddress(int id, Address address){
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
        List<Customer> customersUsingAddress = customerRepository.findByAddress_AddressId(id);

        if (!companiesUsingAddress.isEmpty() || !customersUsingAddress.isEmpty()) {
            throw new RuntimeException("Cannot delete address: It is still in use by a customer or company");
        }
        addressRepository.deleteById(id);
    }
}
