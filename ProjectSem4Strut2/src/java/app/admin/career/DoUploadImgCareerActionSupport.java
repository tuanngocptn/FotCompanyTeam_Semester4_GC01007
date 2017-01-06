/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.career;

import com.opensymphony.xwork2.ActionSupport;
import controller.CareerJson;
import entity.CareerForJson;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import model.DataProcess;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ADMIN
 */
public class DoUploadImgCareerActionSupport extends ActionSupport {
    
    private String code;
    private File file;
    public DoUploadImgCareerActionSupport() {
    }
    
    public String execute() throws Exception {
         String destPath = "D:/hoctap/SEM4/ProjectSem4Strut2/web/images/career";
        DataProcess dataProcess = new DataProcess();
        String url = "";
        try {
            Random rand = new Random();
            int ran = rand.nextInt();
            url = Integer.toString(ran) + ".jpg";
            File destFile = new File(destPath, url);
            FileUtils.copyFile(file, destFile);

        } catch (IOException e) {
            return "error";
        }
        url = "images/career/" + url;
        
        CareerJson careerJson = new CareerJson();
        List<CareerForJson> careerForJsons = careerJson.read();
        for(CareerForJson careerForJson: careerForJsons){
            if(careerForJson.getCode().equals(code)){
                careerForJsons.remove(careerForJson);
                careerForJson.setImage(url);
                careerForJsons.add(careerForJson);
                break;
            }
        }
        careerJson.write(careerForJsons);
        
//        if(dataProcess.setAvata(codeWorker, url))
//            return "index";
//        return "error";
        return "admin";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    
}
