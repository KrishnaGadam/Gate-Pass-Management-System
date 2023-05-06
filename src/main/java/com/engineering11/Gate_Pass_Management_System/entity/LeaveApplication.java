package com.engineering11.Gate_Pass_Management_System.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "LEAVE_APPLICATION")
@Getter
@Setter
public class LeaveApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicationId;
    private String status;
    private String reason;
    private Date startDate;
    private Date endDate;
    private Long hostelAdminId;
    private Long studentId;


}
