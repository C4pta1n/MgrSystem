package com.dao.impl;

import com.bean.Evaluate;
import com.dao.EvaluateDao;
import com.dao.TcourseDao;
import com.dbc.BaseDao;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EvaluateDaoImpl extends BaseDao<Evaluate> implements EvaluateDao {

    @Override
    public Evaluate getEntity(ResultSet rs)  {
        TcourseDao td = new TcourseDaoImpl();
        Evaluate evaluate = new Evaluate();
        try {

            evaluate.setTcourse(td.findByTcid(rs.getInt(1)));
            evaluate.setSno(rs.getInt(2));
            evaluate.setRank(rs.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evaluate;
    }
}
