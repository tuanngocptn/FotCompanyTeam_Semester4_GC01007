/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.worker;

import com.opensymphony.xwork2.ActionSupport;
import controller.Mail;
import entity.Order;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class SetDoneActionSupport extends ActionSupport {

    private int codeOrder;

    public int getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }

    public SetDoneActionSupport() {
    }

    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if (dataProcess.setStatusOrder(codeOrder, "done")) {
            List<Order> lstOrder = dataProcess.getOrder();
            Order order = new Order();
            for(Order od:lstOrder){
                if(od.getCodeOrder() == codeOrder){
                    order = od;
                    break;
                }
            }
            String subject = "Thông báo Hoàn Thành công việc tại Fọt Căm Pà Ly";
            String Content = "<p>Dear: " + order.getNameCustomer() + "<br><br>Công Việc của bạn đã hoàn thành sau đây là thông tin:</p><table border='1'><tr><th>Mã Đơn</th><th>Tên Khách Hàng</th><th>Số Điện Thoại</th><th>Địa Điểm</th><th>Mã CV</th><th>Tổng CN</th><th>Ngày Bắt Đầu</th><th>Ngày Kết Thúc</th><th>Status</th><th>Đơn Giá</th></tr><tr><td>" + order.getCodeOrder() + "</td><td>" + order.getNameCustomer() + "</td><td>" + order.getPhone() + "</td><td>" + order.getLocation() + "</td><td>" + order.getCodeCareer() + "</td><td>" + order.getQuantityWorker() + "</td><td>" + order.getStartDate() + "</td><td>" + order.getEndDate() + "</td><td>" + order.getStatus() + "</td><td>" + order.getPriceOrder() + "</td></tr></table><br><p>cảm ơn bạn đã sử dụng dịch vụ của chúng tôi bạn có thể kiểm tra toàn bộ dịch vụ bạn đã sử dụng của Fọt Căm Pà Ly tại link sau: <br> http://localhost:8084/ProjectSem4Strut2/checkHang?emailCustomer="+order.getEmailCustomer()+" <br><br>Thanks and Best Regards!</p>";
            Mail m = new Mail(subject, Content, order.getEmailCustomer());
            return "worker";
        }
        return "error";
    }

}
