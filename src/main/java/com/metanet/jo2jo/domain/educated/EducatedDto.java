package com.metanet.jo2jo.domain.educated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EducatedDto {
    private Long eduno;
    private Long empno;
    private Long currno;
    private Long edustate;
    private Long achievement;

    public EducatedDto(Long eduno, Long empno, Long currno, Long edustate, Long achievement) {
        this.eduno = eduno;
        this.empno = empno;
        this.currno = currno;
        this.edustate = edustate;
        this.achievement = achievement;
    }
}
