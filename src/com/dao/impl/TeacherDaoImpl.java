package com.dao.impl;

import com.bean.*;
import com.dao.DepartmentDao;
import com.dao.ScoresDao;
import com.dao.TeacherDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl extends BaseDao<Teacher> implements TeacherDao {
    @Override
    public boolean updateScores(int sno,int cno,int score) {
        String sql="select * from tcourse where cno=? ";
        List<Tcourse> list= new ArrayList<>();
        TcourseDaoImpl tdi=new TcourseDaoImpl();
        list=tdi.query(sql,cno);
        sql="update scores set score=? where sno=? and tcid=? ";
        ScoresDaoImpl sdi=new ScoresDaoImpl();
        boolean t=sdi.update(sql,score,sno,list.get(0).getTcid());
        return t;
    }

    @Override
    public List<Scores> queryScores(Account account) {
        List<Scores> list=new ArrayList<>();
        ScoresDaoImpl sd=new ScoresDaoImpl();
        String sql="select scores.sno,scores.tcid,scores.score  from scores,tcourse where scores.tcid=tcourse.tcid and tcourse.tno=? ";
        list=sd.query(sql,account.getTeacher().getTno());
        return list;
    }

    @Override
    public List<Tcourse> queryCourse(Account account) {
        TcourseDaoImpl td=new TcourseDaoImpl();
        String sql="select * from tcourse where tno=? ";
        List<Tcourse> listtc=new ArrayList<>();
        listtc=td.query(sql,account.getTeacher().getTno());
        return listtc;
    }

    @Override
    public List<Evaluate> queryEvaluate(Account account) {
        List<Evaluate> listeva=new ArrayList<>();
        EvaluateDaoImpl ed=new EvaluateDaoImpl();
        String sql="select evaluate.tcid,evaluate.sno,evaluate.rank from evaluate,tcourse where evaluate.tcid=tcourse.tcid and tcourse.tno=? ";
        listeva=ed.query(sql,account.getTeacher().getTno());
        return listeva;
    }

    @Override
    public Teacher findByTno(int tno) {
        List<Teacher> list=new ArrayList<>();
        Teacher tea=new Teacher();
        String sql="select * from Teacher where tno=? ";
        list=query(sql,tno);
        tea=list.get(0);
        return tea;
    }

    @Override
    public Teacher getEntity(ResultSet rs) {
         Teacher tea=new Teacher();
         DepartmentDao Dd=new DepartmentDaoImpl();
        try {
            tea.setTno(rs.getInt(1));
            tea.setTname(rs.getString(2));
            tea.setTsex(rs.getString(3));
            tea.setTbirthday(rs.getDate(4));
            tea.setDepartment(Dd.findByDno(rs.getInt(5)));
            tea.setTechtitle(rs.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tea;
    }
}
