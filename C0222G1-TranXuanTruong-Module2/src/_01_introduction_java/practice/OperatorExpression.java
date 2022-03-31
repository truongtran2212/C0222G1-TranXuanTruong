package _01_introduction_java.practice;

import java.util.Scanner;

public class OperatorExpression {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner danger = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = danger.nextFloat();

        System.out.println("Enter height: ");
        height = danger.nextFloat();
        float area = width * height;

        System.out.println("Area is: " + area);
    }
}
