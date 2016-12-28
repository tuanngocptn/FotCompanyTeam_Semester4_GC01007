/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.worker;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Panda
 */
public class SetIndexOrderActionSupport extends ActionSupport {
    
    private int index;
    
    public SetIndexOrderActionSupport() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public String execute() throws Exception {
        return "worker";
    }
    
}
