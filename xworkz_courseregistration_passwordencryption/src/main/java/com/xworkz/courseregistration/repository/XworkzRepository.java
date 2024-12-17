package com.xworkz.courseregistration.repository;

import com.xworkz.courseregistration.entity.XworkzEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface XworkzRepository {
    boolean onSave(XworkzEntity entity);
    XworkzEntity findByEmail(String email);
}
