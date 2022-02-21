package com.metanet.jo2jo.domain.educated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EducatedSelectDto  {
	private Long rn;	
	private Long currno;
	private String currname;
	private String content;
	private String instructor;
	private String startdate;
	private String enddate;
	private String edustate;
	private Long empno;
	
	public EducatedSelectDto() {
		
	}

	public EducatedSelectDto(Long rn,Long currno, String currname, String content, String instructor,
			String startdate, String enddate,Long empno) {
		this.rn = rn;		
		this.currno = currno;
		this.currname = currname;
		this.content = content;
		this.instructor = instructor;
		this.startdate = startdate;
		this.enddate = enddate;
		this.empno = empno;
	}
}
