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
                <div class="col-md-1">
                    <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
                        Tạo mới
                    </button>
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3><span class="glyphicon glyphicon-plus"></span> &nbsp;Thêm mới địa phương</h3>
                                    </div>
                                    <div class="panel-body">
                                        <form class="form-horizontal" role="form" action="/project1/dpmanage" method="post">
                                            <!-- TÊN XÃ -->

                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Tên xã</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="maTK" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Tên xã</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="maTK" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Số điện thoại</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="maTK" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Nơi nhận</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="maTK" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Diện tích</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="maTK" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Số dân</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="maTK" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>                                     
                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-6" >
                                                    <input type="submit" value="Thêm mới"name="submit" class="btn btn-primary"/>
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
                <div class="col-md-1">
                    <button class="btn btn-success btn-sm" data-toggle="modal" data-target="#1myModal">
                        Thêm thông tin địa phương
                    </button>
                    <div class="modal fade" id="1myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="col-lg-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3><span class="glyphicon glyphicon-th"></span>&nbsp;Thêm thông tin địa phương</h3>
                                    </div>
                                    <div class="panel-body">
                                        <form class="form-horizontal" role="form" action="/project1/umanage?id=${tkList.getMaTK()}" method="post">
                                            <!--Địa phương-->
                                            <div class="form-group">
                                                <div class="col-sm-3" >
                                                    <label class="label label-info" style="padding: 5px;font-size:13px">Địa phương</label>
                                                </div>
                                                <div class="col-sm-9" >
                                                    <select class="form-control" name="diaphuong">
                                                        <c:forEach items="${dpList}" var="dpList">
                                                            <option value="${dpList.getTenDP()}">${dpList.getTenDP()}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <!--Người phụ trách-->
                                            <div class="form-group">
                                                <div class="col-sm-3" >
                                                    <label class="label label-info" style="padding: 5px;font-size:13px">Người phụ trách</label>
                                                </div>
                                                <div class="col-sm-9" >
                                                    <select class="form-control" name="diaphuong">
                                                        <c:forEach items="${dpList}" var="dpList">
                                                            <option value="${dpList.getTenDP()}">${dpList.getTenDP()}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <!--Tiêu chí-->
                                            <div class="form-group">
                                                <div class="col-sm-3" >
                                                    <label class="label label-info" style="padding: 5px;font-size:13px">Tiêu chí</label>
                                                </div>
                                                <div class="col-sm-9" >
                                                    <input type="text" name="maTK" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <!--Nội Dung-->
                                            <div class="form-group">
                                                <div class="col-sm-3" >
                                                    <label class="label label-info" style="padding: 5px;font-size:13px">Nội dung</label>
                                                </div>
                                                <div class="col-sm-9" >
                                                    <input type="text" name="maTK" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-6" >
                                                    <input type="submit" value="Thêm mới"name="submit" class="btn btn-success"/>
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


                <div class="row">
                    <div class="col-lg-5 col-lg-push-5">
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
            <div class="panel-heading">

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
                                <th>Mã</th>
                                <th>Tên Xã</th>
                                <th>Số ĐT</th>
                                <th>Nơi nhận</th>
                                <th>Diện tích</th>
                                <th>Số dân</th>
                                <th>Lựa chọn</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.dpList}" var="dpList">
                            <tr>
                                <td>${dpList.getMaDP()}</td>
                                <td>${dpList.getTenDP()}</td>
                                <td>${dpList.getSDT()}</td>
                                <td>${dpList.getNoiNhan()}</td>
                                <td>${dpList.getDienTich()}</td>
                                <td>${dpList.getSoDan()}</td>
                                <td>
                                    <a href="/project1/umanage?do=edit&id=${dpList.getMaDP()}" ><span class="glyphicon glyphicon-wrench"></span></a>&nbsp;&nbsp;

                                    <a href="/project1/umanage?do=del&id=${dpList.getMaDP()}" onclick="return confirm('Bạn thực sự muốn xóa: ${dpList.getTenDP()}?')"><span class="glyphicon glyphicon-trash"></span></a>
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
