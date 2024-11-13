<%--
  Created by IntelliJ IDEA.
  User: HUY
  Date: 11/10/2024
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="vn.com.bookstore.model.*,vn.com.bookstore.entities.*" %>
<%@ page import="vn.com.bookstore.model.SachImpl" %>
<%@ page import="vn.com.bookstore.model.SachDao" %>
<%@ page import="vn.com.bookstore.entities.Sach" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thông tin chi tiết về sách</title>
    <link rel="stylesheet" type="text/css" href="css/templatemo_style.css"/>
</head>
<body>
<%
Sach objSach = null;

if(request.getParameter("id") != null) {

    String maSach = "" + request.getParameter("id");
    SachDao sachDao = new SachImpl();

    objSach = sachDao.layChiTiet(maSach);
}
%>
<c:set var="s" value="<%=objSach%>"/>
<div id="templatemo_container">
    <jsp:include page="home/menu.jsp"/>
    <jsp:include page="home/header.jsp"/>
    <div id="templatemo_content">
        <div id="templatemo_content_left">
            <jsp:include page="home/sidebar.jsp"/>
        </div>
        <div id="templatemo_content_right">
            <h1><c:out value="${s.tenSach}"/> </h1>
            <h2><c:out value="${s.moTa}"/></h2>
            <p style="width: 100%;text-align: center">
                Tác giả: <span style="font-weight: bold; font-size: 16px"><c:out value="${s.tacGia}"/></span>
            </p>
            <p style="width: 100%;text-align: center">
                <img src='images/<c:out value="${s.anhSach}"/>' width="300"/>
            </p>
            <p style="width: 100%;text-align: center">
                Giá sách: <span style="color:red"><c:out value="${s.giaSach}"/></span>
            </p>
            <p style="width: 100%;text-align: right">
                <a href="admin/TrangChu.jsp" >Trở lại</a>
            </p>
            <a href="#"><img src="images/templatemo_ads.jpg" alt="ads"/></a>
        </div>
        <div class="cleaner_with_height">&nbsp;</div>
    </div>
    <jsp:include page="home/footer.jsp"/>
</div>
</body>
</html>
