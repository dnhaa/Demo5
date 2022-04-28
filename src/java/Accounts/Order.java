/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

/**
 *
 * @author acer
 */
public class Order {
    private int id;
    private String orderdate;
    private String shipdate;
    private int status;
    private int accid;

    public Order() {
    }

    public Order(int id, String orderdate, String shipdate, int status, int accid) {
        this.id = id;
        this.orderdate = orderdate;
        this.shipdate = shipdate;
        this.status = status;
        this.accid = accid;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the orderdate
     */
    public String getOrderdate() {
        return orderdate;
    }

    /**
     * @param orderdate the orderdate to set
     */
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    /**
     * @return the shipdate
     */
    public String getShipdate() {
        return shipdate;
    }

    /**
     * @param shipdate the shipdate to set
     */
    public void setShipdate(String shipdate) {
        this.shipdate = shipdate;
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
     * @return the accid
     */
    public int getAccid() {
        return accid;
    }

    /**
     * @param accid the accid to set
     */
    public void setAccid(int accid) {
        this.accid = accid;
    }
    
    
}
