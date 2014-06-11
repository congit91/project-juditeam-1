<%-- 
    Document   : manage-users
    Created on : Jun 9, 2014, 10:20:07 AM
    Author     : Welcomes
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="alert alert-danger" style="text-align: center"><b>QUẢN LÝ TÀI KHOẢN NGƯỜI SỬ DỤNG </b></div>
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">
                <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#1myModal">
                    Tạo mới tài khoản
                </button>
                <div class="modal fade" id="1myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3><span class="glyphic on glyphicon-user"></span>Tạo mới tài khoản</h3>
                                </div>
                                <div class="panel-body">
                                    <form class="form-horizontal" role="form" action="/project1/umanage" method="post">
                                        <!-- /.UserName -->
                                        <div class="form-group">                                    
                                            <div class="col-sm-12" >
                                                <input type="text" name="maTK" disabled class="form-control" id="inputEmail3">
                                            </div>
                                        </div>
                                        <!-- /.UserName -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="text" name="tenTK" class="form-control" id="inputEmail3" placeholder="Tên tài khoản">
                                            </div>
                                        </div>
                                        <!-- /.Password -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="password" name="matkhau" class="form-control" id="inputEmail3" placeholder="Mật khẩu">
                                            </div>
                                        </div>
                                        <!-- /.FullName -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="text" name="hoTen" class="form-control" id="inputEmail3" placeholder="Họ và tên">
                                            </div>
                                        </div>
                                        <!-- /.Email -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="email" name="email" class="form-control" id="inputEmail3" placeholder="Email">
                                            </div>
                                        </div>
                                        <!-- /.Phone -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="text" name="SDT" class="form-control" id="inputEmail3" placeholder="Số điện thoại">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-12" >
                                                <input type="submit" value="Thêm mới" name="submit" class="btn btn-success"/>
                                                &nbsp;
                                                <button type="reset" class="btn btn-warning">Clear</button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-5 col-lg-push-6">
                        <form action="/project1/umanage?do=search" method="post">
                            <div class="col-md-11">

                                <div class="input-group">

                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="glyphicon glyphicon-search"></span>
                                            <span class="caret"></span></button>

                                    </div><!-- /btn-group -->

                                    <input type="text" name="userName" class="form-control" placeholder="Nhập tên tài khoản muốn tìm...">

                                </div><!-- /input-group -->
                            </div><!-- /input-group -->
                            <div class="col-md-1">
                                <input type="submit" name="submit" value="Tìm kiếm" class="btn btn-default dropdown-toggle" style="background:#3e8f3e;color:#ffffff">
                            </div>
                        </form>
                    </div><!-- /.col-lg-6 -->
                </div><!-- /.row -->
            </div>

            <div class="panel panel-default">
                <div class="col-md-1" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Mã TK</div>
                <div class="col-md-1" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Tên TK</div>
                <div class="col-md-3" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Họ Tên</div>
                <div class="col-md-3" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Email</div>
                <div class="col-md-2" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Điện Thoại</div>
                <div class="col-md-2" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Lựa chọn</div>
            </div>
            <c:forEach items="${tkList}" var="tkList">
                <div class="panel panel-title">
                    <div class="col-md-1" style="text-transform: inherit;padding:5px">${tkList.getMaTK()}</div>
                    <div class="col-md-1" style="text-transform: inherit;padding:5px" >${tkList.getTenTK()}</div>
                    <div class="col-md-3" style="text-transform: inherit;padding:5px">${tkList.getHoTen()}</div>
                    <div class="col-md-3" style="text-transform: inherit;padding:5px">${tkList.getEmail()}</div>
                    <div class="col-md-2" style="text-transform: inherit;padding:5px">${tkList.getSDT()}</div>
                    <div class="col-md-2" style="text-transform: inherit;padding:5px">
                        <!-- Công mi sửa chổ này nghe-->

                        <!--Edit-->
                        <div class="col-md-6">
                            <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
                                <span class="glyphicon glyphicon-wrench"></span>
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="col-lg-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <h3><span class="glyphic on glyphicon-user"></span>Thay đổi thông tin tài khoản</h3>
                                            </div>
                                            <div class="panel-body">
                                                <form class="form-horizontal" role="form" action="/project1/umanage?id=${tkList.getMaTK()}" method="post">
                                                    <!-- /.UserName -->
                                                    <div class="form-group">                                    
                                                        <div class="col-sm-12" >
                                                            <input type="text" name="maTK" value="${tkList.getMaTK()}" disabled class="form-control" id="inputEmail3">
                                                        </div>
                                                    </div>
                                                    <!-- /.UserName -->
                                                    <div class="form-group">

                                                        <div class="col-sm-12" >
                                                            <input type="text" name="tenTK" value="${tkList.getTenTK()}" ${tkList.getMaTK() > 0 ? 'disabled' : ''} class="form-control" id="inputEmail3" placeholder="Tên tài khoản">
                                                        </div>
                                                    </div>
                                                    <!-- /.Password -->
                                                    <div class="form-group">

                                                        <div class="col-sm-12" >
                                                            <input type="password" name="matkhau" value="${tkList.getMatkhau()}" class="form-control" id="inputEmail3" placeholder="Mật khẩu">
                                                        </div>
                                                    </div>
                                                    <!-- /.FullName -->
                                                    <div class="form-group">

                                                        <div class="col-sm-12" >
                                                            <input type="text" name="hoTen" value="${tkList.getHoTen()}" class="form-control" id="inputEmail3" placeholder="Họ và tên">
                                                        </div>
                                                    </div>
                                                    <!-- /.Email -->
                                                    <div class="form-group">

                                                        <div class="col-sm-12" >
                                                            <input type="email" name="email" value="${tkList.getEmail()}" class="form-control" id="inputEmail3" placeholder="Email">
                                                        </div>
                                                    </div>
                                                    <!-- /.Phone -->
                                                    <div class="form-group">

                                                        <div class="col-sm-12" >
                                                            <input type="text" name="SDT" value="${tkList.getSDT()}" class="form-control" id="inputEmail3" placeholder="Số điện thoại">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12" >
                                                            <input type="submit" ${tkList.getMaTK() > 0 ? 'value="Sửa"' : 'value="Thêm mới"'} name="submit" class="btn btn-success"/>
                                                            &nbsp;
                                                            <button type="reset" class="btn btn-warning">Clear</button>
                                                        </div>
                                                    </div>

                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--Delete-->
                        <div class="col-md-6">
                            <a href="/project1/umanage?do=del&id=${tkList.getMaTK()}" onclick="return confirm('Bạn thực sự muốn xóa: ${tkList.getTenTK()}?')" class="btn btn-primary btn-sm" role="button"><span class="glyphicon glyphicon-trash"></span></a>
                        </div>
                    </div>
                </div>                               
            </c:forEach>                             

        </div>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
    </body>
</html>
