/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.order;

import com.opensymphony.xwork2.ActionSupport;
import entity.Order;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class DoUpdateOrderActionSupport extends ActionSupport {
    
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public DoUpdateOrderActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if(dataProcess.updateOrder(order))
            return "admin";
        return "error";
        
    }
    
}
