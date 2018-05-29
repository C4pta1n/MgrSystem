package com.bean.bean;

public class Tcourse {
	private Course course;
	private Teacher teacher;
	private Speciality speciality;
	private int tcid;
	private String classno;
	private String semester;
	private String schoolyear;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	public int getTcid() {
		return tcid;
	}
	public void setTcid(int tcid) {
		this.tcid = tcid;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSchoolyear() {
		return schoolyear;
	}
	public void setSchoolyear(String schoolyear) {
		this.schoolyear = schoolyear;
	}
	public Tcourse(Course course, Teacher teacher, Speciality speciality, int tcid, String classno, String semester,
			String schoolyear) {
		this.course = course;
		this.teacher = teacher;
		this.speciality = speciality;
		this.tcid = tcid;
		this.classno = classno;
		this.semester = semester;
		this.schoolyear = schoolyear;
	}
	public Tcourse() {
		// TODO Auto-generated constructor stub
	}
	
}
