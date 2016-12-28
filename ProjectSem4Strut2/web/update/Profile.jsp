<%-- 
    Document   : Profile
    Created on : Dec 11, 2016, 12:32:07 PM
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
            <h1 style="color: white; text-align: center" >Sửa thông tin Công Nhân!</h1>
            <div id="content" class="container" style="padding: 20px">
                <div class="col-md-4">
                    <s:form  action="doUploadImg?codeWorker=%{#worker.getCodeWorker()}" method="post" enctype="multipart/form-data">
                        <input type="file" name="file" style="display: inline-block; color: white"/>
                        <s:submit cssStyle="display: inline-block" cssClass="btn btn-warning"/>
                    </s:form>
                    <img style="padding: 10px; border-radius: 15px" src="<s:url value="%{#worker.getAvatar()}"/>" alt="Smiley face" height="auto" width="100%">
                </div>

                <div class="col-md-8 form_frofile" style="padding-top: 40px">
                    <s:form action="doUpdateProfile" method="POST" cssClass="form-horizontal"> 
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Mã Công Nhân" cssClass="control-label col-sm-4" />
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="codeWorker" readonly="true" value="%{#worker.getCodeWorker()}" required="required"/><br>

                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Mã Công Việc" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="codeCareer" value="%{#worker.getCodeCareer()}" readonly="true" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Tên Đăng Nhập" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="user" value="%{#worker.getUser()}" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Mật Khẩu" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="pass" value="%{#worker.getPass()}" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Tên Đầy Đủ" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="name" value="%{#worker.getName()}" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Ngày Sinh" cssClass="control-label col-sm-4" placeholder="Ngày/Tháng/Năm"/>
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="dateOfBirth" value="%{#worker.getDateOfBirth()}" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Số Điện Thoại" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="phone" type="number" value="%{#worker.getPhone()}" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block"> 
                            <s:label value="Email" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="email" type="email" value="%{#worker.getEmail()}" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Địa Chỉ" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="adress" value="%{#worker.getAdress()}" required="required"/><br>
                            </div>
                        </div>
                        <div class="form-group col-md-6" style="display: inline-block">
                            <s:label value="Link Avartar" cssClass="control-label col-sm-4"/>
                            <div class="col-sm-8">
                                <s:textfield cssClass="form-control" name="avatar" value="%{#worker.getAvatar()}" readonly="true" required="required" /><br>
                            </div>
                        </div>
                        <div class="form-group col-md-12" style="display: inline-block">
                            <s:submit  cssClass="col-md-4 col-md-offset-7 btn btn-warning" value="Cập Nhật Thay Đổi" method="execute"/>
                        </div>
                    </s:form>
                </div>
            </div>
        </div>
    </body>
    <style type="text/css">
        .form_frofile{
            color: white;
        }
    </style>
</html>
