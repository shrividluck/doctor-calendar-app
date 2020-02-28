package com.example.docappointment.repository;

import com.example.docappointment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DocRepository extends JpaRepository<Doctor, Long> {

}
