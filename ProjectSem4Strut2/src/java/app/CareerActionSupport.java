/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.opensymphony.xwork2.ActionSupport;
import controller.CareerJson;
import entity.Career;
import entity.CareerForJson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class CareerActionSupport extends ActionSupport {
    List<CareerForJson> lstCareerJson;
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
        lstCareerJson = new ArrayList<>();
        CareerJson careerJson = new CareerJson();
        for(CareerForJson cfj : careerJson.read()){
            if(cfj.getShow().endsWith("1")||cfj.getShow().endsWith("2")||cfj.getShow().endsWith("3")||cfj.getShow().endsWith("4")){
                this.lstCareerJson.add(cfj);
            }
        }
        Collections.sort(lstCareerJson, new Comparator<CareerForJson>() {
            @Override
            public int compare(CareerForJson o1, CareerForJson o2) {
                return Integer.parseInt(o2.getShow()) > Integer.parseInt(o1.getShow()) ? -1 : (Integer.parseInt(o2.getShow()) < Integer.parseInt(o1.getShow()) ) ? 1 : 0;
            }
        });
    }

    public List<CareerForJson> getLstCareerJson() {
        return lstCareerJson;
    }

    public void setLstCareerJson(List<CareerForJson> lstCareerJson) {
        this.lstCareerJson = lstCareerJson;
    }
    
    
    
    public String execute() throws Exception {
        return "index";
    }
    
}
