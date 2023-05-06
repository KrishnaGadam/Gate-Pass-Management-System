package com.engineering11.Gate_Pass_Management_System.service;

import com.engineering11.Gate_Pass_Management_System.dao.HostelAdminRepository;
import com.engineering11.Gate_Pass_Management_System.dao.LeaveApplicationRepository;
import com.engineering11.Gate_Pass_Management_System.dao.StudentRepository;
import com.engineering11.Gate_Pass_Management_System.entity.HostelAdmin;
import com.engineering11.Gate_Pass_Management_System.entity.LeaveApplication;
import com.engineering11.Gate_Pass_Management_System.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HostelAdminService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private HostelAdminRepository hostelAdminRepository;

    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    public List<Student> findAll(){

        return studentRepository.findAll();
    }

    public String addStudent(Student student){
        try{
            studentRepository.save(student);
            return "Successfully added user to Database";
        }catch (Exception e){
            log.error("Exception while adding student",e.getMessage());
        }
        return null;
    }

    public String addHostelAdmin(HostelAdmin hostelAdmin){
        try {
            hostelAdminRepository.save(hostelAdmin);
            return "Successfully added Hostel Admin to Database";
        }catch (Exception e){
            log.error("Exception while adding Hostel Admin");
        }
        return null;
    }

    public List<LeaveApplication> getPendingApplication(){
        return leaveApplicationRepository.findByStatus("Pending");
    }
    public List<LeaveApplication> getApprovedApplication(){
        return leaveApplicationRepository.findByStatus("Approved");
    }
    public List<LeaveApplication> getAllApplication(){
        return leaveApplicationRepository.findAll();
    }

    public String changeStatus(Long id){
        try {
            Optional<LeaveApplication> leaveApplication=leaveApplicationRepository.findByApplicationId(id);
            leaveApplication.get().setStatus("Approved");
            leaveApplicationRepository.save(leaveApplication.get());
            return "Successfully Approved the application!";
        }catch (Exception e){
            log.error("Error in changing status",e.getMessage());
        }
        return null;

    }


}
