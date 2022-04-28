/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import dao.OrderDao;
import dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
public class CheckoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //kiem tra thong tin login nguoi dung
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            if (acc == null) {
                response.sendRedirect("loginPage.jsp?warning=dangnhap");
            } else {
                if (acc.getRole() == 1) {
                    response.sendRedirect("viewCartPage.jsp?warning1=admin");
                } else {
                    //lay acc id cua user 
                    int accid = acc.getAccid();
                    Date d = new Date(System.currentTimeMillis());
                    String orderdate = d.toString();

                //cach 1: lay getDate, getMonth, getYear
                    //cach 2: sua thanh datetime
                    //insert new order, insert orderdetail
                    HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
                    if (cart != null && cart.size() > 0) {
                        int result = OrderDao.checkout(orderdate, accid, cart);
                        if (result > 0) {
                            // xoa cart object r khoi session
                            session.removeAttribute("cart");
                            response.sendRedirect("index.jsp");

                            //sau khi checkout nen cho ngta check lich su
                        }

                    } else {
                        response.sendRedirect("viewCartPage.jsp?warning2=cart");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

//chinh search acc --> plant (index.jsp)
//register chuyen thanh trang jsp
//trang personal: show tat ca don hang
//checkout xong chuyen qua trang personal --> hien thi tat ca don hang chi lay cua nguoi login
//manage plant
//create plant
