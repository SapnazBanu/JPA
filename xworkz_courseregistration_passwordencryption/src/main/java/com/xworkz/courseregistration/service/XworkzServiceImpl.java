package com.xworkz.courseregistration.service;

import com.xworkz.courseregistration.dto.XworkzDTO;
import com.xworkz.courseregistration.entity.XworkzEntity;
import com.xworkz.courseregistration.repository.XworkzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class XworkzServiceImpl implements XworkzService {
    @Autowired
    private XworkzRepository xworkzRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public String onSave(XworkzDTO dto) {
        String errorMessage = null;
        if (dto != null) {
            String name = dto.getName();

            if (name.length() < 10) {
                errorMessage = "Invalid Name: it should contain a minimum of 10 characters";
                System.err.println("Invalid Name: it should contain a minimum of 10 characters");

            } else {
                int age = dto.getAge();
                if (age <= 18) {
                    errorMessage = "Invalid Age: Age must be greater than 18";
                    System.err.println("Invalid Age: Age must be greater than 18");
                } else {
                    String email = dto.getEmail();
                    if (!email.contains("@") || !email.endsWith("gmail.com")) {
                        errorMessage = "Invalid Email: email must have @ and it should end with gmail.com";
                        System.err.println("Invalid Email: email must have @ and it should end with gmail.com");
                    } else {
                        String password = dto.getPassword();
                        if (password.length() < 7 || !password.matches("^(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{7,}$")) {
                            errorMessage = "Invalid Password";
                            System.err.println("Invalid Password");
                        } else {
                            String cPassword = dto.getConfirmPassword();
                            if (!cPassword.equals(password)) {
                                errorMessage = "Password and Confirm Password don't match";
                                System.err.println("Password and Confirm Password don't match");
                            } else {
                                String ph = dto.getPhno();
                                if (!ph.startsWith("9") || ph.length() != 10) {
                                    errorMessage = "Invalid Contact Number: Contact Number should have 10 characters and must start with 9";
                                    System.err.println("Invalid Contact Number: Contact Number should have 10 characters and must start with 9");
                                } else {
                                    XworkzEntity websiteEntity = new XworkzEntity();
                                    websiteEntity.setName(dto.getName());
                                    websiteEntity.setEmail(dto.getEmail());
                                    websiteEntity.setAge(dto.getAge());
                                    websiteEntity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
                                    websiteEntity.setPhno(dto.getPhno());
                                    xworkzRepository.onSave(websiteEntity);
                                    errorMessage = "Validation successful";
                                    System.out.println("Validation successful");
                                }
                            }
                        }
                    }
                }
            }
        }
        return errorMessage;
    }

    @Override
    public String validateAndLogin(String email, String password) {
        XworkzEntity entity = xworkzRepository.findByEmail(email);

        if (entity != null)
        {
            if (bCryptPasswordEncoder.matches(password, entity.getPassword())) {
                return entity.getName();
            } else {
                return "Invalid email or password";
            }
        }

        return "Invalid email or password";


    }

    @Override
    public XworkzDTO getUserDetails(String email) {
        XworkzEntity entity = xworkzRepository.findByEmail(email);
        if (entity != null) {
            XworkzDTO dto = new XworkzDTO();
            dto.setName(entity.getName());
            dto.setEmail(entity.getEmail());
            dto.setAge(entity.getAge());
            dto.setPhno(entity.getPhno());
            return dto;
        }
        return null;
    }
    }





