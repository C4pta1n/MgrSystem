package com.bean;

public class Department {
    private int dno;
    private String deptname;
    private String headler;
    public Department(int dno, String deptname, String headler) {
        this.dno = dno;
        this.deptname = deptname;
        this.headler = headler;
    }
    public Department() {

    }
    public int getDno() {
        return dno;
    }
    public void setDno(int dno) {
        this.dno = dno;
    }
    public String getDeptname() {
        return deptname;
    }
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
    public String getHeadler() {
        return headler;
    }
    public void setHeadler(String headler) {
        this.headler = headler;
    }
}
