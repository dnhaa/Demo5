/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class MainController extends HttpServlet {

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
           //lay action tu cac trang tren front end
            String action = request.getParameter("action");
            String url = "index.jsp"; //default page se mo
            switch(action){
                case "GO": //search account
                    url = "searchServlet";
                    break;
                case "login":
                    url = "LoginServlet";
                    break;
                case "logout":
                    url = "LogoutServlet";
                    break;
                case "addtocart":
                    url = "AddToCartServlet";
                    break;
                case "Update quantity":
                    url = "UpdateCartServlet";
                    break;
                case "remove":
                    url = "RemoveCartServlet";
                    break;
                case "checkout":
                    url = "CheckoutServlet";
                    break;
                case "managePlant":
                    url = "managePlantPage.jsp";
                    break;
                case "search plants":
                    url = "SearchPlantServlet";
                    break;
                case "editPlant":
                    url = "editPlantPage.jsp";
                    break;
                case "edit":
                    url = "EditPlantServlet";
                    break;
                case "create plant":
                    url = "CreatePlantServlet";
                    break;
                case "create account":
                    url = "RegisterServlet";
                    break;
            }
            request.getRequestDispatcher(url).forward(request, response);
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
