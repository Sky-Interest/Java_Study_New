package JDBC;

import org.junit.Test;


public class DMLDemo代码优化后 {
    //插入
    @Test
    public void fun(){
        try {
            String sql = "insert into tb_user(username,password) values(?,?)";
            //执行
            JDBCUtil.update(sql,"李四2","123");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,null);
        }
    }

    //修改
    @Test
    public void fun2(){

        try {
            String username = "王五2";

            String sql = "update tb_user set username=? where id = ?";
            //执行
            int i = JDBCUtil.update(sql,username,4);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,null);
        }
    }

    //删除
    @Test
    public void fun3(){
        try {
            String sql = "delete from tb_user where id = ?";
            //执行
            int i = JDBCUtil.update(sql,5);
            System.out.println(i + "，执行的sql:" + sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,null);
        }
    }
}
