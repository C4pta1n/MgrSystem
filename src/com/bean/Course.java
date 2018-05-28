package com.bean;

public class Course {
    private int cno;
    private String cname;
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
        this.cno = cno;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
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
    public Course(int cno, String cname, Speciality speciality, int ctno, int lecture, int experiment, int semester,
                  int credit) {
        this.cno = cno;
        this.cname = cname;
        this.speciality = speciality;
        this.ctno = ctno;
        this.lecture = lecture;
        this.experiment = experiment;
        this.semester = semester;
        this.credit = credit;
    }
    public Course() {
        // TODO Auto-generated constructor stub
    }
}
