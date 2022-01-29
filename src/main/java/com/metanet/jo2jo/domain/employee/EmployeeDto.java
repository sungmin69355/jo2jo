package com.metanet.jo2jo.domain.employee;

import lombok.Getter;

@Getter
public class EmployeeDto {
    private  Long empno;
    private  Long deptno;
    private  Long posno;
    private  String empname;
    private  String email;
    private  String phone;
    private  String address;
    private  String photoaddr;
    private  String  regno;
    private  Long annual;
    private  String id;
    private  String password;
    private  Long salary;
    private  String hiredate;
    private  String academic;
    private  Long military;
    private  Long gender;


    public EmployeeDto(Long empno, Long deptno, Long posno, String empname, String email, String phone, String address, String photoaddr, String regno, Long annual, String id, String password, Long salary, String hiredate, String academic, Long military, Long gender) {
        this.empno = empno;
        this.deptno = deptno;
        this.posno = posno;
        this.empname = empname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.photoaddr = photoaddr;
        this.regno = regno;
        this.annual = annual;
        this.id = id;
        this.password = password;
        this.salary = salary;
        this.hiredate = hiredate;
        this.academic = academic;
        this.military = military;
        this.gender = gender;
    }
}
