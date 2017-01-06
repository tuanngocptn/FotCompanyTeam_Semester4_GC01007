/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.career;

import com.opensymphony.xwork2.ActionSupport;
import controller.CareerJson;
import entity.CareerForJson;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class DoUpdateCareerActionSupport extends ActionSupport {

    private CareerForJson careerForJson;

    public CareerForJson getCareerForJson() {
        return careerForJson;
    }

    public void setCareerForJson(CareerForJson careerForJson) {
        this.careerForJson = careerForJson;
    }

    public DoUpdateCareerActionSupport() {
    }

    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        CareerJson careerJson = new CareerJson();
        List<CareerForJson> lstCareerForJson = careerJson.read();
        String show = "";
        if (careerForJson.getShow().equals("1")
                || careerForJson.getShow().equals("2")
                || careerForJson.getShow().equals("3")
                || careerForJson.getShow().equals("4")) {
            show = careerForJson.getShow();
        }
        for (CareerForJson car : lstCareerForJson) {
            if (car.getCode().equals(careerForJson.getCode())) {
                lstCareerForJson.remove(car);
                break;
            }
        }
        for (CareerForJson car : lstCareerForJson) {
            if (car.getShow().equals(show)) {
                lstCareerForJson.remove(car);
                car.setShow("0");
                lstCareerForJson.add(car);
                break;
            }
        }
        lstCareerForJson.add(careerForJson);
        careerJson.write(lstCareerForJson);
        if (dataProcess.updateCareer(careerForJson.getCode(), careerForJson.getName(), careerForJson.getPrice().intValue())) {
            return "admin";
        }
        addActionMessage("Bạn đã gặp phải lỗi gì đó rất củ chuối... Yêu cầu liên hệ tới Fọt Kăm Ba Lỳ để được giải đáp...");
        return "error";
    }

}
