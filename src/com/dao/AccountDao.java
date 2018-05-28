package com.dao;

import com.bean.Account;

public interface AccountDao {
    public Account login(String username,String password);
}
