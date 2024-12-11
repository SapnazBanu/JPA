package com.xworkz.acer.runner;

import com.xworkz.acer.service.AcerService;
import com.xworkz.acer.service.AcerServiceImpl;

public class MainRunner {
    public static void main(String[] args) {
        AcerService ref = new AcerServiceImpl();
        System.out.println(ref.getproductNameById(1));
        System.out.println(ref.getBrandNameAndPriceByPhoneNumber(7856932514L));
    }    
}
