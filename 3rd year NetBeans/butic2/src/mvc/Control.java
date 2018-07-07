/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MVC;
import GUI.AddItem;
import GUI.ItemSearch;
import GUI.AddEmployee;
import GUI.UpdsatePrice;
import GUI.CustemerHome;
import GUI.ViewItem;
import GUI.SighnUp;
import GUI.DeleteItem;
//import GUI.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author student
 */
public class Control {



    public void reg() throws SQLException, Exception{
         JDBC d=new JDBC();
         String itemno=AddItem.t1.getText().trim();
         String itemtype=AddItem.t2.getText().trim();
         String itembrand=AddItem.t3.getText().trim();
         String itemsize=AddItem.t4.getText().trim();
         String itemamount=AddItem.t5.getText().trim();
         String itemprice=AddItem.t6.getText().trim();

    //List ls=new ArrayList();
    //ls.add(id);
        Statement st=(Statement) d.con.createStatement();
       String qr = "insert into Item values('" +itemno + "','" + itemtype + "','" + itembrand + "','" + itemsize + "','" + itemamount + "','" + itemprice + "')";
        st.execute(qr);
    }

    

    public void search() throws SQLException, Exception{
     ResultSet rs;
         JDBC d=new  JDBC();
        String Itemno=ItemSearch.search.getText().trim();
        Statement st2=(Statement) d.con.createStatement();
        String qr2="select ItemType,ItemBrand,ItemSize,ItemAmount,ItemPrice from Item where ItemNo='"+Itemno+"'";
       rs=st2.executeQuery(qr2);
       while(rs.next()){
       ItemSearch.itm.setText( rs.getString("ItemType"));
       ItemSearch.itm1.setText( rs.getString("ItemBrand"));
       ItemSearch.item2.setText( rs.getString("ItemSize"));
       ItemSearch.item3.setText( rs.getString("ItemAmount"));
       ItemSearch.item4.setText( rs.getString("ItemPrice"));

    }

 }
    public void regester() throws SQLException, Exception{
         JDBC d=new JDBC();
         String fname=AddEmployee.e1.getText().trim();
         String lname=AddEmployee.e2.getText().trim();
         String sex=AddEmployee.e3.getText().trim();
         String salary=AddEmployee.e4.getText().trim();
         String addres=AddEmployee.e5.getText().trim();
         String phone=AddEmployee.e6.getText().trim();
         String username=AddEmployee.e7.getText().trim();
         String password=AddEmployee.e8.getText().trim();

    //List ls=new ArrayList();
    //ls.add(id);st
        Statement fs=(Statement) d.con.createStatement();
       String qr = "insert into Employees values('" +fname + "','" + lname + "','" + sex + "','" + salary + "','" + addres + "','" + phone + "','" + username + "','" + password + "')";
        fs.execute(qr);
    }
    public void updates() throws SQLException, Exception{
         JDBC gc=new JDBC();
        // String itemType=UpdsatePrice.u1.getText().trim();
         String itemNo=UpdsatePrice.u6.getText().trim();
        // String itemAmount=UpdsatePrice.u4.getText().trim();
         String newPrice=UpdsatePrice.u5.getText().trim();
         

    //List ls=new ArrayList();
    
        Statement up=(Statement) gc.con.createStatement();
       String qqq="update Item set ItemPrice="+newPrice+" where ItemNo="+itemNo+"";
       up.execute(qqq);
    }
 public void View() throws SQLException, Exception{
     ResultSet ms;
         JDBC c=new  JDBC();
        Statement st2=(Statement) c.con.createStatement();
        String qr2="select * from Item ";
       ms=st2.executeQuery(qr2);
       while(ms.next()){
       ViewItem.txt1.setText( ms.getString("ItemType"));
       ViewItem.txt1.setText( ms.getString("ItemBrand"));
       ViewItem.txt1.setText( ms.getString("ItemSize"));
       ViewItem.txt1.setText( ms.getString("ItemAmount"));
       ViewItem.txt1.setText( ms.getString("ItemPrice"));
    }

 }

 public void Itemes() throws SQLException, Exception{
         JDBC gc=new JDBC();
        // String itemType=UpdsatePrice.u1.getText().trim();
         String itemNo=CustemerHome.a5.getText().trim();
          String itemAmount=CustemerHome.a1.getText().trim();
        // String itemAmount=UpdsatePrice.u4.getText().trim();
        // String newPrice=CustemerHome.u5.getText().trim();


    //List ls=new ArrayList();
    //ls.add(id);st
        Statement see=(Statement) gc.con.createStatement();
       String qqq="update Item set ItemAmount=(ItemAmount-"+itemAmount+" )where ItemNo="+itemNo+"";
        see.execute(qqq);
    }
public void mana() throws SQLException, Exception{
         JDBC h=new JDBC();
         String name=SighnUp.m1.getText().trim();
         String sname=SighnUp.m2.getText().trim();
         String sex=SighnUp.m5.getText().trim();
         String addres=SighnUp.m6.getText().trim();
         String username=SighnUp.m3.getText().trim();
         String password=SighnUp.m4.getText().trim();

    //List ls=new ArrayList();
    //ls.add(id);st
        Statement fs=(Statement) h.con.createStatement();
       String qr = "insert into Managers values('" +name + "','" + sname + "','" + sex + "','" + addres + "','" + username + "','" + password + "')";
        fs.execute(qr);
    }

 public void del() throws SQLException, Exception{
         JDBC mc=new JDBC();
        
         String itemtype=DeleteItem.ki.getText().trim();
       
        Statement up=(Statement) mc.con.createStatement();
      String qqq="delete from Item where ItemType='"+ itemtype+"'";
        up.execute(qqq);
    }




}
 /* public boolean loginToSys(String ut,String un,String pw) throws SQLException, Exception{
         JDBC mm=new JDBC();
         Statement ss=(Statement) mm.con.createStatement();
         String q1;
         if(ut.compareToIgnoreCase("employee")==0)
            q1="select *from employees where UserName='"
                      +un+"' and PassWords='"+pw+"'";

          ResultSet rs=ss.executeQuery((un));
          rs.next();;
          return rs.first();
         // string    u1="select *from employees where UserName='"+bu+'
           //       +"and PassWords='"+12+"'";

    }
}*/
