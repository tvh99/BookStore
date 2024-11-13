<%--
  Created by IntelliJ IDEA.
  User: HUY
  Date: 09/10/2024
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList,java.util.List,vn.com.stanford.je0824.bookstore.model.*,vn.com.stanford.je0824.bookstore.entities.*" %>
<%@ page import="vn.com.bookstore.model.SachImpl" %>
<%@ page import="vn.com.bookstore.model.ChuDeDao" %>
<%@ page import="vn.com.bookstore.model.SachDao" %>
<%@ page import="vn.com.bookstore.entities.ChuDe" %>
<%@ page import="vn.com.bookstore.model.ChuDeImpl" %>
<%@ page import="vn.com.bookstore.entities.Sach" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("utf-8");
    String tuKhoa = "", maCD = "";

    if(request.getParameter("txtTuKhoa") != null)
    {
        tuKhoa = "" + request.getParameter("txtTuKhoa");
    }

    if(request.getParameter("txtChuDe") != null)
    {
        maCD = "" + request.getParameter("txtChuDe");
    }

    //Lấy danh sách sách
    SachDao sachDao = new SachImpl();

    List<Sach> lstSach = sachDao.timKiemSach(tuKhoa, maCD);

    //Khai báo danh sách chu de
    List<ChuDe> lstChuDe = new ArrayList<>();

    ChuDeDao chuDeDao = new ChuDeImpl();

    //Lâý danh sách chu de
    lstChuDe = chuDeDao.layDanhSach();

%>

<div class="templatemo_content_left_section">
    <h1>Danh mục chủ đề</h1>
    <ul>
        <c:forEach var="c" items="<%=lstChuDe%>">
        <li><a href="TrangChu.jsp?ma=${c.maChuDe}" title="Lọc sách theo chủ đề">${c.tenChuDe}</a></li>
        </c:forEach>
    </ul>
</div>
<div class="templatemo_content_left_section">
</div>


