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
                    <h5><span class="glyphicon glyphicon-search"></span>&nbsp; TÌM KIẾM ĐỊA PHƯƠNG NÂNG CAO</h5>
                </div>
                <div class="panel-body">
                    <div class="col-sm-3 col-sm-offset-10">
                        <a href="/project1/Page?p=search-cb-dp" class="label label-primary">TÌM KIẾM CƠ BẢN</a>  
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/project1/search?do=tk-dp-nc" method="post">
                        <div class="col-sm-9 col-sm-offset-1">

                            <div class="form-group">
                                <div class="col-sm-3" >
                                    <label class="label label-info">
                                        Địa phương(*)
                                    </label> 
                                </div>
                                <div class="col-sm-9" >
                                    <select class="form-control" name="diaPhuong">
                                        <c:forEach items="${dpList}" var="dpList">
                                            <option value="${dpList.getTenDP()}">${dpList.getTenDP()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-3" >
                                    <label class="label label-info">
                                        Người phụ trách(*)
                                    </label> 
                                </div>
                                <div class="col-sm-9" >
                                    <select class="form-control" name="nguoiPhuTrach">
                                        <c:forEach items="${nptList}" var="nptList">
                                            <option value="${nptList.getMaNPT()}-${nptList.getHoTen()}">${nptList.getMaNPT()}-${nptList.getHoTen()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>  
                            <div class="form-group">
                                <div class="col-sm-3" >
                                    <label class="label label-info">
                                        Tên tiêu chí(*)
                                    </label> 
                                </div>
                                <div class="col-sm-9" >
                                    <select class="form-control" name="tieuChi">
                                        <c:forEach items="${tcList}" var="tcList">
                                            <option value="${tcList.getTenTC()}">${tcList.getTenTC()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>  

                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-10" >
                                    <button type="submit" class="btn btn-success" name="do">Tìm kiếm</button>

                                </div>    
                            </div>

                        </div>

                    </form>
                </div>
                <div class="panel-body">
                    <!--                    Kết Quả In ra ở đây-->
                    <c:if test="${npt.getMaNPT() < 1 && tc.getMaTC() < 1}">
                        <p>No results</p>
                    </c:if>
                    <c:if test="${npt.getMaNPT() > 0 || tc.getMaTC() > 0}">
                        <p>Kết quả tìm kiếm: </p>
                    </c:if>
                    <c:if test="${npt.getMaNPT() > 0}">
                        <textarea style="width: 400px">
                            Mã người phụ trách: ${npt.getMaNPT()}
                            Họ tên: ${npt.getHoTen()}
                            Chức vụ: ${npt.getChucVu()}
                            Học vị: ${npt.getHocVi()}
                        </textarea><br/>
                    </c:if>
                    <c:if test="${tc.getMaTC() > 0}">
                        <textarea style="width: 400px">
                            ${tc.getTenTC()}: ${tc.getNoiDung()}
                        </textarea>
                    </c:if>
                </div>

            </div>
        </div>


        <script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
