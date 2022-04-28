/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plants;

/**
 *
 * @author acer
 */
public class PlantsDTO {
    private int PID;
    private String PName;
    private int price;
    private String imgPath;
    private String description;
    private int status;
    private int CateID;
    private String cateName;

    public PlantsDTO() {
    }

    public PlantsDTO(int PID, String PName, int price, String imgPath, String description, int status, int CateID, String cateName) {
        this.PID = PID;
        this.PName = PName;
        this.price = price;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.CateID = CateID;
        this.cateName = cateName;
    }

    /**
     * @return the PID
     */
    public int getPID() {
        return PID;
    }

    /**
     * @param PID the PID to set
     */
    public void setPID(int PID) {
        this.PID = PID;
    }

    /**
     * @return the PName
     */
    public String getPName() {
        return PName;
    }

    /**
     * @param PName the PName to set
     */
    public void setPName(String PName) {
        this.PName = PName;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the CateID
     */
    public int getCateID() {
        return CateID;
    }

    /**
     * @param CateID the CateID to set
     */
    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

    /**
     * @return the cateName
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * @param cateName the cateName to set
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
    
    
    
    
}
