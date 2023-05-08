package com.engineering11.Gate_Pass_Management_System.controller;

import com.engineering11.Gate_Pass_Management_System.entity.LeaveApplication;
import com.engineering11.Gate_Pass_Management_System.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    //add leave application
    @PostMapping("/addLeave")
    public String leaveRequest(@RequestBody LeaveApplication leaveApplication){

        return studentService.leaveRequest(leaveApplication);
    }

    //check status of application
    @GetMapping("/checkStatus/{id}")
    public String checkStatus(@PathVariable Long id){

        return studentService.checkStatus(id);
    }

    //show all the application for particular student
    @GetMapping("/applications/{studentId}")
    public List<LeaveApplication> getApplications(@PathVariable Long studentId){

        return studentService.getApplications(studentId);
    }


}
