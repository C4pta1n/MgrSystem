package com.dao;

import com.bean.Student;
import com.bean.bean.Account;
import com.bean.bean.Course;
import com.bean.bean.Evaluate;
import com.bean.bean.Scores;

import java.util.List;

public interface StudentDao {
    public Account load(String username,String password);
    public List<Course> findCourseBySpno(Account account);
    public List<Scores> findScoreByID(int sno);
    public boolean evaluate(int tcid,int sno);
}
