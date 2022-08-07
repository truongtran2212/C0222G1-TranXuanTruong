package service;

import model.TaiKhoanNganHang;
import model.TaiKhoanThanhToan;
import model.TaiKhoanTietKiem;
import util.KhongTimThayTaiKhoanNganHang;
import util.ReadAndWriteExam;

import java.util.*;

public class AccountServiceImpl implements Service {




    public static Scanner scanner = new Scanner(System.in);
    public static List<TaiKhoanNganHang> taiKhoanNganHangList = getTaiKhoanNganHangList();
    public static final String FILE_ACCOUNT = "src\\data\\bank_account.csv";

    
    public static final String TEN = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}";
    public static List<TaiKhoanNganHang> getTaiKhoanNganHangList() {
        List<TaiKhoanNganHang> taiKhoanNganHangList = new ArrayList<>();
        List<String[]> listString = ReadAndWriteExam.readFile(FILE_ACCOUNT);
        for (String[] item : listString) {
            if (item.length == 8) {
                taiKhoanNganHangList.add(new TaiKhoanTietKiem(Integer.parseInt(item[0]), item[1], item[2], item[3]
                        , Integer.parseInt(item[4]), item[5], item[6], item[7]));
            } else {
                taiKhoanNganHangList.add(new TaiKhoanThanhToan(Integer.parseInt(item[0]), item[1], item[2]
                        , item[3], Integer.parseInt(item[4]), Integer.parseInt(item[5])));
            }
        }

        return taiKhoanNganHangList;
    }

    @Override
    public void addNewTaiKhoanTietKiem() {
        taiKhoanNganHangList = getTaiKhoanNganHangList();
        int id = kiemTraId();

        System.out.println("Nhập mã tài khoản");
        String maTaiKhoan = scanner.nextLine();

        System.out.println("Nhập tên chủ tài khoản");
        String tenChuTaiKhoan;

        while (true) {
            tenChuTaiKhoan = scanner.nextLine();
            if (tenChuTaiKhoan.matches(TEN)) {
                break;
            } else {
                System.out.println("Wrong format");
            }
        }

        System.out.println("Nhập ngày tạo tài khoản");
        String ngayTaoTaiKhoan = scanner.nextLine();

        System.out.println("Nhập tiền tiết kiệm");
        int tienTietKiem;

        while (true) {

            try {
                tienTietKiem = Integer.parseInt(scanner.nextLine());
                if (tienTietKiem > 0) {
                    break;
                } else {
                    System.out.println("Không thể nhập số dương");
                }
            } catch (NumberFormatException e) {
                System.err.println("Sai định dạng");
            }
        }

        System.out.println("Nhập ngày gửi tiết kiệm");
        String ngayGuiTietKiem = scanner.nextLine();

        System.out.println("Nhập lãi suất");
        String laiSuat = scanner.nextLine();

        System.out.println("Nhập kì hạn");
        String kiHan = scanner.nextLine();

        taiKhoanNganHangList.add(new TaiKhoanTietKiem(id, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan,
                tienTietKiem, ngayGuiTietKiem, laiSuat, kiHan));

        updateFile(taiKhoanNganHangList);

    }

    @Override
    public void addNewTaiKhoanThanhToan() {
        taiKhoanNganHangList = getTaiKhoanNganHangList();


        int id = kiemTraId();

        System.out.println("Nhập mã tài khoản");
        String maTaiKhoan = scanner.nextLine();

        System.out.println("Nhập tên chủ tài khoản");
        String tenChuTaiKhoan;
        while (true) {
            tenChuTaiKhoan = scanner.nextLine();
            if (tenChuTaiKhoan.matches(TEN)) {
                break;
            } else {
                System.out.println("Wrong format");
            }
        }

        System.out.println("Nhập ngày tạo tài khoản");
        String ngayTaoTaiKhoan = scanner.nextLine();

        System.out.println("Nhập số thẻ");
        int soThe;

        while (true) {
            try {
                soThe = Integer.parseInt(scanner.nextLine());
                if (soThe > 0) {
                    break;
                } else {
                    System.out.println("Không thể nhập số âm");
                }
            } catch (NumberFormatException e) {
                System.err.println("Sai định dạng");
            }
        }

        System.out.println("nhập số tiền trong tài khoản");
        int soTienTrongTaiKhoan;

        while (true) {

            try {
                soTienTrongTaiKhoan = Integer.parseInt(scanner.nextLine());
                if (soTienTrongTaiKhoan > 0) {
                    break;
                } else {
                    System.out.println("Không thể nhập số âm");
                }
            } catch (NumberFormatException e) {
                System.err.println("Sai định dạng");
            }
        }


        taiKhoanNganHangList.add(new TaiKhoanThanhToan(id, maTaiKhoan, tenChuTaiKhoan,
                ngayTaoTaiKhoan, soThe, soTienTrongTaiKhoan));

        updateFile(taiKhoanNganHangList);

    }

    @Override
    public void delete() {
        taiKhoanNganHangList = getTaiKhoanNganHangList();
        display();

        System.out.println("Nhập mã tài khoản");
        String maTaiKhoan = scanner.nextLine();
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < taiKhoanNganHangList.size(); i++) {
            if (maTaiKhoan.equals(taiKhoanNganHangList.get(i).getMaTaiKhoan())) {
                index = i;
                flag = true;
                break;
            }
        }
        if (!flag) {
            try {
                throw new KhongTimThayTaiKhoanNganHang("Tài khoản không tồn tại");
            } catch (KhongTimThayTaiKhoanNganHang khongTimThayTaiKhoanNganHang) {
                khongTimThayTaiKhoanNganHang.printStackTrace();
            }
        } else {
            System.out.println("Bạn muốn xóa chứ");
            System.out.println("1. Có");
            System.out.println("2. Không");
            String choose;
            boolean check = true;
            while (check) {
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        check = false;
                        break;
                    case "2":
                        return;
                }
            }

            taiKhoanNganHangList.remove(index);
            updateFile(taiKhoanNganHangList);
            display();
            System.out.println("Đã xóa thành công");
        }
    }

    @Override
    public void display() {
        taiKhoanNganHangList = getTaiKhoanNganHangList();
        for (TaiKhoanNganHang item : taiKhoanNganHangList) {
            System.out.println(item);
        }
    }

    @Override
    public void find() {
        taiKhoanNganHangList = getTaiKhoanNganHangList();

        display();

        System.out.println("Nhập mã tài khoản");
        String maTaiKhoan = scanner.nextLine();
        boolean flag = false;

        for (TaiKhoanNganHang item : taiKhoanNganHangList) {
            if (item.getMaTaiKhoan().contains(maTaiKhoan)) {

                System.out.println(item);
                System.out.println("Đã tìm thấy mã tài khoản");
                updateFile(taiKhoanNganHangList);
                flag = true;
            }
        }
        if (!flag) {
            try {
                throw new KhongTimThayTaiKhoanNganHang("Tài khoản không tồn tại");
            } catch (KhongTimThayTaiKhoanNganHang e) {
                e.printStackTrace();
            }
        }
    }

    public static int kiemTraId() {
        if (getTaiKhoanNganHangList().size() == 0) {
            return 1;
        } else {
            return getTaiKhoanNganHangList().get(getTaiKhoanNganHangList().size() - 1).getIdTaiKhoan() + 1;
        }

    }

    public static void updateFile(List<TaiKhoanNganHang> taiKhoanNganHangList) {

        List<String> stringList = new ArrayList<>();
        for (TaiKhoanNganHang item : taiKhoanNganHangList) {
            stringList.add(item.getLine());
        }

        ReadAndWriteExam.writeFile(FILE_ACCOUNT, stringList);
    }


}
