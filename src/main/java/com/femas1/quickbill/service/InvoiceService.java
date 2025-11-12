package com.femas1.quickbill.service;

import com.femas1.quickbill.model.*;
import com.femas1.quickbill.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository,
                          CustomerRepository customerRepository,
                          CompanyRepository companyRepository,
                          StatusRepository statusRepository,
                          AddressRepository addressRepository,
                          ProductRepository productRepository) {
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Invoice createInvoice(Invoice invoice) {

        Customer managedCustomer = customerRepository.findById(invoice.getCustomer().getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + invoice.getCustomer().getCustomerId()));
        invoice.setCustomer(managedCustomer);

        Company managedCompany = companyRepository.findById(invoice.getCompany().getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + invoice.getCompany().getCompanyId()));
        invoice.setCompany(managedCompany);

        Status managedStatus = statusRepository.findById(invoice.getStatus().getStatusId())
                .orElseThrow(() -> new RuntimeException("Status not found with id: " + invoice.getStatus().getStatusId()));
        invoice.setStatus(managedStatus);

        Address managedAddress = addressRepository.findById(invoice.getAddress().getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + invoice.getAddress().getAddressId()));
        invoice.setAddress(managedAddress);

        if (invoice.getItems() != null) {
            for (InvoiceItem item : invoice.getItems()) {

                Product managedProduct = productRepository.findById(item.getProduct().getProductId())
                        .orElseThrow(() -> new RuntimeException("Product not found with id: " + item.getProduct().getProductId()));
                item.setProduct(managedProduct);
                item.setInvoice(invoice);
            }
        }
        return invoiceRepository.save(invoice);
    }

    public Invoice getInvoice(int id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
    }

}