package com.xworkz.courseregistration.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordCheck {
    @Autowired
    private  static PasswordEncoder passwordEncoder;
    public static void main(String[] args) {

        System.out.println("Passw0rd".matches("^(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{7,}$"));

    }
}
