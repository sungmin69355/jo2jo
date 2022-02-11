package com.metanet.jo2jo.domain.curriculum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CurriculumDto {
    private Long currno;
    private String currname;
    private Long currcost;
    private String startdate;
    private String enddate;
    private String deptrange;
    private String content;
    private String instructor;
    private String educos1;
    private String educos2;
    private String educos3;
    private String educos4;
    private String educos5;
    private Long costotalcnt;

    public CurriculumDto(Long currno, String currname, Long currcost, String startdate, String enddate, String deptrange, String content, String instructor, String educos1, String educos2, String educos3, String educos4, String educos5, Long costotalcnt) {
        this.currno = currno;
        this.currname = currname;
        this.currcost = currcost;
        this.startdate = startdate;
        this.enddate = enddate;
        this.deptrange = deptrange;
        this.content = content;
        this.instructor = instructor;
        this.educos1 = educos1;
        this.educos2 = educos2;
        this.educos3 = educos3;
        this.educos4 = educos4;
        this.educos5 = educos5;
        this.costotalcnt = costotalcnt;
    }
}
