package com.metanet.jo2jo.domain.administrator;

import lombok.Getter;

@Getter
public class AdminDto {
    private Long no;
    private String id;
    private String password;

    public AdminDto(Long no, String id, String password) {
        this.no = no;
        this.id = id;
        this.password = password;
    }
}
