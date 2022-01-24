package com.metanet.jo2jo.service;

import com.metanet.jo2jo.domain.Login.LoginDto;
import com.metanet.jo2jo.domain.administrator.AdminDto;
import com.metanet.jo2jo.domain.employee.EmployeeDto;
import com.metanet.jo2jo.repository.administrator.AdminRepository;
import com.metanet.jo2jo.repository.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginService {
    private final AdminRepository adminRepository;
    private final EmployeeRepository employeeRepository;

    public AdminDto adminFindByLoginId(LoginDto loginDto){
        return adminRepository.findByLoginId(loginDto);
    }
    public EmployeeDto employeeFindByLoginId(LoginDto loginDto){
        return employeeRepository.findByLoginId(loginDto);
    }


}
