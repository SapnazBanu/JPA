package com.xworkz.admin_details.controller;

import com.xworkz.admin_details.dto.XworkzAdminDTO;
import com.xworkz.admin_details.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AdminDetailsController {

    public AdminDetailsController() {
        System.out.println("AdminDetailsController created");
    }

    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/submitForm", method = {RequestMethod.GET, RequestMethod.POST})
    public String onSave(XworkzAdminDTO dto, Model model) {
        System.out.println("save method"+dto);

        System.out.println("AdminDetailsController: onSave method invoked");
        System.out.println("Received DTO: " + dto);

        boolean isSaved = adminService.save(dto);

        if (isSaved) {
            System.out.println("Admin details saved successfully");
            model.addAttribute("successMessage", "Registration successful!");
            return "Success.jsp";
        } else {
            System.err.println("Failed to save admin details");
            model.addAttribute("errorMessage", "Registration failed. Please check your input.");
            model.addAttribute("adminDetails", dto);
            return "login.jsp";
        }
//        return "data saved";
    }
}
