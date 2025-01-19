package org.example.hospitalmanagementsystem.Controllers;

import org.example.hospitalmanagementsystem.Service.PatientService;
import org.example.hospitalmanagementsystem.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;


    @GetMapping
    public List<Patient> getAllPatients(){
        System.out.println("Get All Patients");
        return PatientService.getAllPatients();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        System.out.println("Create Patient");
        return PatientService.addPatient(patient);
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id){
        System.out.println("Get Patient");
        return PatientService.getPatientById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable Long id){
        PatientService.deletePatientById(id);
    }
    @PutMapping("/{id}")
    public void updatePatientById(@PathVariable Long id,@RequestBody Patient patient){
        PatientService.updatePatient(id, patient);
    }
}
