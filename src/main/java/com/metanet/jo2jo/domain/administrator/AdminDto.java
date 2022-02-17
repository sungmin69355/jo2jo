package com.metanet.jo2jo.domain.administrator;

import lombok.Getter;

@Getter
public class AdminDto {
    private Long no;
    private Long empno; // 내 정보 세션 보이기 위해 추가
    private String id;
    private String password;

    public AdminDto(Long no, String id, String password) {
        this.no = no;
        this.id = id;
        this.password = password;
    }
}
