<%--
  Created by IntelliJ IDEA.
  User: HUY
  Date: 11/10/2024
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="vn.com.stanford.je0824.bookstore.model.*,vn.com.stanford.je0824.bookstore.entities.*" %>
<%@page import="vn.com.stanford.je0824.bookstore.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Đăng nhập hệ thống</title>
    <link rel="stylesheet" type="text/css" href="css/templatemo_style.css"/>
</head>
<body>
<%
    //Khai báo biến
    String taiKhoan = "", matKhau = "", thongBao = "";

    if(request.getParameter("txtTaiKhoan") != null)
    {
        taiKhoan = request.getParameter("txtTaiKhoan");
        matKhau = request.getParameter("txtMatKhau");

        if(taiKhoan.equals("stanford") && matKhau.equals("123"))
        {
            //Lưu vào session
            session = request.getSession(true);

            //Gán giá trị để lưu
            session.setAttribute("userOnline", taiKhoan);

            //Di chuyển sang trang quản trị
            response.sendRedirect("admin/TrangChu.jsp");
        }
        else
        {
            thongBao = "Tài khoản không chính xác. Bạn vui lòng kiểm tra lại";
        }
    }
%>
<div id="templatemo_container">
    <jsp:include page="home/menu.jsp"/>
    <jsp:include page="home/header.jsp"/>
    <div id="templatemo_content">

        <div id="templatemo_content_left">
            <jsp:include page="home/sidebar.jsp"/>
        </div>

        <div id="templatemo_content_right">
            <h2>BookStore demo </h2>
            <a href="#"><img src="images/templatemo_ads.jpg" alt="ads"/></a>
        </div>
        <div class="cleaner_with_height">&nbsp;</div>
    </div>

    <jsp:include page="home/footer.jsp"/>
</div>
</body>
</html>