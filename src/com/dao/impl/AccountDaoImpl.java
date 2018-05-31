package com.dao.impl;

import com.bean.Account;
import com.dao.AccountDao;
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
        StudentDao td=new StudentDaoImpl();
        try {
                acc.setUsername(rs.getString(1));
                acc.setPassword(rs.getString(2));
                acc.setPid(rs.getInt(3));
                acc.setStudent(td.findStudentBySno(rs.getInt(4)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
}
