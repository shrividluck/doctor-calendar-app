package com.example.docappointment.controller;

import com.example.docappointment.exception.ResourceNotFoundException;
import com.example.docappointment.model.Appointment;
import com.example.docappointment.model.Doctor;

import com.example.docappointment.repository.AppointmentRepository;
import com.example.docappointment.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.LocalTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DoctorAppointmentController {

    @Autowired
    DocRepository docRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return docRepository.findAll();
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointment( ) {
        return appointmentRepository.findAll();
    }

    @GetMapping("/appointment/{doc_id}/{date}/{time}")
    public List<Appointment> getAppointmentByDocIdAndDay(@PathVariable(value = "doc_id") Long docId,
                                            @PathVariable(value = "date") String date,
                                                         @PathVariable(value = "time") String time ) {
        java.time.LocalTime time1 = java.time.LocalTime.parse(time);
        java.time.LocalDate date1 = java.time.LocalDate.parse(date);
        return appointmentRepository.findBydocIdAndDateAndTime(docId, date1, time1);
    }



    @PostMapping("/appointment")
    public Appointment addAppointment(@org.jetbrains.annotations.NotNull @Valid @RequestBody Appointment appt) {

        java.time.LocalTime time1 = appt.getTime();
        int minute = time1.getMinute();
        int hour = time1.getHour();
        // if, the minutes are not divisible by 15, then round it off to the next minutes divisible
        // by 15 and schedule appointment.
        if(minute % 15 != 0) {
            int minutes_to_add = 0;
            if(minute < 15) {
               minutes_to_add = 15 - minute;
            } else if(minute < 30) {
                minutes_to_add = 30 - minute;
            } else if(minute < 45) {
                minutes_to_add = 45 - minute;
            } else {
                minutes_to_add = -minute;
                time1 = time1.plusHours(1);
            }
            time1 = time1.plusMinutes(minutes_to_add);
            appt.setTime(time1);
        }

        List<Appointment> appts = appointmentRepository.findBydocIdAndDateAndTime(appt.get_docId(), appt.getDate(),
                 appt.getTime());
        // if more than 3 appointments have been booked for the same time slot, return null/don't create appointment.
        if(appts.size() >= 3) {
            return null;
        }
        System.out.println("doc_id"+appt.get_docId());
        return appointmentRepository.save(appt);

    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable(value = "id") Long appointmentId) {
        Appointment appt = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", appointmentId));

        appointmentRepository.delete(appt);

        return ResponseEntity.ok().build();
    }
}
