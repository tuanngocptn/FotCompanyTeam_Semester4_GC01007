<%-- 
    Document   : Customer
    Created on : Dec 11, 2016, 10:19:59 AM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<s:if test="%{lstOrder == null}">
    <s:action name="checkHang" executeResult="true"/>
</s:if>
<s:else>
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
                <!--                <div class="container">
                                    
                <%--<s:form action="logout" method="POST" cssClass="col-sm-2 col-sm-offset-3">--%>
                <%--<s:submit value="Đăng Xuất" method="execute" cssClass="btn btn-warning"/>--%>
                <%--</s:form>--%>
            </div>-->
                <div class="container text-center">
                    <h1 class="h3-text" style="color: white">Thượng Đế Page !</h1>
                </div>
                <div class="container" id="content">
                    <div class="panel content-cus">
                        <table class="table table-hover table-condensed">
                            <tr class="warning">
                                <th>Mã Đơn</th>
                                <th>Tên Khách Hàng</th>
                                <th>Số Điện Thoại</th>
                                <th>Địa Điểm</th>
                                <th>Mã CV</th>
                                <th>Tổng CN</th>
                                <th>Ngày Bắt Đầu</th>
                                <th>Ngày Kết Thúc</th>
                                <th>Status</th>
                                <th>DSCN</th>
                                <!--<th>Sửa DSCN</th>-->
                                <th>Xoá</th>
                            </tr>
                            <s:set var="i" value="0"/>
                            <s:iterator var="order" value="lstOrder">
                                <tr class="warning">
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
                                        <s:if test="%{#order.lstWorker.size() > 0}">
                                            <a href="setIndexOrderCus?index=<s:property value="#i"/>&emailCustomer=<s:property value="#order.emailCustomer"/>">Đã có</a>
                                            <s:if test="%{#order.status == 'wait'}">
                                                -
                                                <a href="deleteOrderLstWorkerCus?codeOrder=<s:property value="#order.codeOrder"/>&emailCustomer=<s:property value="#order.emailCustomer"/>">Xoá</a>
                                            </s:if>
                                        </s:if>
                                        <s:else>
                                            <a href="editOrderLstWorkerCus?codeCareer=<s:property value="#order.codeCareer"/>&startDate=<s:property value="#order.startDate"/>&endDate=<s:property value="#order.endDate"/>&quantityWorker=<s:property value="#order.quantityWorker"/>&codeOrder=<s:property value="#order.codeOrder"/>&emailCustomer=<s:property value="#order.emailCustomer"/>">Chưa Có</a>
                                        </s:else>
                                    </td>
                                    <td>
                                        <s:if test="%{#order.status == 'wait'}">
                                            <a href="deleteOrderCus?codeOrder=<s:property value="#order.codeOrder"/>">Xoá</a>
                                        </s:if>
                                    </td>
                                </tr>
                                <s:set var="i" value="#i + 1"/>
                            </s:iterator>
                        </table>
                    </div>


                    <s:if test="%{lstWorkerLeisrure != null}">
                        <div class="container-fluid">
                            <s:set var="count" value="0"/>
                            <s:iterator var="worker" value="lstWorkerLeisrure">
                                <s:set var="count" value="#count + 1"/>
                                <div class="col-md-5 panel" style=" margin: 10px 46px 10px 46px">
                                    <div class="checkbox">
                                        <label class="checkbox-bootstrap">                                        
                                            <s:checkbox name="cbWorker%{#count}" id="%{#worker.getCodeWorker()}" onclick="tickCheckBoxActionListener(this.id, %{quantityWorker})"/>             
                                            <img class="col-md-6" src="<s:url value="%{#worker.getAvatar()}"/>" alt="Smiley face" height="164" width="194">
                                            <div class="col-md-6">
                                                <s:property value="#worker.getName()"/> <br>
                                                <s:property value="#worker.getDateOfBirth()"/>
                                            </div>
                                        </label>
                                    </div>
                                </div>
                            </s:iterator> 
                        </div>
                        <s:form action="#" id="editForm" method="POST" cssClass="form-inline col-md-4 col-md-offset-7">
                            <input name="sum" value="0" readonly="true" class="form-control col-md-3" style="color: white; background-color:rgba(0,0,0,0.7);"/>
                            <s:submit cssClass="btn btn-warning col-md-3 col-md-offset-1" value="Sửa" method="execute" disabled="true" id="btnUpdateLstWorker" onclick="setUrlWorkerCus(%{lstWorkerLeisrure.size()},%{codeOrder})"/>
                        </s:form>
                    </s:if>


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
    <script>
        function tickCheckBoxActionListener(str, size)
        {
            var sum = parseInt(document.getElementsByName("sum")[0].value);
            if (document.getElementById(str).checked)
                sum = sum + 1;
            else
                sum = sum - 1;
            document.getElementsByName("sum")[0].value = sum;
            if (sum === parseInt(size))
                document.getElementById("btnUpdateLstWorker").disabled = false;
            else
                document.getElementById("btnUpdateLstWorker").disabled = true;
        }

        function setUrlWorkerCus(size, codeOrder) {
            console.log("abc");
            var str = "";
            for (var i = 1; i < size + 1; i++) {
                var boo = document.getElementById(document.getElementsByName("cbWorker" + i)[0].id).checked;
                if (boo)
                    str = str + document.getElementsByName("cbWorker" + i)[0].id + "+";
            }
            document.getElementById("editForm").action = "doUpdateLstWorkerCus?codeOrderDo=" + codeOrder + "&lstCbWorkerDo=" + str;
            console.log(document.getElementById("editForm").action);
        }
    </script>
</s:else>

