package com.dao.impl;
import com.bean.Student;
import com.bean.bean.Account;
import com.bean.bean.Course;
import com.bean.bean.Scores;
import com.dao.DepartmentDao;
import com.dao.SpecialityDao;
import com.dao.StudentDao;
import com.dbc.BaseDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {
    DepartmentDao dd = new DepartmentDaoImpl();
    SpecialityDao sd = new SpecialityDaoImpl();
    Scanner in = new Scanner(System.in);
    Account account =new Account();
    @Override
    public Account load(String username,String password) {
        List<Account> list=new ArrayList<>();
        String sql="select * from account where username=? and password=? ";
        list=query(sql,username,password);
        if(list.size()!=0) {
            System.out.println("登录成功！");
        }else System.out.println("用户名或密码错误，登陆失败！");
        return account;
    }

    @Override
    public List<Course> findCourseBySpno(Account account) {
        ScoresDaoImpl sdi = new ScoresDaoImpl();
        CourseDaoImpl cdi = new CourseDaoImpl();
        String sql = "select * from scores where sno=?";
        List<Scores> list = sdi.query(sql,account.getStudent().getSno());
        String sql1 = "select * from tcourse where tcid=?";
        List<Course> list1 = cdi.query(sql1,list);
        String sql2 = "select * from course where spno=?";
        List<Course> list2 = cdi.query(sql2,list1.get(0));
        return list2;
    }

    @Override
    public List<Scores> findScoreByID(int sno) {
        String sql = "select * from scores where sno=?";
        List<Scores> list= query(sql,sno);
        return list;
    }

    @Override
    public boolean evaluate(int tcid,int sno) {
        System.out.println("请输入评价等级");
        String rank = in.next();
        String sql = "update evaluate set rank=? where tcid=? and sno=?";
        boolean t = update(sql,rank,tcid,sno);
        if (t) return true;
        else  return false;
    }

    @Override
    public Student getEntity(ResultSet rs) throws SQLException {
        Student stu=new Student();
        while(rs.next()){
            stu.setSno(rs.getInt(1));
            stu.setSname(rs.getString(2));
            stu.setSex(rs.getString(3));
            stu.setSbirthday(rs.getDate(4));
            stu.setDepartment(dd.findByDno(rs.getInt(5)));
            stu.setSpeciality(sd.findBySpno(rs.getInt(6)));
            stu.setClassno(rs.getString(7));
        }
        return stu;
    }
}
