<%-- 
    Document   : seach-cb
    Created on : Jun 6, 2014, 6:04:42 PM
    Author     : Welcomes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="col-lg-8 col-sm-8 col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h5><span class="glyphicon glyphicon-search"></span>&nbsp; TÌM KIẾM VĂN BẢN NÂNG CAO</h5>
                </div>
                <div class="panel-body">
                    <div class="col-sm-2 col-sm-offset-10">
                        <a href="/project1/Page?p=search-cb-vb" class="label label-primary">TÌM KIẾM CƠ BẢN</a>  
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/project1/search?do=tk-vb-nc" method="post">
                        <div class="col-sm-10 col-sm-offset-1">
                            <div class="form-group">
                                <div class="col-sm-2" >
                                    <label class="label label-info">
                                        Tên tài liệu
                                    </label> 
                                </div>
                                <div class="col-sm-10" >
                                    <input type="text" name="tenVB" class="form-control" placeholder="">
                                </div>
                            </div>    
                             <div class="form-group">
                                <div class="col-sm-2" >
                                    <label class="label label-info">
                                       Loại
                                    </label> 
                                </div>
                                <div class="col-sm-10" >
                                    <input type="text" name="loaiVB" class="form-control" placeholder="">
                                </div>
                            </div>
                             <div class="form-group">
                                <div class="col-sm-2" >
                                    <label class="label label-info">
                                       Nơi ban hành
                                    </label> 
                                </div>
                                <div class="col-sm-10" >
                                    <input type="text" name="noiBanHanh" class="form-control" placeholder="">
                                </div>
                            </div>  
                             <div class="form-group">
                                <div class="col-sm-2" >
                                    <label class="label label-info">
                                       Ngày ban hành
                                    </label> 
                                </div>
                                <div class="col-sm-10" >
                                    <input type="text" name="ngayBanHanh" class="form-control" placeholder="">
                                </div>
                            </div>  
                             <div class="form-group">
                                <div class="col-sm-2" >
                                    <label class="label label-info">
                                       Nơi nhận
                                    </label> 
                                </div>
                                <div class="col-sm-10" >
                                    <input type="text" name="noiNhan" class="form-control" placeholder="">
                                </div>
                            </div> 
                           <div class="form-group">
                                <div class="col-sm-2 col-sm-offset-10" >
                                    <button type="submit" class="btn btn-success" name="do">Tìm kiếm</button>

                                </div>    
                            </div>

                        </div>

                    </form>
                </div>
                <div class="panel-body">
                    <!--Kết Quả In ra ở đây-->
                    <c:if test="${vbList != null}">
                        <table>
                            <tr>
                                <td>Mã văn bản</td>
                                <td>Tên văn bản</td>
                                <td>Loại văn bản</td>
                                <td>Nơi ban hành</td>
                                <td>Ngày ban hành</td>
                                <td>Nơi nhận</td>
                                <td></td>
                            </tr>
                            <c:forEach items="${vbList}" var="vbList">
                                <c:if test="${vbList.getActive() == 1}">
                                    <tr>
                                        <td>${vbList.getMaVB()}</td>
                                        <td>${vbList.getTenVB()}</td>
                                        <td>${vbList.getLoaiVB()}</td>
                                        <td>${vbList.getNoiBanHanh()}</td>
                                        <td>${vbList.getNgayBanHanh()}</td>
                                        <td>${vbList.getNoiNhan()}</td>
                                        <td><a href="/project1/search?maVB=${vbList.getMaVB()}">Xem</a></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </table>
                    </c:if>
                    <c:if test="${vbList == null && currentVB == null}">
                        <p>No results</p>
                    </c:if>
                    <c:if test="${currentVB != null}">
                    <p>Kết quả tìm kiếm: </p>
                    <textarea name="result" style="height:400px; width: 600px; text-align: left" readonly>
        Tên văn bản: ${currentVB.getTenVB()}
        Loại văn bản: ${currentVB.getLoaiVB()}
        Ngày ban hành: ${currentVB.getNgayBanHanh()}
        Nơi ban hành: ${currentVB.getNoiBanHanh()}
        Nội dung:
        ${currentVB.getNoiDung()}
                    </textarea>
                    </c:if>
                </div>

            </div>
        </div>


        <script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
