<%--
  Created by IntelliJ IDEA.
  User: HUY
  Date: 04/10/2024
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.bookstore.model.*,vn.com.stanford.je0824.bookstore.entities.*" %>
<%@page import="vn.com.stanford.je0824.bookstore.servlet.*" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý thông tin sách</title>
</head>
<%
    request.setCharacterEncoding("utf-8");
    String tuKhoa = "", maCD = "";

    if(request.getParameter("txtTuKhoa") != null)
    {
        tuKhoa = "" + request.getParameter("txtTuKhoa");
    }

    if(request.getParameter("cboChuDe") != null)
    {
        maCD = "" + request.getParameter("cboChuDe");
    }

    //Lấy danh sách sách
    SachDao sachDao = new SachImpl();

    List<Sach> lstSach = sachDao.timKiemSach(tuKhoa, maCD);

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
<fieldset>
    <legend>
        Nhập thông tin tìm kiếm
    </legend>
    <table>
        <tr>
            <td>Từ khóa:</td>
            <td>
                <input type="text" name="txtTuKhoa" value="<%=tuKhoa%>"/>
            </td>
            <td>Chủ đề:</td>
            <td>
                <select name="cboChuDe">
                    <option value="">Chọn chủ đề</option>
                    <c:set var="maCD" value="<%=maCD%>"/>
                    <c:forEach var="c" items="<%=lstChuDe %>">
                        <c:if test="${c.maChuDe==maCD}">
                            <option value="${c.maChuDe}" selected="selected">${c.tenChuDe}</option>
                        </c:if>
                        <c:if test="${c.maChuDe!=maCD}">
                            <option value="${c.maChuDe}">${c.tenChuDe}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="submit" name="btnTimKiem" value="Tìm kiếm"/>
            </td>
        </tr>
    </table>
</fieldset>
</form>
<div style="width: 100%; text-align: right">
    <a href="SachAdd.jsp">Thêm mới</a>
</div>
<table border="1" style="width:100%; border-collapse:collapse;">
    <tr>
        <th>
            Ảnh sách
        </th>
        <th>
            Mã sách
        </th>
        <th>
            Tên sách
        </th>
        <th>
            Mô tả
        </th>
        <th>
            Giá sách
        </th>
        <th>
            Tác giả
        </th>
        <th>
        </th>
    </tr>
    <tbody>
    <c:forEach var="s" items="<%=lstSach %>">
        <tr>
            <td>
             <img src="../images/${s.anhSach}" width="100" height="120" alt="book store"/> </td>
            <td>${s.maSach}</td>
            <td>${s.tenSach}</td>
            <td>${s.moTa}</td>
            <td>${s.giaSach}</td>
            <td>${s.tacGia}</td>
            <td>
                <a href="SachAdd.jsp?id=${s.maSach}" title="Nhấn vào đây để sửa thông tin">Sửa</a>
                &nbsp;
                <a href="SachServlet?id=${s.maSach}" onclick="return confirm('Bạn có chắc chắn muốn xóa không ?')" title="Nhấn vào đây để xóa thông tin">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="footer.jsp" %>
</body>
</html>
