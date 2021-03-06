package com.dao.impl;

import com.bean.Speciality;
import com.bean.Tcourse;
import com.dao.*;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TcourseDaoImpl extends BaseDao<Tcourse> implements TcourseDao {
    @Override
    public Tcourse getEntity(ResultSet rs) {
        Tcourse tc=new Tcourse();
        TeacherDao td=new TeacherDaoImpl();
        CourseDao cd=new CourseDaoImpl();
        SpecialityDao sd=new SpecialityDaoImpl();
        ClassDao cld = new ClassDaoImpl();
        try {
            tc.setTcid(rs.getInt(1));
            tc.setTeacher(td.findByTno(rs.getInt(2)));
            tc.setSpeciality(sd.findBySpno(rs.getInt(3)));
            tc.setClazz(cld.findById(rs.getInt(7)));
            tc.setCourse(cd.findByCno(rs.getString(4)));
            tc.setSemester(rs.getString(5));
            tc.setSchoolyear(rs.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tc;
    }

    @Override
    public Tcourse findByTcid(int tcid) {
        List<Tcourse> list=new ArrayList<>();
        String sql="select * from Tcourse where tcid=? ";
        list=query(sql,tcid);
        return list.get(0);
    }
}
