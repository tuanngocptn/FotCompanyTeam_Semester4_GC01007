/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.worker;

import com.opensymphony.xwork2.ActionSupport;
import entity.Order;
import entity.Worker;
import java.util.List;
import java.util.Map;
import model.DataProcess;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Panda
 */
public class ViewWorkerActionSupport extends ActionSupport implements SessionAware {
    
    List<Order> lstOrder;
    
    private Map<String, Object> session;

    public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }
    
    public Map<String, Object> getSession() {
        return session;
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
    public ViewWorkerActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        Worker worker = (Worker) session.get("worker");
        this.lstOrder = dataProcess.getOrderByCodeWorker(worker.getCodeWorker());
        return "worker";
    }

    

    
    
}
