package com.xworkz.courseregistration.controller;

import com.xworkz.courseregistration.dto.XworkzDTO;
import com.xworkz.courseregistration.service.XworkzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PasswordController {

    public PasswordController() {
        System.out.println("PasswordController created");
    }

    @Autowired
    private XworkzService xworkzService;

    @PostMapping("/saveUp")
    public String onSave(XworkzDTO dto, Model model) {
        System.out.println("onSave in PasswordController");
        System.out.println(dto);
        String validationMessage = xworkzService.onSave(dto);
        if ("Validation successful".equals(validationMessage)) {
            return "Success";
        } else {
            model.addAttribute("error", validationMessage);
            return "Signup";
        }
    }


    @PostMapping("/saveIn")
    public String onLogin(String email, String password, Model model) {
        System.out.println("onLogin in PasswordController");
        String validationMessage = xworkzService.validateAndLogin(email, password);
        if (!"Invalid email or password".equals(validationMessage)) {
            XworkzDTO userDetails = xworkzService.getUserDetails(email);
            model.addAttribute("userName", validationMessage);
            model.addAttribute("userDetails", userDetails);
            return "SigninSuccess";
        } else {
            model.addAttribute("error", validationMessage);
            return "Signin";
        }
    }


    @RequestMapping("/user")
    public String getUserDetails(String email, Model model) {
        XworkzDTO userDetails = xworkzService.getUserDetails(email);
        model.addAttribute("userName", userDetails.getName());
        model.addAttribute("userDetails", userDetails);
        return "SigninSuccess";
    }
}
