package test.com.dao.impl; 

import com.bean.Account;
import com.bean.Tcourse;
import com.dao.AccountDao;
import com.dao.TeacherDao;
import com.dao.impl.AccountDaoImpl;
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
    account = ad.login("211001100","123456");
    if (account!=null) {
        System.out.println("登陆成功");
        TeacherDao td=new TeacherDaoImpl();
        List<Tcourse> list=new ArrayList<>();
        list=td.queryCourse(account);
        Tcourse tcourse= new Tcourse();
        for(int i=0;i<list.size();i++){
            tcourse=list.get(i);
            System.out.println(tcourse.getCourse().getCname()+tcourse.getSchoolyear()+tcourse.getSemester());
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
