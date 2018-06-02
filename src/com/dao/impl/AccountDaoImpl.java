package com.dao.impl;

import com.bean.Account;
import com.bean.Admin;
import com.bean.Teacher;
import com.dao.AccountDao;
import com.dao.AdminDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public  class AccountDaoImpl extends BaseDao<Account> implements AccountDao {

    @Override
    public Account login(String username,String password) {
        Account account =null;
        List<Account> list=new ArrayList<>();
        String sql="select * from account where username=? and password=? ";
        list=query(sql,username,password);
        if(list.size()!=0) account=list.get(0);
        return account;
    }

    @Override
    public Account getEntity(ResultSet rs) {
        Account acc = new Account();
        StudentDao sd=new StudentDaoImpl();
        TeacherDao td=new TeacherDaoImpl();
        AdminDao ad=new AdminDaoImpl();
        try {
                acc.setUsername(rs.getString(1));
                acc.setPassword(rs.getString(2));
                acc.setPid(rs.getInt(3));
                int num=rs.getInt(3);
                if (num==3)  acc.setStudent(sd.findStudentBySno(rs.getInt(4)));
                else if(num==2) acc.setTeacher(td.findByTno(rs.getInt(5)));
                else if(num==1) acc.setAdmin(ad.findByAno(rs.getInt(6)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
}
