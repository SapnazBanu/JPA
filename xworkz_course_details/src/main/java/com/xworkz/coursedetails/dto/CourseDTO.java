package com.xworkz.coursedetails.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class CourseDTO {
    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String confirmPassword;
    private Long phoneNo;
}
