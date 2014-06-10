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
                    <h5><span class="glyphicon glyphicon-search"></span>&nbsp; TÌM KIẾM ĐỊA PHƯƠNG CƠ BẢN</h5>
                </div>
                <div class="panel-body">
                    <div class="col-sm-2 col-sm-offset-10">
                        <a href="/project1/Page?p=search-nc-dp" class="label label-warning">TÌM KIẾM NÂNG CAO</a>  
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/project1/search?do=tk-dp-cb" method="post">
                        <div class="col-sm-10 col-sm-offset-1">
                            <div class="form-group">
                                <div class="col-sm-10" >
                                    <select class="form-control" name="diaphuong">
                                        <c:forEach items="${dpList}" var="dpList">
                                            <option value="${dpList.getTenDP()}">${dpList.getTenDP()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-2" >
                                    <input type="submit" class="btn btn-primary" name="submit" value="Tìm Kiếm">
                                    <input type="text" name="timkiem" value="TKDPCB" hidden/>
                                </div>
                            </div>    
                        </div>
                    </form>
                </div>
                <div class="panel-body">
                    <div class="col-md-12">
                        <label>Kết quả tìm kiếm: </label>
                    </div>
                    <div class="col-md-12">
                        <div class="panel-body">
                            <div class="col-md-3">
                                <b class="label label-success" style="font-size:14px">
                                    Người phụ trách:
                                </b>
                            </div>
                            <div class="col-md-9">
                                <c:forEach items="${nptList}" var="nptList">${nptList.getHoTen()} - ${nptList.getChucVu()} </c:forEach>
                                </div>

                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="panel-body">
                                <div class="col-md-3">
                                    <b class="label label-success" style="font-size:14px">
                                        Dân số:
                                    </b>
                                </div>
                                <div class="col-md-9">
                                ${dp.getSoDan()} <i>người</i>.
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="panel-body">
                            <div class="col-md-3">
                                <b class="label label-success" style="font-size:14px">
                                    Diện tích:
                                </b>
                            </div>
                            <div class="col-md-9">
                                ${dp.getDienTich()} <i>ha</i>.
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="panel-body">
                            <div class="col-md-3">
                                <b class="label label-warning" style="font-size:14px">
                                    Nội dung tìm kiếm
                                </b>
                            </div>
                            <div class="col-md-9">

                                <div class="panel panel-group" style="border:1px solid #004050; padding: 5px; min-height:40px">
                                    <p>
                                        <c:forEach items="${dp.getTcList()}" var="tcList">
                                            + ${tcList.getTenTC()}: ${tcList.getNoiDung()}
                                        </c:forEach>  
                                    </p>
                                </div>


                            </div>
                        </div>
                    </div>



                </div>

            </div>

        </div>


        <script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
