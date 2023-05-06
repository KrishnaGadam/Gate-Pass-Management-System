package com.engineering11.Gate_Pass_Management_System.dao;

import com.engineering11.Gate_Pass_Management_System.entity.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication,Long> {
    Optional<LeaveApplication> findByApplicationId(Long id);
    List<LeaveApplication> findByStatus(String status);
    List<LeaveApplication> findByStudentId(Long id);
}
