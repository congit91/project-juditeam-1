<%-- 
    Document   : manage
    Created on : Jun 3, 2014, 7:17:35 PM
    Author     : Welcomes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management</title>
        <link href="../css/bootstrap-theme.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link href="../css/bootstrap.css" rel="stylesheet"/>
        <link href="../css/blog.css" rel="stylesheet"/>
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
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Quản lý <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/project1/Page?p=search-cb-vb">Quản lý tài khoản</a></li>
                                <li class="divider"></li>
                                <li><a href="/project1/Page?p=search-cb-dp">Quản lý người phụ trách</a></li>
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
                <div class="col-md-6" style="text-align: center">
                    <div class="jumbotron"style="background:gray">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span class="glyphicon glyphicon-lock"></span>
                                Đăng nhập hệ thống!
                            </div>
                            <div class="panel-body">

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6" style="text-align: center">
                    <div class="jumbotron"style="background:gray">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span class="glyphicon glyphicon-lock"></span>
                                Đăng nhập hệ thống!
                            </div>
                            <div class="panel-body">

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6" style="text-align: center">
                    <div class="jumbotron"style="background:gray">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span class="glyphicon glyphicon-lock"></span>
                                Đăng nhập hệ thống!
                            </div>
                            <div class="panel-body">

                            </div>
                        </div> 
                    </div>
                </div>
                <div class="col-md-6" style="text-align: center">
                    <div class="jumbotron"style="background:gray">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <span class="glyphicon glyphicon-lock"></span>
                                Đăng nhập hệ thống!
                            </div>
                            <div class="panel-body">

                            </div>
                        </div>
                    </div>
                </div>


            </div>
            <footer class="panel panel-success">
                <p>&copy; Company 2014 &ReverseEquilibrium;Design by JuDi Team</p>
            </footer>

        </div><!--/.container-->

        <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    </body>
</html>
