package com.femas1.quickbill.service;

import com.femas1.quickbill.model.Status;
import com.femas1.quickbill.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    public Status getStatus(int statusId){
        return statusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Invoice status not found. Ids: 1 = Paid, 2 = Pending 3 = Draft"));
    }
}
