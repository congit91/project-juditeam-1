<%-- 
    Document   : addmember
    Created on : Jun 3, 2014, 6:45:51 AM
    Author     : Welcomes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <title>Add Member</title>
        <style>
            body{
                padding:70px 0px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3><span class="glyphicon glyphicon-user"></span>${vb.getMaVB() > 0 ? 'Thay đổi thông tin văn bản' : 'Thêm mới văn bản'}</h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" action="/project1/vbmanage?id=${vb.getMaVB()}" method="post">
                                <!-- /.Mã VB -->
                                <div class="form-group">                                    
                                    <div class="col-sm-12" >
                                        <input type="text" name="maVB" value="${vb.getMaVB()}" disabled class="form-control" id="inputEmail3" placeholder="Mã văn bản">
                                    </div>
                                </div>
                                <!-- /.tên VB -->
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="text" name="tenVB" value="${vb.getTenVB()}" class="form-control" id="inputEmail3" placeholder="Tên văn bản">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="text" name="loaiVB" value="${vb.getLoaiVB()}" class="form-control" id="inputEmail3" placeholder="Loại văn bản">
                                    </div>
                                </div>
                                <!-- /.Password -->
                                <div class="form-group">

                                    <div class="col-sm-12" >
                                        <input type="text" name="noiBanHanh" value="${vb.getNoiBanHanh()}" class="form-control" id="inputEmail3" placeholder="Nơi ban hành">
                                    </div>
                                </div>
                                <!-- /.FullName -->
                                <div class="form-group">

                                    <div class="col-sm-12" >
                                        <input type="text" name="ngayBanHanh" value="${vb.getNgayBanHanh()}" class="form-control" id="inputEmail3" placeholder="Ngày ban hành">
                                    </div>
                                </div>
                                <!-- /.Email -->
                                <div class="form-group">

                                    <div class="col-sm-12" >
                                        <input type="text" name="noiNhan" value="${vb.getNoiNhan()}" class="form-control" id="inputEmail3" placeholder="Nơi nhận">
                                    </div>
                                </div>
                                <!-- /.Phone -->
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <textarea name="noiDung" class="col-md-12 form-control" style="margin-top: 5px" rows="4" id="inputEmail3" placeholder="Nội dung" >${vb.getNoiDung()}</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="submit" ${vb.getMaVB() > 0 ? 'value="Sửa"' : 'value="Thêm mới"'} name="submit" class="btn btn-success"/>
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
        <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    </body>
</html>
