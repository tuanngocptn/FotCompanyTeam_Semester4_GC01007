/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Panda
 */
public class Order {
    private int codeOrder;
    private String nameCustomer;
    private String emailCustomer;
    private long phone;
    private String location;
    private String codeCareer;
    private int quantityWorker;
    private Date startDate;
    private Date endDate;
    private String status;
    private List<Worker> lstWorker;
    private int priceOrder;

    public Order() {
    }

    public Order(int codeOrder, String nameCustomer, String emailCustomer, long phone, String location, String codeCareer, int quantityWorker, Date startDate, Date endDate, String status, List<Worker> lstWorker, int priceOrder) {
        this.codeOrder = codeOrder;
        this.nameCustomer = nameCustomer;
        this.emailCustomer = emailCustomer;
        this.phone = phone;
        this.location = location;
        this.codeCareer = codeCareer;
        this.quantityWorker = quantityWorker;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.lstWorker = lstWorker;
        this.priceOrder = priceOrder;
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public int getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(int priceOrder) {
        this.priceOrder = priceOrder;
    }

    
    
    @Override
    public String toString() {
        return "Order{" + "codeOrder=" + codeOrder + ", nameCustomer=" + nameCustomer + ", emailCustomer=" + emailCustomer + ", phone=" + phone + ", location=" + location + ", codeCareer=" + codeCareer + ", quantityWorker=" + quantityWorker + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", lstWorker=" + lstWorker + ", priceOrder=" + priceOrder + '}';
    }

}
