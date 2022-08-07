package _01_introduction_java.exercise;

import java.util.Scanner;

public class DoiSoThanhChu {
    public static void main(String[] args) {
        System.out.println(" Input number: ");
        Scanner src = new Scanner(System.in);
        int number = src.nextInt();

        int ones = number % 10;
        int tens = (number / 10) % 10;
        int hundreds = number / 100;

//        System.out.printf(String.valueOf(ones));
//        System.out.printf(String.valueOf(tens));
//        System.out.printf(String.valueOf(hundreds));

        String output1 = "";
        String output2 = "";
        String output3 = "";


        if(number == 0){
            System.out.println(" ");
        }else if(number < 0)
            System.out.println("out of ability");

//        System.out.printf(String.valueOf(ones));
//        System.out.printf(String.valueOf(tens));
//        System.out.printf(String.valueOf(hundreds));

        if (ones > 0) {
            switch (ones) {
                case 1:
                    output1 = "one";
                    break;
                case 2:
                    output1 = "two";
                    break;
                case 3:
                    output1 = "three";
                    break;
                case 4:
                    output1 = "four";
                    break;
                case 5:
                    output1 = "five";
                    break;
                case 6:
                    output1 = "six";
                    break;
                case 7:
                    output1 = "seven";
                    break;
                case 8:
                    output1 = "eight";
                    break;
                case 9:
                    output1 = "nine";
                    break;
            }
        }
        if (tens == 1) {
            switch (ones) {
                case 0:
                    output2 = "ten";
                    break;
                case 1:
                    output2 = "eleven";
                    break;
                case 2:
                    output2 = "twelve";
                    break;
                case 3:
                    output2 = "thirteen";
                    break;
                case 4:
                    output2 = "fourteen";
                    break;
                case 5:
                    output2 = "fifteen";
                    break;
                case 6:
                    output2 = "sixteen";
                    break;
                case 7:
                    output2 = "seventeen";
                    break;
                case 8:
                    output2 = "eighteen";
                    break;
                case 9:
                    output2 = "nineteen";
                    break;
            }
        } else {
            switch (tens) {
                case 2:
                    output2 = "twenty";
                    break;
                case 3:
                    output2 = "thirty";
                    break;
                case 4:
                    output2 = "forty";
                    break;
                case 5:
                    output2 = "fifty";
                    break;
                case 6:
                    output2 = "sixty";
                    break;
                case 7:
                    output2 = "seventy";
                    break;
                case 8:
                    output2 = "eighty";
                    break;
                case 9:
                    output2 = "ninety";
                    break;
            }
        }

        switch (hundreds) {
            case 1:
                output3 = "one hundred";
                break;
            case 2:
                output3 = "two hundred";
                break;
            case 3:
                output3 = "three hundred";
                break;
            case 4:
                output3 = "four hundred";
                break;
            case 5:
                output3 = "five hundred ";
                break;
            case 6:
                output3 = "six hundred ";
                break;
            case 7:
                output3 = "seven hundred ";
                break;
            case 8:
                output3 = "eight hundred ";
                break;
            case 9:
                output3 = "nine hundred ";
                break;
        }
        if (tens == 1 ) {
            System.out.println(output3 + " " +output2);
        }
        else {
            System.out.println(output3 + " " + output2 + " " + output1);
        }
    }
}

