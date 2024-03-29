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
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Mã ĐP</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="maDP" value="" disabled class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Tên ĐP</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="tenDP" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Số điện thoại</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="SDT" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Nơi nhận</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="noiNhan" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Diện tích</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="dienTich" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2" >
                                                    <label class="label label-primary" style="padding: 5px;font-size:13px">Số dân</label>
                                                </div>
                                                <div class="col-sm-10" >
                                                    <input type="text" name="soDan" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>                                     
                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-6" >
                                                    <input type="submit" value="Thêm mới" name="submit" class="btn btn-primary"/>
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
                    <!--cHO NAY NE CON-->
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
                                        <form class="form-horizontal" role="form" action="/project1/dpmanage" method="post">
                                            <!--Địa phương-->
                                            <div class="form-group">
                                                <div class="col-sm-3" >
                                                    <label class="label label-info" style="padding: 5px;font-size:13px">Địa phương</label>
                                                </div>
                                                <div class="col-sm-9" >
                                                    <select class="form-control" name="diaPhuong">
                                                        <c:forEach items="${dpList}" var="dpList">
                                                            <option value="${dpList.getTenDP()}">${dpList.getTenDP()}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <!--                                            Người phụ trách
                                                                                        <div class="form-group">
                                                                                            <div class="col-sm-3" >
                                                                                                <label class="label label-info" style="padding: 5px;font-size:13px">Người phụ trách</label>
                                                                                            </div>
                                                                                            <div class="col-sm-9" >
                                                                                                <select class="form-control" name="nguoiPhuTrach">
                                            <c:forEach items="${nptList}" var="npt">
                                                <c:if test="${npt.getDiaPhuong().getMaDP() < 1}">
                                                    <option value="${npt.getMaNPT()}-${npt.getHoTen()}">${npt.getMaNPT()}-${npt.getHoTen()}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>-->
                                            <!--Tiêu chí-->
                                            <div class="form-group">
                                                <div class="col-sm-3" >
                                                    <label class="label label-info" style="padding: 5px;font-size:13px">Tiêu chí</label>
                                                </div>
                                                <div class="col-sm-9" >
                                                    <select class="form-control" name="tieuChi">
                                                        <c:forEach items="${tcList}" var="tcList">
                                                            <option value="${tcList.getTenTC()}">${tcList.getTenTC()}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <!--Nội Dung-->
                                            <div class="form-group">
                                                <div class="col-sm-3" >
                                                    <label class="label label-info" style="padding: 5px;font-size:13px">Nội dung</label>
                                                </div>
                                                <div class="col-sm-9" >
                                                    <input type="text" name="noiDung" value=""  class="form-control" id="inputEmail3">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-6" >
                                                    <input type="submit" value="Thêm thông tin" name="submit" class="btn btn-success"/>
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
                    <!--kET THUC NE CON-->                                   

                </div>


                <div class="row">
                    <div class="col-lg-5 col-lg-push-4">
                        <form action="/project1/dpmanage?do=search" method="post">
                            <div class="col-md-11">

                                <div class="input-group">

                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                            <span class="glyphicon glyphicon-search"></span>
                                            <span class="caret"></span></button>

                                    </div><!-- /btn-group -->

                                    <input type="text" name="tenDP" class="form-control" placeholder="Nhập tên xã muốn tìm...">

                                </div><!-- /input-group -->
                            </div><!-- /input-group -->
                            <div class="col-md-1">
                                <input type="submit" name="submit" value="Tìm kiếm" class="btn btn-default dropdown-toggle" style="background:#3e8f3e;color:#ffffff">
                            </div>
                        </form>
                    </div><!-- /.col-lg-6 -->
                </div><!-- /.row -->
            </div>



            <!---Ket qua -->

            <div class="panel panel-default">
                <div class="col-md-1" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Mã</div>
                <div class="col-md-2" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Tên Xã</div>
                <div class="col-md-2" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Số ĐT</div>
                <div class="col-md-2" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Nơi nhận</div>
                <div class="col-md-2" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Diện tích</div>
                <div class="col-md-1" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Số dân</div>
                <div class="col-md-2" style="background: #428bca;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Lựa chọn</div>
            </div>
            <c:forEach items="${requestScope.dpList}" var="dpList">
                <div class="panel panel-title">
                    <div class="col-md-1" style="text-transform: inherit;padding:5px">${dpList.getMaDP()}</div>
                    <div class="col-md-2" style="text-transform:inherit;padding:5px">${dpList.getTenDP()}</div>
                    <div class="col-md-2" style="text-transform: inherit;padding:5px">${dpList.getSDT()}</div>
                    <div class="col-md-2" style="text-transform: inherit;padding:5px">${dpList.getNoiNhan()}</div>
                    <div class="col-md-2" style="text-transform: inherit;padding:5px">${dpList.getDienTich()}</div>
                    <div class="col-md-1" style="text-transform: inherit;padding:5px">${dpList.getSoDan()}</div>
                    <div class="col-md-2" style="text-transform: inherit;padding:5px">

                        <div class="col-md-3">
                            <a href="/project1/dpmanage?p=edit&id=${dpList.getMaDP()}" class="btn btn-primary btn-sm" >
                                <span class="glyphicon glyphicon-edit"></span>
                            </a>
                        </div>

                        <div class="col-md-3">
                            <c:if test="${dpList.getActive() == 0}">
                                <a href="/project1/dpmanage?p=restore&id=${dpList.getMaDP()}" class="btn btn-primary btn-sm" >
                                    <span class="glyphicon glyphicon-unchecked"></span>
                                </a>
                            </c:if>
                            <c:if test="${dpList.getActive() == 1}">
                                <a href="/project1/dpmanage?p=remove&id=${dpList.getMaDP()}" onclick="return confirm('Bạn thực sự địa phương ${dpList.getTenDP()} ngừng hoạt động?')" class="btn btn-primary btn-sm" >
                                    <span class="glyphicon glyphicon-check"></span>
                                </a>
                            </c:if>
                        </div>
                        <div class="col-md-3">
                            <a href="/project1/dpmanage?p=del&id=${dpList.getMaDP()}" onclick="return confirm('Bạn thực sự muốn xóa: ${dpList.getTenDP()}?')" class="btn btn-primary btn-sm" role="button"><span class="glyphicon glyphicon-trash"></span></a>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </div>
    </body>
</html>
