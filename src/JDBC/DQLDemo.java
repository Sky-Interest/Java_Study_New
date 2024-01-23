package JDBC;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DQLDemo {
    @Test
    public void fun(){
        //贾链欲执事
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet re = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///g2405", "root", "root");
            stat = conn.createStatement();

            String sql = "SELECT * FROM tb_user WHERE id = 1";
            //执行
            re = stat.executeQuery(sql);

            while (re.next()){
                //获得id/username/password
                int id = re.getInt("id");
                String username = re.getString("username");
                String password = re.getString("password");

                /*
                System.out.println(id);
                System.out.println(username);
                System.out.println(password);
                 */

                //把数据封装到对象
                User user = new User(id,username,password);
                System.out.println("user:" + user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if(re != null){
                try {
                    re.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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

    @Test
    public void fun2(){
        List<User> users = new ArrayList<>();
        //贾链欲执事
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet re = null;
        try {
            //conn = DriverManager.getConnection("jdbc:mysql:///g2405", "root", "root");
            conn = JDBCUtil.getConnection();
            stat = conn.createStatement();

            String sql = "SELECT * FROM tb_user";
            //执行
            re = stat.executeQuery(sql);

            while (re.next()){
                //获得id/username/password
                int id = re.getInt("id");
                String username = re.getString("username");
                String password = re.getString("password");

               /*
                System.out.println(id);
                System.out.println(username);
                System.out.println(password);
                */
                System.out.println("------------------");
                User user = new User(id,username,password);
                users.add(user);
            }

            users.forEach(user -> System.out.println(user));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if(re != null){
                try {
                    re.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
