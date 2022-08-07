package model;

public class TaiKhoanThanhToan extends TaiKhoanNganHang {
    private int soThe;
    private int soTienTrongTaiKhoan;

    public TaiKhoanThanhToan(int idAccount,
                             String codeAccount,
                             String nameOwner,
                             String dateAccount,
                             int soThe,
                             int soTienTrongTaiKhoan) {
        super(idAccount, codeAccount, nameOwner, dateAccount);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public int getSoThe() {
        return soThe;
    }

    public void setSoThe(int soThe) {
        this.soThe = soThe;
    }

    public int getSoTienTrongTaiKhoan() {
        return soTienTrongTaiKhoan;
    }

    public void setSoTienTrongTaiKhoan(int soTienTrongTaiKhoan) {
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    @Override
    public String toString() {
        return "AccountSaving{" + super.toString() +
                "soThe=" + soThe +
                ", soTienTrongTaiKhoan='" + soTienTrongTaiKhoan + '\'' +
                '}';
    }

    @Override
    public String getLine() {
        return super.getLine() + "," + soThe + "," +soTienTrongTaiKhoan ;
    }
}
