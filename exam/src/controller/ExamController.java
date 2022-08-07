package controller;

import service.AccountServiceImpl;

import java.util.Scanner;

public class ExamController {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        displayMainMenu();
    }

    public static void displayMainMenu() {
        AccountServiceImpl accountService = new AccountServiceImpl();
        while (true) {

            System.out.println("1. Thêm mới tài khoản tiết kiệm ");
            System.out.println("2. Thêm mới tài khoản thanh toán ");

            System.out.println("3. Xóa tài khoản");
            System.out.println("4. Hiển thị các tài khoản");
            System.out.println("5. tìm tài khoản");
            System.out.println("6. Thoát ");

           String choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    accountService.addNewTaiKhoanTietKiem();
                    break;
                case "2":
                    accountService.addNewTaiKhoanThanhToan();
                    break;
                case "3":
                    accountService.delete();
                    break;
                case "4":
                    accountService.display();
                    break;
                case "5":
                    accountService.find();
                    break;
                case "6":
                    System.exit(5);
                    break;
            }
        }
    }
}
