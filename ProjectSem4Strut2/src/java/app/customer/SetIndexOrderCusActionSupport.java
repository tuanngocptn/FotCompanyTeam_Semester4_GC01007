/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.customer;

import com.opensymphony.xwork2.ActionSupport;
import entity.Order;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class SetIndexOrderCusActionSupport extends ActionSupport {

    private int index;
    
    private List<Order> lstOrder;

    private String emailCustomer;

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }
    
    public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public SetIndexOrderCusActionSupport() {
    }

    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        this.lstOrder = dataProcess.getOrderByEmail(this.emailCustomer);
        return "customer";
    }

}
