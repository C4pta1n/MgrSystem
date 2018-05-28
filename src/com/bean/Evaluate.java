package com.bean;

public class Evaluate {
    private Tcourse tcourse;
    private int sno;
    private String rank;
    public Tcourse getTcourse() {
        return tcourse;
    }
    public void setTcourse(Tcourse tcourse) {
        this.tcourse = tcourse;
    }
    public int getSno() {
        return sno;
    }
    public void setSno(int sno) {
        this.sno = sno;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    public Evaluate(Tcourse tcourse, int sno, String rank) {
        this.tcourse = tcourse;
        this.sno = sno;
        this.rank = rank;
    }
    public Evaluate() {
        // TODO Auto-generated constructor stub
    }
}
