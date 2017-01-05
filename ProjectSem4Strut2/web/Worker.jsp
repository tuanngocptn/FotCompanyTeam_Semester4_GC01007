<%-- 
    Document   : Worker
    Created on : Dec 2, 2016, 11:22:06 AM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<s:set var="worker" value="#session.worker"/>
<s:set var="codeCareer" value="#session.worker.codeCareer"/>
<s:if test="%{#worker == null || #codeCareer == 'adm'}">
    <jsp:forward page="/index.jsp"/>
</s:if>
<s:if test="%{lstOrder == null}">
    <s:action name="workerView" executeResult="true"/>
</s:if>
<s:else>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
            <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
            <link rel="stylesheet" type="text/css" href="css/css.css"/>
        </head>
        <body>
            <div id="bodyDiv">
                <div id="topBar" class="container ">
                    <p id="logo"><strong>FOTCOMPANY</strong><p>
                    <ul class="col-md-8">
                        <a href="index.jsp"><li class="col-md-2 col-md-offset-4 text-center " >Trang Chủ</li></a>
                        <a href="index.jsp"><li class="col-md-2 text-center" >Check Hàng</li></a>
                        <a href="index.jsp"><li class="col-md-2 text-center" >Đặt Gạch</li></a>
                        <a href="logout.action" ><li class="col-md-2 text-center btn btn-warning" >Đăng Xuất</li></a>
                    </ul>
                </div>
                <div id="content" class="container">
                    <h1 style="color: white">Worker Page!</h1>
                    <s:form action="updateProfile" method="POST" cssClass="form-inline">
                        <div class="form-group">
                            <s:textfield name="codeWorker" value="%{#worker.codeWorker}" disabled="true" cssClass="form-control" required="required"/>
                            <s:textfield name="name" value="%{#worker.name}" disabled="true" cssClass="form-control" required="required"/> 
                        </div>
                        <s:submit value="Cập Nhật Thông Tin" method="execute" cssClass="btn btn-warning"/>
                    </s:form>
                    <div class="panel" style="margin-top: 15px">
                        <table class="table table-hover table-condensed text-center">
                            <tr>
                                <th>Mã Đơn</th>
                                <th>Tên Khách Hàng</th>
                                <th>Số Điện Thoại</th>
                                <th>Địa Điểm</th>
                                <th>Mã CV</th>
                                <th>Tổng CN</th>
                                <th>Ngày Bắt Đầu</th>
                                <th>Ngày Kết Thúc</th>
                                <th>Status</th>
                                <th>Sửa Status</th>
                                <th>Chi Tiết</th>
                            </tr>
                            <s:set var="i" value="0"/>
                            <s:iterator var="order" value="lstOrder">
                                <tr>
                                    <td><s:property value="#order.codeOrder"/></td>
                                    <td><s:property value="#order.nameCustomer"/></td>
                                    <td><s:property value="#order.phone"/></td>
                                    <td><s:property value="#order.location"/></td>
                                    <td><s:property value="#order.codeCareer"/></td>
                                    <td><s:property value="#order.quantityWorker"/></td>
                                    <td><s:property value="#order.startDate"/></td>
                                    <td><s:property value="#order.endDate"/></td>
                                    <td><s:if test="%{#order.status == 'doing'}">
                                            Làm
                                        </s:if>
                                        <s:if test="%{#order.status == 'done'}">
                                            Xong
                                        </s:if>
                                        <s:if test="%{#order.status == 'wait'}">
                                            Chờ
                                        </s:if>
                                    </td>
                                    <td>
                                        <s:set var="currentDate" value="%{new java.util.Date()}"/>
                                        <s:if test="%{#order.status == 'doing' && !(#currentDate.before(#order.endDate))}">
                                            <a href="workerSetStatus?codeOrder=<s:property value="#order.codeOrder"/>">Xong</a>
                                        </s:if>
                                    </td>
                                    <td><a href="setIndexOrder?index=<s:property value="#i"/>">Chi Tiết</a></td>
                                </tr>
                                <s:set var="i" value="#i + 1"/>
                            </s:iterator>
                        </table>
                    </div>
                    <s:if test="%{lstOrder.get(index).getLstWorker().size() != 0}">
                        <div class="container-fluid">
                            <s:set var="count" value="0"/>
                            <s:iterator var="worker" value="lstOrder.get(index).getLstWorker()">
                                <s:set var="count" value="#count + 1"/>
                                <div class="col-md-5 panel" style=" margin: 10px 46px 10px 46px">
                                    <div class="checkbox">
                                        <label>                                        
                                            <img class="col-md-6" src="<s:url value="%{#worker.getAvatar()}"/>" alt="Smiley face" height="164" width="194">
                                            <div class="col-md-6">
                                                <s:property value="#worker.getName()"/> <br>
                                                <s:property value="#worker.getPhone()"/> <br>
                                                <s:property value="#worker.getDateOfBirth()"/> <br>
                                                <s:property value="#worker.getCodeWorker()"/> <br>
                                                <s:property value="#worker.getUser()"/> <br>
                                                <s:property value="#worker.getEmail()"/> <br>
                                                <s:property value="#worker.getAdress()"/> <br>
                                            </div>
                                        </label>
                                    </div>
                                </div>
                            </s:iterator> 
                        </div>
                    </s:if>
                </div>
            </div>
        </body>
    </html>
</s:else>
