package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class OperatorExpression {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner danger = new Scanner(System.in);//Khai báo đối tượng Scanner

        System.out.println("Enter width: ");
        width = danger.nextFloat();//Nhập chiều rộng

        System.out.println("Enter height: ");
        height = danger.nextFloat();//Nhập chiều dài
        float area = width * height;

        System.out.println("Area is: " + area);
    }
}
