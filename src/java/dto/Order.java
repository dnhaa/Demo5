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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getShipdate() {
        return shipdate;
    }

    public void setShipdate(String shipdate) {
        this.shipdate = shipdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }
    
    
}
