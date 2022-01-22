package com.metanet.jo2jo.service;

import com.metanet.jo2jo.domain.administrator.AdminDto;
import com.metanet.jo2jo.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public int insertAdmin(AdminDto adminDto){
        return adminRepository.insertAdmin(adminDto);
    }


}
