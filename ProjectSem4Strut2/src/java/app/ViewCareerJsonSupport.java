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
import java.util.List;
import model.DataProcess;

/**
 *
 * @author ADMIN
 */
public class ViewCareerJsonSupport extends ActionSupport {

    private CareerForJson careerForJson;
    private List<CareerForJson> lstCareerJson;
    private String code;
    List<Career> lstCareer;
    DataProcess dataProcess;
    CareerJson careerJson;
    public ViewCareerJsonSupport() {
        careerJson = new CareerJson();
        lstCareerJson = new ArrayList<>();
        lstCareer = new ArrayList<>();
        dataProcess = new DataProcess();
    }

    public String execute() throws Exception {
        lstCareer = dataProcess.getCareer();
        lstCareerJson = careerJson.read();
        for (Career career : lstCareer) {
            boolean boo = true;
            for (CareerForJson careerForJson : lstCareerJson) {
                if (careerForJson.getCode().equals(career.getCodeCareer())) {
                    boo = false;
                    break;
                }
            }
            if (boo) {
                lstCareerJson.add(new CareerForJson(career.getCodeCareer(), career.getNameCareer(), "chưa có slogan", Long.valueOf(career.getPriceCareer()), "images/career/kcbt2.jpg", "chưa có lời giới thiệu ngắn", "Chưa có lời giới thiệu dài", "0"));
            }
        }
        for (CareerForJson careerForJson : lstCareerJson) {
            if(careerForJson.getCode().equals(this.code)){
                this.careerForJson = careerForJson;
            }
        }
        return "viewCareer";
    }

    public CareerForJson getCareerForJson() {
        return careerForJson;
    }

    public void setCareerForJson(CareerForJson careerForJson) {
        this.careerForJson = careerForJson;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    

}
