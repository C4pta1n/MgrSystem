package com.dao.impl;

import com.bean.*;
import com.dao.AdminDao;
import com.dao.TcourseDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl extends BaseDao<Admin> implements AdminDao {
    @Override
    public List<Account> queryuser() {
        String sql="select * from Account ";
        AccountDaoImpl adi= new AccountDaoImpl();
        List<Account> list=new ArrayList<>();
        list=adi.query(sql);
        return list;
    }

    @Override
    public List<Evaluate> queryEvaluate() {
        String sql="select * from Evaluate";
        EvaluateDaoImpl edi= new EvaluateDaoImpl();
        List <Evaluate> list = new ArrayList<>();
        list=edi.query(sql);
        return list;
    }

    @Override
    public List<Tcourse> queryTcourse() {
        List<Tcourse> account =new ArrayList<>();
        TcourseDaoImpl tdi= new TcourseDaoImpl();
        String sql="select * from account";
        account =tdi.query(sql);
        return account;
    }

    @Override
    public List<Scores> queryScores() {
        List<Scores> scores =new ArrayList<>();
        ScoresDaoImpl sdi= new ScoresDaoImpl();
        String sql="select * from Scores";
        scores =sdi.query(sql);
        return scores;
    }

    @Override
    public Admin findByAno(int Ano) {
        Admin admin =new Admin();
        List<Admin>  list = new ArrayList<>();
        String sql="select * from admin where ano= ?";
        list =query(sql,Ano);
        admin= list.get(0);
        return admin;
    }

    @Override
    public boolean addAccount(int pid,int id) {
        AccountDaoImpl adi= new AccountDaoImpl();
        String sql="";
        if(pid==3)  sql="insert into account values(?,?,3,?,null,null)";
        else if(pid==2) sql="insert into account values(?,?,2,null,?,null)";
        else if(pid==1) sql="insert into account values(?,?,1,null,null,?)";
        String user=String.valueOf(id);
        String password=String.valueOf(id);
        boolean t=false;
        t=adi.update(sql,user,password,id);
        return t;
    }

    @Override
    public boolean delAccount(String name) {
        AccountDaoImpl adi =new AccountDaoImpl();
        String sql="delete from account where username=? ";
        boolean t=false;
        t=adi.update(sql,name);
        return t;
    }

    @Override
    public boolean updateAccount(int id) {
        return false;
    }

    @Override
    public boolean addTcourse(int tno) {

        return false;
    }

    @Override
    public boolean delTcourse(int tcid) {
        TcourseDaoImpl td=new TcourseDaoImpl();
        String sql="delete from tcourse where tcid=? ";
        boolean t=false;
        t=td.update(sql,tcid);
        return t;
    }

    @Override
    public boolean updateTcourse(int tcid) {
        return false;
    }

    @Override
    public Admin getEntity(ResultSet rs) {
        Admin admin =new Admin();
        try {
            admin.setAno(rs.getInt(1));
            admin.setAname(rs.getString(2));
            admin.setAsex(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
