package com.xworkz.acer.Repo;

import java.util.List;

import com.xworkz.acer.entity.AcerEntity;

public interface AcerRepo {
    List<AcerEntity> getproductNameById(int id);
    List<Object[]> getBrandNameAndPriceByPhoneNumber(long pohone_no);
}