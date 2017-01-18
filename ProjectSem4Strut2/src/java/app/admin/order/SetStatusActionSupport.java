/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin.order;

import com.opensymphony.xwork2.ActionSupport;
import controller.Mail;
import entity.Order;
import entity.Worker;
import java.util.List;
import model.DataProcess;

/**
 *
 * @author Panda
 */
public class SetStatusActionSupport extends ActionSupport {
    
    private String status;
    private int codeOrder ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }
    
    
    public SetStatusActionSupport() {
    }
    
    public String execute() throws Exception {
        DataProcess dataProcess = new DataProcess();
        if(dataProcess.setStatusOrder(codeOrder, status)){
            if(status.equals("done"))
            {
            List<Order> orders = dataProcess.getOrder();
            Order order = new Order();
            for(Order or : orders){
                if(or.getCodeOrder() == codeOrder){
                    order = or;
                    break;
                }
            }
                String subject = "Thông báo Hoàn Thành công việc tại Fọt Căm Pà Ly";
                String Content = "<p>Dear: " + order.getNameCustomer() + "<br><br>Công Việc của bạn đã hoàn thành sau đây là thông tin:</p><table border='1'><tr><th>Mã Đơn</th><th>Tên Khách Hàng</th><th>Số Điện Thoại</th><th>Địa Điểm</th><th>Mã CV</th><th>Tổng CN</th><th>Ngày Bắt Đầu</th><th>Ngày Kết Thúc</th><th>Status</th><th>Đơn Giá</th></tr><tr><td>" + order.getCodeOrder() + "</td><td>" + order.getNameCustomer() + "</td><td>" + order.getPhone() + "</td><td>" + order.getLocation() + "</td><td>" + order.getCodeCareer() + "</td><td>" + order.getQuantityWorker() + "</td><td>" + order.getStartDate() + "</td><td>" + order.getEndDate() + "</td><td>" + order.getStatus() + "</td><td>" + order.getPriceOrder() + "</td></tr></table><br><p>cảm ơn bạn đã sử dụng dịch vụ của chúng tôi bạn có thể kiểm tra toàn bộ dịch vụ bạn đã sử dụng của Fọt Căm Pà Ly tại link sau: <br> http://localhost:8084/ProjectSem4Strut2/checkHang?emailCustomer="+order.getEmailCustomer()+" <br><br>Thanks and Best Regards!</p>";
                Mail m = new Mail(subject, Content, order.getEmailCustomer());
            }
            if(status.equals("doing"))
            {
            String htmlLstWorker = "";
            List<Order> orders = dataProcess.getOrder();
            Order order = new Order();
            for(Order or : orders){
                if(or.getCodeOrder() == codeOrder){
                    order = or;
                    break;
                }
            }
            List<Worker> lstWorker = order.getLstWorker();
            List<Worker> lstWorkerMain = dataProcess.getWorkers();
            for (Worker wk : lstWorker) {
                for (Worker worker : lstWorkerMain) {
                    if (wk.getCodeWorker().equals(worker.getCodeWorker())) {
                        htmlLstWorker = htmlLstWorker + "<tr>";
                        htmlLstWorker = htmlLstWorker + "<td>" + worker.getName() + "</td>";
                        htmlLstWorker = htmlLstWorker + "<td>" + worker.getPhone()+ "</td>";
                        htmlLstWorker = htmlLstWorker + "<td>" + worker.getDateOfBirth() + "</td>";
                        htmlLstWorker = htmlLstWorker + "<td>" + worker.getCodeCareer() + "</td>";
                        htmlLstWorker = htmlLstWorker + "<td>" + worker.getUser() + "</td>";
                        htmlLstWorker = htmlLstWorker + "<td>" + worker.getEmail() + "</td>";
                        htmlLstWorker = htmlLstWorker + "<td>" + worker.getAdress() + "</td>";
                        htmlLstWorker = htmlLstWorker + "</tr>";
                    }
                }
            }
            String subject = "Thông báo tiến độ Công Việc tại Fọt Căm Pà Ly";
            String Content = "<p>Dear: " + order.getNameCustomer() + "<br><br>Đơn đặt hàng của bạn đã được chấp nhận sau đây là thông tin:</p><table border='1'><tr><th>Mã Đơn</th><th>Tên Khách Hàng</th><th>Số Điện Thoại</th><th>Địa Điểm</th><th>Mã CV</th><th>Tổng CN</th><th>Ngày Bắt Đầu</th><th>Ngày Kết Thúc</th><th>Status</th><th>Đơn Giá</th></tr><tr><td>" + order.getCodeOrder() + "</td><td>" + order.getNameCustomer() + "</td><td>" + order.getPhone() + "</td><td>" + order.getLocation() + "</td><td>" + order.getCodeCareer() + "</td><td>" + order.getQuantityWorker() + "</td><td>" + order.getStartDate() + "</td><td>" + order.getEndDate() + "</td><td>" + order.getStatus() + "</td><td>" + order.getPriceOrder() + "</td></tr></table> <br><p>Danh sách công nhân trực tiếp tham gia</p><br><table border='1'><tr><th>Tên</th><th>Số ĐT</th><th>Ngày Sinh</th><th>Mã CN</th><th>Tài Khoản</th><th>Email</th><th>Quê Quán</th></tr>"
                    +htmlLstWorker+ "</table><br><br><p>cảm ơn bạn đã sử dụng dịch vụ của chúng tôi bạn có thể kiểm tra tiến độ công việc của bạn tại link sau: <br> http://localhost:8084/ProjectSem4Strut2/checkHang?emailCustomer="+order.getEmailCustomer()+" <br><br>Thanks and Best Regards!</p>";
            Mail m = new Mail(subject, Content, order.getEmailCustomer());
            }
            return "admin";
        }
        return "error";
    }
    
}
