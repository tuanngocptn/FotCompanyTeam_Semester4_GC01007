/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Career;
import entity.Comment;
import entity.Order;
import entity.Worker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Panda
 */
public class DataProcess {

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = InfoDatabase.url;
            conn = DriverManager.getConnection(url, InfoDatabase.id, InfoDatabase.pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public Worker checkLogin(String user, String pass) {
        String sql = "SELECT * FROM tblWorker WHERE _user = '" + user + "' AND _pass = '" + pass + "'";
        ResultSet rs;
        try {
            rs = getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                String codeWorker = rs.getString(1);
                String codeCareer = rs.getString(2);
                String name = rs.getString(5);
                String avatar = rs.getString(6);
                Date dateOfBirth = this.plus2date(rs.getDate(7));
                long phone = rs.getLong(8);
                String email = rs.getString(9);
                String address = rs.getString(10);
                return new Worker(codeWorker, codeCareer, user, pass, name, avatar, dateOfBirth, phone, email, address);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Date plus2date(Date date) {
        return new Date(date.getTime() + (1000 * 60 * 60 * 24 * 2));
    }

    public List<Career> getCareer() {
        List<Career> lst = new ArrayList<>();
        String sql = "SELECT * FROM tblCareer";
        ResultSet rs;
        try {
            rs = getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                String codeCareer = rs.getString(1);
                String nameCareer = rs.getString(2);
                lst.add(new Career(codeCareer, nameCareer));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Career cr : lst) {
            if (cr.getCodeCareer().equals("adm")) {
                lst.remove(cr);
                break;
            }
        }
        return lst;
    }

    public List<Worker> getWorkers() {
        List<Worker> lst = new ArrayList<>();
        String sql = "SELECT * FROM tblWorker";
        ResultSet rs;
        try {
            rs = getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                String codeWorker = rs.getString(1);
                String codeCareer = rs.getString(2);
                String user = rs.getString(3);
                String pass = rs.getString(4);
                String name = rs.getString(5);
                String avatar = rs.getString(6);
                Date dateOfBirth = this.plus2date(rs.getDate(7));
                long phone = rs.getLong(8);
                String email = rs.getString(9);
                String address = rs.getString(10);
                lst.add(new Worker(codeWorker, codeCareer, user, pass, name, avatar, dateOfBirth, phone, email, address));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public List<Order> getOrder() {
        List<Order> lst = new ArrayList<>();
        String sql = "SELECT * FROM tblOrder";
        ResultSet rs;
        try {
            rs = getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                int codeOrder = rs.getInt(1);
                String nameCustomer = rs.getString(2);
                String emailCustomer = rs.getString(3);
                long phone = rs.getLong(4);
                String location = rs.getString(5);
                String codeCareer = rs.getString(6);
                int quantityWoker = rs.getInt(7);
                Date startDate = this.plus2date(rs.getDate(8));
                Date endDate = this.plus2date(rs.getDate(9));
                String status = rs.getString(10);
                String strWorkers = rs.getString(11);
                List<Worker> lstWorker = new ArrayList<>();
                if (!strWorkers.isEmpty()) {
                    Arrays.asList(strWorkers.split("#")).stream().forEach((str) -> {
                        lstWorker.add(this.getWorker(str));
                    });
                }
                Order od = new Order(codeOrder, nameCustomer, emailCustomer, phone, location, codeCareer, quantityWoker, startDate, endDate, status, lstWorker);
                lst.add(od);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Order> subLst = new ArrayList<>();
        for (int i = lst.size() - 1; i > -1; i--) {
            subLst.add(lst.get(i));
        }
        return subLst;
    }

    public List<Order> getOrderByCodeWorker(String codeWorker) {
        List<Order> lst = new ArrayList<>(), sublst = this.getOrder();
        for (Order order : sublst) {
            for (Worker worker : order.getLstWorker()) {
                if (codeWorker.equals(worker.getCodeWorker())) {
                    lst.add(order);
                    break;
                }
            }
        }
        return lst;
    }

    public List<Order> getOrderByEmail(String email) {
        List<Order> lst = new ArrayList<>();
        String sql = "SELECT * FROM tblOrder WHERE _emailCustomer = '" + email + "'";
        ResultSet rs;
        try {
            rs = getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                int codeOrder = rs.getInt(1);
                String nameCustomer = rs.getString(2);
                String emailCustomer = rs.getString(3);
                long phone = rs.getLong(4);
                String location = rs.getString(5);
                String codeCareer = rs.getString(6);
                int quantityWoker = rs.getInt(7);
                Date startDate = this.plus2date(rs.getDate(8));
                Date endDate = this.plus2date(rs.getDate(9));
                String status = rs.getString(10);
                String strWorkers = rs.getString(11);
                List<Worker> lstWorker = new ArrayList<>();
                if (!strWorkers.isEmpty()) {
                    Arrays.asList(strWorkers.split("#")).stream().forEach((str) -> {
                        lstWorker.add(this.getWorker(str));
                    });
                }
                Order od = new Order(codeOrder, nameCustomer, emailCustomer, phone, location, codeCareer, quantityWoker, startDate, endDate, status, lstWorker);
                lst.add(od);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public Worker getWorker(String codeWorker) {
        String sql = "SELECT * FROM tblWorker WHERE _codeWorker = '" + codeWorker + "'";
        ResultSet rs;
        Worker worker = new Worker();
        try {
            rs = getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                String codeCareer = rs.getString(2);
                String user = rs.getString(3);
                String pass = rs.getString(4);
                String name = rs.getString(5);
                String avatar = rs.getString(6);
                Date dateOfBirth = this.plus2date(rs.getDate(7));
                long phone = rs.getLong(8);
                String email = rs.getString(9);
                String address = rs.getString(10);
                worker = new Worker(codeWorker, codeCareer, user, pass, name, avatar, dateOfBirth, phone, email, address);
            }
            rs.close();
            return worker;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Comment> getComment() {
        List<Comment> lst = new ArrayList<>();
        String sql = "SELECT * FROM tblComment";
        ResultSet rs;
        try {
            rs = getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                int codeComment = rs.getInt(1);
                String areaComent = rs.getString(2);
                String user = rs.getString(3);
                Date dateTime = rs.getDate(4);
                Timestamp timestamp = rs.getTimestamp(4);
                Date date = new java.util.Date(timestamp.getTime());
                String content = rs.getString(5);
                String status = rs.getString(6);
                lst.add(new Comment(codeComment, areaComent, user, date, content, status));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public boolean addNewOrder(String nameCustomer, String emailCustomer, long phone, String location, String codeCareer, int quantityWorker, Date startDate, Date endDate, String status, List<Worker> lstWorker) {
        String sql = "INSERT INTO TblOrder VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            prst.setString(1, nameCustomer);
            prst.setString(2, emailCustomer);
            prst.setLong(3, phone);
            prst.setString(4, location);
            prst.setString(5, codeCareer);
            prst.setInt(6, quantityWorker);
            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            prst.setDate(7, sqlStartDate);
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
            prst.setDate(8, sqlEndDate);
            prst.setString(9, status);
            String strLstWorkers = "";
            if (!lstWorker.isEmpty()) {
                for (Worker worker : lstWorker) {
                    strLstWorkers = strLstWorkers + worker.getCodeWorker() + "#";
                }
            }
            prst.setString(10, strLstWorkers);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateOrder(Order order) {
        String sql = "UPDATE tblOrder SET _nameCustomer=?, _emailCustomer=?,_phoneCustomer=?,_location=?,_codeCareer=?,_quantityWoker=?,_startDate=?,_endDate=? WHERE _codeOrder=?";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            prst.setString(1, order.getNameCustomer());
            prst.setString(2, order.getEmailCustomer());
            prst.setLong(3, order.getPhone());
            prst.setString(4, order.getLocation());
            prst.setString(5, order.getCodeCareer());
            prst.setInt(6, order.getQuantityWorker());
            java.sql.Date sqlStartDate = new java.sql.Date(order.getStartDate().getTime());
            prst.setDate(7, sqlStartDate);
            java.sql.Date sqlEndDate = new java.sql.Date(order.getEndDate().getTime());
            prst.setDate(8, sqlEndDate);
            prst.setInt(9, order.getCodeOrder());
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean addCareer(String codeCareer, String nameCareer) {
        String sql = "INSERT INTO tblCareer VALUES(?,?)";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            prst.setString(1, codeCareer);
            prst.setString(2, nameCareer);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteCareer(String codeCareer) {
        String sql = "DELETE  FROM tblCareer WHERE _codeCareer = '" + codeCareer + "'";
        String sql2 = "SELECT * FROM tblWorker WHERE _codeCareer = '" + codeCareer + "'";
        PreparedStatement prst;
        ResultSet rs;
        try {
            rs = getConnection().createStatement().executeQuery(sql2);
            if (rs.next()) {
                return false;
            }
            prst = getConnection().prepareCall(sql);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Career getCareer(String code) {
        Career career = new Career();
        String sql = "SELECT _nameCareer FROM TblCareer WHERE _codeCareer ='" + code + "'";
        ResultSet rs;
        try {
            rs = getConnection().createStatement().executeQuery(sql);
            while (rs.next()) {
                career = new Career(code, rs.getString(1));
                break;
            }
            rs.close();
            return career;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return career;
    }

    public boolean updateCareer(String codeCareer, String nameCareer) {
        String sql = "UPDATE tblCareer SET _nameCareer = '" + nameCareer + "' WHERE _codeCareer = '" + codeCareer + "'";
        PreparedStatement prst;
        ResultSet rs;
        try {
            prst = getConnection().prepareCall(sql);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean setAvata(String codeWorker, String urlAvatar) {
        String sql = "UPDATE tblWorker SET _avatar = '" + urlAvatar + "' WHERE _codeWorker = '" + codeWorker + "'";
        PreparedStatement prst;
        ResultSet rs;
        try {
            prst = getConnection().prepareCall(sql);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean addWorker(String codeWorker, String codeCareer, String user, String pass, String name, Date dateOfBirth, long phone, String email, String adress) {
        String sql = "INSERT INTO tblWorker(_codeWorker,_codeCareer,_user,_pass,_name,_dateOfBirth,_phone,_email,_address) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            prst.setString(1, codeWorker);
            prst.setString(2, codeCareer);
            prst.setString(3, user);
            prst.setString(4, pass);
            prst.setString(5, name);
            prst.setDate(6, new java.sql.Date(dateOfBirth.getTime()));
            prst.setLong(7, phone);
            prst.setString(8, email);
            prst.setString(9, adress);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteWorker(String codeWorker) {
        String sql = "DELETE  FROM tblWorker WHERE _codeWorker = ?";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            prst.setString(1, codeWorker);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateWorker(String codeWorker, String codeCareer, String user, String pass, String name, String avatar, Date dateOfBirth, long phone, String email, String adress) {
        String sql = "UPDATE tblWorker SET  _codeCareer=? ,_user = ?,_pass=?,_name = ?,_avatar = ?, _dateOfBirth = ?, _phone = ?, _email = ?, _address = ? WHERE _codeWorker = ?";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            prst.setString(1, codeCareer);
            prst.setString(2, user);
            prst.setString(3, pass);
            prst.setString(4, name);
            prst.setString(5, avatar);
            prst.setDate(6, new java.sql.Date(dateOfBirth.getTime()));
            prst.setLong(7, phone);
            prst.setString(8, email);
            prst.setString(9, adress);
            prst.setString(10, codeWorker);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean setStatusComment(String codeStatus, boolean status) {
        String sql = "UPDATE tblComment SET _status = ? WHERE _codeComment =?";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            if (status) {
                prst.setString(1, "hide");
            } else {
                prst.setString(1, "show");
            }
            prst.setString(2, codeStatus);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteComment(String codeStatus) {
        String sql = "DELETE FROM tblComment WHERE _codeComment = ?";
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            prst.setString(1, codeStatus);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateListWorkerOrder(List<Worker> lstWorker, int codeOrder, String status) {
        String str = "";
        System.out.println(lstWorker.size());
        for (Worker worker : lstWorker) {
            str = str + worker.getCodeWorker() + "#";
        }
        String sql = "UPDATE tblOrder SET _status = '" + status + "', _lstWorkers = '" + str + "' WHERE _codeOrder=" + codeOrder;
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            prst.execute();
            prst.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Worker> getWorkerLeisrure(String codeCareer, Date startDate, Date endDate) {
        List<Order> lstOrderFull = this.getOrder(), lstOrder = new ArrayList<>();
        List<Worker> lstWorkerFull = this.getWorkers(), lstWorker = new ArrayList<>();
        List<Worker> lst = new ArrayList<>();
        for (Order order : lstOrderFull) {
            if (order.getCodeCareer().equals(codeCareer)) {
                lstOrder.add(order);
            }
        }
        for (Worker worker : lstWorkerFull) {
            if (worker.getCodeCareer().equals(codeCareer)) {
                lstWorker.add(worker);
            }
        }
        int i = 1;
        for (Worker worker : lstWorker) {
            boolean boo = true;
            for (Order order : lstOrder) {
                Date startOrderDate = order.getStartDate();
                Date endOrderDate = order.getEndDate();
                for (Worker wk : order.getLstWorker()) {
                    if (worker.getCodeWorker().equals(wk.getCodeWorker())) {
                        if (startDate.equals(startOrderDate)
                                || startDate.equals(endOrderDate)
                                || endDate.equals(endOrderDate)
                                || endDate.equals(startOrderDate)
                                || (startDate.after(startOrderDate) && endDate.before(endOrderDate))
                                || startDate.before(startOrderDate) && endDate.after(endOrderDate)) {
                            boo = false;
                        }
                    }
                    i++;
                }
            }
            if (boo) {
                lst.add(worker);
            }
        }
        return lst;
    }

    public boolean deleteOrder(int codeOrder) {
        String sql = "DELETE FROM tblOrder WHERE _codeOrder = " + codeOrder;
        PreparedStatement prst;
        try {
            prst = getConnection().prepareCall(sql);
            prst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean setStatusOrder(int codeOrder, String status) {
        String sql = "UPDATE tblOrder SET _status = '" + status + "' WHERE _codeOrder = " + codeOrder;
        PreparedStatement prst;
        System.out.println(sql);
        try {
            prst = getConnection().prepareCall(sql);
            prst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        DataProcess dataProcess = new DataProcess();
        System.out.println(dataProcess.getOrder().size());
    }
}
