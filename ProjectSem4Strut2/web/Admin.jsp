<%-- 
    Document   : Admin
    Created on : Dec 2, 2016, 10:53:15 AM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:set var="codeCareer" value="#session.worker.codeCareer"/>
<s:if test="%{#codeCareer != 'adm'}">
    <jsp:forward page="/index.jsp"/>
</s:if>
<s:if test="%{lstCareer == null || lstOrder == null || lstWorker == null || lstComent == null}">
    <s:action name="adminView" executeResult="true"/>
</s:if>
<s:else>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Admin Page!</title>
            <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
            <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
            <link rel="stylesheet" type="text/css" href="css/css.css"/>
            <style type="text/css">
                * > input{
                    border-radius: 5px;
                }
                .paging-nav {
                    text-align: right;
                    padding-top: 2px;
                }

                .paging-nav a {
                    margin: auto 1px;
                    text-decoration: none;
                    display: inline-block;
                    padding: 1px 7px;
                    background: #f0ad4e;
                    color: white;
                    border-radius: 3px;
                }

                .paging-nav .selected-page {
                    background: #ec971f;
                    font-weight: bold;
                }

                .paging-nav,

                #tableData {
                    /*width: 400px;*/
                    /*margin: 0 auto;*/
                    font-family: Arial, sans-serif;
                }

                .tooltipp {
                    position: relative;
                    display: inline-block;
                    border-bottom: 1px dotted black;
                }

                .tooltipp .tooltipptext {
                    visibility: hidden;
                    width: 300px;
                    background-color: black;
                    color: #fff;
                    text-align: center;
                    border-radius: 6px;
                    padding: 5px 0;

                    /* Position the tooltipp */
                    position: absolute;
                    z-index: 1;
                }

                .tooltipp:hover .tooltipptext {
                    visibility: visible;
                }
            </style>
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

                <div id="content" class="container tab-content">
                    <div style="margin-top: 15px">
                        <s:form action="adminFind" method="POST" cssClass="form-inline">
                            <s:textfield name="txtFind" placeholder="Tìm Kiếm" cssClass="form-control col-md-2 col-md-offset-10" onchange="adminFind()"/>
                        </s:form>
                    </div>
                    <ul class="nav nav-tabs" style="margin-top: 15px">
                        <li class="active"><a data-toggle="tab" href="#home">Danh Sách Đơn Đặt Hàng</a></li>
                        <li><a data-toggle="tab" href="#menu1">Danh Sách Công Nhân</a></li>
                        <li><a data-toggle="tab" href="#menu2">Danh Sách Công Việc</a></li>
                    </ul>
                    <div class="tab-pane fade well" id="menu2" style="margin-top: 5px">
                        <h3></h3>
                        <s:form action="addCareer" method="POST">
                            <table id="tblCareer" class="table table-striped table-hover table-bordered table-condensed" >
                                <tr>
                                    <th>Mã Công Việc</th>
                                    <th>Tên Công Việc</th>
                                    <th>Đơn giá (1người/1ngày)</th>
                                    <th colspan="2"></th>
                                </tr>
                                <tr>
                                    <td><s:textfield name="codeCareer" required="required"/> <br></td>
                                    <td><s:textfield name="nameCareer" required="required"/><br></td>
                                    <td><s:textfield name="priceCareer" required="required"/><br></td>
                                    <td colspan="2"><s:submit method="execute" value="Thêm Công Việc" cssClass="btn btn-warning"/></td>
                                </tr>
                                <s:iterator var="career" value="lstCareer">
                                    <tr>
                                        <td><s:property value="#career.getCodeCareer()"/></td>
                                        <td><s:property value="#career.getNameCareer()"/></td>
                                        <td><s:property value="#career.getPriceCareer()"/></td>
                                        <td><a href="updateCareer?code=<s:property value="#career.getCodeCareer()"/>">Sửa</a></td>
                                        <td><a href="deleteCareer?code=<s:property value="#career.getCodeCareer()"/>">Xoá</a></td>
                                    </tr>
                                </s:iterator>
                            </table>
                        </s:form>
                    </div>

                    <div id="home" class="tab-pane fade well in active" style="margin-top: 5px">


                        <s:if test="%{lstWorkerLeisrure != null}">
                            <s:form action="#" id="editForm" method="POST">
                                <h4>Danh Sách Công Nhân Rảnh Rỗi</h4>

                                <table class="table table-striped table-hover table-bordered table-condensed text-center">
                                    <tr>
                                        <th>Mã Công Nhân</th>
                                        <th>Tên Đầy Đủ</th>
                                        <th>Ngày Sinh</th>
                                        <th>Số Điện Thoại</th>
                                        <th><input name="sum" value="0" readonly="true"/></th>
                                    </tr>
                                    <s:set var="count" value="1"/>
                                    <s:set var="boo" value="true"/>
                                    <s:iterator var="worker" value="lstWorkerLeisrure">
                                        <s:if test="%{#boo}">
                                            <s:set var="code" value="#worker.getPass()"/>
                                            <s:set var="boo" value="false"/>
                                        </s:if>
                                        <tr class="">
                                            <td><s:property value="#worker.getCodeWorker()"/> <s:property value=""/> </td>
                                            <td><s:property value="#worker.getName()"/></td>
                                            <td><s:property value="#worker.getDateOfBirth()"/></td>
                                            <td><s:property value="#worker.getPhone()"/></td>
                                            <td><s:checkbox name="cbWorker%{#count}" id="%{#worker.getCodeWorker()}" onclick="tickCheckBoxActionListener(this.id, %{quantityWorker})"/></td>
                                        </tr>
                                        <s:set var="count" value="#count + 1"/>
                                    </s:iterator>    
                                    <td><strong>Đơn Giá</strong></td>
                                    <td colspan="2" >
                                        <div class="tooltipp">Gợi ý:
                                            <span class="tooltipptext">Tổng Số Công Nhân x Số Ngày x Đơn Giá</span>
                                        </div>
                                        <p onclick="suggest()" id="suggest" style="display: inline; cursor: pointer"><s:property value="lstWorkerLeisrure.get(0).getAvatar()"/></p>
                                    </td>
                                    <td><input name="txtPriceOrder" value="0" type="number"/></td>
                                    <td>       
                                        <s:submit cssClass="btn btn-warning col-sm-4 col-sm-offset-1" value="Sửa" method="execute" disabled="true" id="btnUpdateLstWorker" onclick="setUrlWorker(%{lstWorkerLeisrure.size()},%{codeOrder})"/>
                                        <a class="btn btn-warning col-sm-4 col-sm-offset-2" href="Admin.jsp">Đóng</a>
                                    </td>
                                </table>
                            </s:form>
                        </s:if>

                        <table id="tableHome" class="table table-striped table-hover table-bordered table-condensed text-center" style="font-size: 13px">
                            <tr style="color:green">
                                <th>Stt</th>
                                <th>Họ Tên</th>
                                <th>Email</th>
                                <th>Số ĐT</th>
                                <th>Địa Điểm</th>
                                <th>CV</th>
                                <th>CN</th>
                                <th>Bắt Đầu</th>
                                <th>Kết Thúc</th>
                                <th colspan="2">Status</th>
                                <th>Giá</th>
                                <th>Công Nhân</th>
                                <th>Sửa-(Xoá)</th>
                            </tr>
                            <s:set var="i" value="1"/>
                            <s:iterator var="order" value="lstOrder">
                                <s:if test="%{#order.codeOrder == #code}">
                                    <tr style="color:blue" class="info">
                                    </s:if>
                                    <s:elseif test="%{#order.status == 'wait'}">
                                    <tr style="color: red" class="danger">
                                    </s:elseif>
                                    <s:else>
                                    <tr style="color:green" class="success">
                                    </s:else>
                                    <td><s:property value="#i"/> </td>
                                    <s:set var="i" value="#i+1"/>
                                    <td><s:property value="#order.nameCustomer"/></td>
                                    <td><s:property value="#order.emailCustomer"/></td>
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
                                        <s:if test="#order.status == 'doing'">
                                            <a href="setStatus?status=wait&codeOrder=<s:property value="#order.codeOrder"/>">Chờ</a>
                                        </s:if>
                                        <s:if test="%{#order.lstWorker.size() != 0 && #order.status == 'wait'}">
                                            <a href="setStatus?status=doing&codeOrder=<s:property value="#order.codeOrder"/>">Làm</a>
                                        </s:if>
                                        <s:set var="currentDate" value="%{new java.util.Date()}"/>
                                        <s:if test="%{#order.status == 'doing'  && !(#currentDate.before(#order.endDate))}">
                                            <a href="setStatus?status=done&codeOrder=<s:property value="#order.codeOrder"/>">Xong</a>
                                        </s:if>
                                    </td>
                                    <td><s:property value="#order.priceOrder"/></td>
                                    <td>
                                        <s:if test="%{#order.lstWorker.size() == 0}">
                                            <a href="editOrderLstWorker?codeCareer=<s:property value="#order.codeCareer"/>&startDate=<s:property value="#order.startDate"/>&endDate=<s:property value="#order.endDate"/>&quantityWorker=<s:property value="#order.quantityWorker"/>&codeOrder=<s:property value="#order.codeOrder"/>">Chưa Có</a>
                                        </s:if>
                                        <s:else>
                                            <a href="viewOrder?codeOrder=<s:property value="#order.codeOrder"/>">Đã Có</a>
                                            <s:if test="%{#order.status == 'wait'}">
                                                -
                                                <a href="deleteOrderLstWorker?codeOrder=<s:property value="#order.codeOrder"/>">(Xoá)</a>
                                            </s:if>
                                        </s:else>
                                    </td>
                                    <td>
                                        <s:if test="%{#order.status == 'wait'}">
                                            <a href="viewOrder?codeOrder=<s:property value="#order.codeOrder"/>">Sửa</a>
                                            <s:if test="%{#order.status != 'done'}">
                                                -
                                                <a href="deleteOrder?codeOrder=<s:property value="#order.codeOrder"/>">(Xoá)</a>
                                            </s:if>                 
                                        </s:if>

                                    </td>
                                </tr>
                            </s:iterator>
                        </table>


                    </div>

                    <div class="tab-pane fade well" id="menu1" style="margin-top: 5px">
                        <s:form action="addWorker"  method="POST"> 
                            <table id="tblWorker" class="table table-striped table-hover table-bordered table-condensed text-center" style="font-size: 13px">
                                <tr>
                                    <th>Mã CN</th>
                                    <th>Mã CV</th>
                                    <th>Tên Đăng Nhập</th>
                                    <th>Mật Khẩu</th>
                                    <th>Tên Đầy Đủ</th>
                                    <th>Ngày Sinh</th>
                                    <th>Số Điện Thoại</th>
                                    <th>Email</th>
                                    <th>Địa Chỉ</th>
                                    <th colspan="2"></th>
                                </tr> 
                                <tr>
                                    <td><s:textfield name="codeWorker" required="required" cssStyle="width: 50px"/></td>
                                    <td><s:textfield name="codeCareer" required="required" cssStyle="width: 50px"/></td>
                                    <td><s:textfield name="user" required="required"/></td>
                                    <td><s:textfield name="pass" required="required"/></td>
                                    <td><s:textfield name="name" required="required"/></td>
                                    <td><s:textfield name="dateOfBirth" type="date" required="required" cssStyle="width: 130px"/></td>
                                    <td><s:textfield name="phone" type="number" required="required"/></td>
                                    <td><s:textfield name="email" type="email" required="required"/></td>
                                    <td><s:textfield name="adress" required="required"/></td>
                                    <td colspan="2"><s:submit value="Thêm" method="execute" cssClass="btn btn-warning"/></td>
                                </tr>
                                <s:iterator var="worker" value="lstWorker">
                                    <tr>
                                        <td><s:property value="#worker.codeWorker"/></td>
                                        <td><s:property value="#worker.codeCareer"/></td>
                                        <td><s:property value="#worker.user"/></td>
                                        <td><s:property value="#worker.pass"/></td>
                                        <td><s:property value="#worker.name"/></td>
                                        <td><s:property value="#worker.dateOfBirth"/></td>
                                        <td><s:property value="#worker.phone"/></td>
                                        <td><s:property value="#worker.email"/></td>
                                        <td><s:property value="#worker.adress"/></td>
                                        <td><a href="updateWorker?codeWorker=<s:property value="#worker.codeWorker"/>">Sửa</a></td>
                                        <td><a href="deleteWorker?codeWorker=<s:property value="#worker.codeWorker"/>">Xoá</a></td>
                                    </tr>
                                </s:iterator>
                            </table>
                        </s:form>
                    </div>

                    <!--            <h3>Tất Cả Nhận Xét</h3>
                                <table border="1">
                                    <tr>
                                        <th>STT</th>
                                        <th>Khu Vực Cmt</th>
                                        <th>Người Cmt</th>
                                        <th>Thời Gian</th>
                                        <th>Nội Dung</th>
                                        <th>Trạng Thái</th>
                                        <th>Set TT</th>
                                        <th>Xoá</th>
                                    </tr>
                    <s:iterator var="comment" value="lstComent">
                        <tr>
                            <td><s:property value="#comment.codeComment"/></td>
                            <td><s:property value="#comment.areaComent"/></td>
                            <td><s:property value="#comment.user"/></td>
                            <td><s:property value="#comment.dateTime"/></td>
                            <td><s:property value="#comment.content"/></td>
                            <td>
                        <s:if test="%{#comment.status == 'show'}">
                            Hiện
                        </s:if>
                        <s:else>
                            Ẩn
                        </s:else>
                    </td>
                    <td><a href="showHideComment?codeComment=<s:property value="#comment.codeComment"/>&statusComment=<s:property value="#comment.status"/>">Ẩn/Hiện</a></td>
                    <td><a href="deleteComment?codeComment=<s:property value="#comment.codeComment"/>">Xoá</a></td>
                </tr>
                    </s:iterator>
                </table>-->
                </div>
            </div>
        </body>
    </html>

    <script>
        function suggest() {
            console.log(document.getElementById("suggest").innerHTML);
            document.getElementsByName("txtPriceOrder")[0].value = document.getElementById("suggest").innerHTML;
        }
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
        function setUrlWorker(size, codeOrder) {
            console.log(size);
            console.log(codeOrder);
            var str = "";
            for (var i = 1; i < size + 1; i++) {
                var boo = document.getElementById(document.getElementsByName("cbWorker" + i)[0].id).checked;
                if (boo)
                    str = str + document.getElementsByName("cbWorker" + i)[0].id + "+";
            }
            var priceOrder = document.getElementsByName("txtPriceOrder")[0].value;
            document.getElementById("editForm").action = "doUpdateLstWorker?codeOrderDo=" + codeOrder + "&priceOrder=" + priceOrder + "&lstCbWorkerDo=" + str;
        }
    </script>

    <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/paging.js"></script> 
    <script type="text/javascript">
        $(document).ready(function () {
            $('#tblWorker').paging({limit: 10});
            $('#tableHome').paging({limit: 10});
            $('#tblCareer').paging({limit: 10});
        });

    </script>
</s:else>