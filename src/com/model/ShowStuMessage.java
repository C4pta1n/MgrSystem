package com.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShowStuMessage {
    private final StringProperty stuId;
    private final StringProperty stuName;
    private String sex;
    private String birthday;
    private String speciality;
    private String department;
    private String clazz;

    public String getStuId() {
        return stuId.get();
    }

    public StringProperty stuIdProperty() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId.set(stuId);
    }

    public String getStuName() {
        return stuName.get();
    }

    public StringProperty stuNameProperty() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName.set(stuName);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public ShowStuMessage(String stuId, String stuName) {
        this.stuId = new SimpleStringProperty(stuId);
        this.stuName = new SimpleStringProperty(stuName);
    }

    public ShowStuMessage() {
        this(null,null);
    }
}
