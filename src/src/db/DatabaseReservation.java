package src.db;

import src.mode.User;

import java.util.ArrayList;
import java.util.Random;

public class DatabaseReservation {

    public static ArrayList<User> userTable = new ArrayList<>();

    static {
        userTable.add(
                new User("John Smith", "123456789", "555-1234", "john.smith@example.com", "123 Main St", "Room 101")
        );
        userTable.add(
                new User("Alice Johnson", "987654321", "555-5678", "alice.johnson@example.com", "456 Elm St", "Room 202")
        );
        userTable.add(
                new User("Michael Davis", "456789123", "555-4321", "michael.davis@example.com", "789 Oak St", "Room 303")
        );
        userTable.add(
                new User("Emily Wilson", "321654987", "555-8765", "emily.wilson@example.com", "987 Pine St", "Room 404")
        );
        userTable.add(
                new User("David Brown", "159753468", "555-9876", "david.brown@example.com", "654 Cedar St", "Room 505")
        );
        userTable.add(
                new User("Sarah Taylor", "852741963", "555-2345", "sarah.taylor@example.com", "321 Maple St", "Room 606")
        );
        userTable.add(
                new User("Matthew Anderson", "369258147", "555-3456", "matthew.anderson@example.com", "852 Walnut St", "Room 707")
        );
        userTable.add(
                new User("Olivia Martinez", "741852963", "555-6789", "olivia.martinez@example.com", "963 Birch St", "Room 808")
        );
        userTable.add(
                new User("Daniel Wilson", "258741369", "555-7890", "daniel.wilson@example.com", "147 Cherry St", "Room 909")
        );
        userTable.add(
                new User("Sophia Thompson", "654123987", "555-9012", "sophia.thompson@example.com", "369 Elm St", "Room 1010")
        );

    }

    static String generateRandomName() {
        String[] names = {
                "John Doe", "Alice Smith", "Michael Johnson", "Emily Williams", "David Brown",
                "Sarah Davis", "Matthew Wilson", "Olivia Anderson", "Daniel Martinez", "Sophia Taylor"
        };
        Random rand = new Random();
        return names[rand.nextInt(names.length)];
    }

    static String generateRandomID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }

    static String generateRandomPhoneNumber() {
        Random rand = new Random();
        StringBuilder phoneNumber = new StringBuilder("555-");
        for (int i = 0; i < 4; i++) {
            phoneNumber.append(rand.nextInt(10));
        }
        return phoneNumber.toString();
    }

    static String generateRandomEmail() {
        String[] domains = {"example.com", "gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
        Random rand = new Random();
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            email.append((char) (rand.nextInt(26) + 'a'));
        }
        email.append("@");
        email.append(domains[rand.nextInt(domains.length)]);

        return email.toString();
    }

    static void printUserTable() {
        for (User user : userTable) {
            System.out.println("Name: " + user.getName());
            System.out.println("ID: " + user.getId());
            System.out.println("Phone Number: " + user.getPhoneNumber());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Address: " + user.getAddress());
            System.out.println("Room: " + user.getRoom());
            System.out.println("--------------------------");
        }
    }
}