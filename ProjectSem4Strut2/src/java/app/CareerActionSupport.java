/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.opensymphony.xwork2.ActionSupport;
import entity.Career;
import java.util.ArrayList;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class CareerActionSupport extends ActionSupport {
    
    private String codeCareer;
    private String nameCareer;
    private List<Career> lstCareer;

    public DataProcess getDataProcess() {
        return dataProcess;
    }

    public void setDataProcess(DataProcess dataProcess) {
        this.dataProcess = dataProcess;
    }
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

    public List<Career> getLstCareer() {
        return dataProcess.getCareer();
    }

    public void setLstCareer(List<Career> lstCareer) {
        this.lstCareer = lstCareer;
    }
    
    public CareerActionSupport() {
        dataProcess = new DataProcess();
    }
    
    public String execute() throws Exception {
        return "index";
    }
    
}
