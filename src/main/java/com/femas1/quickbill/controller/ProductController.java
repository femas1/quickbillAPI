package com.femas1.quickbill.controller;

import com.femas1.quickbill.model.Product;
import com.femas1.quickbill.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController (ProductService productService){
        this.productService = productService;
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id){ return productService.updateProduct(product, id);}

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){productService.deleteProduct(id); return "Product successfully deleted!";}
}
