<%-- 
    Document   : seach-cb
    Created on : Jun 6, 2014, 6:04:42 PM
    Author     : Welcomes
--%>

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
                    <h5><span class="glyphicon glyphicon-search"></span>&nbsp; TÌM KIẾM VĂN BẢN CƠ BẢN</h5>
                </div>
                <div class="panel-body">
                    <div class="col-sm-2 col-sm-offset-10">
                        <a href="/project1/Page?p=search-nc-vb" class="label label-warning">TÌM KIẾM NÂNG CAO</a>  
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/project1/contact" method="post">
                        <div class="col-sm-10 col-sm-offset-1">
                            <div class="form-group">
                                <div class="col-sm-2" >
                                    <button type="submit" class="btn btn-primary" name="do">Tìm kiếm</button>
                                </div>
                                <div class="col-sm-10" >
                                    <select class="form-control">
                                        <option>Xã Bình Triều</option>
                                        <option>Xã Tam Trà</option>
                                        <option>Xã Tam Mỹ</option>
                                    </select>
                                </div>
                            </div>    
                        </div>

                    </form>
                </div>
                <div class="panel-body">
                    Kết Quả In ra ở đây
                </div>

            </div>
        </div>


        <script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
