package com.dao.impl;

import com.bean.Course;
import com.dao.CourseDao;
import com.dao.SpecialityDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl extends BaseDao<Course> implements CourseDao {
    @Override
    public Course getEntity(ResultSet rs) {
        Course course=new Course();
        SpecialityDao sd=new SpecialityDaoImpl();
        try {
            course.setCno(rs.getString(1));
            course.setCname(rs.getString(2));
            course.setSpeciality(sd.findBySpno(rs.getInt(3)));
            course.setCtno(rs.getInt(4));
            course.setLecture(rs.getInt(5));
            course.setExperiment(rs.getInt(6));
            course.setSemester(rs.getInt(7));
            course.setCredit(rs.getString(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public Course findByCno(String cno) {
        Course course=new Course();
        List<Course> list =new ArrayList<>();
        String sql="select *from course where cno=? ";
        list=query(sql,cno);
        course=list.get(0);
        return course;
    }
}
