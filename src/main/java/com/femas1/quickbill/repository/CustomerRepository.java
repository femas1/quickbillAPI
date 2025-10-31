package com.femas1.quickbill.repository;

import com.femas1.quickbill.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByAddress_AddressId(Integer addressId);
}
