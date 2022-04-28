/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.locks.StampedLock;
import mylib.Utils;
import sun.font.StrikeCache;

/**
 *
 * @author acer
 */
public class PlantsDAO {

    public static ArrayList<PlantsDTO> getPlantsName(String pname)
            throws Exception {
        ArrayList<PlantsDTO> list1 = null;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String sql = " select PID,PName,price,imgPath, description,status, Categories.CateID as 'CateID', cateName \n"
                    + "	 from Plants, Categories\n"
                    + "	 where Plants.CateID = Categories.CateID\n"
                    + "	 and PName like ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + pname + "%");
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                list1 = new ArrayList<>();
                while (rs.next()) {
                    int PID = rs.getInt("PID");
                    String PName = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgPath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int CateID = rs.getInt("CateID");
                    String cateName = rs.getString("cateName");
                    PlantsDTO acc = new PlantsDTO(PID, PName, price, imgPath, description, status, CateID, cateName);
                    list1.add(acc);
                }
            }
            cn.close();
        }
        return list1;
    }
    //hàm này để lấy tất cả các cây trồng có trong bảng

    public static ArrayList<PlantsDTO> getPlants()
            throws Exception {
        ArrayList<PlantsDTO> list = null;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String sql = "select PID, PName, price, imgPath, description, status, Categories.CateID as 'CateID', cateName  "
                    + "From Plants, Categories where Plants.CateID = Categories.CateID";
            //PreparedStatement pst = cn.prepareStatement(sql);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                list = new ArrayList<>();
                while (rs.next()) {
                    int PID = rs.getInt("PID");
                    String PName = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgPath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int CateID = rs.getInt("CateID");
                    String cateName = rs.getString("cateName");
                    PlantsDTO ac = new PlantsDTO(PID, PName, price, imgPath, description, status, CateID, cateName);
                    list.add(ac);
                }
            }
            cn.close();
        }
        return list;
    }

    public static PlantsDTO getPlants(int id)
            throws Exception {
        PlantsDTO p = null;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String sql = "select PID, PName, price, imgPath, description, status, Categories.CateID as 'CateID', cateName \n"
                    + "From Plants, Categories\n"
                    + "where Plants.CateID = Categories.CateID and PID = ?";
            //PreparedStatement pst = cn.prepareStatement(sql);
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int PID = rs.getInt("PID");
                    String PName = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgPath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int CateID = rs.getInt("CateID");
                    String cateName = rs.getString("cateName");
                    p = new PlantsDTO(PID, PName, price, imgPath, description, status, CateID, cateName);
                }
            }
            cn.close();
        }
        return p;
    }
    
    public static int inserPlants(String PName, int price, String imgPath,  String description,  int status, int CateID) {
        int result = 0;
        Connection cn = null;

        try {
            cn = Utils.makeConnection();
            if (cn != null) {
                String sql = "insert Plants(PName, price, imgPath, description, status, CateID) values(?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, PName);
                pst.setInt(2, price);
                pst.setString(3, imgPath);
                pst.setString(4, description);
                pst.setInt(5, status);
                pst.setInt(6, CateID);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             if (cn != null){
                 try {
                     cn.close();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
        }
        return result;
    }
    public static int updatePlants(int PID,String PName, int price,String description, int status, int CateID) throws Exception {
        int result = 0;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String url = "update Plants "
                    + "set PName=?, price=?, description=?, status=?, CateID=?\n"
                    + "where PID=? ";
            PreparedStatement pst = cn.prepareStatement(url);
            pst.setString(1, PName);
            pst.setInt(2, price);
            pst.setString(3, description);
            pst.setInt(4, status);
            pst.setInt(5, CateID);
            pst.setInt(6, PID);
            result = pst.executeUpdate();
            
            cn.close();
        }
        return result;
    }
}
