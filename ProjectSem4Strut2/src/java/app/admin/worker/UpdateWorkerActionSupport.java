/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.worker;

import com.opensymphony.xwork2.ActionSupport;
import entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class UpdateWorkerActionSupport extends ActionSupport {
        
    private String codeWorker;
    private Worker worker;

    public String getCodeWorker() {
        return codeWorker;
    }

    public void setCodeWorker(String codeWorker) {
        this.codeWorker = codeWorker;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
        
    
    public UpdateWorkerActionSupport() {
        
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        this.worker = dataProcess.getWorker(codeWorker);
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        String dateString  = df.format(this.worker.getDateOfBirth());
//        this.worker.setDateOfBirth(df.parse(dateString));
        return "updateWorker";
    }
    
}
