package vn.com.stanford.je0824.bookstore.servlet;

import vn.com.stanford.je0824.bookstore.entities.Sach;
import vn.com.stanford.je0824.bookstore.model.SachDao;
import vn.com.stanford.je0824.bookstore.model.SachImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SachServlet", value = "/admin/SachServlet")
public class SachServlet extends HttpServlet {

    /***
     * Xử lý xóa thông tin sách
     * @param request   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param response  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String maSach = "" + request.getParameter("id");

        if(!maSach.isEmpty())
        {
            SachDao sachDao = new SachImpl();

            //Thực hiện xóa
            boolean ketQua = sachDao.xoa(maSach);

            if(ketQua)
            {
                response.sendRedirect("QuanLySach.jsp");
            }
        }
    }

    /**
     * Xử lý thêm mới hoặc cập nhật thông tin sách
     * @param request   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param response  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //Khai báo biến
        boolean isInsert = true;
        String maSach = "", tenSach = "", moTa = "", anhSach = "", tacGia = "", sachId = "", maChuDe = "";
        int giaSach = 0;

        if(request.getParameter("hSachId") != null && !request.getParameter("hSachId").isEmpty())
            sachId = "" + request.getParameter("hSachId");

        maSach = request.getParameter("txtMaSach");
        tenSach = request.getParameter("txtTenSach");
        moTa = request.getParameter("txtMoTa");
        anhSach = request.getParameter("txtAnhSach");
        tacGia = request.getParameter("txtTacGia");
        maChuDe = request.getParameter("cboChuDe");

        giaSach = Integer.parseInt("" + request.getParameter("txtGiaSach"));

        //Khai báo 1 đối tượng
        Sach objSach;
        objSach = new Sach();

        if(!sachId.isEmpty())
        {
            isInsert = false;
            objSach.setMaSach(sachId);
        }
        else
        {
            objSach.setMaSach(maSach);
        }

        //Gán giá trị cho các thuộc tính
        objSach.setTenSach(tenSach);
        objSach.setMoTa(moTa);
        objSach.setAnhSach(anhSach);
        objSach.setTacGia(tacGia);
        objSach.setGiaSach(giaSach);
        objSach.setMaChuDe(maChuDe);

        boolean ketQua = false;

        SachDao sachDao = new SachImpl();

        if(isInsert)
        {
            objSach.setNgayTao(new Date());
            objSach.setNgayCapNhat(new Date());
            ketQua = sachDao.themMoi(objSach);
        }
        else
        {
            objSach.setNgayCapNhat(new Date());
            ketQua =sachDao.capNhat(objSach);
        }

        if(ketQua)
        {
            response.sendRedirect("QuanLySach.jsp");
        }
    }
}