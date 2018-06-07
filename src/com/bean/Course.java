package com.bean;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
    private final StringProperty cno;
    private final StringProperty cname;
    private Speciality speciality;
    private int ctno;
    private int lecture;
    private int experiment;
    private int semester;
    private final StringProperty credit;

    public String getCno() {
        return cno.get();
    }
    public void setCno(String cno) {
        this.cno.set(cno);
    }
    public StringProperty cnoProperty(){
        return cno;
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

    public String getCredit() {
        return credit.get();
    }
    public void setCredit(String credit) {
        this.credit.set(credit);
    }
    public StringProperty creditPriperty(){
        return credit;
    }

    public Course(String cname,String credit,String cno) {
        this.cname = new SimpleStringProperty(cname);
        this.credit = new SimpleStringProperty(credit);
        this.cno = new SimpleStringProperty(cno);
    }
    public Course() {
        this(null,null,null);
    }
}
