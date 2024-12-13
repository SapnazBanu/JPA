package com.xworkz.admin_details.service;

import com.xworkz.admin_details.dto.XworkzAdminDTO;
import com.xworkz.admin_details.entity.XworkzAdminEntity;
import com.xworkz.admin_details.repository.AdminRepository;
import com.xworkz.admin_details.repository.AdminRepositoryImpl;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public boolean save(XworkzAdminDTO dto) {
        if (dto == null) {
            System.out.println("DTO is null.");
            return false;
        }

        boolean isValid = true;
        if (dto.getName() == null || !dto.getName().matches("^[a-zA-Z\\s]{10,}$")) {
            System.out.println("Invalid name. It must be at least 10 characters and contain no special characters.");
            isValid = false;
        }
        if (dto.getAge() <= 18) {
            System.out.println("Invalid age. Age must be greater than 18.");
            isValid = false;
        }
        if (dto.getEmail() == null || !dto.getEmail().matches("^[\\w.-]+@gmail\\.com$")) {
            System.out.println("Invalid email. It must be a valid Gmail address.");
            isValid = false;
        }
        if (dto.getPassword() == null || !dto.getPassword().matches("^(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{7,}$")) {
            System.out.println("Invalid password. It must be at least 7 characters long and contain at least 2 special characters.");
            isValid = false;
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            System.out.println("Password and confirm password do not match.");
            isValid = false;
        }

        if (dto.getPhoneNo() == null || !dto.getPhoneNo().toString().matches("^9\\d{9}$")) {
            System.out.println("Invalid phone number. It must start with 9 and be exactly 10 digits long.");
            isValid = false;
        }

            if (isValid) {
                XworkzAdminEntity entity = new XworkzAdminEntity();
                entity.setName(dto.getName());
                entity.setAge(dto.getAge());
                entity.setEmail(dto.getEmail());
                entity.setPassword(dto.getPassword());
                entity.setConfirmPassword(dto.getConfirmPassword());
                entity.setPhoneNo(dto.getPhoneNo());

                AdminRepository repo = new AdminRepositoryImpl();
                repo.save(entity);
                System.out.println("entity: " + entity.toString());
            }

        return isValid;
       }

}