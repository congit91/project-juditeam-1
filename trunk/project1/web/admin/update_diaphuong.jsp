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
                         <h3><span class="glyphicon glyphicon-user"></span>${dp.getMaDP() > 0 ?'Thay đổi thông tin ĐP' : 'Thêm mới địa phương'}</h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" action="/project1/dpmanage?id=${dp.getMaDP()}" method="post">
                                <!-- /.Mã VB -->
                                <div class="form-group">                                    
                                    <div class="col-sm-12" >
                                        <input type="text" name="maDP" value="${dp.getMaDP() }" disabled class="form-control" id="inputEmail3" placeholder="Mã văn bản">
                                    </div>
                                </div>
                                <!-- /.tên VB -->
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="text" name="tenDP" value="${dp.getTenDP()}" class="form-control" id="inputEmail3" placeholder="Tên văn bản">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="text" name="SDT" value="${dp.getSDT()}" class="form-control" id="inputEmail3" placeholder="Loại văn bản">
                                    </div>
                                </div>
                                <!-- /.Password -->
                                <div class="form-group">

                                    <div class="col-sm-12" >
                                        <input type="text" name="noiNhan" value="${dp.getNoiNhan()}" class="form-control" id="inputEmail3" placeholder="Nơi ban hành">
                                    </div>
                                </div>
                                <!-- /.FullName -->
                                <div class="form-group">

                                    <div class="col-sm-12" >
                                        <input type="text" name="dienTich" value="${dp.getDienTich()}" class="form-control" id="inputEmail3" placeholder="Ngày ban hành">
                                    </div>
                                </div>
                                <!-- /.Email -->
                                <div class="form-group">

                                    <div class="col-sm-12" >
                                        <input type="text" name="soDan" value="${dp.getSoDan()}" class="form-control" id="inputEmail3" placeholder="Nơi nhận">
                                    </div>
                                </div>
                                <!-- /.Phone -->
                             
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="submit" ${dp.getMaDP() > 0 ? 'value="Sửa"' : 'value="Thêm mới"'} name="submit" class="btn btn-success"/>
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
