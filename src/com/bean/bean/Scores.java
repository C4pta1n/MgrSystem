package com.bean.bean;

public class Scores {
	private Student student;
	private int tcid;
	private int score;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public int getTcid() {
		return tcid;
	}
	public void setTcid(int tcid) {
		this.tcid = tcid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Scores(Student student, int tcid, int score) {
		this.student = student;
		this.tcid = tcid;
		this.score = score;
	}
	public Scores() {
		// TODO Auto-generated constructor stub
	}
	
}
