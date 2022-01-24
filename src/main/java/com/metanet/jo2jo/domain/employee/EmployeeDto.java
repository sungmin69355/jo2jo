package com.metanet.jo2jo.domain.employee;

import lombok.Getter;

@Getter
public class EmployeeDto {
    private  Long empno;
    private  Long deptno;
    private  Long posno;
    private  String email;
    private  String empname;
    private  String address;
    private  String photoaddr;
    private  String regno;
    private  int annual;
    private  String id;
    private  String password;
    private  Long salaary;
    private  String hiredate;
    private  String academic;
    private  int military;
    private  int gender;

    public EmployeeDto(Long empno, Long deptno, Long posno, String email, String empname, String address, String photoaddr, String regno, int annual, String id, String password, Long salaary, String hiredate, String academic, int military, int gender) {
        this.empno = empno;
        this.deptno = deptno;
        this.posno = posno;
        this.email = email;
        this.empname = empname;
        this.address = address;
        this.photoaddr = photoaddr;
        this.regno = regno;
        this.annual = annual;
        this.id = id;
        this.password = password;
        this.salaary = salaary;
        this.hiredate = hiredate;
        this.academic = academic;
        this.military = military;
        this.gender = gender;
    }
}
