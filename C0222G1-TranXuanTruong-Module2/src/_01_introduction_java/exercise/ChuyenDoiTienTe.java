package _01_introduction_java.exercise;

import java.util.Scanner;

public class ChuyenDoiTienTe {
        public static void main(String[] args) {
            Scanner change = new Scanner(System.in);
            System.out.println("Nhập USD");
            int rate = 23000;
            int usd = change.nextInt();
            System.out.println(usd + " USD đổi sang VND là: " + usd*rate + " VND");
        }
}
