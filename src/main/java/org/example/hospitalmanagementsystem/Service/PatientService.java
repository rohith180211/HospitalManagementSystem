package org.example.hospitalmanagementsystem.Service;

import org.example.hospitalmanagementsystem.models.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    // Mock database for storing patients
    private static final List<Patient> patients = new ArrayList<>();

    // Get all patients
    public static List<Patient> getAllPatients() {
        try {
            System.out.println("Inside getAllPatients method");
            return patients; // Return the list of patients
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get a patient by ID
    public static Patient getPatientById(Long id) {
        try {
            System.out.println("Inside getPatientById method");
            return patients.stream()
                    .filter(patient -> patient.getId().equals(id))
                    .findFirst()
                    .orElse(null); // Return the patient if found, otherwise null
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Add a new patient
    public static Patient addPatient(Patient patient) {
        try {
            System.out.println("Inside addPatient method");
            patients.add(patient);
            return patient;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update an existing patient by ID
    public static Patient updatePatient(Long id) {
        try {
            System.out.println("Inside updatePatient method");
            return null; // Return null if patient not found
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Delete a patient by ID
    public static boolean deletePatientById(Long id) {
        try {
            System.out.println("Inside deletePatientById method");
            return patients.removeIf(patient -> patient.getId().equals(id)); // Remove the patient if found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
