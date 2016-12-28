/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.opensymphony.xwork2.ActionSupport;
import entity.Worker;
import java.util.Map;
import model.DataProcess;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Panda
 */
public class LoginActionSupport extends ActionSupport implements SessionAware {
    
    Map<String, Object> session;
    private String user;
    private String pass;

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
    
    public LoginActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        Worker worker = dataProcess.checkLogin(user, pass);
        if(worker!=null)
        {
            session.put("worker", worker);
            if(worker.getCodeCareer().equals("adm"))
                return "admin";
            return "worker";
        }
        addActionMessage("Sai tên đăng nhập hoặc Mật khẩu!");
        return "failed";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
}
