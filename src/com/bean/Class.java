package com.bean;

public class Class {
    private Speciality speciality;
    private String className;
    private int classno;
    private String header;
    public Speciality getSpeciality() {
        return speciality;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
    public int getClassno() {
        return classno;
    }
    public void setClassno(int classno) {
        this.classno = classno;
    }
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }

    public Class(Speciality speciality, String className, int classno, String header) {
        this.speciality = speciality;
        this.className = className;
        this.classno = classno;
        this.header = header;
    }

    public Class() {

        // TODO Auto-generated constructor stub
    }
}
