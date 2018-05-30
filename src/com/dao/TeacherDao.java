package com.dao;

import com.bean.*;

import java.util.List;

public interface TeacherDao {
    public boolean updateScores(int sno,int tcid);
    public List<Scores> queryScores(int sno,int tcid);
    public List<Tcourse> queryCourse(Account account);
    public List<Evaluate> queryEvaluate(Account account);

    public Teacher findByTno(int tno);
}
