/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.opensymphony.xwork2.ActionSupport;
import entity.Worker;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Panda
 */
public class LogoutActionSupport extends ActionSupport implements SessionAware{

    Map<String, Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public LogoutActionSupport() {
    }

    public String execute() throws Exception {
        Worker worker = new Worker();
        session.remove("worker");
        return "index";
    }

}
