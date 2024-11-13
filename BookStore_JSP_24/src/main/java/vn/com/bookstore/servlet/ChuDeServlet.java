package vn.com.bookstore.servlet;

import vn.com.bookstore.entities.ChuDe;
import vn.com.bookstore.model.ChuDeDao;
import vn.com.bookstore.model.ChuDeImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChuDeServlet", value = "/admin/ChuDeServlet")
public class ChuDeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maChuDe = "" + request.getParameter("id");

        if(!maChuDe.isEmpty())
        {
            ChuDeDao chuDeDao = new ChuDeImpl();

            //Thực hiện xóa
            boolean ketQua = chuDeDao.xoa(maChuDe);

            if(ketQua)
            {
                response.sendRedirect("QuanLyChuDe.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String maChuDe = "", tenChuDe = "";

        request.setCharacterEncoding("utf-8");

        maChuDe =  request.getParameter("txtMaChuDe");
        tenChuDe = request.getParameter("txtTenChuDe");

        System.out.println("Ma Chu De: " + maChuDe);
        System.out.println("Ten Chu De: " + tenChuDe);

        ChuDeDao chuDeDao = new ChuDeImpl();

        ChuDe objChuDe = null;
        boolean isInsert = true;

        if(!maChuDe.isEmpty())
        {
            objChuDe = chuDeDao.layChiTiet(maChuDe);
        }

        if(objChuDe != null)
        {
            isInsert = false;
        }
        else{
            objChuDe = new ChuDe();
        }

        objChuDe.setMaChuDe(maChuDe);
        objChuDe.setTenChuDe(tenChuDe);

        boolean ketQua = false;

        if(!isInsert)
        {
            ketQua = chuDeDao.capNhat(objChuDe);
        }
        else
        {
            ketQua = chuDeDao.themMoi(objChuDe);
        }

        if(ketQua)
        {
            response.sendRedirect("QuanLyChuDe.jsp");
        }
    }
}