package com.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShowEva {
    private final StringProperty courseid;
    private final StringProperty courseName;
    private final StringProperty tameforcourse;
    private int tcid;

    public int getTcid() {
        return tcid;
    }

    public void setTcid(int tcid) {
        this.tcid = tcid;
    }

    public String getCouseid() {
        return courseid.get();
    }

    public StringProperty couseidProperty() {
        return courseid;
    }

    public void setCouseid(String couseid) {
        this.courseid.set(couseid);
    }

    public String getCourseName() {
        return courseName.get();
    }

    public StringProperty courseNameProperty() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    public String getTameforcourse() {
        return tameforcourse.get();
    }

    public StringProperty tameforcourseProperty() {
        return tameforcourse;
    }

    public void setTameforcourse(String tameforcourse) {
        this.tameforcourse.set(tameforcourse);
    }

    public ShowEva(String courseid, String courseName, String tameforcourse) {
        this.courseid = new SimpleStringProperty(courseid);
        this.courseName = new SimpleStringProperty(courseName);
        this.tameforcourse = new SimpleStringProperty(tameforcourse);
    }

    public ShowEva() {
        this(null,null,null);
    }
}
