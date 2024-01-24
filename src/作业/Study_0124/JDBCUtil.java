package 作业.Study_0124;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

    public static String url = "jdbc:mysql://localhost:3306/gb1840";
    public static String username = "root";
    public static String password = "12345";
    public static String dirverClassName = "com.mysql.jdbc.Driver";
    public static BasicDataSource ds = null;
    static
    {
        ds = new BasicDataSource();
        ds.setDriverClassName(dirverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        //ds.setMaxActive(maxActive);

    }
    public static Connection getConnection() {

        try {

            return ds.getConnection(); //从数据库连接池中得到一个可用的连接对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static void close(Statement st, Connection con, ResultSet rs)
    {

        if(st!=null)
        {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(con!=null)
        {
            try {
                con.close(); //归还连接对象到池子中
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
