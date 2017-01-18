<%-- 
    Document   : index
    Created on : Dec 2, 2016, 10:17:57 AM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:if test="%{lstCareer == null || lstCareerJson == null}">
    <s:action name="getLstCareer" executeResult="true" />
</s:if>
<s:else>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
            <link rel="stylesheet" type="text/css" href="css/mycss.css"/>
            <style>
                /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
                @keyframes slidy {
                    0% { left: 0%; }
                    20% { left: 0%; }
                    25% { left: -100%; }
                    45% { left: -100%; }
                    50% { left: -200%; }
                    70% { left: -200%; }
                    75% { left: -300%; }
                    95% { left: -300%; }
                    100% { left: -400%; }
                }

                body { margin: 0; } 
                div#slider { overflow: hidden; }
                div#slider figure img { width: 20%; float: left; }
                div#slider figure { 
                    position: relative;
                    width: 500%;
                    margin: 0;
                    left: 0;
                    text-align: left;
                    font-size: 0;
                    animation: 30s slidy infinite; 
                }

            </style>
            <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
            <script type="text/javascript" src="js/prefixfree.min.js"></script>
        </head>
        <body>
            <div>
                <div class="bodyDiv">


                    <div id="back-first" style="">


                        <div class="bodyDiv" style="z-index: 0;">
                            <div id="slider" style="position: absolute; height: 100%">
                                <figure>
                                    <img src="images/back0.jpg" alt>
                                    <img src="images/back1.jpg" alt>
                                    <!--<img src="images/back2.jpg" alt>-->
                                    <img src="images/back3.jpg" alt>
                                    <img src="images/back4.jpg" alt>
                                    <img src="images/back0.jpg" alt>
                                </figure>
                            </div>
                            <div style="background-color: rgba(0,0,0,0.4); position: relative">
                                <div id="topBar" class="container">
                                    <p id="logo"><strong>FOTCOMPANY</strong><p>
                                    <ul class="col-md-8">
                                        <a href="index.jsp"><li class="col-md-2 col-md-offset-4 text-center " >Trang Chủ</li></a>
                                        <a href="#checkHangg"><li class="col-md-2 text-center showCheckHang" >Đơn Hàng</li></a>
                                        <a href="#datGach"><li class="col-md-2 text-center showDatGach" >Đặt Hàng</li></a>
                                        <a href="#dangNhap"><li class="col-md-2 text-center showDangNhap" >Đăng Nhập</li></a>
                                    </ul>
                                </div>

                                <div  class="" id="banner-top">
                                    <div id="banner-top-top" class="container text-center">
                                        <h1 class="h1-text">Fọt Company</h1>
                                        <h3 class="h3-text">Mọi Lúc - Mọi Nơi</h3>
                                        <p></p>
                                        <a href="#checkHangg" class="btn btn-warning showCheckHang col-sm-4 col-sm-offset-1 ">Đơn Hàng</a>
                                        <a href="#datGach" class="btn btn-warning showDatGach col-sm-4 col-sm-offset-2">Đặt Hàng</a>
                                        <a href="/ProjectSem4Strut2/ListCareer.jsp" class="btn btn-warning showDatGach col-sm-10 col-sm-offset-1" style="margin-top: 15px;">Danh Sách Dịch Vụ</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="content container" id="checkHangg">
                        <div  style="" >
                            <s:form action="checkHang" method="POST" cssClass="col-md-6 col-md-offset-3">
                                <div class="col-md-8">
                                    <s:textfield cssClass="form-control" name="emailCustomer" type="email" placeholder="Email" required="required"/>
                                </div>
                                <s:submit value="Đơn Hàng" method="execute" cssClass="col-md-3 col-md-offset-1 btn btn-warning"/>
                            </s:form>
                        </div>
                    </div>


                    <div class="back-second container" style="height: 580px">
                        <s:set var="careerJson" value="%{lstCareerJson.get(0)}"/>
                        <div style="height: 290px" class="col-md-12">
                            <div style="padding: 20px" class="col-md-6" >
                                <div class="img_hover1" style="height: 250px; width: 481px;border-radius: 5px; background-image:url(<s:property value="#careerJson.getImage()"/>)">
                                    <div class="img_congViec1">
                                        <div class="show_in1">
                                            <a href="#datGach" class="btn btn-warning showDatGach col-sm-4 col-sm-offset-4">Đặt Hàng</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div style="padding: 20px" class="text-center col-md-6">
                                <h2 class="font-helveticaneue"><s:property value="#careerJson.getName()"/></h2>
                                <h4 class="font-helveticaneue"><s:property value="#careerJson.getSlogan()"/></h4>
                                <p><s:property value="#careerJson.getSortText()"/></p>
                            </div>
                        </div>

                        <div style="height: 290px" class="col-md-12">
                            <s:set var="careerJson" value="%{lstCareerJson.get(1)}"/>
                            <div style="padding: 20px" class="col-md-6" >
                                <div class="img_hover2" style="height: 250px; width: 481px;border-radius: 5px; background-image:url(<s:property value="#careerJson.getImage()"/>)">
                                    <div class="img_congViec2">
                                        <div class="show_in2">
                                            <a href="#datGach" class="btn btn-warning showDatGach col-sm-4 col-sm-offset-4">Đặt Hàng</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div style="padding: 20px" class="text-center col-md-6">
                                <h2 class="font-helveticaneue"><s:property value="#careerJson.getName()"/></h2>
                                <h4 class="font-helveticaneue"><s:property value="#careerJson.getSlogan()"/></h4>
                                <p><s:property value="#careerJson.getSortText()"/></p>
                            </div>
                        </div>
                    </div>

                    <div class="container content" id="dangNhap">
                        <div  class="col-md-offset-3 col-md-8">
                            <s:form action="login" method="POST" cssClass="">
                                <div class="col-md-4">
                                    <s:textfield cssClass="form-control" name="user" placeholder="Tên Đăng Nhập" required="required"/>
                                </div>
                                <div class="col-md-4">
                                    <s:password cssClass="form-control" name="pass" placeholder="Mật Khẩu" required="required"/>
                                </div> 
                                <s:submit cssClass="btn btn-warning col-md-2" method="execute" value="Đăng Nhập"/>
                            </s:form>
                        </div>
                    </div>
                    <div class="back-second container" style="height: 580px">
                        <div style="height: 290px" class="col-md-12">
                            <s:set var="careerJson" value="%{lstCareerJson.get(2)}"/>
                            <div style="padding: 20px" class="text-center col-md-6">
                                <h2 class="font-helveticaneue"><s:property value="#careerJson.getName()"/></h2>
                                <h4 class="font-helveticaneue"><s:property value="#careerJson.getSlogan()"/></h4>
                                <p><s:property value="#careerJson.getSortText()"/></p>
                            </div>
                            <div style="padding: 20px" class="col-md-6" >
                                <div class="img_hover3" style="height: 250px; width: 481px;border-radius: 5px; background-image:url(<s:property value="#careerJson.getImage()"/>)">
                                    <div class="img_congViec3">
                                        <div class="show_in3">
                                            <a href="#datGach" class="btn btn-warning showDatGach col-sm-4 col-sm-offset-4">Đặt Hàng</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div style="height: 290px" class="col-md-12">
                            <s:set var="careerJson" value="%{lstCareerJson.get(3)}"/>
                            <div style="padding: 20px" class="text-center col-md-6">
                                <h2 class="font-helveticaneue"><s:property value="#careerJson.getName()"/></h2>
                                <h4 class="font-helveticaneue"><s:property value="#careerJson.getSlogan()"/></h4>
                                <p><s:property value="#careerJson.getSortText()"/></p>
                            </div>
                            <div style="padding: 20px" class="col-md-6" >
                                <div class="img_hover4" style="height: 250px; width: 481px;border-radius: 5px; background-image:url(<s:property value="#careerJson.getImage()"/>)">
                                    <div class="img_congViec4">
                                        <div class="show_in4">
                                            <a href="#datGach" class="btn btn-warning showDatGach col-sm-4 col-sm-offset-4">Đặt Hàng</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="container content" id="datGach">
                        <div  class="container" style=""> 
                            <h2 class="text-center h2-text" style="color: white; margin-top: 40px; margin-bottom: 30px">Đặt Hàng Ngay</h2>
                            <div class="col-md-5 col-md-offset-3" style="margin-top: 20px">
                                <s:form action="addOrder" method="POST" name="addOrderForm" id="addOrderForm" cssClass="form-horizontal">
                                    <div class="form-group">     
                                        <s:label value="Tên Đầy Đủ:" cssClass="col-sm-5 control-label"/>
                                        <div class="col-sm-7">
                                            <s:textfield name="nameCustomer" cssClass="form-control" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">   
                                        <s:label value="Email:" cssClass="col-sm-5 control-label"/>
                                        <div class="col-sm-7">
                                            <s:textfield name="emailCustomer" type="email" cssClass="form-control" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">    
                                        <s:label value="Số Điện Thoại:" cssClass="col-sm-5 control-label"/>
                                        <div class="col-sm-7">
                                            <s:textfield name="phone" type="number"  cssClass="form-control" required="required"/>
                                        </div>
                                    </div>

                                    <div class="form-group"> 
                                        <s:label value="Địa Điểm:" cssClass="col-sm-5 control-label"/>
                                        <div class="col-sm-7">
                                            <s:textfield name="location" placeholder="" cssClass="form-control" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">    
                                        <s:label value="Công Việc Yêu Cầu:" cssClass="col-sm-5 control-label"/>
                                        <div class="col-sm-7">
                                            <s:select headerKey="-1" cssClass="form-control" headerValue="--Chọn--" list="lstCareer" listKey="codeCareer" listValue="nameCareer" name="codeCareer"/>
                                        </div>
                                    </div>
                                    <div class="form-group" >         
                                        <s:label value="Số Lượng Công Nhân:" cssClass="col-sm-5 control-label"/>
                                        <div class="col-sm-7">  
                                            <s:textfield name="quantityWorker" type="number" placeholder="" cssClass="form-control" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <s:label value="Ngày Bắt Đầu:" cssClass="col-sm-5 control-label"/>
                                        <div class="col-sm-7">
                                            <s:textfield name="startDate" type="date" cssClass="form-control" required="required" onchange="IsEmpty()"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <s:label value="Ngày Kết Thúc:" cssClass="col-sm-5 control-label"/>
                                        <div class="col-sm-7">
                                            <s:textfield name="endDate" type="date" cssClass="form-control" required="required" onchange="IsEmpty()"/>
                                        </div>
                                    </div>
                                    <s:submit method="execute" id="btnDatGach" value="Đặt Hàng" cssClass="btn btn-warning col-sm-4 col-sm-offset-8"/>
                                </s:form>
                            </div>
                        </div>
                    </div>
                    <div id="topBar" class="container" style="margin-top: 20px">
                        <p id="logo"><strong>FOTCOMPANY</strong><p>
                        <ul class="col-md-8">
                            <a href="index.jsp"><li class="col-md-2 col-md-offset-4 text-center " >Trang Chủ</li></a>
                            <a href="#checkHangg"><li class="col-md-2 text-center showCheckHang" >Đơn Hàng</li></a>
                            <a href="#datGach"><li class="col-md-2 text-center showDatGach" >Đặt Hàng</li></a>
                            <a href="#dangNhap"><li class="col-md-2 text-center showDangNhap" >Đăng Nhập</li></a>
                        </ul>
                    </div>
                </div>

            </div>
        </body>
    </html>
    <script>
        function IsEmpty() {
            var startDateLong = Date.parse(document.forms['addOrderForm'].startDate.value);
            var endDateLong = Date.parse(document.forms['addOrderForm'].endDate.value);
            var date = new Date();
            var curentDatelong = Date.parse(date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate());

            if (endDateLong < startDateLong
                    || endDateLong < curentDatelong
                    || startDateLong < curentDatelong) {
//                alert("Yêu cầu chọn ngày cẩn thận [validate hết rồi ko cần phải thử (_ _!) ] !");
//                document.getElementById("addOrderForm").action = "#";
//                return false;
                document.getElementById("btnDatGach").disabled = true;
            } else {
//                document.getElementById("addOrderForm").action = "addOrder";
//                alert("AAAA Diu Xuaa !");
//                return true;
                document.getElementById("btnDatGach").disabled = false;
            }
        }


        $(document).ready(function () {
            // Add smooth scrolling to all links
            $("a").on('click', function (event) {

                // Make sure this.hash has a value before overriding default behavior
                if (this.hash !== "") {
                    // Prevent default anchor click behavior
                    event.preventDefault();

                    // Store hash
                    var hash = this.hash;

                    // Using jQuery's animate() method to add smooth page scroll
                    // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
                    $('html, body').animate({
                        scrollTop: $(hash).offset().top
                    }, 800, function () {

                        // Add hash (#) to URL when done scrolling (default click behavior)
                        window.location.hash = hash;
                    });
                } // End if
            });
        });

        $(".img_hover1").hover(function () {
            $('.img_congViec1').slideToggle();
        });
        $(".img_hover2").hover(function () {
            $('.img_congViec2').slideToggle();
        });
        $(".img_hover3").hover(function () {
            $('.img_congViec3').slideToggle();
        });
        $(".img_hover4").hover(function () {
            $('.img_congViec4').slideToggle();
        });
    </script>
</s:else>