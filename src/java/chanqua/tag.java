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
public class tag extends SimpleTagSupport {

    private Object name;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            out.print("<h1>Cam ơn  " + ((AccountsDTO) name).getFullname() + " đã tin tưởng và mua hàng bên shop</h1>");
            out.print("<h1>Dưới đây là sản phẩm bạn đã lựa chọn: </h1>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in tag tag", ex);
        }
    }

    public void setName(Object name) {
        this.name = name;
    }
     
}
