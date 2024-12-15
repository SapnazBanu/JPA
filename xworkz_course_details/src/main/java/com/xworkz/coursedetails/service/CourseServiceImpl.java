package com.xworkz.coursedetails.service;

import com.xworkz.coursedetails.dto.CourseDTO;
import com.xworkz.coursedetails.entity.CourseEntity;
import com.xworkz.coursedetails.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository repository;

    @Override
    public String getNameByEmailAndPassword(String email, String password) {
        String name = repository.getNameByEmailAndPassword(email, password);
        return name;
    }

    @Override
    public String validate(CourseDTO courseDTO) {
        String msg = null;
        boolean valid = true;

        if (courseDTO == null) {
            return "CourseDTO object is null";
        }

        System.out.println(courseDTO.toString());

        String name = courseDTO.getName();
        if (name != null && !name.isEmpty() && name.length() >= 10 && name.matches("[A-Za-z ]+")) {
            System.out.println("name is valid");

            Integer age = courseDTO.getAge();
            if (age != null && age > 18) {
                System.out.println("age is valid");

                String email = courseDTO.getEmail();
                if (email != null && email.endsWith("gmail.com") && email.contains("@")) {
                    System.out.println("email is valid");

                    String password = courseDTO.getPassword();
                    if (password != null) {
                        int specialCharCount = 0;
                        for (char c : password.toCharArray()) {
                            if (!Character.isLetterOrDigit(c)) {
                                specialCharCount++;
                            }
                        }

                        if (password.length() == 9 && specialCharCount == 2) {
                            System.out.println("valid password");

                            String confirmPassword = courseDTO.getConfirmPassword();
                            if (confirmPassword != null && confirmPassword.equals(password)) {
                                System.out.println("password matches");

                                String phone = String.valueOf(courseDTO.getPhoneNo());
                                if (phone != null && phone.length() == 10 && phone.startsWith("9")) {
                                    System.out.println("valid phone");

                                    CourseEntity courseEntity = new CourseEntity();
                                    courseEntity.setName(courseDTO.getName());
                                    courseEntity.setAge(courseDTO.getAge());
                                    courseEntity.setEmail(courseDTO.getEmail());
                                    courseEntity.setPassword(courseDTO.getPassword());
                                    courseEntity.setConfirmPassword(courseDTO.getConfirmPassword());
                                    courseEntity.setPhoneNo(courseDTO.getPhoneNo());

                                    boolean saved = this.repository.save(courseEntity);
                                    System.out.println(saved);
                                    return "Course registration is successful!";
                                } else {
                                    msg = "Phone number must begin with 9 and be 10 digits long";
                                    return msg;
                                }
                            } else {
                                msg = "Password doesn't match";
                                return msg;
                            }
                        } else {
                            msg = "Password must contain 2 special characters and be 9 characters long";
                            return msg;
                        }
                    } else {
                        msg = "Password cannot be null";
                        return msg;
                    }
                } else {
                    msg = "Please enter a valid email with '@gmail.com'";
                    return msg;
                }
            } else {
                msg = "Age must be greater than 18";
                return msg;
            }
        } else {
            msg = "Name must be at least 10 characters long and contain no special characters";
            return msg;
        }
    }
}