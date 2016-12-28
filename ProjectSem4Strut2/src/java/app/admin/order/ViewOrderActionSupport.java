/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.order;

import com.opensymphony.xwork2.ActionSupport;
import entity.Order;
import java.util.List;
import model.DataProcess;



public class ViewOrderActionSupport extends ActionSupport {
    
    private int codeOrder;
    
    private Order order;
    
    public ViewOrderActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        List<Order> lst = dataProcess.getOrder();
        for (Order or : lst) 
            if(or.getCodeOrder() == codeOrder)
                this.order = or;
        return "viewOrderAdmin";
    }

    public int getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
    
    
}
