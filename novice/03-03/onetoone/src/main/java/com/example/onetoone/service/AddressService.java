package com.example.onetoone.service;


import com.example.onetoone.model.Address;
import com.example.onetoone.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public List<Address> getAllAddress(){
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }
    public Address getAddressById(Long id){
        Address address= addressRepository.findById(id).orElse(null);
        return address;
    }
    public Address addAddress(Address address){
        addressRepository.save(address);
        return address;
    }
    public void delete(Long id){
        addressRepository.deleteById(id);
    }
    public Address updateAddress(Long id, Address address){
        addressRepository.save(address);
        return address;
    }



}
