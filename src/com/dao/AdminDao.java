package com.dao;

import com.bean.*;

import java.util.List;

public interface AdminDao {
   public List<Account> queryuser();
   public List<Evaluate> queryEvaluate();
   public List<Tcourse> queryTcourse();
   public List<Scores>  queryScores();
   public Admin findByAno(int Ano);

   public boolean addAccount(int pid,int id);
   public boolean delAccount(String name);
   public boolean updateAccount(int id);

   public boolean addTcourse(int tno);
   public boolean delTcourse(int tcid);
   public boolean updateTcourse(int tcid);
}
