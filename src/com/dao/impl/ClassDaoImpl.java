package com.dao.impl;

import com.bean.Class;
import com.dao.ClassDao;
import com.dao.SpecialityDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassDaoImpl extends BaseDao<Class> implements ClassDao {
    SpecialityDao sp = new SpecialityDaoImpl();
    @Override
    public Class getEntity(ResultSet rs) throws SQLException {
        Class clas = new Class();
        clas.setSpeciality(sp.findBySpno(rs.getInt(1)));
        clas.setClassno(rs.getString(2));
        clas.setHeader(rs.getString(3));
        return clas;
    }
}
