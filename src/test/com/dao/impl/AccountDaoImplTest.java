package test.com.dao.impl; 

import com.bean.Account;
import com.bean.Evaluate;
import com.bean.Scores;
import com.bean.Tcourse;
import com.dao.AccountDao;
import com.dao.AdminDao;
import com.dao.StudentDao;
import com.dao.TcourseDao;
import com.dao.impl.AccountDaoImpl;
import com.dao.impl.AdminDaoImpl;
import com.dao.impl.StudentDaoImpl;
import com.dao.impl.TcourseDaoImpl;
import com.model.ShowScore;
import com.view.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;


public class AccountDaoImplTest { 


public void after() throws Exception { 
} 

/** 
* 
* Method: login(String username, String password) 
* 
*/ 
@Test
public void testLogin() throws Exception {
    AccountDao ad = new AccountDaoImpl();
    Account account = null;
    StudentDao sd = new StudentDaoImpl();
    TcourseDao tcd = new TcourseDaoImpl();
    account = ad.login("311001101","123");
    if (account!=null) System.out.println("登陆成功");
    else System.out.println("登陆失败");
    ObservableList<ShowScore> tcourses = FXCollections.observableArrayList();
    List<Scores> scores = new ArrayList<>();
    scores = sd.findScoreByID(account.getStudent().getSno());
    for (Scores s : scores){
        ShowScore showScore = new ShowScore();
        showScore.setId(tcd.findByTcid(s.getTcid()).getCourse().getCno());
        showScore.setName(tcd.findByTcid(s.getTcid()).getCourse().getCname());
        showScore.setScore(String.valueOf(s.getScore()));
        tcourses.add(showScore);
    }
    System.out.println(tcourses.get(0).getId());
    /*tcourse = sd.queryCourse(account);
    for (Tcourse t:tcourse){
        tcourses.add(t);
    }
    System.out.println(tcourses.get(0).getCourse().getCname());*/
} 

/** 
* 
* Method: getEntity(ResultSet rs) 
* 
*/ 
@Test
public void testGetEntity() throws Exception {
    AdminDao ad = new AdminDaoImpl();
    boolean flag = ad.updateAccount("10001","贾志远","男");
    System.out.println(flag);
} 


} 
