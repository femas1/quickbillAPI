package com.femas1.quickbill.controller;

import com.femas1.quickbill.model.Address;
import com.femas1.quickbill.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "http://localhost:5173")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    @PostMapping
    public Address createAddress(@RequestBody Address address){return addressService.createAddress(address);}

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Integer id){return addressService.getAddress(id);}

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Integer id, @RequestBody Address address){return addressService.updateAddress(id,
            address);}

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id){addressService.deleteAddress(id);}
}
