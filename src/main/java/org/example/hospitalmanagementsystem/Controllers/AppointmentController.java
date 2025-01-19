package org.example.hospitalmanagementsystem.Controllers;

import org.example.hospitalmanagementsystem.Service.AppointmentService;
import org.example.hospitalmanagementsystem.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        System.out.println("Get All Appointments");
        return appointmentService.getAllAppointments();
    }

    // Create a new appointment
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        System.out.println("Create Appointment");
        return appointmentService.addAppointment(appointment);
    }

    // Get an appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        System.out.println("Get Appointment");
        return appointmentService.getAppointmentById(id);
    }

    // Delete an appointment by ID
    @DeleteMapping("/{id}")
    public String deleteAppointmentById(@PathVariable Long id) {
        System.out.println("Delete Appointment");
        boolean isDeleted = appointmentService.deleteAppointmentById(id);
        return isDeleted ? "Appointment deleted successfully" : "Appointment not found";
    }

    // Update an appointment by ID
    @PutMapping("/{id}")
    public Appointment updateAppointmentById(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        System.out.println("Update Appointment");
        return appointmentService.updateAppointment(id, updatedAppointment);
    }
}
