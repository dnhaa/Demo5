/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytaghandler;

import dao.PlantDao;
import dto.Plant;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ACER
 */
public class getOnePlant extends SimpleTagSupport {
    private String pid;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            Plant p = PlantDao.getPlant(new Integer(pid));
            getJspContext().setAttribute("p", p);

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            
        } catch (java.io.IOException ex) {
            throw new JspException("Error in getOnePlant tag", ex);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }
    
}
