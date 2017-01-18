/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ADMIN
 */
public class Mail {

    private final String subject;
    private final String content;
    private final String toEmail;
    final String username = "photcompany@gmail.com";
    final String password = "A123@123";

    private void sent() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage mimemsg = new MimeMessage(session);
            mimemsg.addRecipients(Message.RecipientType.TO, toEmail);
            mimemsg.setHeader("Content-Type", "text/plain; charset=UTF-8");
            mimemsg.setSubject(this.subject, "UTF-8");
            mimemsg.setContent(this.content, "text/html; charset=UTF-8");
            Transport.send(mimemsg);
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
//            message.setSubject(this.subject);
//            message.setContent(this.content, "text/html; charset=UTF-8");
//            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public Mail(String subject, String content, String toEmail) {
        this.subject = subject;
        this.content = content;
        this.toEmail = toEmail;
        this.sent();
    }

    public static void main(String[] args) {
        String content = "<table border='1'><tr><th>Mã Đơn</th><th>Tên Khách Hàng</th><th>Số Điện Thoại</th><th>Địa Điểm</th><th>Mã CV</th><th>Tổng CN</th><th>Ngày Bắt Đầu</th><th>Ngày Kết Thúc</th><th>Status</th><th>DSCN</th><th>Đơn Giá</th><th>Xoá</th></tr></table>";
        Mail mail = new Mail("Đặt gạch tại Fọt căm pà ly thành công", content, "tuanngocptn@gmail.com");
    }

}
