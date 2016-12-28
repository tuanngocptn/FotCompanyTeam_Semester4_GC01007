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
public class Comment {
    private int codeComment;
    private String areaComent;
    private String user;
    private Date dateTime;
    private String content;
    private String status;

    public Comment() {
    }

    public Comment(int codeComment, String areaComent, String user, Date dateTime, String content, String status) {
        this.codeComment = codeComment;
        this.areaComent = areaComent;
        this.user = user;
        this.dateTime = dateTime;
        this.content = content;
        this.status = status;
    }

    public int getCodeComment() {
        return codeComment;
    }

    public void setCodeComment(int codeComment) {
        this.codeComment = codeComment;
    }

    public String getAreaComent() {
        return areaComent;
    }

    public void setAreaComent(String areaComent) {
        this.areaComent = areaComent;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
