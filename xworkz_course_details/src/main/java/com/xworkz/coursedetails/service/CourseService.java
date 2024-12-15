package com.xworkz.coursedetails.service;

import com.xworkz.coursedetails.dto.CourseDTO;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    String  validate(CourseDTO dto);
    String getNameByEmailAndPassword(String email,String password);

}
