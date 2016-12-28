/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.career;

import com.opensymphony.xwork2.ActionSupport;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class DoUpdateCareerActionSupport extends ActionSupport {

    private String codeCareer;
    private String nameCareer;

    public String getCodeCareer() {
        return codeCareer;
    }

    public void setCodeCareer(String codeCareer) {
        this.codeCareer = codeCareer;
    }

    public String getNameCareer() {
        return nameCareer;
    }

    public void setNameCareer(String nameCareer) {
        this.nameCareer = nameCareer;
    }

    
    
    public DoUpdateCareerActionSupport() {
    }

    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if(dataProcess.updateCareer(codeCareer, nameCareer))
            return "admin";
        addActionMessage("Bạn đã gặp phải lỗi gì đó rất củ chuối... Yêu cầu liên hệ tới Fọt Kăm Ba Lỳ để được giải đáp...");
        return "error";
    }

}
