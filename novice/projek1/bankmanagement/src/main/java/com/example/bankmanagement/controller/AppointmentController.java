package com.example.bankmanagement.controller;


import com.example.bankmanagement.model.Appointment;
import com.example.bankmanagement.model.User;
import com.example.bankmanagement.repository.AppointmentRepository;
import com.example.bankmanagement.service.AppointmentService;
import com.example.bankmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createAppointment(Model model){
        Appointment appointment= new Appointment();
        model.addAttribute("appointment", appointment);
        model.addAttribute("dateString", "");

        return "appointment";

    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAppointmentPost(@ModelAttribute ("appointment") Appointment appointment, @ModelAttribute("dateString") String date, Model model, Principal principal) throws ParseException {
        SimpleDateFormat format1= new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d1= format1.parse(date);
        appointment.setDate(d1);

        User user= userService.findByUsername(principal.getName());
        appointment.setUser(user);

        appointmentService.createAppointment(appointment);

        return "redirect:/userFront";
    }
}
