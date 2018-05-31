package test.com.dao.impl; 

import com.bean.Account;
import com.bean.Evaluate;
import com.bean.Scores;
import com.bean.Tcourse;
import com.dao.AccountDao;
import com.dao.TeacherDao;
import com.dao.impl.AccountDaoImpl;
import com.dao.impl.StudentDaoImpl;
import com.dao.impl.TeacherDaoImpl;
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
    account = ad.login("311001101","123456");
    if (account!=null) {
        System.out.println("登陆成功");
        StudentDaoImpl sdi=new StudentDaoImpl();
        List<Tcourse> list=new ArrayList<>();
        list=sdi.queryCourse(account);
        Tcourse tc=new Tcourse();
        Scores s=new Scores();
        for(int i=0;i<list.size();i++){
           tc=list.get(i);
            System.out.println(tc.getCourse().getCname()+tc.getSchoolyear()+tc.getSemester());
        }
    }
    else System.out.println("登陆失败");
} 

/** 
* 
* Method: getEntity(ResultSet rs) 
* 
*/ 
@Test
public void testGetEntity() throws Exception { 
//TODO: Test goes here... 
} 


} 
