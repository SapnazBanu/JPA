package com.xworkz.courseregistration.service;

import com.xworkz.courseregistration.dto.XworkzDTO;
import com.xworkz.courseregistration.entity.XworkzEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface XworkzService {
    String onSave(XworkzDTO dto);
    String validateAndLogin(String email, String password);
    XworkzDTO getUserDetails(String email);
}
