package com.xworkz.coursedetails.controller;

import com.xworkz.coursedetails.dto.CourseDTO;
import com.xworkz.coursedetails.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class CourseController {

    @Autowired
    private CourseService service;

    public CourseController() {
        System.out.println("running CourseController");
    }

//    @PostMapping("/saveIn")
//    public String save(Model model, CourseDTO dto) {
//        System.out.println(dto.toString());
//        String valid = service.validate(dto);
//        model.addAttribute("msg", valid);
//        return "Signin.jsp";
//    }

        @PostMapping("/saveUp")
        public String onSave(CourseDTO dto,Model model){
            System.out.println("Controller :" + dto);
            String msg = this.service.validate(dto);
            model.addAttribute("msg", msg);
            return "Signup.jsp";

        }
        @PostMapping("/saveIn")
    public  String save(@RequestParam String email, @RequestParam String password,Model model)
        {
            String valid = service.getNameByEmailAndPassword(email,password);
            System.out.println("is it working"+valid);
            model.addAttribute("msg",valid);

            return "Signin.jsp";
        }


    }
