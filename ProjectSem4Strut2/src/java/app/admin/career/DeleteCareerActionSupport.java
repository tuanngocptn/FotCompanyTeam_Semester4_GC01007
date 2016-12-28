/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.career;

import com.opensymphony.xwork2.ActionSupport;
import entity.Career;
import entity.Order;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class DeleteCareerActionSupport extends ActionSupport {
    
    private String code;
    private DataProcess dataProcess;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    public DeleteCareerActionSupport() {
        dataProcess = new DataProcess();
    }
    
    public String execute() throws Exception {
        if (dataProcess.deleteCareer(code)) {
            return "admin";
        }
        addActionMessage("Bạn đã gặp phải lỗi gì đó rất củ chuối... Yêu cầu liên hệ tới Fọt Kăm Ba Lỳ để được giải đáp...");
        return "error";
    }
    
}
