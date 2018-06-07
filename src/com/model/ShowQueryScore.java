package com.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShowQueryScore {
    private final StringProperty courseId;
    private final StringProperty courseName;
    private final StringProperty stuId;
    private final StringProperty stuName;
    private final StringProperty courseCredit;
    private final StringProperty courseScore;

    public String getCourseId() {
        return courseId.get();
    }

    public StringProperty courseIdProperty() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId.set(courseId);
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

    public String getCourseCredit() {
        return courseCredit.get();
    }

    public StringProperty courseCreditProperty() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit.set(courseCredit);
    }

    public String getCourseScore() {
        return courseScore.get();
    }

    public StringProperty courseScoreProperty() {
        return courseScore;
    }

    public void setCourseScore(String courseScore) {
        this.courseScore.set(courseScore);
    }

    public ShowQueryScore(String courseId, String courseName, String stuId, String stuName, String courseCredit, String courseScore) {
        this.courseId = new SimpleStringProperty(courseId);
        this.courseName = new SimpleStringProperty(courseName);
        this.stuId = new SimpleStringProperty(stuId);
        this.stuName = new SimpleStringProperty(stuName);
        this.courseCredit = new SimpleStringProperty(courseCredit);
        this.courseScore = new SimpleStringProperty(courseScore);
    }

    public ShowQueryScore() {
        this(null,null,null,null,null,null);
    }
}
