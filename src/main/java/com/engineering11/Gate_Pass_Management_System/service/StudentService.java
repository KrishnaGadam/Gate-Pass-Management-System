package com.engineering11.Gate_Pass_Management_System.service;

import com.engineering11.Gate_Pass_Management_System.dao.LeaveApplicationRepository;
import com.engineering11.Gate_Pass_Management_System.dao.StudentRepository;
import com.engineering11.Gate_Pass_Management_System.entity.LeaveApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    public String leaveRequest(LeaveApplication leaveApplication){
        try {
            leaveApplicationRepository.save(leaveApplication);
            return "Successfully added Leave Application!";

        }catch (Exception e){
            log.error("Error in adding Leave Application",e.getMessage());
        }
        return null;
    }

    public String checkStatus(Long id){
        Optional<LeaveApplication> leaveApplication=leaveApplicationRepository.findByApplicationId(id);
        return leaveApplication.get().getStatus();
    }
    public List<LeaveApplication> getApplications(Long id){

        return leaveApplicationRepository.findByStudentId(id);
    }


}
