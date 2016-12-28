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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class AdminFindActionSupport extends ActionSupport {

    private List<Order> lstOrder;
    private List<Worker> lstWorker;
    private List<Career> lstCareer;
    private List<Comment> lstComent;
    private DataProcess dataProcess;
    private String txtFind;

    public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }

    public List<Worker> getLstWorker() {
        return lstWorker;
    }

    public void setLstWorker(List<Worker> lstWorker) {
        this.lstWorker = lstWorker;
    }

    public List<Career> getLstCareer() {
        return lstCareer;
    }

    public void setLstCareer(List<Career> lstCareer) {
        this.lstCareer = lstCareer;
    }

    public List<Comment> getLstComent() {
        return lstComent;
    }

    public void setLstComent(List<Comment> lstComent) {
        this.lstComent = lstComent;
    }

    public String getTxtFind() {
        return txtFind;
    }

    public void setTxtFind(String txtFind) {
        this.txtFind = txtFind;
    }

    public AdminFindActionSupport() {
        dataProcess = new DataProcess();
        this.lstCareer = dataProcess.getCareer();
        this.lstComent = dataProcess.getComment();
        this.lstOrder = dataProcess.getOrder();
        this.lstWorker = dataProcess.getWorkers();
    }

    public String execute() throws Exception {
        if (!(this.txtFind.equals("") || this.txtFind == null)) {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            List<Order> lstOrders = new ArrayList<>();
            List<Worker> lstWorkers = new ArrayList<>();
            List<Career> lstCareers = new ArrayList<>();
            List<Comment> lstComents = new ArrayList<>();

            for (Order order : lstOrder) {
                if (Integer.toString(order.getCodeOrder()).contains(this.txtFind.toLowerCase())
                        || order.getNameCustomer().toLowerCase().contains(this.txtFind.toLowerCase())
                        || order.getEmailCustomer().toLowerCase().contains(this.txtFind.toLowerCase())
                        || Long.toString(order.getPhone()).contains(this.txtFind.toLowerCase())
                        || order.getLocation().toLowerCase().contains(this.txtFind.toLowerCase())
                        || order.getLocation().toLowerCase().contains(this.txtFind.toLowerCase())
                        || order.getCodeCareer().toLowerCase().contains(this.txtFind.toLowerCase())
                        || Integer.toString(order.getQuantityWorker()).contains(this.txtFind.toLowerCase())
                        || format.format(order.getStartDate()).contains(this.txtFind.toLowerCase())
                        || format.format(order.getEndDate()).contains(this.txtFind.toLowerCase())
                        ) {
                    lstOrders.add(order);
                }
            }

            for (Career career : lstCareer) {
                if (career.getCodeCareer().toLowerCase().contains(this.txtFind.toLowerCase())
                        || career.getNameCareer().toLowerCase().contains(this.txtFind.toLowerCase())) {
                    lstCareers.add(career);
                }
            }

            for (Worker worker : lstWorker) {
                if (worker.getCodeWorker().toLowerCase().contains(this.txtFind.toLowerCase())
                        || worker.getCodeCareer().toLowerCase().contains(this.txtFind.toLowerCase())
                        || worker.getUser().toLowerCase().contains(this.txtFind.toLowerCase())
                        || worker.getPass().toLowerCase().contains(this.txtFind.toLowerCase())
                        || worker.getName().toLowerCase().contains(this.txtFind.toLowerCase())
                        || worker.getEmail().toLowerCase().contains(this.txtFind.toLowerCase())
                        || worker.getAdress().toLowerCase().contains(this.txtFind.toLowerCase())
                        || Long.toString(worker.getPhone()).contains(this.txtFind.toLowerCase())
                        || format.format(worker.getDateOfBirth()).contains(this.txtFind.toLowerCase())) {
                    lstWorkers.add(worker);
                }
            }

            for (Comment comment : lstComent) {
                if (comment.getAreaComent().toLowerCase().contains(this.txtFind.toLowerCase())
                        || comment.getUser().toLowerCase().contains(this.txtFind.toLowerCase())
                        || comment.getContent().toLowerCase().contains(this.txtFind.toLowerCase())
                        || comment.getStatus().toLowerCase().contains(this.txtFind.toLowerCase())) {
                    lstComents.add(comment);
                }
            }
            this.lstCareer = lstCareers;
            this.lstComent = lstComents;
            this.lstOrder = lstOrders;
            this.lstWorker = lstWorkers;
        }
        return "admin";
    }

}
