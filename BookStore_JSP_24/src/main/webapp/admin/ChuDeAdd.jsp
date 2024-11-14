<%--
  Created by IntelliJ IDEA.
  User: HUY
  Date: 04/10/2024
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList,java.util.List,vn.com.bookstore.model.*,vn.com.bookstore.entities.*" %>
<%@ page import="vn.com.bookstore.model.ChuDeDao" %>
<%@ page import="vn.com.bookstore.entities.ChuDe" %>
<%@ page import="vn.com.bookstore.model.ChuDeImpl" %>
<!-- Khai báo bộ thẻ để sử dụng trên trang web -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm hoặc sửa chủ đề</title>
</head>
<body>
<%
    //Xử lý hiển thị chi tiết
    String maChuDe = "", tenChuDe = "";

    if(request.getParameter("id") != null)
    {
        maChuDe = "" + request.getParameter("id");

        ChuDeDao chuDeDao = new ChuDeImpl();
        //Lấy chi tiết
        ChuDe objChuDe = chuDeDao.layChiTiet(maChuDe);

        if(objChuDe != null)
        {
            maChuDe = objChuDe.getMaChuDe();
            tenChuDe = objChuDe.getTenChuDe();
        }
    }

%>
<div style="width:100%; text-align:center;">
    <h2 style="text-transform: uppercase;">Thêm, sửa thông tin chủ đề</h2>
</div>

<form method="post" action="ChuDeServlet">
    <fieldset>
        <legend>Nhập thông tin chủ đề</legend>
        <table>
            <tr>
                <td>
                    Mã chủ đề:
                </td>
                <td>
                    <input type="text" name="txtMaChuDe" value="<%=maChuDe%>"/>
                </td>
            </tr>
            <tr>
                <td>
                    Tên chủ đề:
                </td>
                <td>
                    <input type="text" name="txtTenChuDe" value="<%=tenChuDe%>"/>
                </td>
            </tr>

            <tr>
                <td>

                </td>
                <td>
                    <input type="submit" name="btnCapNhat" value="Cập nhật"/>
                    &nbsp;
                    <a href="admin/QuanLySach.jsp">Trở lại</a>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
