<%-- 
    Document   : ViewCareer
    Created on : Jan 6, 2017, 11:37:54 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<s:if test="%{careerForJson == null}">
    <s:action name="getLstCareerJson" executeResult="true" />
</s:if>
<s:else>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
            <link rel="stylesheet" type="text/css" href="css/css.css"/>
            <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
            <style type="text/css">
                .back-second{
                    padding: 0px;
                    background-color: white;
                    margin-top: 20px;
                    margin-bottom: 20px;
                    border-radius: 5px;
                }
            </style>
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
                        <a href="logout.action"><li class="col-md-2 text-center btn btn-warning" >Quay Lại</li></a>
                    </ul>
                </div>
                <div class="container text-center">
                    <h1 class="h3-text" style="color: white">Chi tiết dịch vụ !</h1>
                </div>
                <div class="back-second container" style="height: 100%">
                    <div style="height: 290px" class="col-md-12">
                        <div style="padding: 20px" class="col-md-6" >
                            <div class="img_hover1" style="height: 250px; width: 481px;border-radius: 5px; background-image:url(<s:property value="%{careerForJson.getImage()}"/>)">
                            </div>
                        </div>
                        <div style="padding: 20px" class="text-center col-md-6">
                            <h2 class="font-helveticaneue"><s:property value="%{careerForJson.getName()}"/></h2>
                            <h4 class="font-helveticaneue"><s:property value="%{careerForJson.getSlogan()}"/></h4>
                            <p><s:property value="%{careerForJson.getSortText()}"/></p>
                            <p>Giá 1 thợ / 1 ngày <s:property value="%{careerForJson.getPrice()}"/></p>
                        </div>
                    </div>
                    <div style="padding: 20px" class="text-center col-md-12">
                        <p><s:property value="%{careerForJson.getLongText()}"/></p>
                    </div>
                </div>
            </div>
        </body>
    </html>
</s:else>