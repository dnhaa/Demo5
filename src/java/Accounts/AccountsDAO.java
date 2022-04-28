/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mylib.Utils;

/**
 *
 * @author acer
 */
public class AccountsDAO implements Serializable {

    public static AccountsDTO getAccounts(String email, String password) throws SQLException {
        AccountsDTO acc = null;
        Connection cn = null;
        try {
            cn = Utils.makeConnection();
            if (cn != null) {
                String sql = "select accID, email, password, fullname, phone, status, role "
                        + "From dbo.Accounts Where email = ? and password = ? collate latin1_general_cs_as";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                //xu lí rs
                if (rs != null && rs.next()) {
                    int accID = rs.getInt("accID");
                    String fullname = rs.getString("fullname");
                    String phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int role = rs.getInt("role");
                    acc = new AccountsDTO(accID, email, password, fullname, status, phone, role);
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
    //hàm này để insert a new account vào bảng Accounts
    //input email, password,....

    public static int inserAccount(String email, String password, String fullname, String phone, int status, int role) {
        int result = 0;
        Connection cn = null;

        try {
            cn = Utils.makeConnection();
            if (cn != null) {
                String sql = "insert into Accounts("
                        + "email, password, fullname, phone, status, role"
                        + ") Values(? ,? ,? ,? ,? ,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, fullname);
                pst.setString(4, phone);
                pst.setInt(5, status);
                pst.setInt(6, role);
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
    //hàm này để lấy tất cả các account
    //input: tên cần tìm
    //out: arraylist chứa account cần tìm
    public static ArrayList<AccountsDTO> getAccountsName(String name)
    throws Exception{
        ArrayList<AccountsDTO> list = null;
        Connection cn = null;
        cn = Utils.makeConnection();
        if (cn != null){
            String sql = "select accID,email,password,fullname,phone,status, role from Accounts where fullname like ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            if (rs != null){
                list = new ArrayList<>();
                while(rs.next()){
                    int accID = rs.getInt("accID");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String fullname = rs.getString("fullname");
                    String phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int role = rs.getInt("role");
                     AccountsDTO acc = new AccountsDTO(accID, email, password, fullname, status, phone, role);
                     list.add(acc);
                }
            }
            cn.close();
        }
        return list;
        
    }
    //hàm này để update status củ account khi biết id
    //input: accID, oldstatus 
    //out: 1/0
    public static int updateStatusAccount(int accID, int oldStatus)
    throws Exception{
        int result = 0;
        Connection cn = Utils.makeConnection();
        if (cn != null){
            String sql = "Update Accounts set status=? where accID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            if (oldStatus == 1){
                pst.setInt(1, 0);
            }else{
                pst.setInt(1, 1);
            }
            pst.setInt(2, accID);
            result = pst.executeUpdate();
        }
        return result;
    }
}
