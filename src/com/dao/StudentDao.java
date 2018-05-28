package com.dao;

import com.bean.bean.Account;
import com.bean.bean.Course;
import com.bean.bean.Evaluate;
import com.bean.bean.Scores;

import java.util.List;

public interface StudentDao {
    public Account load();
    public List<Course> findCourse();
    public List<Scores> findScoreByID(int sno);
    public Evaluate evaluate();
}
