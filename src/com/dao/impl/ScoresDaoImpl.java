package com.dao.impl;

import com.bean.Scores;
import com.dao.ScoresDao;
import com.dao.StudentDao;
import com.dao.TcourseDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoresDaoImpl extends BaseDao<Scores> implements ScoresDao {
    @Override
    public Scores getEntity(ResultSet rs) {
        StudentDao sd=new StudentDaoImpl();
        TcourseDao td=new TcourseDaoImpl();
        Scores scores=new Scores();
        try {
            scores.setStudent(sd.findStudentBySno(rs.getInt(1)));
            scores.setTcid(rs.getInt(2));
            scores.setScore(rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }
}
