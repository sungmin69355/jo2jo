package com.metanet.jo2jo.domain.curriculum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CurriculumDto {
    private Long currno;
    @NotBlank(message = "이름을 입력해주세요")
    private String currname;
    @NotNull(message = "비용을 입력해주세요")
    private Long currcost;
//    @NotNull(message = "시작일을 입력해주세요")
    private String startdate;
//    @NotNull(message = "종료일을 입력해주세요")
    private String enddate;
    @NotEmpty(message = "부서 범위를 선택해주세요")
    private String deptrange;
    @NotBlank(message = "내용을 입력해주세요")
    private String content;
    @NotBlank(message = "강사명을 입력해주세요")
    private String instructor;
    @NotBlank(message = "코스를 한개 이상 입력해주세요")
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

    public CurriculumDto() {

    }
}
