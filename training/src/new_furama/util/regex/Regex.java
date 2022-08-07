package new_furama.util.regex;

import new_furama.model.Customer;
import new_furama.model.facility.Facility;
import new_furama.util.NotFoundCustomerException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Regex {
    static Scanner scanner = new Scanner(System.in);
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
    public static boolean checkIdCustomer(List<Customer> customerList, String id){

        boolean check = true;
        for (Customer item: customerList) {
            if(id.equals(item.getIdCustomer())){
                check = false;
                break;
            }
        }
        return check;
    }
    public static Customer checkCustomerToEdit(List<Customer> customers, String checkList) throws NotFoundCustomerException {
        boolean check = true;
        for (Customer item : customers) {
            if (item.getIdCustomer().equals(checkList)){
                check = false;
                return item;
            }
        }
        if (check){
            throw new NotFoundCustomerException();
        }
        return null;
    }
    public static Facility checkFacilityToDelete(Map<Facility, Integer> facilityList, String checkList){
        for (Map.Entry<Facility, Integer> element : facilityList.entrySet()) {
            if (element.getKey().getIdFacility().equals(checkList)){
                return element.getKey();
            }
        }
        return null;
    }
}
