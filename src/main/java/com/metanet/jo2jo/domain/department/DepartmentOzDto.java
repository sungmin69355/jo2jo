package com.metanet.jo2jo.domain.department;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentOzDto {
    String id;
    String name;
    String pId;

    public DepartmentOzDto(String id, String name, String pId) {
        this.id = id;
        this.name = name;
        this.pId = pId;
    }
}
