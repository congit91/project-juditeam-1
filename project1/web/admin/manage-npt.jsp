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
        <div class="alert alert-danger" style="text-align: center"><b>QUẢN LÝ NGƯỜI PHỤ TRÁCH </b></div>
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel panel-heading">
                <a href="/project1/umanage?do=add" class="btn btn-primary btn-sm" >
                    Tạo mới
                </a>               
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
             </div>
            <table class="col-md-12 table-hover">
                <tr >
                    <td class="col-md-1"style="background: #3e8f3e;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Mã NPT</td>
                    <td class="col-md-2"style="background: #3e8f3e;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Họ Tên</td>
                    <td class="col-md-1"style="background: #3e8f3e;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Năm sinh</td>
                    <td class="col-md-2"style="background: #3e8f3e;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Quê quán</td>
                    <td class="col-md-1"style="background: #3e8f3e;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Chức vị</td>
                    <td class="col-md-1"style="background: #3e8f3e;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">SĐT</td>
                    <td class="col-md-2"style="background: #3e8f3e;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Email</td>
                    <td class="col-md-1"style="background: #3e8f3e;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Địa phương</td>
                    <td class="col-md-1"style="background: #3e8f3e;padding:5px;font-weight:bold;text-transform: uppercase;color:#ffffff">Lựa chọn</td>
                </tr>
                <c:forEach items="${tkList}" var="tkList">
                <tr style="border-bottom:#428bca solid thin">
                    <td  class="col-md-1" style="text-transform: inherit;padding:5px">a</td>
                    <td  class="col-md-2" style="text-transform: inherit;padding:5px">b</td>
                    <td  class="col-md-1" style="text-transform: inherit;padding:5px">c</td>
                    <td  class="col-md-2" style="text-transform: inherit;padding:5px">d</td>
                    <td  class="col-md-1" style="text-transform: inherit;padding:5px">e</td>
                    <td  class="col-md-1" style="text-transform: inherit;padding:5px">f</td>
                    <td  class="col-md-2" style="text-transform: inherit;padding:5px">g</td>
                    <td  class="col-md-1" style="text-transform: inherit;padding:5px">h</td>
                    <td  class="col-md-1" style="text-transform: inherit;padding:5px">
                        <div class="col-md-6">
                            <a href="/project1/umanage?do=edit&id=${tkList.getMaTK()}" class="btn btn-primary btn-sm" >
                                <span class="glyphicon glyphicon-wrench"></span>
                            </a>
                        </div>
                        <!--Delete-->
                        <div class="col-md-6">
                            <a href="/project1/umanage?do=del&id=${tkList.getMaTK()}" onclick="return confirm('Bạn thực sự muốn xóa: ${tkList.getTenTK()}?')" class="btn btn-primary btn-sm" role="button"><span class="glyphicon glyphicon-trash"></span></a>
                        </div>
                    </td>
                </tr>
                   </c:forEach> 
            </table>

            
                                      

       
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
    </body>
</html>
