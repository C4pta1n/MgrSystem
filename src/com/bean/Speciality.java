package com.bean;

public class Speciality {
    private int spno;
    private Department department;
    private String spname;
    public int getSpno() {
        return spno;
    }
    public void setSpno(int spno) {
        this.spno = spno;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public String getSpname() {
        return spname;
    }
    public void setSpname(String spname) {
        this.spname = spname;
    }
    public Speciality(int spno, Department department, String spname) {
        this.spno = spno;
        this.department = department;
        this.spname = spname;
    }
    public Speciality() {
        // TODO Auto-generated constructor stub
    }
}
