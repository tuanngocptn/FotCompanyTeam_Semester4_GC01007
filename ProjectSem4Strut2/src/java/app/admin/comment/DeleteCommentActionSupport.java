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
public class DeleteCommentActionSupport extends ActionSupport {
    
    private String codeComment;

    public String getCodeComment() {
        return codeComment;
    }

    public void setCodeComment(String codeComment) {
        this.codeComment = codeComment;
    }
    
    public DeleteCommentActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if(dataProcess.deleteComment(codeComment))
            return "admin";
        addActionMessage("Có gì đó bị sai!~.~");
        return "error";
    }
    
}
