package _01_introduction_java.exercise;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = src.nextLine();
        System.out.println("Hello: " + name);
    }
}
