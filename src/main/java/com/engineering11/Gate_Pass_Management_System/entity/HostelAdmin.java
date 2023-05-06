package com.engineering11.Gate_Pass_Management_System.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "HOSTEL_ADMIN")
@Getter
@Setter
public class HostelAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hostelAdminId;
    private String hostelAdminName;
}
