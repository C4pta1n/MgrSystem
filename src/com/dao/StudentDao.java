package com.dao;

import com.bean.Account;
import com.bean.Course;
import com.bean.Evaluate;
import com.bean.Scores;

public interface StudentDao {
    public Account load(String username,String password);
    public CourseDao findCourseBySpno(int spno);
    public Scores findScoreByID(int sno);
    public boolean evaluate(int tcid,int sno);
}
