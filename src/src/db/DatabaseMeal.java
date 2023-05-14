package src.db;

import src.mode.Restaurants;

import java.util.ArrayList;
import java.util.Random;

public class DatabaseMeal {

    public static ArrayList<Restaurants> restaurantsTable = new ArrayList<>();

    static {
        restaurantsTable.add(
                new Restaurants("R00M-001", "ITALIAN", "LUNCH", 3, 4500.00)
        );
        restaurantsTable.add(
                new Restaurants("ROOM-002", "MEXICAN", "DINNER", 4, 5500.00)
        );
        restaurantsTable.add(
                new Restaurants("ROOM-003", "INDIAN", "BREAKFAST,LUNCH", 5, 3500.00)
        );
        restaurantsTable.add(
                new Restaurants("ROOM-004", "THAI", "DINNER", 1, 2500.00)
        );

    }

    static String generateRandomRoom() {
        Random rand = new Random();
        int roomNumber = rand.nextInt(100) + 1;
        return "ROOM-" + String.format("%03d", roomNumber);
    }

    static String generateRandomCuisine() {
        String[] cuisines = {
                "Japanese", "Korean", "Greek", "Vietnamese", "Lebanese",
                "Thai", "Mexican", "Italian", "Indian", "French"
        };
        Random rand = new Random();
        return cuisines[rand.nextInt(cuisines.length)];
    }

    static String generateRandomMeals() {
        String[] meals = {
                "Breakfast", "Lunch", "Dinner", "Brunch", "Snacks"
        };
        Random rand = new Random();
        StringBuilder mealsString = new StringBuilder();
        int numberOfMeals = rand.nextInt(3) + 1;
        for (int i = 0; i < numberOfMeals; i++) {
            mealsString.append(meals[rand.nextInt(meals.length)]);
            if (i != numberOfMeals - 1) {
                mealsString.append(",");
            }
        }
        return mealsString.toString();
    }

    static int generateRandomRating() {
        Random rand = new Random();
        return rand.nextInt(5) + 1;
    }

    static double generateRandomPrice() {
        Random rand = new Random();
        return rand.nextDouble() * 10000 + 1000;
    }

    static void printRestaurantsTable() {
        for (Restaurants restaurant : restaurantsTable) {
            System.out.println("Room: " + restaurant.getRoom());
            System.out.println("Cuisine: " + restaurant.getCuisine());
            System.out.println("Meals: " + restaurant.getMeals());
            System.out.println("Rating: " + restaurant.getRating());
            System.out.println("Price: " + restaurant.getPrice());
            System.out.println("--------------------------");
        }
    }
}

