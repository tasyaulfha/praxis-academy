package com.example.bankmanagement.service.UserServiceImpl;

import com.example.bankmanagement.model.Appointment;
import com.example.bankmanagement.repository.AppointmentRepository;
import com.example.bankmanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findAppointment(Long id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public void confirmAppointment(Long id) {
        Appointment appointment = findAppointment(id);
        appointment.setConfirmed(true);
        appointmentRepository.save(appointment);

    }
}
