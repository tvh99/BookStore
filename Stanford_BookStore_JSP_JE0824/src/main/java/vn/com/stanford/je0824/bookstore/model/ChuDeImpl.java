package vn.com.stanford.je0824.bookstore.model;

import vn.com.stanford.je0824.bookstore.entities.ChuDe;
import vn.com.stanford.je0824.bookstore.entities.Sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChuDeImpl implements ChuDeDao{
    /**
     * Hàm lấy danh sách chủ đề
     * @return
     */
    @Override
    public List<ChuDe> layDanhSach() {
        //Khai báo 1 danh sách
        List<ChuDe> lstChuDe = new ArrayList<ChuDe>();

        String strSQL = "Select MaChuDe, TenChuDe from ChuDe";

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataProvider.ketNoi();

            //Khai báo công việc
            Statement comm = conn.createStatement();

            //Lấy kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Đọc từng dòng để đưa về danh sách
            ChuDe objChuDe;
            while(rs.next())
            {
                //Khởi tạo đối tượng
                objChuDe = new ChuDe();

                objChuDe.setMaChuDe(rs.getString("MaChuDe"));
                objChuDe.setTenChuDe(rs.getString("TenChuDe"));

                //Thêm vào danh sách
                lstChuDe.add(objChuDe);
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return lstChuDe;
    }

    /**
     * Lấy chi tiết chủ đề
     * @param id
     * @return
     */
    @Override
    public ChuDe layChiTiet(String id) {
        //Khai báo 1 đối tượng
        ChuDe objChuDe = null;

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataProvider.ketNoi();

            String strSQL = "{call SP_LayChiTietChuDe(?)}";

            //Khai báo công việc
            CallableStatement comm = conn.prepareCall(strSQL);
            comm.setString(1, id);

            //Lấy kết quả
            ResultSet rs = comm.executeQuery();

            //Đọc từng dòng để đưa về danh sách
            while(rs.next())
            {
                //Khởi tạo đối tượng
                objChuDe = new ChuDe();

                objChuDe.setMaChuDe(rs.getString("MaChuDe"));
                objChuDe.setTenChuDe(rs.getString("TenChuDe"));
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Khong lay duoc thong tin chi tiet. Chi tiet loi: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return objChuDe;
    }

    /**
     * Hàm thêm mới chủ đề
     * @param obj
     * @return
     */
    @Override
    public boolean themMoi(ChuDe obj) {
        //Khai báo 1 kết quả
        boolean ketQua = false;

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataProvider.ketNoi();

            String strSQL = "{call SP_ThemChuDe(?,?)}";

            //Khai báo công việc
            CallableStatement comm = conn.prepareCall(strSQL);

            comm.setString(1, obj.getMaChuDe());
            comm.setString(2, obj.getTenChuDe());

            //Thực hiện công việc
            ketQua = comm.executeUpdate() > 0;

        }
        catch(SQLException ex)
        {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public boolean capNhat(ChuDe obj) {
        //Khai báo 1 kết quả
        boolean ketQua = false;

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataProvider.ketNoi();

            String strSQL = "{call SP_SuaChuDe(?,?)}";

            //Khai báo công việc
            CallableStatement comm = conn.prepareCall(strSQL);

            comm.setString(1, obj.getMaChuDe());
            comm.setString(2, obj.getTenChuDe());

            //Thực hiện công việc
            ketQua = comm.executeUpdate() > 0;

        }
        catch(SQLException ex)
        {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public boolean xoa(String id) {
        //Khai báo 1 kết quả
        boolean ketQua = false;

        //Khai báo kết nối
        Connection conn = null;

        try
        {
            conn = DataProvider.ketNoi();

            String strSQL = "{call SP_XoaChuDe(?)}";

            //Khai báo công việc
            CallableStatement comm = conn.prepareCall(strSQL);

            comm.setString(1, id);

            //Thực hiện công việc
            ketQua = comm.executeUpdate() > 0;

        }
        catch(SQLException ex)
        {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + ex.getMessage());
        }
        finally {
            if(conn!= null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }
}
