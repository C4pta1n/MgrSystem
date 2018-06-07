package com.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShowTeaMessage {
    private final StringProperty teaId;
    private final StringProperty teaName;
    private String sex;
    private String birthday;
    private String department;
    private String techtile;

    public String getTechtile() {
        return techtile;
    }

    public void setTechtile(String techtile) {
        this.techtile = techtile;
    }

    public String getTeaId() {
        return teaId.get();
    }

    public StringProperty teaIdProperty() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId.set(teaId);
    }

    public String getTeaName() {
        return teaName.get();
    }

    public StringProperty teaNameProperty() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName.set(teaName);
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


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ShowTeaMessage(String teaId, String teaName) {
        this.teaId = new SimpleStringProperty(teaId);
        this.teaName = new SimpleStringProperty(teaName);
    }

    public ShowTeaMessage() {
        this(null,null);
    }
}
