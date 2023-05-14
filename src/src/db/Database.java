package src.db;

import src.mode.Apartments;

import java.util.ArrayList;
import java.util.Random;

public class Database {
    public static ArrayList<Apartments> apartmentsTable = new ArrayList<>();

    static {
        apartmentsTable.add(
                new Apartments("ROOM-10001", "SINGLE", "123456789V", "John Smith", "01/01/2023", "8:00 AM")
        );
        apartmentsTable.add(
                new Apartments("ROOM-10002", "DOUBLE", "987654321V", "Alice Johnson", "02/01/2023", "9:30 AM")
        );
        apartmentsTable.add(
                new Apartments("ROOM-10003", "TRIPLE", "456789123V", "Michael Davis", "03/01/2023", "10:45 AM")
        );
        apartmentsTable.add(
                new Apartments("ROOM-10004", "DOUBLE", "654321987V", "Emily Wilson", "04/01/2023", "12:15 PM")
        );
        apartmentsTable.add(
                new Apartments("ROOM-10005", "SINGLE", "789456123V", "David Brown", "05/01/2023", "2:30 PM")
        );
    }

    static String generateRandomRoom() {
        Random rand = new Random();
        int roomNumber = rand.nextInt(9000) + 1001;
        return "ROOM-" + roomNumber;
    }

    static String generateRandomType() {
        String[] types = {"SINGLE", "DOUBLE", "TRIPLE"};
        Random rand = new Random();
        return types[rand.nextInt(types.length)];
    }

    static String generateRandomID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }

    static String generateRandomName() {
        String[] names = {
                "John Doe", "Alice Smith", "Michael Johnson", "Emily Williams", "David Brown",
                "Sarah Davis", "Matthew Wilson", "Olivia Anderson", "Daniel Martinez", "Sophia Taylor"
        };
        Random rand = new Random();
        return names[rand.nextInt(names.length)];
    }

    static String generateRandomDate() {
        Random rand = new Random();
        int day = rand.nextInt(28) + 1;
        int month = rand.nextInt(12) + 1;
        int year = rand.nextInt(5) + 2023;
        return String.format("%02d", day) + "/" + String.format("%02d", month) + "/" + year;
    }

    static String generateRandomTime() {
        Random rand = new Random();
        int hours = rand.nextInt(12) + 1;
        int minutes = rand.nextInt(60);
        String time = String.format("%02d", hours) + ":" + String.format("%02d", minutes);
        if (rand.nextBoolean()) {
            time += " AM";
        } else {
            time += " PM";
        }
        return time;
    }

    static void printApartmentsTable() {
        for (Apartments apartment : apartmentsTable) {
            System.out.println("Room: " + apartment.getRoom());
            System.out.println("Type: " + apartment.getType());
            System.out.println("ID: " + apartment.getID());
            System.out.println("Tenant Name: " + apartment.getTenantName());
            System.out.println("MoveIn Date: " + apartment.getMoveInDate());
            System.out.println("Move Out Time: " + apartment.getMoveOutTime());
            System.out.println("--------------------------");
        }
    }
}
