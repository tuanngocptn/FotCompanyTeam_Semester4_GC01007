/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.worker;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import model.DataProcess;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Panda
 */
public class DoUploadImgActionSupport extends ActionSupport {

    private File file;
    private String codeWorker;

    public String getCodeWorker() {
        return codeWorker;
    }

    public void setCodeWorker(String codeWorker) {
        this.codeWorker = codeWorker;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public DoUploadImgActionSupport() {
    }

    public String execute() throws Exception {
        String destPath = "D:/hoctap/SEM4/ProjectSem4Strut2/web/images/avatars";
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
        url = "images/avatars/" + url;
        if(dataProcess.setAvata(codeWorker, url))
            return "index";
        return "error";
    }

}
