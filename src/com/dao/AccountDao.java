package com.dao;

import com.bean.Account;

public interface AccountDao {
    public Account login(String username,String password);
    public boolean changePassword(Account account,String password,String password0,String password1);
}
