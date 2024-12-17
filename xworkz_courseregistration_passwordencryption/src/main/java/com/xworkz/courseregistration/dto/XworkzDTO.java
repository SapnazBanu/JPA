package com.xworkz.courseregistration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class XworkzDTO {
    int id;
    String name;
    Integer age;
    String email;
    String password;
    String confirmPassword;
    String phno;
}
