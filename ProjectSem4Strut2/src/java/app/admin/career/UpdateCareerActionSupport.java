/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.career;

import com.opensymphony.xwork2.ActionSupport;
import controller.CareerJson;
import entity.Career;
import entity.CareerForJson;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class UpdateCareerActionSupport extends ActionSupport {

    private Career career;
    private CareerForJson careerForJson;
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
        careerForJson = new CareerForJson();
    }

    public CareerForJson getCareerForJson() {
        return careerForJson;
    }

    public void setCareerForJson(CareerForJson careerForJson) {
        this.careerForJson = careerForJson;
    }

    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        CareerJson careerJson = new CareerJson();
        for (CareerForJson car : careerJson.read()) {
            if (car.getCode().equals(code)) {
                this.careerForJson = car;
                break;
            }
        }
        this.career = dataProcess.getCareer(code);
        return "updateCareer";
    }

}
