package com.dbc;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public abstract class BaseDao<T> {
       private Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        private Connection getConnection(){
            if (conn == null){
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Myschool?useSSL=true","root","root");
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
            return conn;
        }
        private void close(){
            try {
                if (rs!=null) rs.close();
                if (pst!=null) pst.close();
                if (conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //更新
        public boolean update(String sql,Object...objects){
            boolean t=false;
            conn = getConnection();
            try {
                pst = conn.prepareStatement(sql);
                for (int i = 0; i < objects.length; i++) {
                    pst.setObject(i+1,objects[i]);
                }
               int num = pst.executeUpdate();
                if(num>0) t=true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
            return t;
        }
        //查询
        public <T>List<T> query(String sql,Object...objects){
            List<T> list = new ArrayList<>();
            conn = getConnection();
            try {
                pst = conn.prepareStatement(sql);
                for (int i = 0; i < objects.length; i++) {
                    pst.setObject(i+1,objects[i]);
                }
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add((T) getEntity(rs));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }

            return list;
        }
        public abstract T getEntity(ResultSet rs);

    }

