package new_furama.service.impl;

import new_furama.model.facility.Facility;
import new_furama.model.facility.House;
import new_furama.model.facility.Room;
import new_furama.model.facility.Villa;
import new_furama.service.FacilityService;
import new_furama.util.ReadAndWrite;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {

    public Scanner scanner = new Scanner(System.in);
    public static final String ID_VILLA = "^SVVL-[0-9]{4}-[A-Z]$";
    public static final String ID_ROOM = "^SVRO-[0-9]{4}-[A-Z]$";
    public static final String ID_HOUSE = "^SVHO-[0-9]{4}-[A-Z]$";

    public static final String NAME_FACILITY = "^[A-Z][a-zA-Z]+$";
    public static Map<Facility, Integer> facilityIntegerMap = getFacilityIntegerMap();

    public static final String FILE_FACILITY = "src\\new_furama\\data\\facility.csv";

    @Override
    public void display() {
        facilityIntegerMap = getFacilityIntegerMap();

        for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
            System.out.println(item.getKey() + " amount rent: " + item.getValue());
        }
    }

    public static Map<Facility, Integer> getFacilityIntegerMap() {
        Map<Facility, Integer> facilityList = new LinkedHashMap<>();
        List<String[]> listString = ReadAndWrite.readFile(FILE_FACILITY);

        for (String[] item : listString) {
            if (item[1].equals("Villa")) {
                facilityList.put(new Villa(item[0], item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3]))
                        , Integer.parseInt(item[4]));
            } else if (item[1].equals("House")) {
                facilityList.put(new House(item[0], item[1], Integer.parseInt(item[2]))
                        , Integer.parseInt(item[3]));
            } else {
                facilityList.put(new Room(item[0], item[1], Integer.parseInt(item[2]))
                        , Integer.parseInt(item[3]));
            }
        }
        return facilityList;
    }


    //    private String idFacility;
//    private String nameFacility;
//    private int feeRent;
    @Override
    public void addNewVilla() {
        facilityIntegerMap = getFacilityIntegerMap();
        System.out.println("Input id villa ");
        String idVilla;
        while (true) {
            idVilla = scanner.nextLine();
            if (idVilla.matches(ID_VILLA)) {
                break;
            } else {
                System.err.println("Wrong format");
            }
        }
        System.out.println("input name facility");
        String nameFacility;
        while (true) {
            nameFacility = scanner.nextLine();
            if (nameFacility.matches(NAME_FACILITY)) {
                break;
            } else {
                System.err.println("Wrong format");
            }
        }
        System.out.println("Input rentPrice");
        int rentPrice;
        while (true) {
            rentPrice = Integer.parseInt(scanner.nextLine());
            try {
                if (rentPrice > 0) {
                    break;
                } else {
                    System.out.println("Can't input negative number");
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format");
            }
        }
        System.out.println("Input pool area");
        int poolArea;
        while (true) {
            poolArea = Integer.parseInt(scanner.nextLine());
            try {
                if (poolArea > 0) {
                    break;
                } else {
                    System.out.println("Can't input negative number");
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format");
            }
        }

        facilityIntegerMap.put(new Villa(idVilla, nameFacility, rentPrice, poolArea), 0);

        updateFile(facilityIntegerMap);
    }

    @Override
    public void addNewHouse() {
        facilityIntegerMap = getFacilityIntegerMap();
        System.out.println("Input id house ");
        String idHouse;
        while (true) {
            idHouse = scanner.nextLine();
            if (idHouse.matches(ID_HOUSE)) {
                break;
            } else {
                System.err.println("Wrong format");
            }
        }
        System.out.println("input name facility");
        String nameFacility;
        while (true) {
            nameFacility = scanner.nextLine();
            if (nameFacility.matches(NAME_FACILITY)) {
                break;
            } else {
                System.err.println("Wrong format");
            }
        }
        System.out.println("Input rentPrice");
        int rentPrice;
        while (true) {
            rentPrice = Integer.parseInt(scanner.nextLine());
            try {
                if (rentPrice > 0) {
                    break;
                } else {
                    System.out.println("Can't input negative number");
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format");
            }
        }

        facilityIntegerMap.put(new House(idHouse, nameFacility, rentPrice), 0);

        updateFile(facilityIntegerMap);
    }


    @Override
    public void addNewRoom() {
        facilityIntegerMap = getFacilityIntegerMap();
        System.out.println("Input id room ");
        String idRoom;
        while (true) {
            idRoom = scanner.nextLine();
            if (idRoom.matches(ID_ROOM)) {
                break;
            } else {
                System.err.println("Wrong format");
            }
        }
        System.out.println("input name facility");
        String nameFacility;
        while (true) {
            nameFacility = scanner.nextLine();
            if (nameFacility.matches(NAME_FACILITY)) {
                break;
            } else {
                System.err.println("Wrong format");
            }
        }
        System.out.println("Input rentPrice");
        int rentPrice;
        while (true) {
            rentPrice = Integer.parseInt(scanner.nextLine());
            try {
                if (rentPrice > 0) {
                    break;
                } else {
                    System.out.println("Can't input negative number");
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format");
            }
        }

        facilityIntegerMap.put(new House(idRoom, nameFacility, rentPrice), 0);

        updateFile(facilityIntegerMap);
    }

    @Override
    public void edit() {

    }

    public static void updateFile(Map<Facility, Integer> facilityIntegerMap) {
        List<String> stringList = new ArrayList<>();
        for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
            stringList.add(item.getKey().getLine() + "," + item.getValue());

        }
        ReadAndWrite.writeFile(FILE_FACILITY, stringList);
    }
}
