<%--
  Created by IntelliJ IDEA.
  User: HUY
  Date: 04/10/2024
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.bookstore.model.*,vn.com.stanford.je0824.bookstore.entities.*" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý thông tin chủ đề</title>
</head>
<%
    //Khai báo danh sách chủ đề
    List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

    ChuDeDao chuDeDao = new ChuDeImpl();

    lstChuDe = chuDeDao.layDanhSach();
%>
<body>
<%@include file="header.jsp" %>
<%@include file="menu.jsp" %>
<div style="width:100%; text-align:center;">
    <h2 style="text-transform: uppercase;">Quản lý thông tin sách</h2>
</div>
<form method="post">

</form>
<div style="width: 100%; text-align: right">
    <a href="ChuDeAdd.jsp">Thêm mới</a>
</div>
<table border="1" style="width:100%; border-collapse:collapse;">
    <tr>
        <th>
            Mã chủ đề
        </th>
        <th>
            Tên chủ đề
        </th>

        <th style="width: 100px;">
        </th>
    </tr>
    <tbody>
    <c:forEach var="c" items="<%=lstChuDe %>">
        <tr>
            <td>${c.maChuDe}</td>
            <td>${c.tenChuDe}</td>
            <td>
                <a href="ChuDeAdd.jsp?id=${c.maChuDe}" title="Nhấn vào đây để sửa thông tin">Sửa</a>
                &nbsp;
                <a href="ChuDeServlet?id=${c.maChuDe}" onclick="return confirm('Bạn có chắc chắn muốn xóa không ?')" title="Nhấn vào đây để xóa thông tin">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="footer.jsp" %>
</body>
</html>
