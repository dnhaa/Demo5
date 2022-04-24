/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author ACER
 */
public class Plant {
    int pid;
    String pname;
    int price;
    String imgpath;
    String description;
    int status;
    int cateid;
    String catename;

    public Plant() {
    }

    public Plant(int pid, String pname, int price, String imgpath, String description, int status, int cateid, String catename) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.imgpath = imgpath;
        this.description = description;
        this.status = status;
        this.cateid = cateid;
        this.catename = catename;
    }

    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }
    
}
