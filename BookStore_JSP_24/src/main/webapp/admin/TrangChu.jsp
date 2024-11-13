<%--
  Created by IntelliJ IDEA.
  User: HUY
  Date: 09/10/2024
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList,java.util.List,vn.com.bookstore.model.*,vn.com.bookstore.entities.*" %>
<%@ page import="vn.com.bookstore.model.SachImpl" %>
<%@ page import="vn.com.bookstore.model.SachDao" %>
<%@ page import="vn.com.bookstore.entities.Sach" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang Chủ - BookStore</title>
    <link rel="stylesheet" type="text/css" href="../css/templatemo_style.css"/>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String maCD = "";

    if(request.getParameter("ma") != null)
    {
        maCD = "" + request.getParameter("ma");
    }

    //Lấy danh sách sách
    SachDao sachDao = new SachImpl();

    List<Sach> lstSach = sachDao.timKiemSach("", maCD);
%>
<div id="templatemo_container">
    <jsp:include page="../home/menu.jsp"/>
    <jsp:include page="../home/header.jsp"/>
    <div id="templatemo_content">
        <div id="templatemo_content_left">
            <jsp:include page="../home/sidebar.jsp"/>
        </div>
        <div id="templatemo_content_right">
            <c:forEach var="s" items="<%=lstSach %>" varStatus="i">
                <div class="templatemo_product_box">
                    <h1>${s.tenSach} <span>(by ${s.tacGia})</span></h1>
                    <img src="../images/${s.anhSach}" width="100" height="150" alt="image"/>
                    <div class="product_info">
                        <p>${s.moTa}</p>
                        <h3>${s.giaSach}</h3>
                        <div class="buy_now_button"><a href="#">Mua ngay</a></div>
                        <div class="detail_button"><a href="../ChiTiet.jsp?id=${s.maSach}">Chi tiết</a></div>
                    </div>
                    <div class="cleaner">&nbsp;</div>
                </div>
                <c:if test="${i.index%2==0}">
                <div class="cleaner_with_width">&nbsp;</div>
                </c:if>
                <c:if test="${i.index%2!=0}">
                    <div class="cleaner_with_height">&nbsp;</div>
                </c:if>
        </c:forEach>
            <a href="#"><img src="../images/templatemo_ads.jpg" alt="ads"/></a>
        </div>
        <div class="cleaner_with_height">&nbsp;</div>
    </div>

    <jsp:include page="../home/footer.jsp"/>
</div>
</body>
</html>
