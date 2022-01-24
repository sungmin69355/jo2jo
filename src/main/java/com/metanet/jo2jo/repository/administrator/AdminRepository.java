package com.metanet.jo2jo.repository.administrator;

import com.metanet.jo2jo.domain.Login.LoginDto;
import com.metanet.jo2jo.domain.administrator.AdminDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminRepository {
    int insertAdmin(AdminDto adminDto);
    AdminDto findByLoginId(LoginDto loginDto);
}
