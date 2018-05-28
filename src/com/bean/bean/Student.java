package com.bean.bean;

import java.sql.Date;

public class Student {
	private int sno;
	private String sname;
	private String sex;
	private Date sbirthday;
	private Department department;
	private int spno;
	private String classno;
	private Speciality speciality;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getSbirthday() {
		return sbirthday;
	}
	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getSpno() {
		return spno;
	}
	public void setSpno(int spno) {
		this.spno = spno;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	public Student(int sno, String sname, String sex, Date sbirthday, Department department, int spno, String classno,
			Speciality speciality) {
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.sbirthday = sbirthday;
		this.department = department;
		this.spno = spno;
		this.classno = classno;
		this.speciality = speciality;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
}
