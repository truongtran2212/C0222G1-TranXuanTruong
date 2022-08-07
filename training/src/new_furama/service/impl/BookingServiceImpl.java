package new_furama.service.impl;

import new_furama.model.Booking;
import new_furama.model.Customer;
import new_furama.model.facility.Facility;
import new_furama.service.BookingService;
import new_furama.util.NotFoundCustomerException;
import new_furama.util.ReadAndWrite;
import new_furama.util.regex.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.*;

public class BookingServiceImpl implements BookingService {

    public static Scanner scanner = new Scanner(System.in);
    public static final String FILE_BOOKING = "src\\new_furama\\data\\booking.csv";
    public List<Booking> bookingList = getBookingList();

    @Override
    public void display() {
        bookingList = getBookingList();

        for (Booking item : bookingList) {
            System.out.println(item);
        }
    }

    public List<Booking> getBookingList() {
        List<Booking> bookingList = new ArrayList<>();
        List<String[]> list = ReadAndWrite.readFile(FILE_BOOKING);

        for (String[] item : list) {
            bookingList.add(new Booking(item[0], item[1], item[2], item[3], item[4]));
        }
        return bookingList;
    }

    //    private String idBooking;
//    private String idCustomer;
//    private String idFacility;
    @Override
    public void addNew() {
        bookingList = getBookingList();
        int id = bookingList.size() + 1;

        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();

        System.out.println("input time checkin");
        String startTime = dateCheck();
        System.out.println("input time checkout");
        String endTime = afterBeforeCheck(startTime);

        Booking booking = new Booking(String.valueOf(id), customer.getIdCustomer(), facility.getIdFacility(), startTime, endTime);
        bookingList.add(booking);

        updateFile(bookingList);
        System.out.println("booking succesful");
    }

    public static Customer chooseCustomer() {


        System.out.println("Input id Customer");
        String id;
        List<Customer> listCustomerNoBooking = new LinkedList<>();

        for (Customer item : CustomerServiceImpll.customerList) {
            if (item.getBooking().equals("No")) {
                listCustomerNoBooking.add(item);
                System.out.println(item);
            }
        }

        Customer customer;
        while (true) {
            id = Regex.checkRegex(CustomerServiceImpll.ID_CUSTOMER);
            try {
                customer = Regex.checkCustomerToEdit(listCustomerNoBooking, id);
                break;
            } catch (NotFoundCustomerException e) {
                System.out.println("Not Found");
            }
        }
        customer.setBooking("Yes");
        CustomerServiceImpll.updateFile(CustomerServiceImpll.customerList);
        return customer;
    }

    public static Facility chooseFacility() {

        Map<Facility, Integer> facilityIntegerLinkedHashMap = new LinkedHashMap<>();

        for (Map.Entry<Facility, Integer> item : FacilityServiceImpl.facilityIntegerMap.entrySet()) {
            if (item.getValue() < 5) {
                facilityIntegerLinkedHashMap.put(item.getKey(), item.getValue());
                System.out.println(item.getKey() + ", rent amount=" + item.getValue());
            }
        }

        int choose = 0;
        String regex = null;
        boolean check = true;
        while (check) {
            System.out.println("------------Choose Facility-------------");
            System.out.println("1. Villa");
            System.out.println("2. House");
            System.out.println("3. Room");
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("wrong format");
            }
            switch (choose) {
                case 1:
                    regex = FacilityServiceImpl.ID_VILLA;
                    check = false;
                    break;
                case 2:
                    regex = FacilityServiceImpl.ID_HOUSE;
                    check = false;
                    break;
                case 3:
                    regex = FacilityServiceImpl.ID_ROOM;
                    check = false;
                    break;
            }
        }
        System.out.println("input id facility you want booking");


        String id;
        Facility facility;

        while (true) {
            id = Regex.checkRegex(regex);
            facility = Regex.checkFacilityToDelete(facilityIntegerLinkedHashMap, id);
            if (facility == null) {
                System.out.println("No have id in this list");
            } else {
                break;
            }
        }
        for (Map.Entry<Facility, Integer> item : FacilityServiceImpl.facilityIntegerMap.entrySet()) {
            if (item.getKey().getIdFacility().equals(facility.getIdFacility())) {
                item.setValue(item.getValue() + 1);
            }
        }
        FacilityServiceImpl.updateFile(FacilityServiceImpl.facilityIntegerMap);
        return facility;
    }

    @Override
    public void edit() {

    }

    public static void updateFile(List<Booking> bookingList) {
        List<String> stringList = new ArrayList<>();
        for (Booking item : bookingList) {
            stringList.add(item.getLine());
        }
        ReadAndWrite.writeFile(FILE_BOOKING, stringList);
    }

    public static void dateTimeCheck(String time) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        LocalDate localDate1 = LocalDate.parse(time, formatter);
    }

    public static void afterBefore(String startTime, String endTime) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
        LocalDate localDate1 = LocalDate.parse(startTime, formatter);
        LocalDate localDate2 = LocalDate.parse(endTime, formatter);

        if (localDate1.isAfter(localDate2)) {
            throw new Exception();
        }
    }

    public static String dateCheck() {
        String dateCheck;
        while (true) {
            try {
                dateCheck = scanner.nextLine();
                dateTimeCheck(dateCheck);
                break;
            } catch (Exception ignored) {
                System.err.println("Input wrong format");
            }
        }
        return dateCheck;
    }

    public static String afterBeforeCheck(String startTime) {
        String endTime;
        while (true) {
            try {
                endTime = scanner.nextLine();
                afterBefore(startTime, endTime);
                break;
            } catch (Exception ignored) {
                System.err.println("Input wrong format");
            }
        }
        return endTime;
    }
}
