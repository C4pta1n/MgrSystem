package com.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShowCourse {
    private final StringProperty courseId;
    private final StringProperty coursename;
    private final StringProperty credit;
    private final StringProperty semester;
    private final StringProperty schoolYear;

    public String getCourseId() {
        return courseId.get();
    }

    public StringProperty courseIdProperty() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId.set(courseId);
    }

    public String getCoursename() {
        return coursename.get();
    }

    public StringProperty coursenameProperty() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename.set(coursename);
    }

    public String getCredit() {
        return credit.get();
    }

    public StringProperty creditProperty() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit.set(credit);
    }

    public String getSemester() {
        return semester.get();
    }

    public StringProperty semesterProperty() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester.set(semester);
    }

    public String getSchoolYear() {
        return schoolYear.get();
    }

    public StringProperty schoolYearProperty() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear.set(schoolYear);
    }

    public ShowCourse(String courseId, String coursename, String credit, String semester, String schoolYear) {
        this.courseId = new SimpleStringProperty(courseId);
        this.coursename = new SimpleStringProperty(coursename);
        this.credit = new SimpleStringProperty(credit);
        this.semester = new SimpleStringProperty(semester);
        this.schoolYear = new SimpleStringProperty(schoolYear);
    }

    public ShowCourse() {
        this(null,null,null,null,null);
    }
}
