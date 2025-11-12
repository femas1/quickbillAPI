package com.femas1.quickbill.service;

import com.femas1.quickbill.model.Product;
import com.femas1.quickbill.model.TaxRate;
import com.femas1.quickbill.repository.ProductRepository;
import com.femas1.quickbill.repository.TaxRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final TaxRateRepository taxRateRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, TaxRateRepository taxRateRepository){
        this.productRepository = productRepository;
        this.taxRateRepository = taxRateRepository;
    }

    public Product createProduct(Product product){
        int taxRateId = product.getTaxRate().getRateId();
        TaxRate existingTaxRate = taxRateRepository.findById(taxRateId)
                .orElseThrow(() -> new RuntimeException(
                "TaxRate not found with id: " + taxRateId));
        product.setTaxRate(existingTaxRate);
        return productRepository.save(product);
    }

    public Product getProduct(int id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(Product product, int id){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
        int taxRateId = product.getTaxRate().getRateId();
        TaxRate existingTaxRate = taxRateRepository.findById(taxRateId)
                .orElseThrow(() -> new RuntimeException(
                        "TaxRate not found with id: " + taxRateId));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setUnitPrice(product.getUnitPrice());
        existingProduct.setTaxRate(existingTaxRate);
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int id){
        productRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Product not fouund!"));
        productRepository.deleteById(id);
    }
}
