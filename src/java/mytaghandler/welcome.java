/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytaghandler;

import dto.Account;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ACER
 */
public class welcome extends SimpleTagSupport {
    private Object user;

    
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            //gap the mo <welcome> thi code o day run
            out.println("<h1>Welcome " + ((Account)user).getFullname() + "</h1>");
            
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            //gap the dong <welcome> thi code o day run
        } catch (java.io.IOException ex) {
            throw new JspException("Error in welcome tag", ex);
        }
    }

    public void setUser(Object user) {
        this.user = user;
    }
    
}
