package com.dao.impl;

import com.bean.Class;
import com.bean.Course;
import com.dao.ClassDao;
import com.dao.SpecialityDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoImpl extends BaseDao<Class> implements ClassDao {
    SpecialityDao sp = new SpecialityDaoImpl();
    @Override
    public Class getEntity(ResultSet rs) {
        Class clas = null;
        try {
            clas = new Class();
            clas.setSpeciality(sp.findBySpno(rs.getInt(1)));
            clas.setClassName(rs.getString(2));
            clas.setHeader(rs.getString(3));
            clas.setClassno(rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clas;
    }

    @Override
    public Class findById(int classno) {
        List<Class> list =new ArrayList<>();
        Class clazz = new Class();
        String sql="select *from class where clano=? ";
        list=query(sql,classno);
        clazz=list.get(0);
        return clazz;
    }
}
