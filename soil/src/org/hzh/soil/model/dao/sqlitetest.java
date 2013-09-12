/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hzh.soil.model.dao;

import java.sql.*;
import org.sqlite.JDBC;

/**
 *
 * @author Administrator
 */
public class sqlitetest {

    public static void main(String[] args) {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:E:/web/work/soil/sqlite-shell/sqlite-shell-win32-x86-3080002/soil_entry.db");

            Statement stat = conn.createStatement();

//            stat.executeUpdate("create table tbl1(name varchar(20), salary int);");//创建一个表，两列


            stat.executeUpdate("insert into soil_entry values(0, 12.3, -12.55, 5.5, '2013 2/3');"); //插入数据

//            stat.executeUpdate("insert into tbl1 values('LiSi',7800);");
//            stat.executeUpdate("insert into tbl1 values('WangWu',5800);");
//            stat.executeUpdate("insert into tbl1 values('ZhaoLiu',9100);");

            ResultSet rs = stat.executeQuery("select * from soil_entry;"); //查询数据

            while (rs.next()) { //将查询到的数据打印出来

                System.out.print("id = " + rs.getString("id") + " "); //列属性一

                System.out.println("time = " + rs.getString("timestamp")); //列属性二

            }
            rs.close();
            conn.close(); //结束数据库的连接

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

