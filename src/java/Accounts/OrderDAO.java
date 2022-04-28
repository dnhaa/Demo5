/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import mylib.Utils;

/**
 *
 * @author acer
 */
public class OrderDAO {
    //hàm này để insert a new order 
    //insert order xong, thì đến chèn luôn orderdetail 
    //input: orderdate, accid, cart obj
    //out: 1/0
    public static int checkOut(String orderdate, int accid, HashMap<String, Integer> cart)
    throws Exception{
        int result=0;
        Connection cn = Utils.makeConnection();
        if (cn != null){
        cn.setAutoCommit(false); 
        String sql = "insert Orders(OrdDate, shipdate, status, AccID) values (?, NULL,1,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, orderdate);
            pst.setInt(2, accid);
            result = pst.executeUpdate();
            if (result>0){
                //chèn orderdetail 
                sql = "select top 1 OrderID from Orders order by OrderID desc";
                pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()){
                    int orderid = rs.getInt("orderid");
                    for(String id : cart.keySet()){
                        int quantity = cart.get(id);
                        sql="insert OrderDetails (OrderID, FID, quantity) values(?,?,?)";
                        pst = cn.prepareStatement(sql);
                        pst.setInt(1, orderid);
                        pst.setInt(2, new Integer(id));
                        pst.setInt(3, quantity);
                        pst.executeUpdate();
                    }
                    cn.commit();
                    cn.setAutoCommit(true);
                }
            }
            cn.close();
        }
        return 1;
    }
}
