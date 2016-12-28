/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.customer;

import com.opensymphony.xwork2.ActionSupport;
import entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class EditOrderLstWorkerCusActionSupport extends ActionSupport {
    
    private String codeOrder;
    private String codeCareer;
    private String startDate;
    private String endDate;
    private int quantityWorker;
    private List<Worker> lstWorkerLeisrure;

    public String getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(String codeOrder) {
        this.codeOrder = codeOrder;
    }

    public int getQuantityWorker() {
        return quantityWorker;
    }

    public void setQuantityWorker(int quantityWorker) {
        this.quantityWorker = quantityWorker;
    }
    
    public String getCodeCareer() {
        return codeCareer;
    }

    public void setCodeCareer(String codeCareer) {
        this.codeCareer = codeCareer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Worker> getLstWorkerLeisrure() {
        return lstWorkerLeisrure;
    }

    public void setLstWorkerLeisrure(List<Worker> lstWorkerLeisrure) {
        this.lstWorkerLeisrure = lstWorkerLeisrure;
    }

    
    
    public EditOrderLstWorkerCusActionSupport() {
        lstWorkerLeisrure = new ArrayList<>();
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        lstWorkerLeisrure = dataProcess.getWorkerLeisrure(codeCareer, format.parse(startDate), format.parse(endDate));
        return "customer";
    }
    
}
