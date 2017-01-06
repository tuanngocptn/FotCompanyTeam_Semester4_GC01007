<%-- 
    Document   : UpdateCareer
    Created on : Dec 4, 2016, 5:05:01 PM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:set var="codeCareer" value="#session.worker.codeCareer"/>
<s:if test="%{#codeCareer != 'adm'}">
    <jsp:forward page="/index.jsp"/>
</s:if>
<s:else>
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
                <h1 style="color: white; text-align: center">Sửa Công Việc!</h1>
                <div id="content" class="container" style="padding: 20px">

                    <div class="col-md-12">
                        <div class="form-group col-md-7 col-md-offset-4" >
                            <s:form action="doUploadImgCareerJson?code=%{career.getCodeCareer()}" method="post" enctype="multipart/form-data">
                                <input type="file" name="file" style="display: inline-block; color: white"/>
                                <s:submit cssStyle="display: inline-block" cssClass="btn btn-warning"/>
                            </s:form>
                        </div>
                    </div>

                    <div class="col-md-12 form_frofile" style="padding-top: 20px; color:white">
                        <s:form action="doUpdateCareer" method="POST">
                            <div class="form-group col-md-7 col-md-offset-2" >
                                <s:label value="Ảnh"  cssClass="control-label col-sm-4"/>
                                <div class="col-sm-8">
                                    <s:textfield readonly="true" cssClass="form-control"  name="careerForJson.image" value="%{careerForJson.getImage()}" required="required"/><br>
                                </div>
                            </div>
                            <div class="form-group col-md-7 col-md-offset-2">
                                <s:label value="Mã Công Việc"  cssClass="control-label col-sm-4"/>
                                <div class="col-sm-8">
                                    <s:textfield cssClass="form-control"  name="careerForJson.code" value="%{career.getCodeCareer()}" readonly="true" /> <br>
                                </div>
                            </div>
                            <div class="form-group col-md-7 col-md-offset-2" >
                                <s:label value="Tên Công Việc"  cssClass="control-label col-sm-4"/>
                                <div class="col-sm-8">
                                    <s:textfield cssClass="form-control"  name="careerForJson.name" value="%{career.getNameCareer()}" required="required"/><br>
                                </div>
                            </div>
                            <div class="form-group col-md-7 col-md-offset-2" >
                                <s:label value="Đơn giá (1người/1ngày)"  cssClass="control-label col-sm-4"/>
                                <div class="col-sm-8">
                                    <s:textfield cssClass="form-control"  name="careerForJson.price" value="%{career.getPriceCareer()}" required="required"/><br>
                                </div>
                            </div>
                            <div class="form-group col-md-7 col-md-offset-2" >
                                <s:label value="Slogan"  cssClass="control-label col-sm-4"/>
                                <div class="col-sm-8">
                                    <s:textfield cssClass="form-control"  name="careerForJson.slogan" value="%{careerForJson.getSlogan()}" required="required"/><br>
                                </div>
                            </div>

                            <div class="form-group col-md-7 col-md-offset-2" >
                                <s:label value="Giới Thiệu Ngắn"  cssClass="control-label col-sm-4"/>
                                <div class="col-sm-8">
                                    <s:textfield cssClass="form-control"  name="careerForJson.sortText" value="%{careerForJson.getSortText()}" required="required"/><br>
                                </div>
                            </div>
                            <div class="form-group col-md-7 col-md-offset-2" >
                                <s:label value="Giới Thiệu Dài"  cssClass="control-label col-sm-4"/>
                                <div class="col-sm-8">
                                    <s:textfield cssClass="form-control"  name="careerForJson.longText" value="%{careerForJson.getLongText()}" required="required"/><br>
                                </div>
                            </div>
                            <div class="form-group col-md-7 col-md-offset-2" >
                                <s:label value="Vị Trí Xuất Hiện Tại Trang Chủ"  cssClass="control-label col-sm-4"/>
                                <div class="col-sm-8">
                                    <s:textfield cssClass="form-control"  name="careerForJson.show" value="%{careerForJson.getShow()}" required="required"/><br>
                                </div>
                            </div>
                            <div class="form-group col-md-7 col-md-offset-2" >
                                <s:submit cssClass="btn btn-warning col-md-offset-8" method="execute" value="Cập Nhật Thay Đổi"/>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </body>
    </html>
</s:else>