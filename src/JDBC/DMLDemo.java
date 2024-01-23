package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLDemo {
    //插入
    @Test
    public void fun(){
        //贾链欲执事
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement stat = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///g2405", "root", "root");
            stat = conn.createStatement();

            String sql = "insert into tb_user(username,password) values('李四','123')";
            //执行
            int i = stat.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    //修改
    @Test
    public void fun2(){
        //贾链欲执事
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement stat = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///g2405", "root", "root");
            stat = conn.createStatement();

            //String sql = "update tb_user set username='王五' where id = 3";
            String username = "王五";

            String sql = "update tb_user set username='"+username +"' where id = 4";
            //执行
            int i = stat.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    //修改
    @Test
    public void fun3(){
        //贾链欲执事
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement stat = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///g2405", "root", "root");
            stat = conn.createStatement();

            String sql = "delete from tb_user where id = 3";
            //执行
            int i = stat.executeUpdate(sql);
            System.out.println(i + "，执行的sql:" + sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
