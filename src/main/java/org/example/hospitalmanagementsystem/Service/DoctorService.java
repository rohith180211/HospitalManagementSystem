package org.example.hospitalmanagementsystem.Service;

import org.example.hospitalmanagementsystem.models.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    // Mock database for storing doctors
    private static final List<Doctor> doctors = new ArrayList<>();

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        try {
            logger.info("Fetching all doctors");
            return doctors; // Return the list of doctors
        } catch (Exception e) {
            logger.error("Error fetching doctors: {}", e.getMessage());
            return null;
        }
    }

    // Get a doctor by ID
    public Doctor getDoctorById(Long id) {
        try {
            logger.info("Fetching doctor with ID: {}", id);
            return doctors.stream()
                    .filter(doctor -> doctor.getId().equals(id))
                    .findFirst()
                    .orElse(null); // Return the doctor if found, otherwise null
        } catch (Exception e) {
            logger.error("Error fetching doctor: {}", e.getMessage());
            return null;
        }
    }

    // Add a new doctor
    public Doctor addDoctor(Doctor doctor) {
        try {
            logger.info("Adding new doctor: {}", doctor);
            doctors.add(doctor);
            return doctor;
        } catch (Exception e) {
            logger.error("Error adding doctor: {}", e.getMessage());
            return null;
        }
    }

    // Update an existing doctor by ID
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        try {
            logger.info("Updating doctor with ID: {}", id);
            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getId().equals(id)) {
                    doctors.set(i, updatedDoctor); // Update the doctor
                    return updatedDoctor;
                }
            }
            return null; // Return null if doctor not found
        } catch (Exception e) {
            logger.error("Error updating doctor: {}", e.getMessage());
            return null;
        }
    }

    // Delete a doctor by ID
    public boolean deleteDoctorById(Long id) {
        try {
            logger.info("Deleting doctor with ID: {}", id);
            return doctors.removeIf(doctor -> doctor.getId().equals(id)); // Remove the doctor if found
        } catch (Exception e) {
            logger.error("Error deleting doctor: {}", e.getMessage());
            return false;
        }
    }
}
