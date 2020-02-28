package com.example.docappointment.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "doctor_table")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        //allowGetters = true)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;



    public Long getId() {
        return docId;
    }

    public void setId(Long id) {
        this.docId = id;
    }

    public String get_Doc_first_name() {
        return firstname;
    }

    public void set_Doc_first_name(String f_name) {
        this.firstname = f_name;
    }

    public String get_Doc_last_name() {
        return lastname;
    }

    public void set_Doc_last_name(String l_name) {
        this.lastname = l_name;
    }

}
