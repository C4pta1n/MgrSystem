package com.dao.impl;

import com.bean.Evaluate;
import com.dao.EvaluateDao;
import com.dao.TcourseDao;
import com.dbc.BaseDao;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EvaluateDaoImpl extends BaseDao<Evaluate> implements EvaluateDao {
    TcourseDao td = new TcourseDaoImpl();
    @Override
    public Evaluate getEntity(ResultSet rs) throws SQLException {
        Evaluate evaluate = new Evaluate();
        evaluate.setTcourse(td.findByTcid(rs.getInt(1)));
        evaluate.setSno(rs.getInt(2));
        evaluate.setRank(rs.getString(3));
        return null;
    }
}
