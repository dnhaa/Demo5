/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytaghandler;

import dao.PlantDao;
import dto.Plant;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ACER
 */
public class getAllPlants extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            
            ArrayList<Plant> plantList = PlantDao.getPlants();
            getJspContext().setAttribute("plantList", plantList);
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

           
        } catch (java.io.IOException ex) {
            throw new JspException("Error in getAllPlants tag", ex);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
