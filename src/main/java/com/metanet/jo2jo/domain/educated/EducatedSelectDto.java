package com.metanet.jo2jo.domain.educated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EducatedSelectDto {
	private Long empno;
	private Long currno;
	private String currname;
	private String content;
	private String instructor;
	private String startdate;
	private String enddate;
	private String edustate;
	
	public EducatedSelectDto() {
		
	}

	public EducatedSelectDto(Long empno, Long currno, String currname, String content, String instructor,
			String startdate, String enddate) {
		this.empno = empno;
		this.currno = currno;
		this.currname = currname;
		this.content = content;
		this.instructor = instructor;
		this.startdate = startdate;
		this.enddate = enddate;
	}
}
