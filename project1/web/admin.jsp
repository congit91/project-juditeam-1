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
        <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                </div>
                <div class="col-md-12">
                    <ul class="nav navbar-nav">
                        <li><a  class="active"href="/project1/admin.jsp">Administrator</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Quản lý <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/project1/Page?p=manage-user">Quản lý tài khoản</a></li>
                                <li class="divider"></li>
                                <li><a href="/project1/Page?p=manage-diaphuong">Quản lý người phụ trách</a></li>
                            </ul>
                        </li>
                        <li><a href="/project1/Page?p=about">Thống kê</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="/project1/home.jsp">Trang chủ</a></li>
                        <li><a href="/project1/authen?do=logout"><span class="glyphicon glyphicon-th-large"  >Đăng xuất</span></a></li>
                    </ul>
                </div>
            </div><!-- /.container -->
        </div><!-- /.navbar -->
        <div class="container">
            <div class="row">
                <c:if test="${p == 'manage'}">
                    <%@include file="admin/manage.jsp" %>
                </c:if>
                <c:if test="${p == 'adduser'}">
                    <%@include file="admin/adduser.jsp" %>
                </c:if>
                <c:if test="${p == 'manage-user'}">
                    <%@include file="admin/manage-users.jsp" %>
                </c:if>
                <c:if test="${p == 'manage-diaphuong'}">
                    <%@include file="admin/manage-diaphuong.jsp" %>
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
