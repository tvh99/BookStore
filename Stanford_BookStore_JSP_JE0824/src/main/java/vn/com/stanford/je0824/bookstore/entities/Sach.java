package vn.com.stanford.je0824.bookstore.entities;

import java.util.Date;

public class Sach {
    /**
     * Hàm khởi tạo không có đối số
     */
    public Sach()
    {

    }

    /**
     * Hàm khởi tạo có 1 đối số
     * @param tenSach
     */
    public Sach(String tenSach)
    {
        this.tenSach = tenSach;
    }

    /**
     * Hàm khởi tạo có 5 tham số
     * @param tenSach
     * @param anhSach
     * @param moTa
     * @param giaSach
     */
    public Sach(String tenSach, String anhSach, String moTa, String tacGia, int giaSach)
    {
        this.tenSach = tenSach;
        this.anhSach = anhSach;
        this.moTa = moTa;
        this.tacGia = tacGia;
        this.giaSach = giaSach;
    }

    private String tenSach;
    private String moTa;
    private String anhSach;
    private String tacGia;
    private int giaSach;
    private Date ngayTao;
    private Date ngayCapNhat;
    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }


    private String maChuDe;

    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public String getMoTa() {
        return moTa;
    }
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public String getAnhSach() {
        return anhSach;
    }
    public void setAnhSach(String anhSach) {
        this.anhSach = anhSach;
    }
    public String getTacGia() {
        return tacGia;
    }
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    public int getGiaSach() {
        return giaSach;
    }
    public void setGiaSach(int giaSach) {
        this.giaSach = giaSach;
    }
    public Date getNgayTao() {
        return ngayTao;
    }
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    public String getMaChuDe() {
        return maChuDe;
    }
    public void setMaChuDe(String maChuDe) {
        this.maChuDe = maChuDe;
    }

    private int soLuong = 0;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    private String maSach;

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
}
