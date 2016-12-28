/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Panda
 */
public class Worker {
    private String codeWorker;
    private String codeCareer;
    private String user;
    private String pass;
    private String name;
    private String avatar;
    private Date dateOfBirth;
    private long phone;
    private String email;
    private String adress;

    public Worker() {
    }

    public Worker(String codeWorker, String codeCareer, String user, String pass, String name, String avatar, Date dateoOfBirth, long phone, String email, String adress) {
        this.codeWorker = codeWorker;
        this.codeCareer = codeCareer;
        this.user = user;
        this.pass = pass;
        this.name = name;
        this.avatar = avatar;
        this.dateOfBirth = dateoOfBirth;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateoOfBirth) {
        this.dateOfBirth = dateoOfBirth;
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
   

    
    
}
