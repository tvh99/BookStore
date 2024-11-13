package vn.com.stanford.je0824.bookstore.model;

import vn.com.stanford.je0824.bookstore.entities.Sach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SachImpl implements SachDao{


    @Override
    public List<Sach> timKiemSach(String tuKhoa, String maCD) {
        //Khai báo 1 danh sách
        List<Sach> lstSach = new ArrayList<Sach>();

        String strSQL = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from Sach where 1=1";

                if(!tuKhoa.isEmpty())
        {
            strSQL += " and (MaSach = '" + tuKhoa + "' OR TenSach like '%" + tuKhoa + "%' OR TacGia like '%" + tuKhoa + "%')";
        }

        if(!maCD.isEmpty())
        {
            strSQL+= " and MaChuDe = '" + maCD + "'";
        }
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
            Sach objSach;
            while(rs.next())
            {
                //Khởi tạo đối tượng
                objSach = new Sach();

                objSach.setMaSach(rs.getString("MaSach"));
                objSach.setTenSach(rs.getString("TenSach"));
                objSach.setMoTa(rs.getString("MoTa"));
                objSach.setAnhSach(rs.getString("AnhSach"));
                objSach.setGiaSach(rs.getInt("GiaSach"));
                objSach.setMaChuDe(rs.getString("MaChuDe"));
                objSach.setNgayTao(rs.getDate("NgayTao"));
                objSach.setTacGia(rs.getString("TacGia"));

                //Thêm vào danh sách
                lstSach.add(objSach);
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
        return lstSach;
    }

    @Override
    public List<Sach> layDanhSach() {
        //Khai báo 1 danh sách
        List<Sach> lstSach = new ArrayList<Sach>();

        String strSQL = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from Sach";

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
            Sach objSach;
            while(rs.next())
            {
                //Khởi tạo đối tượng
                objSach = new Sach();

                objSach.setMaSach(rs.getString("MaSach"));
                objSach.setTenSach(rs.getString("TenSach"));
                objSach.setMoTa(rs.getString("MoTa"));
                objSach.setAnhSach(rs.getString("AnhSach"));
                objSach.setGiaSach(rs.getInt("GiaSach"));
                objSach.setMaChuDe(rs.getString("MaChuDe"));
                objSach.setNgayTao(rs.getDate("NgayTao"));
                objSach.setTacGia(rs.getString("TacGia"));

                //Thêm vào danh sách
                lstSach.add(objSach);
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
        return lstSach;
    }

    /**
     * Hàm lấy chi tiết thông tin sách
     * @param id
     * @return
     */
    @Override
    public Sach layChiTiet(String id) {
        //Khai báo 1 đối tượng sách
        Sach objSach = null;

        String strSQL = "Select MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, MaChuDe, NgayTao from Sach where MaSach = '" + id + "'";

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

            while(rs.next())
            {
                //Khởi tạo đối tượng
                objSach = new Sach();

                objSach.setMaSach(rs.getString("MaSach"));
                objSach.setTenSach(rs.getString("TenSach"));
                objSach.setMoTa(rs.getString("MoTa"));
                objSach.setAnhSach(rs.getString("AnhSach"));
                objSach.setGiaSach(rs.getInt("GiaSach"));
                objSach.setMaChuDe(rs.getString("MaChuDe"));
                objSach.setNgayTao(rs.getDate("NgayTao"));
                objSach.setTacGia(rs.getString("TacGia"));
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
        return objSach;
    }

    @Override
    public boolean themMoi(Sach objSach) {
        Connection conn = null;

        try {

            conn = DataProvider.ketNoi();

            String strInsert = "Insert into Sach(MaSach, TenSach, MoTa, AnhSach, GiaSach, TacGia, NgayTao, MaChuDe) values(?, ?, ?, ?, ?, ?, ?, ?)";

            //Tạo công việc
            PreparedStatement comm = conn.prepareStatement(strInsert);

            comm.setString(1, objSach.getMaSach());
            comm.setString(2, objSach.getTenSach());
            comm.setString(3, objSach.getMoTa());
            comm.setString(4, objSach.getAnhSach());
            comm.setFloat(5, objSach.getGiaSach());
            comm.setString(6, objSach.getTacGia());
            comm.setDate(7, new Date(objSach.getNgayTao().getTime()));
            comm.setString(8, objSach.getMaChuDe());

            //Thực hiện công việc
            return comm.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + e.getMessage());
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

        return false;
    }

    @Override
    public boolean capNhat(Sach objSach) {
        Connection conn = null;

        try {

            conn = DataProvider.ketNoi();

            String strUpdate = "Update Sach set TenSach=?, MoTa=?, AnhSach=?, GiaSach=?, TacGia=?, NgayCapNhat=?, MaChuDe=? where MaSach=?";

            //Tạo công việc
            PreparedStatement comm = conn.prepareStatement(strUpdate);

            comm.setString(1, objSach.getTenSach());
            comm.setString(2, objSach.getMoTa());
            comm.setString(3, objSach.getAnhSach());
            comm.setFloat(4, objSach.getGiaSach());
            comm.setString(5, objSach.getTacGia());
            comm.setDate(6, new Date(objSach.getNgayCapNhat().getTime()));
            comm.setString(7, objSach.getMaChuDe());

            comm.setString(8, objSach.getMaSach());

            //Thực hiện công việc
            return comm.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + e.getMessage());
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

        return false;
    }

    @Override
    public boolean xoa(String maSach) {
        Connection conn = null;

        try {

            conn = DataProvider.ketNoi();

            String strDelete = "Delete from Sach where MaSach=?";

            //Tạo công việc
            PreparedStatement comm = conn.prepareStatement(strDelete);

            comm.setString(1, maSach);

            //Thực hiện công việc
            return comm.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Có lỗi xảy ra. Chi tiết: " + e.getMessage());
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

        return false;
    }


}
