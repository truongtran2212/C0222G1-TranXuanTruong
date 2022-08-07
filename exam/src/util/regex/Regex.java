package util.regex;

import java.util.Scanner;

public class Regex {
    public static Scanner scanner = new Scanner(System.in);

    public static String checkRegex(String regex){

        String checkRegex;
        while (true){
            checkRegex = scanner.nextLine();
            if(checkRegex.matches(regex)){
                return checkRegex;
            }else{
                System.err.println("Wrong format");
            }
        }
    }
}
