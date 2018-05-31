package com.dao.impl;
import com.bean.*;
import com.dao.DepartmentDao;
import com.dao.SpecialityDao;
import com.dao.StudentDao;
import com.dbc.BaseDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {
    DepartmentDao dd = new DepartmentDaoImpl();
    SpecialityDao sd = new SpecialityDaoImpl();

    @Override
    public List<Tcourse> queryCourse(Account account) {
        ScoresDaoImpl sdi = new ScoresDaoImpl();
        Tcourse tc=new Tcourse();
        TcourseDaoImpl tdi = new TcourseDaoImpl();
        String sql = "select * from scores where sno=? ";
        List<Scores> list = sdi.query(sql,account.getStudent().getSno());
        String sql1="select * from tcourse where tcid=? ";
        List<Tcourse> listtc = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int k =list.get(i).getTcid();
            tc= (Tcourse) tdi.query(sql1,k).get(0);
            listtc.add(tc);
        }
        return listtc;
    }

    @Override
    public List<Scores> findScoreByID(int sno) {
        String sql = "select * from scores where sno=?";
        List<Scores> list= query(sql,sno);
        return list;
    }

    @Override
    public boolean evaluate(int tcid,int sno,String rank) {
        String sql = "update evaluate set rank=? where tcid=? and sno=?";
        boolean t = update(sql,rank,tcid,sno);
        if (t) return true;
        else  return false;
    }

    @Override
    public Student findStudentBySno(int sno) {
        Student stu =new Student();
        List<Student> list =new ArrayList<>();
        String sql="select * from student where sno=? ";
        list=query(sql,sno);
        stu=list.get(0);
        return stu;
    }

    @Override
    public Student getEntity(ResultSet rs)  {
        Student stu=new Student();

        try {
            stu.setSno(rs.getInt(1));
            stu.setSname(rs.getString(2));
            stu.setSex(rs.getString(3));
            stu.setSbirthday(rs.getDate(4));
            stu.setDepartment(dd.findByDno(rs.getInt(5)));
            stu.setSpeciality(sd.findBySpno(rs.getInt(6)));
            stu.setClassno(rs.getString(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }
}
