<%-- 
    Document   : Success
    Created on : Dec 1, 2016, 3:05:42 PM
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
        <h1>Success!</h1>
        <s:property value="#session.worker.dateoOfBirth"/>
    </body>
</html>
