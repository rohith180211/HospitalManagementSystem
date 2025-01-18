package org.example.hospitalmanagementsystem.Controllers;

import org.example.hospitalmanagementsystem.models.Appointment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @GetMapping
    public List<Appointment> getAllAppointments() {
        System.out.println("Get All Appointments");
        return null;
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        System.out.println("Create Appointment");
        return appointment;
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        System.out.println("Get Appointment");
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAppointmentById(@PathVariable Long id) {
        System.out.println("Delete Appointment");
    }

    @PutMapping("/{id}")
    public void updateAppointmentById(@PathVariable Long id) {
        System.out.println("Update Appointment");
    }
}
