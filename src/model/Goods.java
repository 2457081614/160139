package model;



public class Goods {
    private int sid=0;  //商品编号
    private String sname=null;  //商品名字
    private double inprice=0;    //商品进价
    private double outprice=0;    //商品卖价
    private int save=0;			//商品库存
    private String note="";   //商品备注
    private String state="";   //商品状态 上架不上架
    public int  getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public double getInprice() {
        return inprice;
    }
    public void setInprice(double inprice) {
        this.inprice = inprice;
    }
    public double getOutprice() {
        return outprice;
    }
    public void setOutprice(double outprice) {
        this.outprice = outprice;
    }
    public int getSave() {
        return save;
    }
    public void setSave(int save) {
        this.save = save;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

}
