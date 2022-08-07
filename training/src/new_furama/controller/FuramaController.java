package com.codegym.controller;

import com.codegym.service.impl.BookingServiceImpl;
import com.codegym.service.impl.CustomerServiceImpll;
import com.codegym.service.impl.FacilityServiceImpl;
import javafx.scene.transform.Scale;

import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        displayMainMenu();
    }

    public static void displayMainMenu() {

        int choose;
        while (true) {
            System.out.println("1. Display list customer ");
            System.out.println("2. Display list booking");
            System.out.println("3. Display list facility ");
            System.out.println("4. Exit");


            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    displayMenuCustomer();
                    break;
                case 2:
                    displayMenuBooking();
                    break;
                case 3:
                    displayMenuFacility();
                    break;
                case 4:
                    System.exit(4);
                    break;
            }
        }
    }

    public static void displayMenuCustomer() {
        CustomerServiceImpll customerService = new CustomerServiceImpll();

        while (true) {
            try {
                System.out.println("--------Customer Menu----------");
                System.out.println("1. Display list customer");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Return main menu");

                System.out.println("Chọn 1 option ");
                int choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        customerService.display();
                        break;
                    case 2:
                        customerService.addNew();
                        break;
                    case 3:
                        customerService.edit();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Input number 1 to 4");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public static void displayMenuFacility() {

        FacilityServiceImpl facilityService = new FacilityServiceImpl();

        while (true) {
            try {
                System.out.println("--------Facility Menu----------");
                System.out.println("1. Display list facility");
                System.out.println("2. Add new facility");
                System.out.println("3. Edit facility");
                System.out.println("4. Return main menu");

                System.out.println("Chọn 1 option ");


                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        facilityService.display();
                        break;
                    case 2:
                        addNewMenuFacility();
                        break;
                    case 3:
                        facilityService.edit();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Input number 1 to 4");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
    public static void addNewMenuFacility() {

        FacilityServiceImpl facilityService = new FacilityServiceImpl();

        while (true) {
            try {
                System.out.println("--------Facility New Menu----------");
                System.out.println("1. Add new villa");
                System.out.println("2. Add new house");
                System.out.println("3. Add new room");
                System.out.println("4. Return main menu");

                System.out.println("Chọn 1 option ");

                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        facilityService.addNewVilla();
                        displayMenuFacility();
                        break;
                    case 2:
                        facilityService.addNewHouse();
                        displayMenuFacility();
                        break;
                    case 3:
                        facilityService.addNewRoom();
                        displayMenuFacility();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Input number 1 to 4");

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
    public static void displayMenuBooking() {
        BookingServiceImpl bookingService = new BookingServiceImpl();


        while (true) {
            try {
                System.out.println("--------Booking Menu----------");
                System.out.println("1. Add new booking");
                System.out.println("2. display list booking");
                System.out.println("3. Edit contracts");
                System.out.println("4. Return main menu");

                System.out.println("Chọn 1 option ");

                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        bookingService.addNew();
                        break;
                    case 2:
                        bookingService.display();

                        break;
                    case 3:
                        bookingService.edit();

                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Input number 1 to 6");

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

}

