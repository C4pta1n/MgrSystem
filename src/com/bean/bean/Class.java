package com.bean.bean;

public class Class {
	private Speciality speciality;
	private String classno;
	private String header;
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Class(Speciality speciality, String classno, String header) {
		this.speciality = speciality;
		this.classno = classno;
		this.header = header;
	}
	public Class() {

		// TODO Auto-generated constructor stub
	}
	
	
}
