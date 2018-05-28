package com.bean;

public class Account {
    private Admin admin;
    private Student student;
    private Teacher teacher;
    private String username;
    private String password;
    private int pid;
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public Account(Admin admin, Student student, Teacher teacher, String username, String password, int pid) {
        this.admin = admin;
        this.student = student;
        this.teacher = teacher;
        this.username = username;
        this.password = password;
        this.pid = pid;
    }
    public Account() {
        // TODO Auto-generated constructor stub
    }

}
