package com.femas1.quickbill.service;

import com.femas1.quickbill.model.Address;
import com.femas1.quickbill.model.Customer;
import com.femas1.quickbill.repository.AddressRepository;
import com.femas1.quickbill.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository){
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }
    public Customer createCustomer(Customer customer){
        Address address = customer.getAddress();
        Address savedAddress = addressRepository.save(address);
        customer.setAddress(savedAddress);
        return customerRepository.save(customer);
    }
    public Customer getCustomer(int id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer updateCustomer(int id, Customer customerDetails){
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer does not exist"));
        Address existingAddress = existingCustomer.getAddress();
        Address newAddressData = customerDetails.getAddress();
        existingAddress.setStreet(newAddressData.getStreet());
        existingAddress.setPostalCode(newAddressData.getPostalCode());
        existingAddress.setLocation(newAddressData.getLocation());
        existingAddress.setCountry(newAddressData.getCountry());

        addressRepository.save(existingAddress);

        existingCustomer.setFirstName(customerDetails.getFirstName());
        existingCustomer.setLastName(customerDetails.getLastName());
        existingCustomer.setEmail(customerDetails.getEmail());

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(int id){
        if(!customerRepository.existsById(id)){
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}
