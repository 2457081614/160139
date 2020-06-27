package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DAO {
    private static DAO dao=new DAO();
    public  DAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "数据库加载失败"+e.getMessage());
        }
    }
    public static Connection getConn()
    {
        try {
            Connection conn=null;
            String url="jdbc:mysql://localhost:3306/shop?&characterEncoding=utf-8";   //127.0.0.1:3306
            conn=DriverManager.getConnection(url,"root","root");
            return conn;
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "数据库连接失败"+e.getMessage());
            return null;
        }
    }
}
