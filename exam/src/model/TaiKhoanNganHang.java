package model;

public abstract class TaiKhoanNganHang {
    private  int idTaiKhoan;
    private  String maTaiKhoan;
    private  String tenChuTaiKhoan;
    private  String ngayTaoTaiKhoan;

    public TaiKhoanNganHang(int idTaiKhoan, String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
        this.maTaiKhoan = maTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenChuTaiKhoan() {
        return tenChuTaiKhoan;
    }

    public void setTenChuTaiKhoan(String tenChuTaiKhoan) {
        this.tenChuTaiKhoan = tenChuTaiKhoan;
    }

    public String getNgayTaoTaiKhoan() {
        return ngayTaoTaiKhoan;
    }

    public void setNgayTaoTaiKhoan(String ngayTaoTaiKhoan) {
        this.ngayTaoTaiKhoan = ngayTaoTaiKhoan;
    }

    @Override
    public String toString() {
        return "idTaiKhoan='" + idTaiKhoan + '\'' +
                ", maTaiKhoan='" + maTaiKhoan + '\'' +
                ", tenChuTaiKhoan='" + tenChuTaiKhoan + '\'' +
                ", ngayTaoTaiKhoan='" + ngayTaoTaiKhoan + '\'' +
                '}';
    }
    public String getLine(){
        return idTaiKhoan + "," + maTaiKhoan + "," + tenChuTaiKhoan + "," + ngayTaoTaiKhoan;
    }
}
