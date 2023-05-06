package com.engineering11.Gate_Pass_Management_System.dao;

import com.engineering11.Gate_Pass_Management_System.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {

}
