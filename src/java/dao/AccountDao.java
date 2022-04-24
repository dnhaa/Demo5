/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mylib.Utils;

/**
 *
 * @author ACER
 */
public class AccountDao {

    //Ham nay de lay account dua vao email, password

    public static Account getAccount(String email, String pwd) {
        Account acc = null;
        Connection cn = null;
        try {
            cn = Utils.makeConnection();
            if (cn != null) {
                String sql = "select [accID],[email],[password],[fullname],[phone],[status],[role]\n"
                        + "from dbo.Accounts\n"
                        + "where email=? and password=? collate latin1_general_cs_as";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, pwd);
                ResultSet rs = pst.executeQuery();

                //xu li rs
                if (rs != null && rs.next()) {
                    int accid = rs.getInt("accID");
                    String fullname = rs.getString("fullname");
                    String phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int role = rs.getInt("role");
                    acc = new Account(accid, email, pwd, fullname, phone, status, role);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception ex) {

                }
            }
        }

        return acc;
    }

    //ham nay de insert a new accout vao bang Account
    //input: email, pwd, ...
    //output: 1 / 0
    public static int insertAccount(String email, String pwd, String fullname, String phone, int status, int role) {
        int result = 0;
        Connection cn = null;
        try {
            cn = Utils.makeConnection();
            if (cn != null) {

                String sql = "insert [dbo].[Accounts](\n"
                        + "[email],[password],[fullname],[phone],[status],[role]\n"
                        + ") values (\n"
                        + "?,?,?,?,?, ?\n"
                        + ")";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, pwd);
                pst.setString(3, fullname);
                pst.setString(4, phone);
                pst.setInt(5, status);
                pst.setInt(6, role);
                result = pst.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        return result;
        
    }
    
    //ham nay lay tat ca cac account co fullname chua ten can tim
    //input: ten can tim
    //out: arraList chua acount can tim
    public static ArrayList<Account> getAccounts(String name) throws Exception {
        ArrayList<Account> list = null;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null){
            String sql = "select [accID],[email],[password],[fullname],[phone],[status],[role]\n"
                    + "from dbo.Accounts\n"
                    + "where [fullname] like ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                list = new ArrayList<>();
                while (rs.next()){
                    int accid = rs.getInt("accID");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String fullname = rs.getString("fullname");
                    String phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int role = rs.getInt("role");
                    Account acc = new Account(accid, email, password, fullname, phone, status, role);
                    list.add(acc);
                    
                } //het while
            }//het if
            cn.close();
        }
        return list;
    }
    
    //ham nay de update status cua account khi biet id
    //input: account id,old status
    //output: 1/0
    public static int updateStatusAccount(int accid, int oldStatus) throws Exception{
        int result = 0;
        Connection cn = Utils.makeConnection();
        if (cn != null){
            String sql = "update [dbo].[Accounts]\n"
                    + "set [status] = ?\n"
                    + "where [accID] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            if (oldStatus == 1){
                pst.setInt(1, 0);
            } else{
                pst.setInt(1, 1);
            }
            
            pst.setInt(2, accid);
            result = pst.executeUpdate();
        }
        
        return result;
    }
}
