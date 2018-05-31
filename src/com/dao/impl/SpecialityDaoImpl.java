package com.dao.impl;

import com.bean.Speciality;
import com.dao.DepartmentDao;
import com.dao.SpecialityDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SpecialityDaoImpl extends BaseDao<Speciality> implements SpecialityDao {
    DepartmentDao dd = new DepartmentDaoImpl();
    @Override
    public Speciality findBySpno(int spno) {
        String sql = "select * from speciality where spno=?";
        List<Speciality> list = query(sql,spno);
        return  list.get(0);
    }

    @Override
    public Speciality getEntity(ResultSet rs)  {
        Speciality sp = null;
        try {
            sp = new Speciality();
            sp.setSpno(rs.getInt(1));
            sp.setDepartment(dd.findByDno(rs.getInt(2)));
            sp.setSpname(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sp;
    }
}
