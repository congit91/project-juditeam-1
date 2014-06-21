<%-- 
    Document   : addmember
    Created on : Jun 3, 2014, 6:45:51 AM
    Author     : Welcomes
--%>
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
                            <h3><span class="glyphicon glyphicon-user"></span>${npt.getMaNPT() > 0 ? 'Thay đổi thông tin NPT' : 'Thêm người phụ trách'}</h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" action="/project1/nptmanage?id=${npt.getMaNPT()}" method="post">
                                <!-- /.UserName -->
                                <div class="form-group">                                    
                                    <div class="col-sm-12" >
                                        <input type="text" name="maNPT" value="${npt.getMaNPT()}" disabled class="form-control" id="inputEmail3">
                                    </div>
                                </div>
                                <!-- /.UserName -->
                                <div class="form-group">

                                    <div class="col-sm-12" >
                                        <input type="text" name="hoTen" value="${npt.getHoTen()}" class="form-control" id="inputEmail3" placeholder="Tên NPT">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="text" name="namSinh" value="${npt.getNamSinh()}" class="form-control" id="inputEmail3" placeholder="dd-MM-yyyy">
                                    </div>
                                </div>
                                <!-- /.FullName -->
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="text" name="queQuan" value="${npt.getQueQuan()}" class="form-control" id="inputEmail3" placeholder="Quê quán">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="text" name="hocVi" value="${npt.getHocVi()}" class="form-control" id="inputEmail3" placeholder="Học vị">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="text" name="chucVu" value="${npt.getChucVu()}" class="form-control" id="inputEmail3" placeholder="Chức vụ">
                                    </div>
                                </div>
                                <!-- /.Phone -->
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="text" name="SDT" value="${npt.getSDT()}" class="form-control" id="inputEmail3" placeholder="Số điện thoại">
                                    </div>
                                </div>
                                <!-- /.Email -->
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="email" name="email" value="${npt.getEmail()}" class="form-control" id="inputEmail3" placeholder="Email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <select class="form-control" name="diaPhuong">
                                            <c:if test="${npt.getDiaPhuong().getMaDP() > 0}">
                                                <option value="${npt.getDiaPhuong().getTenDP()}">${npt.getDiaPhuong().getTenDP()}</option>
                                            </c:if>
                                            <c:forEach items="${dpList}" var="dp">
                                                <c:if test="${dp.getNptList().size()<1}">
                                                    <option value="${dp.getTenDP()}">${dp.getTenDP()}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12" >
                                        <input type="submit" ${npt.getMaNPT() > 0 ? 'value="Sửa"' : 'value="Thêm mới"'} name="submit" class="btn btn-success"/>
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
