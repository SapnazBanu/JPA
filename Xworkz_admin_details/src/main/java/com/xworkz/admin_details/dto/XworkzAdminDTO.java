package com.xworkz.admin_details.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@Component
public class XworkzAdminDTO {
    @Id
    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String confirmPassword;
    private Long phoneNo;
}
