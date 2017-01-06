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
public class CareerJsonActionSupport extends ActionSupport {

    List<CareerForJson> lstCareerJson;
    List<Career> lstCareer;
    DataProcess dataProcess;
    CareerJson careerJson;

    public CareerJsonActionSupport() {
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
            System.out.println(careerForJson.getSlogan());
        }
        return "listCareer";
    }

    public List<CareerForJson> getLstCareerJson() {
        return lstCareerJson;
    }

    public void setLstCareerJson(List<CareerForJson> lstCareerJson) {
        this.lstCareerJson = lstCareerJson;
    }

    public List<Career> getLstCareer() {
        return lstCareer;
    }

    public void setLstCareer(List<Career> lstCareer) {
        this.lstCareer = lstCareer;
    }

    public void read() {
        List<CareerForJson> lstCareerJson = new ArrayList<>();
        CareerJson careerJson = new CareerJson();
        lstCareerJson = careerJson.read();
        lstCareerJson.forEach((careerForJson) -> {
            System.out.println(careerForJson);
        });
    }

    public static void main(String[] args) {
        CareerJsonActionSupport actionSupport = new CareerJsonActionSupport();
        actionSupport.read();
    }
}
