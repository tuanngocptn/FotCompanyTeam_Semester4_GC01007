/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.opensymphony.xwork2.ActionSupport;
import entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class OrderActionSupport extends ActionSupport {

    private int codeOrder;
    private String nameCustomer;
    private String emailCustomer;
    private long phone;
    private String location;
    private String codeCareer;
    private int quantityWorker;
    private String startDateString;
    private String endDateString;
    private String status;
    private List<Worker> lstWorker;

    public int getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCodeCareer() {
        return codeCareer;
    }

    public void setCodeCareer(String codeCareer) {
        this.codeCareer = codeCareer;
    }

    public int getQuantityWorker() {
        return quantityWorker;
    }

    public void setQuantityWorker(int quantityWorker) {
        this.quantityWorker = quantityWorker;
    }

    public String getStartDate() {
        return startDateString;
    }

    public void setStartDate(String startDate) {
        this.startDateString = startDate;
    }

    public String getEndDate() {
        return endDateString;
    }

    public void setEndDate(String endDate) {
        this.endDateString = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Worker> getLstWorker() {
        return lstWorker;
    }

    public void setLstWorker(List<Worker> lstWorker) {
        this.lstWorker = lstWorker;
    }

    public OrderActionSupport() {
        this.lstWorker = new ArrayList<>();
    }

    public String execute() throws Exception {
        DataProcess db = new DataProcess();
        System.out.println(nameCustomer + "--" + emailCustomer + "--" + phone + "--" + location + "--" + codeCareer + "--" + quantityWorker + "--" + startDateString + "--" + endDateString + "--" + lstWorker);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = df.parse(startDateString),endDate = df.parse(endDateString);
        if (db.addNewOrder(nameCustomer, emailCustomer, phone, location, codeCareer, quantityWorker, startDate, endDate, "wait", lstWorker)) {
            return "index";
        }
        return "error";
    }

}
