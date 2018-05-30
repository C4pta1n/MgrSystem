package com.dao.impl;

import com.bean.Department;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoImpl extends BaseDao<Department> implements DepartmentDao{
    @Override
    public Department findByDno(int dno) {
        String sql ="select * from department where dno=?";
        List<Department> list = query(sql, dno);
        return list.get(0);
    }

    @Override
    public Department getEntity(ResultSet rs) {
        Department de = null;
        try {
            de = new Department();
            de.setDno(rs.getInt(1));
            de.setDeptname(rs.getString(2));
            de.setHeadler(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return de;
    }
}
