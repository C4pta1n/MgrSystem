package test.com.dao.impl; 

import com.bean.Account;
import com.dao.AccountDao;
import com.dao.impl.AccountDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 


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
    account = ad.login("1001","123456");
    if (account!=null) System.out.println("登陆成功");
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
