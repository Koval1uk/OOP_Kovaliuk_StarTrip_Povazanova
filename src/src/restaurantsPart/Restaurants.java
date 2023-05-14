package src.restaurantsPart;

public class Restaurants implements Runnable {
    private String name;
    private String location;
    private int rating;
    private double priceRange;

    // Constructor
    public Restaurants(String name, String location, int rating, double priceRange) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.priceRange = priceRange;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(double priceRange) {
        this.priceRange = priceRange;
    }

    // Implement the run() method of the Runnable interface
    @Override
    public void run() {
        // Code to be executed in a separate thread
        System.out.println("Thread started for restaurant: " + name);
        // Add any other code you want to execute in the separate thread
    }
}