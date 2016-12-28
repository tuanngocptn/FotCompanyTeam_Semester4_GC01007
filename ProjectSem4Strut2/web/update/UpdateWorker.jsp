<%-- 
    Document   : UpdateWorker
    Created on : Dec 5, 2016, 3:53:00 AM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="//localhost:8084/ProjectSem4Strut2/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="//localhost:8084/ProjectSem4Strut2/css/css.css"/>
        <script type="text/javascript" src="//localhost:8084/ProjectSem4Strut2/js/jquery-3.1.1.js"></script>
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
            <h1 style="color: white; text-align: center">Sửa thông tin Công Nhân!</h1>
            <div id="content" class="container" style="padding: 20px">
                <img class="col-md-4" style="padding: 10px; border-radius: 15px" src="<s:url value="%{worker.getAvatar()}"/>" alt="Smiley face" height="auto" width="100%">
                <div class="col-md-8" style="color: white">
                    <s:form action="doUpdateWorker" method="POST"> 
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Mã Công Nhân" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="codeWorker" readonly="true" value="%{worker.getCodeWorker()}" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Mã Công Việc" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="codeCareer" value="%{worker.getCodeCareer()}" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Tên Đăng Nhập" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="user" value="%{worker.getUser()}" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Mật Khẩu" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="pass" value="%{worker.getPass()}" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Tên Đầy Đủ" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="name" value="%{worker.getName()}" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Ảnh Đại Diện" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="avatar" value="%{worker.getAvatar()}" readonly="true" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Ngày Sinh" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="dateOfBirth" value="%{worker.getDateOfBirth()}" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Số Điện Thoại" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="phone" type="number" value="%{worker.getPhone()}" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Email" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="email" type="email" value="%{worker.getEmail()}" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Địa Chỉ" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield name="adress" value="%{worker.getAdress()}" cssClass="form-control" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-12" style="display: inline-block">
                            <s:submit cssClass="btn btn-warning col-sm-4 col-sm-offset-8" value="Cập Nhật Thay Đổi" method="execute"/>
                        </div>
                    </s:form>
                </div>
            </div>
        </div>
    </body>
</html>
