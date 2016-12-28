/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.order;

import com.opensymphony.xwork2.ActionSupport;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class DeleteOrderActionSupport extends ActionSupport {
    
    private int codeOrder;

    public int getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }
    
    
    public DeleteOrderActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if(dataProcess.deleteOrder(codeOrder))
            return "admin";
        addActionMessage("Có gì đó bị sai!~.~");
        return "error";
    }
    
}
