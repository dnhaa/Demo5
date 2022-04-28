/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytaghandler;

import dao.OrderDao;
import dto.Order;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ACER
 */
public class getAllOrders extends SimpleTagSupport {
    private int userid;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            ArrayList<Order> orderList = OrderDao.getOrders(userid);
            getJspContext().setAttribute("orderList", orderList);
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in getAllOrders tag", ex);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
}
