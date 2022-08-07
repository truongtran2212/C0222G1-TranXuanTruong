package com.codegym.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);
    public static String regexAge(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                    } else {
                        throw new RegexAge("Em chưa 18");
                    }
                } else {
                    throw new RegexAge("Định dạng chưa đúng.");
                }
            } catch (RegexAge e) {
                System.err.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }
}
