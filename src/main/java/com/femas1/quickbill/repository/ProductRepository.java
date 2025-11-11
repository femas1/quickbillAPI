package com.femas1.quickbill.repository;

import com.femas1.quickbill.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {
}
