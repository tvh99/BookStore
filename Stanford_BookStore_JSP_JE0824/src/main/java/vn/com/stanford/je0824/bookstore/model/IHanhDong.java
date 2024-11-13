package vn.com.stanford.je0824.bookstore.model;

import java.util.List;

public interface IHanhDong<T, idT> {

    List<T> layDanhSach();

    T layChiTiet(idT id);

    boolean themMoi(T obj);

    boolean capNhat(T obj);

    boolean xoa(idT id);
}
