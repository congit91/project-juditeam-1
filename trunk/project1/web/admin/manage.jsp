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
                    <a class="navbar-brand" href="#">Hello Admin!</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Quản lí</a></li>
                        <li class="active"><a href="#">Thống kê</a></li>
                        <li class="active"><a href="/project1/authen?do=logout">Đăng xuất</a></li>
                    </ul>
                </div><!-- /.nav-collapse -->
            </div><!-- /.container -->
        </div><!-- /.navbar -->

        <div class="container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><b>Quản Lý Cái Gì Đây</b>
                    <a href="/project1/umanage?do=add">Add new</a>
                    <div class="row">
                        <div class="col-lg-5 col-lg-push-6">
                            <div class="input-group">
                                <div class="input-group-btn">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">

                                        <span class="glyphicon glyphicon-search"></span>
                                        <span class="caret"></span></button>

                                    <ul class="dropdown-menu">
                                        <li><a href="#">UserName</a></li>
                                        <li><a href="#">Email</a></li>
                                        <li><a href="#">Phone</a></li>
                                    </ul>
                                </div><!-- /btn-group -->
                                <input type="text" class="form-control">
                            </div><!-- /input-group -->
                        </div><!-- /.col-lg-6 -->
                    </div><!-- /.row -->
                </div>
                <div class="table-responsive">
                    <form name="formAdmin" action="" method="post">
                        <table class="table table-striped"> 
                            <!--                        <head>
                                                    <form class="navbar-form navbar-left" role="search">
                                                    </form>
                                                    </head>-->
                            <thead>
                                <tr>
                                    <th>Mã TK</th>
                                    <th>Tên TK</th>
                                    <th>Mật khẩu</th>
                                    <th>Họ tên</th>
                                    <th>Email</th>
                                    <th>Số ĐT</th>
                                    <th>Lựa chọn</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.tkList}" var="tkList">
                                    <tr>
                                        <td>${tkList.getMaTK()}</td>
                                        <td>${tkList.getTenTK()}</td>
                                        <td><input type="password" name="pwd" value="${tkList.getMatkhau()}" disabled></td>
                                        <td>${tkList.getHoTen()}</td>
                                        <td>${tkList.getEmail()}</td>
                                        <td>${tkList.getSDT()}</td>
                                        <td>
                                            <a href="/project1/umanage?do=edit&id=${tkList.getMaTK()}" ><span class="glyphicon glyphicon-wrench"></span></a>&nbsp;&nbsp;
                                            
                                            <a href="/project1/umanage?do=del&id=${tkList.getMaTK()}" onclick="return confirm('Bạn thực sự muốn xóa: ${tkList.getTenTK()}?')"><span class="glyphicon glyphicon-trash"></span></a>
                                        </td>
                                    </tr>  
                                </c:forEach>
                            </tbody>
                        </table>
                    </form>
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
