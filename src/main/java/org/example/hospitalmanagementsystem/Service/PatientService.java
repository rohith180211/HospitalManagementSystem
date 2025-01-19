package org.example.hospitalmanagementsystem.Service;

import org.example.hospitalmanagementsystem.Repository.PatientRepo;
import org.example.hospitalmanagementsystem.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private static final Logger logger= LoggerFactory.getLogger(PatientService.class);
    @Autowired
    private static PatientRepo patientRepo;
    // Mock database for storing patients
    private static final List<Patient> patients = new ArrayList<>();

    // Get all patients
    public static List<Patient> getAllPatients() {
        try {
            System.out.println("Inside getAllPatients method");
            return patientRepo.findAll(); // Return the list of patients
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    // Get a patient by ID
    public static Optional<Patient> getPatientById(Long id) {
        try {
            System.out.println("Inside getPatientById method");
            return patientRepo.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Add a new patient
    public static Patient addPatient(Patient patient) {
        try {
            System.out.println("Inside addPatient method");
            patientRepo.save(patient);
            return patient;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update an existing patient by ID
    public static Patient updatePatient(Long id, Patient patient) {
        try {
            Optional<Patient> currentPatient = getPatientById(id);
            if(currentPatient.isPresent()) {
                Patient updatedPatient = currentPatient.get();
                updatedPatient.setId(id);
                updatedPatient.setName(patient.getName());
                updatedPatient.setGender(patient.getGender());
                return patientRepo.save(updatedPatient);
            }
            else {
                logger.error("Patient not found");
                return null; // Return null if patient not found

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Delete a patient by ID
    public static boolean deletePatientById(Long id) {
        try {
            patientRepo.deleteById(id);
            return !patientRepo.existsById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
