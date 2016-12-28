<%-- 
    Document   : Error
    Created on : Dec 1, 2016, 3:05:33 PM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lỗi!</title>
        <!--        <style type="text/css">
                    * ul{
                        text-align: center;
                    }
                    * ul li {
                        color: red;
                    }
                </style>-->
        <link rel="stylesheet" href="//localhost:8084/ProjectSem4Strut2/css/error/reset.min.css">
        <link rel="stylesheet" href="//localhost:8084/ProjectSem4Strut2/css/error/error.css">
    </head>
    <body>
        <div id="world"></div>
        <div id="instructions">Ê ê... Dốt ốt...!<br/><br/><span class="lightInstructions"><s:actionmessage cssStyle=""/></span></div>

        <div id="credits">
            <!--<p> <a href="http://codepen.io/Yakudoo/"  target="blank">my other codepens</a> | <a href="http://epic.net" target="blank">epic.net</a></p>-->
        </div>
        <script src='//localhost:8084/ProjectSem4Strut2/js/error/three.min.js'></script>
        <script src='//localhost:8084/ProjectSem4Strut2/js/error/OrbitControls.js'></script>
        <script src="//localhost:8084/ProjectSem4Strut2/js/error/error.js"></script>

        <!--<h1 style="font-size: 200px; text-align: center; height: 600px" >Ê ê... Dốt ốt...!</h1>-->
        <%--<s:actionmessage cssStyle=""/>--%>
    </body>
</html>
<script type="text/javascript">
    for (var i = 0; i < 256; i++) {
        document.body.style.backgroundColor = "rgba(i,i,i,0.4)";
    }


</script>
