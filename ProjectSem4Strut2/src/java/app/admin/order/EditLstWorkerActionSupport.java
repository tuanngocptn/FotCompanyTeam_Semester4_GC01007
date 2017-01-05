/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.order;

import com.opensymphony.xwork2.ActionSupport;
import entity.Career;
import entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class EditLstWorkerActionSupport extends ActionSupport {

    private String codeOrder;
    private String codeCareer;
    private String startDate;
    private String endDate;
    private int quantityWorker;

    public String getCodeOrder() {
        System.out.println(codeOrder);
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
    private List<Worker> lstWorkerLeisrure;

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

    public EditLstWorkerActionSupport() {
        lstWorkerLeisrure = new ArrayList<>();
    }

    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        lstWorkerLeisrure = dataProcess.getWorkerLeisrure(codeCareer, format.parse(startDate), format.parse(endDate));
        lstWorkerLeisrure.get(0).setPass(this.codeOrder);
        Career career = dataProcess.getCareer(codeCareer);
        long price = quantityWorker * career.getPriceCareer() * this.minus(format.parse(startDate), format.parse(endDate));
        lstWorkerLeisrure.get(0).setAvatar(Long.toString(price));
        return "admin";
    }

    private long minus(Date startDate, Date endDate) {
        return (endDate.getTime() - startDate.getTime())/(1000 * 60 * 60 * 24) + 1;
    }
}
