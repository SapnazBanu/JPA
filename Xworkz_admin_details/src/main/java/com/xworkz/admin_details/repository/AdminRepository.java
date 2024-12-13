package com.xworkz.admin_details.repository;

import com.xworkz.admin_details.entity.XworkzAdminEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository {
    boolean save (XworkzAdminEntity entity);
}
