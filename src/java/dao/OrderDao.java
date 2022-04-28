/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import mylib.Utils;

/**
 *
 * @author ACER
 */
public class OrderDao {

    //ham nay de chen/insert mot new order
    //insert order xong thi chen luon orderDetail
    //input: orderdate, accid, cart
    //output: 1/0

    public static int checkout(String orderdate, int accid, HashMap<String, Integer> cart) throws Exception {
        int result = 0;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            //khi viet sql va execute, ket qua dc luu vinh vien vao bang --> goi la commit
            //chay nhieu cau query, k muon luu ket qua vinh vien --> tat che do auto commit
            //--> dùng bảng tạm thay vi bang vat li 
            cn.setAutoCommit(false);

            //chen vao bang order truoc
            String sql = "insert [dbo].[Orders] ([OrdDate], [shipdate], [status], [AccID])\n"
                    + "values (?, NULL, 1, ?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, orderdate);
            pst.setInt(2, accid);
            result = pst.executeUpdate();

            if (result > 0) {
                //chen order Detail
                sql = "select top 1 [OrderID]\n"
                        + "from [dbo].[Orders]\n"
                        + "order by [OrderID] desc";
                pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int orderid = rs.getInt("OrderID");
                    for (String id : cart.keySet()) {
                        int quantity = cart.get(id);
                        sql = "insert [dbo].[OrderDetails] ([OrderID],[FID],[quantity]) values (?,?,?)";
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
        return result;
    }

    public static ArrayList<Order> getOrders(int id) throws Exception {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [OrderID],[OrdDate],[shipdate],[status],[AccID]\n"
                    + "  FROM [dbo].[Orders]\n"
                    + "  where [AccID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                while (rs.next()){
                    int orderid = rs.getInt("OrderID");
                    String orderdate = rs.getString("OrdDate");
                    String shipdate = rs.getString("shipdate");
                    int status = rs.getInt("status");
                    Order o = new Order(new Integer(orderid), orderdate, shipdate, new Integer(status), id);
                    list.add(o);
                }
            }
            cn.close();
            
        }
        return list;
    }
}
