package com.xworkz.admin_details.service;

import com.xworkz.admin_details.dto.XworkzAdminDTO;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    boolean save(XworkzAdminDTO dto);
}
