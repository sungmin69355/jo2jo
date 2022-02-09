package com.metanet.jo2jo.domain.position;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionDto {
    private Long posno;
    private String posname;
    private Long minsalary;
    private Long maxsalary;

    public PositionDto(Long posno, String posname, Long minsalary, Long maxsalary) {
        this.posno = posno;
        this.posname = posname;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
    }
}
