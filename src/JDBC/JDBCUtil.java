package JDBC;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    public static String url;
    public static String username;
    public static String password;
    public static Connection conn = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;

    public static void main(String[] args) {

    }

    //静态代码块
    static{
        Properties p = new Properties();
        try(InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties")){
            //加载配置文件的内容
            p.load(is);

            //加载驱动
            Class.forName(p.getProperty("driverClass"));
            //从读取的文件里面获取的值赋值给
            url = p.getProperty("url");
            username=p.getProperty("username");
            password=p.getProperty("password");

            System.out.println("url:" + url+",username:"+username+",password:"+ password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获得链接的方法
    public static Connection getConnection(){
        try {
            if(conn == null || conn.isClosed()){
                conn = DriverManager.getConnection(url,username,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    //统一的增删改的方法
    public static int update(String sql,Object...args){
        int rows = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try{
            con = getConnection();
            pst = con.prepareStatement(sql);
            //判断
            if(args != null && args.length>0){
                //给问号赋值
                for(int i =0;i<args.length;i++){
                    pst.setObject(i+1,args[i]);
                }
            }

            rows = pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭
            closeConn(con,pst,null);
        }
        return rows;
    }

    //统一关闭的方法
    public static void closeConn(Connection conn,Statement pst,ResultSet rs){
        //关闭的顺序是 从小到大
        try{
            if(rs != null){
                rs.close();
            }

            if(pst != null){
                pst.close();
            }

            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
