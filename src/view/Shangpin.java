package view;

import model.Goods;
import service.Goodsmanage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
public class Shangpin extends JFrame {
    JLabel j11=new JLabel("货号           ");
    JLabel j12=new JLabel("商品名         ");
    JLabel j13=new JLabel("进价              ");
    JLabel j14=new JLabel("售价                ");//表头
    JLabel j15=new JLabel("库存               ");
    JLabel j16=new JLabel("状态             ");
    JLabel j17=new JLabel("备注 ");
    JPanel jp2=new JPanel();  //表头
    JLabel j1=new JLabel("货号");
    JLabel j2=new JLabel("商品名字");
    JLabel j3=new JLabel("进价");
    JLabel j4=new JLabel("售价");
    JLabel j5=new JLabel("库存");
    JLabel j6=new JLabel("状态");
    JLabel j7=new JLabel("备注");
    JTextField f1=new JTextField(4);
    JTextField f2=new JTextField(10);
    JTextField f3=new JTextField(6);
    JTextField f4=new JTextField(6);
    JTextField f5=new JTextField(6);
    JTextField f6=new JTextField(4);
    JTextField f7=new JTextField(10);
    JButton b1=new JButton("查询");
    JButton b2=new JButton("修改");
    JButton b3=new JButton("删除");
    JButton b4=new JButton("清空");
    JButton b5=new JButton("添加");

    final JTable t1=new JTable();
    public  Shangpin() {

        this.setTitle("商品管理模块");
        this.setLayout(null);
        this.setLocation(300,100 );
        this.setSize(850,600 );
        this.setLayout(null);
        JPanel panel=new JPanel();
        JPanel panel2=new JPanel();
        panel.add(t1);
        panel.setBounds(10, 130,800, 1000);
        jp2.setBounds(0, 100, 800, 100); //表头
        this.add(panel);
        final Vector<String> title=new Vector<String>();
        title.add("货物号");
        title.add("货物名");
        title.add("进价");
        title.add("售价");
        title.add("库存");
        title.add("商品状态");
        title.add("备注");
        Vector value= Goodsmanage.query();
        final DefaultTableModel model=new DefaultTableModel(value,title);
        t1.setModel(model);
        if(t1.getRowCount()>0)
        {
            t1.setRowSelectionInterval(0, 0);
        }
        t1.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO 自动生成的方法存根
            }
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO 自动生成的方法存根
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO 自动生成的方法存根
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO 自动生成的方法存根
                int row=t1.getSelectedRow();
                String sid=t1.getValueAt(row, 0).toString();
                String sname=t1.getValueAt(row, 1).toString();
                String inprice=t1.getValueAt(row, 2).toString();
                String ouprice=t1.getValueAt(row, 3).toString();
                String save=t1.getValueAt(row, 4).toString();
                String state=t1.getValueAt(row, 5).toString();
                String note=t1.getValueAt(row, 6).toString();
                f1.setText(sid);
                f2.setText(sname);
                f3.setText(inprice);
                f4.setText(ouprice);
                f5.setText(save);
                f6.setText(state);
                f7.setText(note);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO 自动生成的方法存根
                int sid=Integer.valueOf(f1.getText().trim());
                String sname=f2.getText().trim();
                double inprice=Double.valueOf(f3.getText().trim());
                double outprice=Double.valueOf(f4.getText().trim());
                int save=Integer.valueOf(f5.getText().trim());
                String state=f6.getText().trim();
                String note=f7.getText().trim();
                Goods good=new Goods();
                good.setSid(sid);
                good.setSname(sname);
                good.setInprice(inprice);
                good.setOutprice(outprice);
                good.setSave(save);
                good.setState(state);
                good.setNote(note);
                Goodsmanage.update(good);
                Vector value=Goodsmanage.query();
                final DefaultTableModel model=new DefaultTableModel(value,title);
                t1.setModel(model);
            }
        });
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO 自动生成的方法存根
                int sid=Integer.valueOf(f1.getText().trim());
                Goods good=new Goods();
                Goodsmanage.delete(sid);
                Vector value=Goodsmanage.query();
                final DefaultTableModel model=new DefaultTableModel(value,title);
                t1.setModel(model);
            }
        });
        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO 自动生成的方法存根
                f1.setText("");
                f2.setText("");
                f3.setText("");
                f4.setText("");
                f5.setText("");
                f6.setText("");
                f7.setText("");
            }
        });
        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO 自动生成的方法存根
                int sid=Integer.valueOf(f1.getText().trim());
                String sname=f2.getText().trim();
                double inprice=Double.valueOf(f3.getText().trim());
                double outprice=Double.valueOf(f4.getText().trim());
                int save=Integer.valueOf(f5.getText().trim());
                String state=f6.getText().trim();
                String note=f7.getText().trim();
                Goods good=new Goods();
                good.setSid(sid);
                good.setSname(sname);
                good.setInprice(inprice);
                good.setOutprice(outprice);
                good.setSave(save);
                good.setState(state);
                good.setNote(note);
                Goodsmanage.insert(good);
                Vector value=Goodsmanage.query();
                final DefaultTableModel model=new DefaultTableModel(value,title);
                t1.setModel(model);

            }
        });
        jp2.add(j11);   //第一个表头
        jp2.add(j12);
        jp2.add(j13);
        jp2.add(j14);
        jp2.add(j15);
        jp2.add(j16);
        jp2.add(j17);
        this.add(jp2);
        panel2.setBounds(0,20,840,100);
        panel2.add(j1);
        panel2.add(f1);
        panel2.add(j2);
        panel2.add(f2);
        panel2.add(j3);
        panel2.add(f3);
        panel2.add(j4);
        panel2.add(f4);
        panel2.add(j5);
        panel2.add(f5);
        panel2.add(j6);
        panel2.add(f6);
        panel2.add(j7);
        panel2.add(f7);
        panel2.add(b2);
        panel2.add(b3);
        panel2.add(b4);
        panel2.add(b5);
        this.setResizable(false); //设置不可以变大
        this.add(panel2);
        this.setVisible(true);
    }
}
