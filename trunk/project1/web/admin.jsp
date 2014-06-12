<%-- 
    Document   : abc
    Created on : Jun 2, 2014, 10:47:30 PM
    Author     : Welcomes
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Page</title>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <style>
            body{
                padding:70px 0px;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <c:if test="${msgResult != null}">
                    <p style="color: red; font-weight: bold">${msgResult}</p>
                </c:if>
                <c:if test="${p == 'manage'}">
                    <%@include file="admin/nav-admin.jsp" %>    
                    <%@include file="admin/manage.jsp" %>
                </c:if>
                <c:if test="${p == 'adduser'}">
                    <%@include file="admin/nav-admin.jsp" %>
                    <%@include file="admin/adduser.jsp" %>
                </c:if>
                <c:if test="${p == 'adddoc'}">
                    <%@include file="admin/nav-admin.jsp" %>
                    <%@include file="admin/adddocu.jsp" %>
                </c:if>
                <c:if test="${p == 'manage-user'}">
                    <%@include file="admin/nav-admin.jsp" %>
                    <%@include file="admin/manage-users.jsp" %>
                </c:if>
                <c:if test="${p == 'manage-diaphuong'}">
                    <%@include file="admin/nav-admin.jsp" %>
                    <%@include file="admin/manage-diaphuong.jsp" %>
                </c:if>
                <c:if test="${p == 'manage-document'}">
                    <%@include file="admin/nav-admin.jsp" %>
                    <%@include file="admin/manage-document.jsp" %>
                </c:if>
                <c:if test="${p == 'login' || p == null}">
                    <%@include file="admin/login.jsp" %>
                </c:if>
            </div>
        </div>


        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
