/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.worker;

import com.opensymphony.xwork2.ActionSupport;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class DeleteWorkerActionSupport extends ActionSupport {
    
    private String codeWorker;

    public String getCodeWorker() {
        return codeWorker;
    }

    public void setCodeWorker(String codeWorker) {
        this.codeWorker = codeWorker;
    }
    
    public DeleteWorkerActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if(dataProcess.deleteWorker(codeWorker))
            return "admin";
        addActionMessage("Bạn đã gặp phải lỗi gì đó rất củ chuối... Yêu cầu liên hệ tới Fọt Kăm Ba Lỳ để được giải đáp...");
        return "error";
    }
    
}
