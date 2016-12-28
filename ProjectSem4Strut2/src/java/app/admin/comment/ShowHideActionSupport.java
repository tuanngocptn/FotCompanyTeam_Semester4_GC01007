/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.comment;

import com.opensymphony.xwork2.ActionSupport;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class ShowHideActionSupport extends ActionSupport {
    
    private String codeComment;
    private String statusComment;

    public String getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(String statusComment) {
        this.statusComment = statusComment;
    }
    
    public String getCodeComment() {
        return codeComment;
    }

    public void setCodeComment(String codeComment) {
        this.codeComment = codeComment;
    }
    
    public ShowHideActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if(this.statusComment.equals("show"))
            dataProcess.setStatusComment(codeComment, true);
        else
            dataProcess.setStatusComment(codeComment, false);
        return "admin";
    }
    
}
