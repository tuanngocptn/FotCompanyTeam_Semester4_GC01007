/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.customer;

import com.opensymphony.xwork2.ActionSupport;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class DeleteOrderActionCusSupport extends ActionSupport {
    
     private int codeOrder;

    public int getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }
    
    public DeleteOrderActionCusSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if(dataProcess.deleteOrder(codeOrder))
            return "index";
        addActionMessage("Có gì đó bị sai!~.~");
        return "error";
    }

    
}
