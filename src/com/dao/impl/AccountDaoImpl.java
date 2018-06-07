package com.dao.impl;

import com.bean.Account;
import com.dao.AccountDao;
import com.dao.AdminDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {

    @Override
    public Account login(String username, String password) {
        Account account = null;
        List<Account> list = new ArrayList<>();
        String sql = "select * from account where username=? and password=? ";
        list = query(sql, username, password);
        if (list.size() != 0) account = list.get(0);
        return account;
    }

    @Override
    public boolean changePassword(Account account, String password, String password0, String password1) {
        String sql = "update account set password = ? where username = ?";
        if (password.equals(account.getPassword())) {
            if (password0.equals(password1)) {
                boolean f = update(sql, password0, account.getUsername());
                return f;
            }
        }
        return false;
    }

    @Override
    public Account findById(String username) {
        Account account = new Account();
        String sql = "select * from account where username = ?";
        List<Account> list = query(sql,username);
        if (list.size()!=0) account = list.get(0);
        return account;
    }

    @Override
    public Account getEntity(ResultSet rs) {
        Account acc = new Account();
        StudentDao td = new StudentDaoImpl();
        AdminDao amd = new AdminDaoImpl();
        TeacherDao tead = new TeacherDaoImpl();
        try {
            acc.setUsername(rs.getString(1));
            acc.setPassword(rs.getString(2));
            acc.setPid(rs.getInt(3));
            if (acc.getPid() == 3) acc.setStudent(td.findStudentBySno(rs.getInt(4)));
            else if (acc.getPid() == 2) acc.setTeacher(tead.findByTno(rs.getInt(5)));
            else if (acc.getPid() == 1) acc.setAdmin(amd.findByAno(rs.getInt(6)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }

}
