package org.example.hospitalmanagementsystem.Repository;

import org.example.hospitalmanagementsystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
}
