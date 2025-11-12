package com.femas1.quickbill.repository;

import com.femas1.quickbill.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
