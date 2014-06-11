<%-- 
    Document   : manage-users
    Created on : Jun 9, 2014, 10:20:07 AM
    Author     : Welcomes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="alert alert-info" style="text-align: center"><b>NGƯỜI QUẢN LÝ ĐỊA PHƯƠNG </b></div>
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">
                <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
                    Add New
                </button>
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3><span class="glyphicon glyphicon-user"></span>${tk.getMaTK() > 0 ? 'Thay đổi thông tin tài khoản' : 'Thêm mới tài khoản'}</h3>
                                </div>
                                <div class="panel-body">
                                    <form class="form-horizontal" role="form" action="/project1/umanage?id=${tk.getMaTK()}" method="post">
                                        <!-- /.UserName -->
                                        <div class="form-group">                                    
                                            <div class="col-sm-12" >
                                                <input type="text" name="maTK" value="${tk.getMaTK()}" disabled class="form-control" id="inputEmail3">
                                            </div>
                                        </div>
                                        <!-- /.UserName -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="text" name="tenTK" value="${tk.getTenTK()}" ${tk.getMaTK() > 0 ? 'disabled' : ''} class="form-control" id="inputEmail3" placeholder="Tên tài khoản">
                                            </div>
                                        </div>
                                        <!-- /.Password -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="password" name="matkhau" value="${tk.getMatkhau()}" class="form-control" id="inputEmail3" placeholder="Mật khẩu">
                                            </div>
                                        </div>
                                        <!-- /.FullName -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="text" name="hoTen" value="${tk.getHoTen()}" class="form-control" id="inputEmail3" placeholder="Họ và tên">
                                            </div>
                                        </div>
                                        <!-- /.Email -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="email" name="email" value="${tk.getEmail()}" class="form-control" id="inputEmail3" placeholder="Email">
                                            </div>
                                        </div>
                                        <!-- /.Phone -->
                                        <div class="form-group">

                                            <div class="col-sm-12" >
                                                <input type="text" name="SDT" value="${tk.getSDT()}" class="form-control" id="inputEmail3" placeholder="Số điện thoại">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-12" >
                                                <input type="submit" ${tk.getMaTK() > 0 ? 'value="Sửa"' : 'value="Thêm mới"'} name="submit" class="btn btn-success"/>
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
    </body>
</html>
