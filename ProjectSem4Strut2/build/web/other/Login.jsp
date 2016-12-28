<%-- 
    Document   : Login
    Created on : Dec 1, 2016, 3:05:05 PM
    Author     : Panda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <img src="images/avatars/default-avatar.png" width="180" height="180">
        <s:form action="login" method="POST">
            <s:label value="User Name:"/>
            <s:textfield name="user"/><br>
            <s:label value="PassWord:"/>
            <s:password name="pass"/><br>
            <s:submit method="execute" value="Login"/>
        </s:form>
    </body>
</html>
