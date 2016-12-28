/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.order;

import com.opensymphony.xwork2.ActionSupport;
import entity.Worker;
import java.util.ArrayList;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class DoUpdateLstWorkerActionSupport extends ActionSupport {

    private String lstCbWorkerDo;

    private int codeOrderDo;

    public String getLstCbWorkerDo() {
        return lstCbWorkerDo;
    }

    public void setLstCbWorkerDo(String lstCbWorkerDo) {
        this.lstCbWorkerDo = lstCbWorkerDo;
    }

    public int getCodeOrderDo() {
        return codeOrderDo;
    }

    public void setCodeOrderDo(int codeOrderDo) {
        this.codeOrderDo = codeOrderDo;
    }

    public DoUpdateLstWorkerActionSupport() {
    }

    public String execute() throws Exception {
        String[] strArr = this.lstCbWorkerDo.split(" ");
        List<Worker> lstWorker = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            Worker worker = new Worker();
            worker.setCodeWorker(strArr[i]);
            lstWorker.add(worker);
        }
        DataProcess dataProcess = new DataProcess();
        if (dataProcess.updateListWorkerOrder(lstWorker, codeOrderDo, "doing")) {
            return "admin";
        }
        System.out.println(this.codeOrderDo + "  " + this.lstCbWorkerDo);
        return "error";
    }

}
