package org.example.hospitalmanagementsystem.Controllers;

import org.example.hospitalmanagementsystem.Service.DoctorService;
import org.example.hospitalmanagementsystem.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        System.out.println("Get All Doctors");
        return doctorService.getAllDoctors();
    }

    // Create a new doctor
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        System.out.println("Create Doctor");
        return doctorService.addDoctor(doctor);
    }

    // Get a doctor by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        System.out.println("Get Doctor");
        return doctorService.getDoctorById(id);
    }

    // Delete a doctor by ID
    @DeleteMapping("/{id}")
    public String deleteDoctorById(@PathVariable Long id) {
        System.out.println("Delete Doctor");
        boolean isDeleted = doctorService.deleteDoctorById(id);
        return isDeleted ? "Doctor deleted successfully" : "Doctor not found";
    }

    // Update a doctor by ID
    @PutMapping("/{id}")
    public Doctor updateDoctorById(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
        System.out.println("Update Doctor");
        return doctorService.updateDoctor(id, updatedDoctor);
    }
}
