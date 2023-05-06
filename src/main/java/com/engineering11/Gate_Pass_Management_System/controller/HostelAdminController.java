package com.engineering11.Gate_Pass_Management_System.controller;

import com.engineering11.Gate_Pass_Management_System.entity.HostelAdmin;
import com.engineering11.Gate_Pass_Management_System.entity.LeaveApplication;
import com.engineering11.Gate_Pass_Management_System.entity.Student;
import com.engineering11.Gate_Pass_Management_System.service.HostelAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hostelAdmin")
public class HostelAdminController {

    @Autowired
    HostelAdminService hostelAdminService;
    @GetMapping("/getStudents")
    public List<Student> getAllStudents(){
        return hostelAdminService.findAll();
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return hostelAdminService.addStudent(student);
    }

    @PostMapping
    public String addHostelAdmin(@RequestBody HostelAdmin hostelAdmin){
        return hostelAdminService.addHostelAdmin(hostelAdmin);
    }

    @GetMapping("/pendingApplication")
    public List<LeaveApplication> getPendingApplication(){
        return hostelAdminService.getPendingApplication();
    }

    @GetMapping("/approve/{id}")
    public String approveApplication(@PathVariable Long id){
        return hostelAdminService.changeStatus(id);
    }

    @GetMapping("/approvedApplication")
    public List<LeaveApplication> getApprovedApplication(){
        return hostelAdminService.getApprovedApplication();
    }

    @GetMapping("/allApplication")
    public List<LeaveApplication> getAllApplication(){
        return hostelAdminService.getAllApplication();
    }

}
