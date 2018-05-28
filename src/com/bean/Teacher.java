package com.bean;
import java.util.Date;
public class Teacher {
    private int tno;
    private String tname;
    private String tsex;
    private Date tbirthday;
    private Department department;
    private char techtitle;

    public Teacher() {

    }

    public Teacher(int tno, String tname, String tsex, Date tbirthday, Department department, char techtitle) {
        this.tno = tno;
        this.tname = tname;
        this.tsex = tsex;
        this.tbirthday = tbirthday;
        this.department = department;
        this.techtitle = techtitle;
    }

    public int getTno() {
        return tno;
    }
    public void setTno(int tno) {
        this.tno = tno;
    }
    public String getTname() {
        return tname;
    }
    public void setTname(String tname) {
        this.tname = tname;
    }
    public String getTsex() {
        return tsex;
    }
    public void setTsex(String tsex) {
        this.tsex = tsex;
    }
    public Date getTbirthday() {
        return tbirthday;
    }
    public void setTbirthday(Date tbirthday) {
        this.tbirthday = tbirthday;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public char getTechtitle() {
        return techtitle;
    }
    public void setTechtitle(char techtitle) {
        this.techtitle = techtitle;
    }
}
