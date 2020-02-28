package com.example.docappointment.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "appt_table")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//allowGetters = true)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentID;

  //  @NotBlank(message = "Please enter docId")
    private Long docId;

    //@NotBlank(message = "Please enter patientfirstname")
    private String patientfirstname;


    private String patientlastname;

    //@NotBlank(message = "Please enter date of appt")
    private java.time.LocalDate date;

    //@NotBlank(message = "Pleae enter time of appt")
    private java.time.LocalTime time;


    private String kindofappointment;


    public Long get_docId() {
        return docId;
    }

    public Long get_apptId() {
        return appointmentID;
    }

    public void set_doc_id(Long id) {
        this.docId = id;
    }

    public String get_patient_first_name() {
        return patientfirstname;
    }

    public void set_patient_first_name(String p_f_name) {
        this.patientfirstname = p_f_name;
    }

    public String get_patient_last_name() {
        return patientlastname;
    }

    public void set_patient_last_name(String p_l_name) {
        this.patientlastname = p_l_name;
    }

    public java.time.LocalDate getDate() {
        return date;
    }

    public void setDate(java.time.LocalDate date) {
        this.date = date;
    }

    public java.time.LocalTime getTime() {
        return time;
    }

    public void setTime(java.time.LocalTime time) {
        this.time = time;
    }

    public String getKind_of_appointment() {
        return kindofappointment;
    }

    public void setKind_of_appointment(String kind_of_appointment) {
        this.kindofappointment = kind_of_appointment;
    }
}
