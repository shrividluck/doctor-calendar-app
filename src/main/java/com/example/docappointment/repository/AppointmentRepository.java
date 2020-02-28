package com.example.docappointment.repository;

import com.example.docappointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    ArrayList<Appointment> findBydocIdAndDateAndTime(Long doc_id, LocalDate date1, LocalTime time1);
}
