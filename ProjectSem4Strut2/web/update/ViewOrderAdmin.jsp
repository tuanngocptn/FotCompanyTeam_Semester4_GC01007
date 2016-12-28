<%-- 
    Document   : ViewOrderAdmin
    Created on : Dec 21, 2016, 2:47:25 PM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:set var="codeCareer" value="#session.worker.codeCareer"/>
<s:if test="%{#codeCareer != 'adm'}">
    <jsp:forward page="/index.jsp"/>
</s:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/css.css"/>
        <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
        <title>JSP Page</title>
    </head>
    <body>

        <div id="bodyDiv">
            <div id="topBar" class="container">
                <p id="logo"><strong>FOTCOMPANY</strong><p>
                <ul class="col-md-8">
                    <a href="index.jsp"><li class="col-md-2 col-md-offset-4 text-center " >Trang Chủ</li></a>
                    <a href="index.jsp"><li class="col-md-2 text-center" >Check Hàng</li></a>
                    <a href="index.jsp"><li class="col-md-2 text-center" >Đặt Gạch</li></a>
                    <a href="logout.action"><li class="col-md-2 text-center btn btn-warning" >Đăng Xuất</li></a>
                </ul>
            </div>
            <div class="container" id="content" style="min-height: 550px">
                <div class="col-md-5" style="position: fixed;">
                    <s:if test="%{order.status != 'wait'}">
                        <div style="padding-top: 20px; padding-bottom: 5px" class="panel content-cus">
                            <s:form action="doUpdateOrder" method="POST" cssClass="form-horizontal">
                                <div class="form-group">     
                                    <s:label value="Mã Đơn:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.codeOrder" readonly="true" value="%{order.getCodeOrder()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Tên Đầy Đủ:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.nameCustomer" readonly="true" value="%{order.getNameCustomer()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Email:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.emailCustomer" readonly="true"  value="%{order.getEmailCustomer()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>                                    <div class="form-group">     
                                    <s:label value="Số Điện Thoại:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.phone" readonly="true" value="%{order.getPhone()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Địa Điểm:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.location" readonly="true" value="%{order.getLocation()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Mã Công Việc:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.codeCareer" readonly="true" value="%{order.getCodeCareer()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Tổng Công Nhân:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.quantityWorker" readonly="true" value="%{order.getQuantityWorker()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Ngày Bắt Đầu:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.startDate" readonly="true" value="%{order.getStartDate()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Ngày Kết Thúc:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.endDate" readonly="true" value="%{order.getEndDate()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Status:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:if test="%{order.getStatus() == 'doing'}">
                                            <s:textfield value="Làm" cssClass="form-control" readonly="true" required="required"/>
                                        </s:if>
                                        <s:if test="%{order.getStatus() == 'done'}">
                                            <s:textfield value="Xong" name="nameCustomer" cssClass="form-control" readonly="true" required="required"/>
                                        </s:if>
                                        <s:if test="%{order.getStatus() == 'wait'}">
                                            <s:textfield value="Chờ" name="nameCustomer" cssClass="form-control" readonly="true" required="required"/>
                                        </s:if>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </s:if>
                    <s:else>
                        <div style="padding-top: 20px; padding-bottom: 40px" class="panel content-cus">
                            <s:form action="doUpdateOrder" method="POST" cssClass="form-horizontal">
                                <div class="form-group">     
                                    <s:label value="Mã Đơn:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.codeOrder" readonly="true" value="%{order.getCodeOrder()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Tên Đầy Đủ:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.nameCustomer" readonly="true" value="%{order.getNameCustomer()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Email:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.emailCustomer"  value="%{order.getEmailCustomer()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>                                    <div class="form-group">     
                                    <s:label value="Số Điện Thoại:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.phone"  value="%{order.getPhone()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Địa Điểm:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.location"  value="%{order.getLocation()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Mã Công Việc:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.codeCareer"  value="%{order.getCodeCareer()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Tổng Công Nhân:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.quantityWorker"  value="%{order.getQuantityWorker()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Ngày Bắt Đầu:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.startDate"  value="%{order.getStartDate()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Ngày Kết Thúc:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:textfield name="order.endDate"  value="%{order.getEndDate()}" cssClass="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">     
                                    <s:label value="Status:" cssClass="col-sm-4 control-label"/>
                                    <div class="col-sm-7">
                                        <s:if test="%{order.getStatus() == 'doing'}">
                                            <s:textfield value="Làm" cssClass="form-control" readonly="true" required="required"/>
                                        </s:if>
                                        <s:if test="%{order.getStatus() == 'done'}">
                                            <s:textfield value="Xong" name="nameCustomer" cssClass="form-control" readonly="true" required="required"/>
                                        </s:if>
                                        <s:if test="%{order.getStatus() == 'wait'}">
                                            <s:textfield value="Chờ" name="nameCustomer" cssClass="form-control" readonly="true" required="required"/>
                                        </s:if>
                                    </div>
                                </div>
                                <s:submit value="Update" method="execute" cssClass="btn btn-warning col-md-2 col-md-offset-9"/>
                            </s:form>
                        </div>
                    </s:else>
                </div>
                <s:if test="%{order.lstWorker.size() != 0}">
                    <div class="col-md-6 col-md-offset-6" style="margin-top: 5px;" > 
                        <div class="container-fluid" style="border-left: 2px dotted white">
                            <s:set var="count" value="0"/>
                            <s:iterator var="worker" value="order.lstWorker">
                                <s:set var="count" value="#count + 1"/>
                                <div class="col-md-11 panel" style=" margin: 10px 46px 10px 46px">
                                    <div class="checkbox">
                                        <label class="checkbox-bootstrap">                                        
                                            <img class="col-md-6" src="<s:url value="%{#worker.getAvatar()}"/>" alt="Smiley face" height="164" width="194">
                                            <div class="col-md-6">
                                                <s:property value="#worker.getName()"/> <br>
                                                <s:property value="#worker.getPhone()"/> <br>
                                                <s:property value="#worker.getDateOfBirth()"/> <br>
                                                <s:property value="#worker.getCodeWorker()"/> <br>
                                                <s:property value="#worker.getUser()"/> <br>
                                                <s:property value="#worker.getPass()"/> <br>
                                                <s:property value="#worker.getEmail()"/> <br>
                                                <s:property value="#worker.getAdress()"/> <br>
                                            </div>
                                        </label>
                                    </div>
                                </div>
                            </s:iterator> 
                        </div>
                    </div>
                </s:if>
            </div>
        </div>
    </body>
</html>