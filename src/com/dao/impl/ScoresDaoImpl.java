package com.dao.impl;

import com.bean.Scores;
import com.dao.ScoresDao;
import com.dbc.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoresDaoImpl extends BaseDao<Scores> implements ScoresDao {
    @Override
    public Scores getEntity(ResultSet rs) throws SQLException {
        return null;
    }
}
