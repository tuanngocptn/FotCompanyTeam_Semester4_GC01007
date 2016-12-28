/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.customer;

import com.opensymphony.xwork2.ActionSupport;
import entity.Order;
import entity.Worker;
import java.util.ArrayList;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class DeleteOrderLstWorkerCusActionSupport extends ActionSupport {

    private int codeOrder;
    private List<Order> lstOrder;

    public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }
    private String emailCustomer;

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public int getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }

    public DeleteOrderLstWorkerCusActionSupport() {
    }

    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if (dataProcess.updateListWorkerOrder(new ArrayList<>(), codeOrder, "wait")) {
            return "customer";
        }
        this.lstOrder = dataProcess.getOrderByEmail(this.emailCustomer);
        return "error";
    }

}
