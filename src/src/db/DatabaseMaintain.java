package src.db;

import src.mode.deletingMethod;

import java.util.ArrayList;
import java.util.Random;

public class DatabaseMaintain {

    public static ArrayList<deletingMethod> deleteTable =new ArrayList<>();

    static {

        deleteTable.add(new deletingMethod("ROOM-01", "8:30 AM"));
        deleteTable.add(new deletingMethod("ROOM-02", "9:45 PM"));
        deleteTable.add(new deletingMethod("ROOM-03", "10:15 AM"));
        deleteTable.add(new deletingMethod("ROOM-04", "11:30 PM"));
        deleteTable.add(new deletingMethod("ROOM-05", "12:45 PM"));
        deleteTable.add(new deletingMethod("ROOM-06", "1:30 AM"));
        deleteTable.add(new deletingMethod("ROOM-07", "2:00 PM"));
        deleteTable.add(new deletingMethod("ROOM-08", "3:15 AM"));
        deleteTable.add(new deletingMethod("ROOM-09", "4:45 PM"));
        deleteTable.add(new deletingMethod("ROOM-10", "5:30 AM"));
        deleteTable.add(new deletingMethod("ROOM-11", "6:00 PM"));
        deleteTable.add(new deletingMethod("ROOM-12", "7:30 AM"));
        deleteTable.add(new deletingMethod("ROOM-13", "8:45 PM"));
        deleteTable.add(new deletingMethod("ROOM-14", "9:15 AM"));
        deleteTable.add(new deletingMethod("ROOM-15", "10:30 PM"));
        deleteTable.add(new deletingMethod("ROOM-16", "11:45 AM"));
        deleteTable.add(new deletingMethod("ROOM-17", "12:15 AM"));
        deleteTable.add(new deletingMethod("ROOM-18", "1:30 PM"));
        deleteTable.add(new deletingMethod("ROOM-19", "2:45 AM"));
        deleteTable.add(new deletingMethod("ROOM-20", "3:15 PM"));
        deleteTable.add(new deletingMethod("ROOM-21", "4:30 AM"));
        deleteTable.add(new deletingMethod("ROOM-22", "5:45 PM"));
        deleteTable.add(new deletingMethod("ROOM-23", "6:15 AM"));
        deleteTable.add(new deletingMethod("ROOM-24", "7:30 PM"));
        deleteTable.add(new deletingMethod("ROOM-25", "8:45 AM"));
    }

    static String generateRandomRoom() {
        Random rand = new Random();
        int roomNumber = rand.nextInt(100) + 1;
        return "ROOM-" + String.format("%02d", roomNumber);
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

    static void printCleanTable() {
        for (deletingMethod record : deleteTable) {
            System.out.println("Room: " + record.getRoom());
            System.out.println("Cleaning Time: " + record.getCleaningTime());
            System.out.println("--------------------------");
        }
    }
}
