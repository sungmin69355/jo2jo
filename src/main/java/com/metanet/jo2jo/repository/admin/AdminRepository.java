package com.metanet.jo2jo.repository.admin;

import com.metanet.jo2jo.domain.administrator.AdminDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminRepository {

    int insertAdmin(AdminDto adminDto);
}
