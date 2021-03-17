package com.example.projek.controller;


import com.example.projek.model.Reseller;
import com.example.projek.security.services.ResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jwt")
public class ResellerController {
    @Autowired
    ResellerService resellerService;

    public ResellerController(ResellerService resellerService) {
        this.resellerService = resellerService;
    }

    @GetMapping("/reseller")
    public List<Reseller> getAllReseller(){
        return (List<Reseller>) resellerService.getAllResellers();
    }

    @PostMapping("/reseller")
    public Reseller addReseller(@RequestBody Reseller reseller){
        return resellerService.save(reseller);
    }
}
