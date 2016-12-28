/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.career;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import entity.Career;
import entity.Order;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class AddCareerActionSupport extends ActionSupport {

    private String codeCareer;
    private String nameCareer;
    private DataProcess dataProcess;

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

    public AddCareerActionSupport() {
        dataProcess = new DataProcess();
    }

    public String execute() throws Exception {
        if (dataProcess.addCareer(codeCareer, nameCareer)) {
            return "admin";
        }
        addActionMessage("Tên hoặc Mã công việc đã tồn tại!");
        return "error";
    }

}
