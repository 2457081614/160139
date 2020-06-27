package service;

import dao.DAO;
import model.Goods;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
public class Goodsmanage {
    public static void insert(Goods g)
    {
        try {
            Connection conn= DAO.getConn();  //数据库连接
            PreparedStatement ps=conn.prepareStatement("insert into goods(sid,sname,inprice,outprice,save,state,note)values(?,?,?,?,?,?,?)");
            ps.setInt(1, g.getSid());
            ps.setString(2, g.getSname());
            ps.setDouble(3, g.getInprice());
            ps.setDouble(4, g.getOutprice());
            ps.setInt(5, g.getSave());
            ps.setString(6, g.getState());
            ps.setString(7, g.getNote());
            int f=ps.executeUpdate();
            if(f>0)
            {
                JOptionPane.showMessageDialog(null, "成功插入数据");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "没有成功插入数据");
            }
            ps.close();
            conn.close();

        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "注意需要不能重复");
        }
    }
    public static void update(Goods g)
    {
        try {
            Connection con=DAO.getConn();
            PreparedStatement ps=con.prepareStatement("update goods set sid=?,sname=?,inprice=?,outprice=?,save=?,state=?,note=? where sid=?");
            ps.setInt(1, g.getSid());
            ps.setString(2, g.getSname());
            ps.setDouble(3, g.getInprice());
            ps.setDouble(4, g.getOutprice());
            ps.setInt(5, g.getSave());
            ps.setString(6, g.getState());
            ps.setString(7, g.getNote());
            ps.setInt(8, g.getSid());
            int f=ps.executeUpdate();
            System.out.println(f);
            if(f>0)
            {
                JOptionPane.showMessageDialog(null, "成功更新数据");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "没有完美的更新数据");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "没有成功更新数据");
        }
    }
    public static void update(int sale,int sid)
    {
        try {
            Connection con=DAO.getConn();
            PreparedStatement ps=con.prepareStatement("update goods set save=save-? where sid=?");
            ps.setInt(1, sale);
            ps.setInt(2, sid);
            int f=ps.executeUpdate();
            System.out.println(f);
            if(f>0)
            {
                JOptionPane.showMessageDialog(null, "成功更新数据");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "没有完美的更新数据");
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "没有成功更新数据");
        }
    }
    public static void delete(int sid)
    {
        try {
            Connection conn=DAO.getConn();
            PreparedStatement ps=conn.prepareStatement("delete from goods where sid=?");
            ps.setInt(1,sid);
            int f=ps.executeUpdate();
            if(f>0)
            {
                JOptionPane.showMessageDialog(null, "成功删除数据");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "没有删除数据");
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "连接失败");
        }
    }
    public static Vector query()
    {
        try {
            Vector vector=new Vector();
            Connection conn=DAO.getConn();
            PreparedStatement ps=conn.prepareStatement("select * from goods ");
            ResultSet rs=ps.executeQuery();
            while(rs.next()&&rs.getRow()>0)
            {
                Vector row=new Vector();
                for(int col=1;col<=rs.getMetaData().getColumnCount();col++)
                {
                    if(col==3||col==4)
                    {
                        row.add(String.valueOf(rs.getDouble(col)));
                    }
                    else if(col==5||col==1)
                    {
                        row.add(String.valueOf(rs.getInt(col)));
                    }
                    else
                    {
                        row.add(String.valueOf(rs.getString(col)));
                    }
                }
                vector.add(row);
            }
            return vector;
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "查询失败");
            e.printStackTrace();
            return null;
        }
    }
}
