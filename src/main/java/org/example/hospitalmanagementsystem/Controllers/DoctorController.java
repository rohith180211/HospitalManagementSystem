package org.example.hospitalmanagementsystem.Controllers;

import org.example.hospitalmanagementsystem.models.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @GetMapping
    public List<Doctor> getAllDoctors() {
        System.out.println("Get All Doctors");
        return null;
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        System.out.println("Create Doctor");
        return doctor;
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        System.out.println("Get Doctor");
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable Long id) {
        System.out.println("Delete Doctor");
    }

    @PutMapping("/{id}")
    public void updateDoctorById(@PathVariable Long id) {
        System.out.println("Update Doctor");
    }
}
