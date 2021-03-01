package com.example.bankmanagement.controller;


import com.example.bankmanagement.model.PrimaryAccount;
import com.example.bankmanagement.model.Recipient;
import com.example.bankmanagement.model.SavingsAccount;
import com.example.bankmanagement.model.User;
import com.example.bankmanagement.service.TransactionService;
import com.example.bankmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/betweenAcounts", method = RequestMethod.GET)
    public String betweenAccounts(Model model){
        model.addAttribute("transfeFrom", "");
        model.addAttribute("transferTo","");
        model.addAttribute("amount", "");

        return "betweenAccounts";

    }
    @RequestMapping(value = "/betweenAccounts", method = RequestMethod.POST)
    public String betweenAccountsPost(
            @ModelAttribute("transferFrom") String transferFrom,
            @ModelAttribute("transferTo") String transferTo,
            @ModelAttribute("amount") String amount,
            Principal principal

    ) throws Exception{
        User user= userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount =user.getSavingsAccount();

        transactionService.beetweenAccountTransfer(transferFrom,transferTo,amount,primaryAccount,savingsAccount);

        return "redirect:/userFront";
    }
    @RequestMapping(value = "/recipient", method = RequestMethod.GET)
    public String recipient(Model model, Principal principal){
        List<Recipient> recipientList= transactionService.findRecipientList(principal);

        Recipient recipient = new Recipient();
        model.addAttribute("recipientList", recipientList);
        model.addAttribute("recipient",recipient);

        return "recipient";
    }

    @RequestMapping(value="/recipient/save", method = RequestMethod.POST)
    public String recipientPost(@ModelAttribute("recipient")Recipient recipient, Principal principal){
        User user= userService.findByUsername(principal.getName());
        recipient.setUser(user);
        transactionService.saveRecipient(recipient);

        return "redirect:/transfer/recipient";
    }

    @RequestMapping(value = "/recipient/edit" , method = RequestMethod.GET)
    public String recipientEdit(@RequestParam(value = "recipientName") String recipientName, Model model, Principal principal){

        Recipient recipient = transactionService.findRecipientByName(recipientName);
        List<Recipient> recipientList = transactionService.findRecipientList(principal);

        model.addAttribute("recipientList", recipientList);
        model.addAttribute("recipient", recipient);

        return "recipient";
    }

    @RequestMapping (value="/recipient/delete", method = RequestMethod.DELETE)
    public String recipientDelete(@RequestParam(value="recipientName")String recipientName, Model model, Principal principal){
        transactionService.deleteRecipientByName(recipientName);

        List<Recipient > recipientList = transactionService.findRecipientList(principal);

        Recipient recipient = new Recipient();
        model.addAttribute("recipient", recipient);
        model.addAttribute("recipientList", recipient);

        return "recipient";
    }
    @RequestMapping(value = "/toSomeoneElse",method = RequestMethod.GET)
    public String toSomeoneElse(Model model, Principal principal){
        List<Recipient> recipientList= transactionService.findRecipientList(principal);

        model.addAttribute("recipientList", recipientList);
        model.addAttribute("accountType","");

        return "toSomeoneElse";
    }
    @RequestMapping(value = "/toSomeoneElse", method = RequestMethod.POST)
    public String toSomeoneElse(@ModelAttribute("recipientName") String recipientName,@ModelAttribute("accountType")String accountType, @ModelAttribute("amount")String amount,Principal principal){
        User user= userService.findByUsername(principal.getName());
        Recipient recipient = transactionService.findRecipientByName(recipientName);
        transactionService.toSomeoneElseTransfer(recipient,accountType,amount,user.getPrimaryAccount(),user.getSavingsAccount());

        return "redicect:/userFront";
    }

}
