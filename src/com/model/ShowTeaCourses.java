package com.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShowTeaCourses {
    private final StringProperty tcid;
    private final StringProperty clazz;
    private final StringProperty courseId;
    private final StringProperty courseName;
    private final StringProperty semester;
    private final StringProperty schoolYear;

    public String getTcid() {
        return tcid.get();
    }

    public StringProperty tcidProperty() {
        return tcid;
    }

    public void setTcid(String tcid) {
        this.tcid.set(tcid);
    }

    public String getClazz() {
        return clazz.get();
    }

    public StringProperty clazzProperty() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz.set(clazz);
    }

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

    public ShowTeaCourses(String tcid, String clazz, String courseId, String courseName, String semester, String schoolYear) {
        this.tcid = new SimpleStringProperty(tcid);
        this.clazz = new SimpleStringProperty(clazz);
        this.courseId = new SimpleStringProperty(courseId);
        this.courseName = new SimpleStringProperty(courseName);
        this.semester = new SimpleStringProperty(semester);
        this.schoolYear = new SimpleStringProperty(schoolYear);
    }

    public ShowTeaCourses() {
        this(null,null,null,null,null,null);
    }
}
