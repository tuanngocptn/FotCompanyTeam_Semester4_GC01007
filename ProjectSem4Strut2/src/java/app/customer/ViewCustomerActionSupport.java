/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.customer;

import com.opensymphony.xwork2.ActionSupport;
import entity.Order;
import java.util.List;
import java.util.Map;
import model.DataProcess;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Panda
 */
public class ViewCustomerActionSupport extends ActionSupport implements SessionAware {
    
    private Map<String, Object> session;
    private String emailCustomer;
    private List<Order> lstOrder;

    public Map<String, Object> getSession() {
        return session;
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

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
    
    
    public ViewCustomerActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        this.lstOrder = dataProcess.getOrderByEmail(this.emailCustomer);
        return "customer";
    }
    
}
