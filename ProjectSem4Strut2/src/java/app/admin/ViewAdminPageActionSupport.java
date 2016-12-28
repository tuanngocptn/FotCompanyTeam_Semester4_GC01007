/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin;

import com.opensymphony.xwork2.ActionSupport;
import entity.Career;
import entity.Comment;
import entity.Order;
import entity.Worker;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class ViewAdminPageActionSupport extends ActionSupport {
    
    private List<Order> lstOrder;
    private List<Worker> lstWorker;
    private List<Career> lstCareer;
    private List<Comment> lstComent;
    private DataProcess dataProcess;
    
    public List<Order> getLstOrder() {
        return dataProcess.getOrder();
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }

    public List<Worker> getLstWorker() {
        return dataProcess.getWorkers();
    }

    public void setLstWorker(List<Worker> lstWorker) {
        this.lstWorker = lstWorker;
    }

    public List<Career> getLstCareer() {
        return dataProcess.getCareer();
    }

    public void setLstCareer(List<Career> lstCareer) {
        this.lstCareer = lstCareer;
    }

    public List<Comment> getLstComent() {
        return dataProcess.getComment();
    }

    public void setLstComent(List<Comment> lstComent) {
        this.lstComent = lstComent;
    }
    
    
    public ViewAdminPageActionSupport() {
        dataProcess = new DataProcess();
    }
    
    public String execute() throws Exception {
        return "admin";
    }
    
}
