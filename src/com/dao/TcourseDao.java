package com.dao;

import com.bean.Tcourse;

public interface TcourseDao {
    public Tcourse findByTcid(int tcid);
}
