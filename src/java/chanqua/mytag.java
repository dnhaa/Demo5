/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chanqua;

import Accounts.AccountsDTO;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author acer
 */
public class mytag extends SimpleTagSupport {

    private Object user;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // gap the mo <welcom>
            //thì code ở dđây
            out.print("<h1>Welcom : " + ((AccountsDTO)user).getFullname() +"</h1>");
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

           //gặp thẻ đóng
           //thì code ở đây
        } catch (java.io.IOException ex) {
            throw new JspException("Error in NewTagHandler tag", ex);
        }
    }

    public void setUser(Object user) {
        this.user = user;
    }
    
}
