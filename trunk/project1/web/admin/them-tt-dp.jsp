<%-- 
    Document   : them-tt-dp
    Created on : Jun 11, 2014, 2:38:41 PM
    Author     : Admin
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<form action="/project1/dpmanage" method="post">
    ??a ph??ng: 
    <select name="diaPhuong">
        <c:forEach items="${dpList}" var="dpList">
            <option value="${dpList.getTenDP()}">${dpList.getTenDP()}</option>
        </c:forEach>
    </select><br>
    Ng??i ph? trách: 
    <select name="nguoiPhuTrach">
        <c:forEach items="${nptList}" var="nptList">
            <c:if test="${nptList.getDiaPhuong().getMaDP() > 0}">
                <option value="${nptList.getMaNPT()}-${nptList.getHoTen()}">${nptList.getMaNPT()}-${nptList.getHoTen()}</option>
            </c:if>
        </c:forEach>
    </select><br>
    Tiêu chí: <input name="tenTC" type="text" /><br>
    N?i dung: <textarea name="noiDung" cols="10" rows="4"></textarea>
    <input type="submit" name="submit" value="OK">
</form>