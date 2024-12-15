package com.xworkz.coursedetails.repository;


import com.xworkz.coursedetails.entity.CourseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {
    boolean save(CourseEntity entity);
    String getNameByEmailAndPassword(String email,String password);
}
