/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.worker;

import com.opensymphony.xwork2.ActionSupport;
import entity.Worker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class AddWorkerActionSupport extends ActionSupport {

    private String codeWorker;
    private String codeCareer;
    private String user;
    private String pass;
    private String name;
    private String avatar;
    private String dateOfBirth;
    private long phone;
    private String email;
    private String adress;
    private DataProcess dataProcess;

    public String getCodeWorker() {
        return codeWorker;
    }

    public void setCodeWorker(String codeWorker) {
        this.codeWorker = codeWorker;
    }

    public String getCodeCareer() {
        return codeCareer;
    }

    public void setCodeCareer(String codeCareer) {
        this.codeCareer = codeCareer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public AddWorkerActionSupport() {
        dataProcess = new DataProcess();
    }
    
    @Override
    public String execute() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirthSql = df.parse(this.dateOfBirth);
        if(dataProcess.addWorker(codeWorker, codeCareer, user, pass, name, dateOfBirthSql, phone, email, adress))
            return "admin";
        addActionMessage("Có gì đó bị sai! Yêu cầu nhập lại =.=!");
        return "error";
    }
    
}
