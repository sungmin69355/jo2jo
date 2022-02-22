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
	private Long achievement;
	private Long empno;
	
	public EducatedSelectDto() {
		
	}

	public EducatedSelectDto(Long rn,Long currno, String currname, String content, String instructor,
			 String enddate,Long achievement,Long empno) {
		this.rn = rn;		
		this.currno = currno;
		this.currname = currname;
		this.content = content;
		this.instructor = instructor;		
		this.enddate = enddate;
		this.achievement = achievement;
		this.empno = empno;
	}
}
