package com.dao.impl;

import com.bean.*;
import com.dao.AccountDao;
import com.dao.AdminDao;
import com.dbc.BaseDao;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Evaluate> queryEvaluate(int tno) {
        String sql = "select * from tcourse where tno = ?";
        TcourseDaoImpl td = new TcourseDaoImpl();
        Tcourse tcourse = (Tcourse) td.query(sql,tno).get(0);
        sql = "select * from evaluate where tcid = ?";
        EvaluateDaoImpl edi= new EvaluateDaoImpl();
        List <Evaluate> list = new ArrayList<>();
        list=edi.query(sql,tcourse.getTcid());
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
        StudentDaoImpl sd = new StudentDaoImpl();
        TeacherDaoImpl td = new TeacherDaoImpl();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        String datestr = "2000-01-01";
        Date date = null;
        try {
             date = sdf.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String sql="";
        String sql0 = "";
        if(pid==3)  {
            sql0 = "insert into student values(?,null,null,?,1001,101,null)";
            boolean f = sd.update(sql0,id,date);
            if (f) sql="insert into account values(?,?,3,?,null,null)";
        }
        else if(pid==2) {
            sql0 = "insert into teacher values(?,null,null,?1001,null)";
            boolean f = td.update(sql0,id,date);
            if (f) sql="insert into account values(?,?,2,null,?,null)";
        } else if(pid==1) {
            sql0 = "insert into admin values (?,null,null)";
            boolean f = update(sql0,id);
            sql="insert into account values(?,?,1,null,null,?)";
        }
        String user=String.valueOf(id);
        String password="123456";
        boolean t=false;
        t=adi.update(sql,user,password,id);
        return t;
    }

    @Override
    public boolean delAccount(String name) {
        AccountDaoImpl adi =new AccountDaoImpl();
        TeacherDaoImpl td = new TeacherDaoImpl();
        Account account = adi.findById(name);
        String sql0 = "";
        String sql="delete from account where username=? ";
        boolean t=false;
        t=adi.update(sql,name);
        if (account.getPid() == 1) {
            sql0 = "delete from admin where ano = ?";
            boolean f = update(sql0,Integer.parseInt(name));
        }
        if (account.getPid() == 2) {
            sql0 = "delete from teacher where tno = ?";
            boolean f = td.update(sql0,Integer.parseInt(name));
        }
        if (account.getPid() == 3) {
            sql0 = "delete from student where sno = ?";
            boolean f = update(sql0,Integer.parseInt(name));
        }
        return t;
    }

    @Override
    public boolean updateAccount(String id,Object...objects) {
        AccountDao acd = new AccountDaoImpl();
        Account account = acd.findById(id);
        String sql = "";
        boolean f = false;
        if (account.getPid() == 1){
            sql = "update admin set aname= ?,asex = ? where ano = ?";
            f = update(sql,objects[0],objects[1],id);
        }else if (account.getPid() == 2) {
            sql = "update teacher set tname = ?,tsex = ?, tbirthday = ?,dno = ?,techtitle = ? where tno = ?";
            f = update(sql,objects[0],objects[1],objects[2],objects[3],objects[4],id);
        }else if (account.getPid() == 3) {
            sql = "update student set sname = ?,sex = ?,sbirthday = ?,dno = ?,spno = ? ,classno = ? where sno = ?";
            f = update(sql,objects[0],objects[1],objects[2],objects[3],objects[4],objects[5],id);
        }
        return f;
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