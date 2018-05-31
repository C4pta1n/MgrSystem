package com.dao;

import com.bean.*;

import java.util.List;

public interface StudentDao {
    public List<Tcourse> queryCourse(Account account);
    public List<Scores> findScoreByID(int sno);
    public boolean evaluate(int tcid,int sno,String rank);
    public Student findStudentBySno(int sno);
}
