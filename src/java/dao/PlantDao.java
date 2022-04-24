/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Plant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mylib.Utils;

/**
 *
 * @author ACER
 */
public class PlantDao {

    //ham nay de lay tat ca cay trong trong plant
    public static int insertPlant(String pname, int price, String imgpath, String description, int status, int cateid) throws Exception {
        int result = 0;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String sql = "insert [dbo].[Plants] ([PName],[price],[imgPath],[description],[status],[CateID])\n"
                    + "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, pname);
            pst.setInt(2, price);
            pst.setString(3, imgpath);
            pst.setString(4, description);
            pst.setInt(5, status);
            pst.setInt(6, cateid);
            result = pst.executeUpdate();

        }

        return result;
    }

    public static ArrayList<Plant> getPlants() throws Exception {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String sql = "select [PID], [PName], [price],[imgPath],[description],[status],[dbo].[Plants].[CateID] as 'cateid', CateName\n"
                    + "from [dbo].[Plants], [dbo].[Categories]\n"
                    + "where [dbo].[Plants].CateID = [dbo].[Categories].CateID";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int pid = rs.getInt("PID");
                    String pname = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgpath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int cateid = rs.getInt("cateid");
                    String catename = rs.getString("CateName");
                    Plant p = new Plant(pid, pname, price, imgpath, description, status, cateid, catename);
                    list.add(p);
                }
            }
            cn.close();
        }
        return list;
    }

    //ham nay lay 1 Plant du avao id
    public static Plant getPlant(int id) throws Exception {
        Plant p = null;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String sql = "select [PID], [PName], [price],[imgPath],[description],[status],[dbo].[Plants].[CateID] as 'cateid', CateName\n"
                    + "from [dbo].[Plants], [dbo].[Categories]\n"
                    + "where [dbo].[Plants].CateID = [dbo].[Categories].CateID\n"
                    + "and [PID]=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                String pname = rs.getString("PName");
                int price = rs.getInt("price");
                String imgpath = rs.getString("imgPath");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                int cateid = rs.getInt("cateid");
                String catename = rs.getString("CateName");
                p = new Plant(id, pname, price, imgpath, description, status, cateid, catename);
            }
            cn.close();
        }
        return p;
    }

    //this func is to get plants who names contain a string
    public static ArrayList<Plant> getPlants1(String name) throws Exception {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String sql = "select [PID], [PName], [price],[imgPath],[description],[status],[dbo].[Plants].[CateID] as 'cateid', CateName\n"
                    + "from [dbo].[Plants], [dbo].[Categories]\n"
                    + "where [dbo].[Plants].CateID = [dbo].[Categories].CateID\n"
                    + "and [PName] like ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int pid = rs.getInt("PID");
                    String pname = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgpath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int cateid = rs.getInt("cateid");
                    String catename = rs.getString("CateName");
                    Plant p = new Plant(pid, pname, price, imgpath, description, status, cateid, catename);
                    list.add(p);
                }
            }
            cn.close();
        }
        return list;
    }

    public static int updatePlant(int pid, String pname, int price, String imgPath, String description, int status, int cateid) throws Exception {
        int rs = 0;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null) {
            String url = "update plants\n"
                    + "set pname=?, price=?, imgPath=?, [description]=?, [status]=?, [CateID]=?\n"
                    + "where [PID]=? ";
            PreparedStatement pst = cn.prepareStatement(url);
            pst.setString(1, pname);
            pst.setInt(2, price);
            pst.setString(3, imgPath);
            pst.setString(4, description);
            pst.setInt(5, status);
            pst.setInt(6, cateid);
            pst.setInt(7, pid);
            rs = pst.executeUpdate();

            cn.close();
        }
        return rs;
    }
    //1. logout khi back lai van add plant dc
    //2. lo duong dan -> phia client goi resource co can qua Main controller k?

}
