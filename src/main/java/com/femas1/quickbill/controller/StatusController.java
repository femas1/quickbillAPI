package com.femas1.quickbill.controller;

import com.femas1.quickbill.model.Status;
import com.femas1.quickbill.service.StatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService){
        this.statusService = statusService;
    }
    @GetMapping("/{id}")
    public Status getStatus(@PathVariable int id){return statusService.getStatus(id);
    }
}
