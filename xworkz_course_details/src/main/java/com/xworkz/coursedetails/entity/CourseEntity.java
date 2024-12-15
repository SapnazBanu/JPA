package com.xworkz.coursedetails.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Component
@Table(name="course_table")
@NamedQuery(name="getNameByEmailAndPassword" ,query="select e.name from CourseEntity e where e.email= :byemail and e.password = :bypassword ")
public class CourseEntity {
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
