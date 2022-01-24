package com.metanet.jo2jo.domain.employee;

import lombok.Getter;

@Getter
public class EmployeeDto {
    private  Long EMPNO;
    private  Long DEPTNO;
    private  Long POSNO;
    private  String EMAIL;
    private  String EMPNAME;
    private  String ADDRESS;
    private  String PHOTOADDR;
    private  String REGNO;
    private  int ANNUAL;
    private  String Id;
    private  String PASSWORD;
    private  Long SALARY;
    private  String HIREDATE;
    private  String ACADEMIC;
    private  int MILITARY;
    private  int GENDER;

    public EmployeeDto(Long EMPNO, Long DEPTNO, Long POSNO, String EMAIL, String EMPNAME, String ADDRESS, String PHOTOADDR, String REGNO, int ANNUAL, String id, String PASSWORD, Long SALARY, String HIREDATE, String ACADEMIC, int MILITARY, int GENDER) {
        this.EMPNO = EMPNO;
        this.DEPTNO = DEPTNO;
        this.POSNO = POSNO;
        this.EMAIL = EMAIL;
        this.EMPNAME = EMPNAME;
        this.ADDRESS = ADDRESS;
        this.PHOTOADDR = PHOTOADDR;
        this.REGNO = REGNO;
        this.ANNUAL = ANNUAL;
        Id = id;
        this.PASSWORD = PASSWORD;
        this.SALARY = SALARY;
        this.HIREDATE = HIREDATE;
        this.ACADEMIC = ACADEMIC;
        this.MILITARY = MILITARY;
        this.GENDER = GENDER;
    }
}
