package do_uu_tien.controller;

import do_uu_tien.service.JobServiceImpl;

import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        displayMainMenu();
    }

    public static void displayMainMenu() {
        JobServiceImpl jobService = new JobServiceImpl();
        int choose;
        while (true) {

            System.out.println("1. Display list ");
            System.out.println("2. Add new job");
            System.out.println("3. Update job");
            System.out.println("4. Exit ");


            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    jobService.display();
                    break;
                case 2:
                    jobService.addNewJob();
                    break;
                case 3:
                    jobService.updateJob();
                    break;
                case 4:
                    System.exit(4);
                    break;
            }
        }
    }
}
