package com.dao;

import com.bean.Course;

public interface CourseDao {
    public Course findByCno(String cno);
}
