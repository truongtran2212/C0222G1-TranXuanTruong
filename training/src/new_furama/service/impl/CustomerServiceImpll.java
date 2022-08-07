package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.util.ReadAndWrite;
import com.codegym.util.RegexData;
import com.codegym.util.regex.Regex;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import javafx.scene.transform.Scale;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpll implements CustomerService {

    public Scanner scanner = new Scanner(System.in);
    public static List<Customer> customerList = getCustomerList();
    public static final String FILE_CUSTOMER = "src\\com\\codegym\\data\\customer\\customer.csv";

    public static final String ID_CUSTOMER = "^CUS-[0-9]{4}-[A-Z]$";
    public static final String NAME_CUSTOMER = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}";
    static final String DATE_OF_BIRTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public void display() {

        customerList = getCustomerList();
        for (Customer item : customerList) {
            System.out.println(item.toString());
        }
    }

    //    private String idCustomer;
//    private String nameCustomer;
//    private String dateOfBirth;
//    private Boolean booking;
    public static List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        List<String[]> list = ReadAndWrite.readFile(FILE_CUSTOMER);

        for (String[] item : list) {
            customerList.add(new Customer(item[0], item[1], item[2], item[3]));
        }
        return customerList;
    }

    @Override
    public void addNew() {
        customerList = getCustomerList();

        System.out.println("Input id Customer");
        String idCustomer;


        idCustomer = Regex.checkRegex(ID_CUSTOMER);
        boolean check = Regex.checkIdCustomer(customerList,idCustomer);
        if(check) {
            System.out.println("Input name customer");
            String nameCustomer;
            while (true) {
                nameCustomer = scanner.nextLine();
                if (nameCustomer.matches(NAME_CUSTOMER)) {
                    break;
                } else {
                    System.out.println("Wrong format");
                }
            }
            System.out.println("Input dateOfBirth");
            String dateOfBirth = RegexData.regexAge(scanner.nextLine(), DATE_OF_BIRTH);


            customerList.add(new Customer(idCustomer, nameCustomer, dateOfBirth, "No"));

            updateFile(customerList);
            System.out.println("add success");
        }else{
            System.out.println("Đã có id này");
        }



    }

    @Override
    public void edit() {
        customerList = getCustomerList();

        System.out.println("Input id Customer");
        String idCustomer;
        while (true) {
            idCustomer = scanner.nextLine();
            if (idCustomer.matches(ID_CUSTOMER)) {
                break;
            } else {
                System.out.println("Wrong format");
            }
        }
        boolean check = false;
        int index = 0;
        for (int i = 0; i < customerList.size(); i++) {
            if (idCustomer.equals(customerList.get(i).getIdCustomer())) {
                index = i;
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Input name customer");
            String nameCustomer;
            while (true) {
                nameCustomer = scanner.nextLine();
                if (nameCustomer.matches(NAME_CUSTOMER)) {
                    customerList.get(index).setNameCustomer(nameCustomer);
                    break;
                } else {
                    System.out.println("Wrong format");
                }
            }
            System.out.println("Input dateOfBirth");
            String dateOfBirth = scanner.nextLine();
            customerList.get(index).setDateOfBirth(dateOfBirth);

            System.out.println("Input booking");
            String booking = scanner.nextLine();
            customerList.get(index).setBooking(booking);

            updateFile(customerList);
            System.out.println("add success");

        } else {
            System.out.println("no have this id in list");
        }
    }

    public static void updateFile(List<Customer> customerList) {
        List<String> stringList = new ArrayList<>();
        for (Customer item : customerList) {
            stringList.add(item.getLine());
        }
        ReadAndWrite.writeFile(FILE_CUSTOMER, stringList);
    }
}