package com.xworkz.admin_details.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name="admin_table")
@Component
public class XworkzAdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="admin_Name")
    private String name;

    @Column(name="admin_Age")
    private int age;

    @Column(name="admin_Email")
    private String email;

    @Column(name="admin_Password")
    private String password;

    @Column(name="admin_confirmPassword")
    private String confirmPassword;

    @Column(name="admin_phoneNo")
    private Long phoneNo;
}
