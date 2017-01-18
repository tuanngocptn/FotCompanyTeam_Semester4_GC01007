<%-- 
    Document   : ListCareer
    Created on : Jan 5, 2017, 3:52:15 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<s:if test="%{lstCareerJson == null}">
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
            <s:form id="myForm" action="viewCareer" method="POST">
                <%--<s:hidden name="lstCareerJson" value="#lstCareerJson"/>--%>
            </s:form>
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
                    <h1 class="h3-text" style="color: white">Danh Sách Dịch Vụ !</h1>
                </div>
                <div class="back-second container" style="height: 100%">
                    <s:iterator var="careerJson" value="lstCareerJson">
                        <a onclick="runForm('<s:property value="#careerJson.code"/>')" style="color: black; cursor: pointer;">
                            <div style="height: 290px" class="col-md-12">
                                <div style="padding: 20px" class="col-md-6" >
                                    <div class="img_hover1" style="height: 250px; width: 481px;border-radius: 5px; background-image:url(<s:property value="#careerJson.image"/>)">
                                    </div>
                                </div>

                                <div style="padding: 20px" class="text-center col-md-6">
                                    <h2 class="font-helveticaneue"><s:property value="#careerJson.name"/></h2>
                                    <h4 class="font-helveticaneue"><s:property value="#careerJson.slogan"/></h4>
                                    <p><s:property value="#careerJson.sortText"/></p>
                                    <p>Giá 1 thợ / 1 ngày <s:property value="#careerJson.price"/></p>
                                </div>
                            </div>
                        </a>
                    </s:iterator>
                </div>
                <div id="topBar" class="container">
                    <p id="logo"><strong>FOTCOMPANY</strong><p>
                    <ul class="col-md-8">
                        <a href="index.jsp"><li class="col-md-2 col-md-offset-4 text-center " >Trang Chủ</li></a>
                        <a href="index.jsp"><li class="col-md-2 text-center" >Check Hàng</li></a>
                        <a href="index.jsp"><li class="col-md-2 text-center" >Đặt Gạch</li></a>
                        <a href="logout.action"><li class="col-md-2 text-center btn btn-warning" >Quay Lại</li></a>
                    </ul>
                </div>
            </div>
        </body>
    </html>
    <script type="text/javascript">
        function runForm(code){
            document.getElementById("myForm").action = "viewCareer?code="+code;
            document.getElementById("myForm").submit();
        }
    </script>
</s:else>
