package com.example.bankmanagement.controller;


import com.example.bankmanagement.model.PrimaryAccount;
import com.example.bankmanagement.model.SavingsAccount;
import com.example.bankmanagement.model.User;
import com.example.bankmanagement.repository.RoleRepository;
import com.example.bankmanagement.security.UserRole;
import com.example.bankmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@RestController

public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/")
    public String home(){
        return "redirect:/index";

    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/signup")
    public String signup(Model model){
        User user= new User();
        model.addAttribute("user", user);

        return "signup";

    }
    @PostMapping("/signup")
    public String signupPost(@ModelAttribute("user")User user, Model model){
        if(userService.checkUserExists(user.getUsername(),user.getEmail())){
            if(userService.checkEmailExists(user.getEmail())){
                model.addAttribute("emailExists", true);
            }
            if (userService.checkUsernameExists(user.getUsername())){
                model.addAttribute("usernameExists", true);
            }
            return "signup";
        }else{
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleRepository.findByName("ROLE_USER")));

            userService.createUser(user,userRoles);

            return "redirect";
        }
    }
    @GetMapping("/userFront")
    public String userFront(Principal principal, Model model){
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount = user.getSavingsAccount();

        return "userFront";
    }
}
