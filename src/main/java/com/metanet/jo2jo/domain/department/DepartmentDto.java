package com.metanet.jo2jo.domain.department;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DepartmentDto {
    private Long deptno;
    private String deptname;
    private Long maneger;
    private Long deptid;

    public DepartmentDto(Long deptno, String deptname, Long maneger, Long deptid) {
        this.deptno = deptno;
        this.deptname = deptname;
        this.maneger = maneger;
        this.deptid = deptid;
    }



public class DepartmentDto {
	private Long deptno;
	private String deptname;
	private Long manager;
	private Long deptpid;
	
	
	public DepartmentDto(Long deptno, String deptname, Long manager, Long deptpid) {	
		this.deptno = deptno;
		this.deptname = deptname;
		this.manager = manager;
		this.deptpid = deptpid;
	}
		
}
