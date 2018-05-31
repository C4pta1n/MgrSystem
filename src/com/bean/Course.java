package com.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
    private int cno;
    private final StringProperty cname;
    private Speciality speciality;
    private int ctno;
    private int lecture;
    private int experiment;
    private int semester;
    private int credit;

    public int getCno() {
        return cno;
    }
    public void setCno(int cno) {
        this.cno=cno;
    }

    public String getCname() {
        return cname.get();
    }
    public void setCname(String cname) {
        this.cname.set(cname);
    }
    public StringProperty cnameProperty(){
        return cname;
    }

    public Speciality getSpeciality() {
        return speciality;
    }
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
    public int getCtno() {
        return ctno;
    }
    public void setCtno(int ctno) {
        this.ctno = ctno;
    }
    public int getLecture() {
        return lecture;
    }
    public void setLecture(int lecture) {
        this.lecture = lecture;
    }
    public int getExperiment() {
        return experiment;
    }
    public void setExperiment(int experiment) {
        this.experiment = experiment;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public Course(String cname) {
        this.cname = new SimpleStringProperty(cname);
    }
    public Course() {
        this(null);
    }
}
