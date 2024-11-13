package vn.com.stanford.je0824.bookstore.model;

import vn.com.stanford.je0824.bookstore.entities.Sach;

import java.util.List;

public interface SachDao extends IHanhDong<Sach, String>{
    //Khai báo các hàm riêng của sách ở đây nếu có
    List<Sach> timKiemSach(String tuKhoa, String maCD);
}
