package model;

public class TaiKhoanTietKiem extends TaiKhoanNganHang {
    private int tienGuiTietKiem;
    private String ngayGuiTietKiem;
    private String laiSuat;
    private String kiHan;

    public TaiKhoanTietKiem(int idAccount,
                            String codeAccount,
                            String nameOwner,
                            String dateAccount,
                            int tienGuiTietKiem,
                            String ngayGuiTietKiem,
                            String laiSuat,
                            String kiHan) {
        super(idAccount, codeAccount, nameOwner, dateAccount);
        this.tienGuiTietKiem = tienGuiTietKiem;
        this.ngayGuiTietKiem = ngayGuiTietKiem;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public int getTienGuiTietKiem() {
        return tienGuiTietKiem;
    }

    public void setTienGuiTietKiem(int tienGuiTietKiem) {
        this.tienGuiTietKiem = tienGuiTietKiem;
    }

    public String getNgayGuiTietKiem() {
        return ngayGuiTietKiem;
    }

    public void setNgayGuiTietKiem(String ngayGuiTietKiem) {
        this.ngayGuiTietKiem = ngayGuiTietKiem;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    public String getKiHan() {
        return kiHan;
    }

    public void setKiHan(String kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String toString() {
        return "AccountPayment{" + super.toString() +
                "tienGuiTietKiem=" + tienGuiTietKiem +
                ", ngayGuiTietKiem='" + ngayGuiTietKiem + '\'' +
                ", laiSuat='" + laiSuat + '\'' +
                ", kiHan='" + kiHan + '\'' +
                '}';
    }

    @Override
    public String getLine() {
        return super.getLine() + "," + tienGuiTietKiem + "," + ngayGuiTietKiem+ "," +laiSuat+ "," +kiHan;
    }
}
