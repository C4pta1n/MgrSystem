package com.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QueryEva {
    private final StringProperty courseId;
    private final StringProperty courseName;
    private final StringProperty semester;
    private final StringProperty schoolYear;
    private final StringProperty evaluate;

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

    public String getEvaluate() {
        return evaluate.get();
    }

    public StringProperty evaluateProperty() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate.set(evaluate);
    }

    public QueryEva(String courseId, String courseName, String semester, String schoolYear, String evaluate) {
        this.courseId = new SimpleStringProperty(courseId);
        this.courseName = new SimpleStringProperty(courseName);
        this.semester = new SimpleStringProperty(semester);
        this.schoolYear = new SimpleStringProperty(schoolYear);
        this.evaluate = new SimpleStringProperty(evaluate);
    }

    public QueryEva() {
        this(null,null,null,null,null);
    }
}
