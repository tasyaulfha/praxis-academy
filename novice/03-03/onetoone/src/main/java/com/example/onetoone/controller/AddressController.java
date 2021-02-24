package com.example.onetoone.controller;


import com.example.onetoone.model.Address;
import com.example.onetoone.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/getAddress")
    public List<Address> getAllUser(){
        return addressService.getAllAddress();
    }
    @GetMapping(path = "/getAddress/{id}")
    public Address getAddress(@PathVariable Long id){
        return addressService.getAddressById(id);
    }
    @DeleteMapping(path = "/delete/{id}")
    private void deleteAddress(@PathVariable Long id){
        addressService.delete(id);
    }
    @PostMapping(path = "/add")
    public Address addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }


}
