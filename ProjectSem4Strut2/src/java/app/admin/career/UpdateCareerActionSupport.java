/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.career;

import com.opensymphony.xwork2.ActionSupport;
import entity.Career;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class UpdateCareerActionSupport extends ActionSupport {

    private Career career;
    private String code;

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UpdateCareerActionSupport() {
        career = new Career();
    }

    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        this.career = dataProcess.getCareer(code);
        return "updateCareer";
    }
    
}
