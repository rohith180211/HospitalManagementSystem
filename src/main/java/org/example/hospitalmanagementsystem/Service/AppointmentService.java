package org.example.hospitalmanagementsystem.Service;

import org.example.hospitalmanagementsystem.models.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    // Mock database for storing appointments
    private static final List<Appointment> appointments = new ArrayList<>();

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        try {
            logger.info("Fetching all appointments");
            return appointments; // Return the list of appointments
        } catch (Exception e) {
            logger.error("Error fetching appointments: {}", e.getMessage());
            return null;
        }
    }

    // Get an appointment by ID
    public Appointment getAppointmentById(Long id) {
        try {
            logger.info("Fetching appointment with ID: {}", id);
            return appointments.stream()
                    .filter(appointment -> appointment.getId().equals(id))
                    .findFirst()
                    .orElse(null); // Return the appointment if found, otherwise null
        } catch (Exception e) {
            logger.error("Error fetching appointment: {}", e.getMessage());
            return null;
        }
    }

    // Add a new appointment
    public Appointment addAppointment(Appointment appointment) {
        try {
            logger.info("Adding new appointment: {}", appointment);
            appointments.add(appointment);
            return appointment;
        } catch (Exception e) {
            logger.error("Error adding appointment: {}", e.getMessage());
            return null;
        }
    }

    // Update an existing appointment by ID
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        try {
            logger.info("Updating appointment with ID: {}", id);
            for (int i = 0; i < appointments.size(); i++) {
                if (appointments.get(i).getId().equals(id)) {
                    appointments.set(i, updatedAppointment); // Update the appointment
                    return updatedAppointment;
                }
            }
            return null; // Return null if appointment not found
        } catch (Exception e) {
            logger.error("Error updating appointment: {}", e.getMessage());
            return null;
        }
    }

    // Delete an appointment by ID
    public boolean deleteAppointmentById(Long id) {
        try {
            logger.info("Deleting appointment with ID: {}", id);
            return appointments.removeIf(appointment -> appointment.getId().equals(id)); // Remove the appointment if found
        } catch (Exception e) {
            logger.error("Error deleting appointment: {}", e.getMessage());
            return false;
        }
    }
}
