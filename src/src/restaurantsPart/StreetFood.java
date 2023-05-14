package src.restaurantsPart;

import java.util.ArrayList;
import java.util.List;

public class StreetFood extends Restaurants {
        private String cuisine;
        private boolean hasFoodCart;

        // Constructor
        public StreetFood(String name, String location, int rating, double priceRange, String cuisine, boolean hasFoodCart) {
            super(name, location, rating, priceRange);
            this.cuisine = cuisine;
            this.hasFoodCart = hasFoodCart;
        }

        // Getters and setters
        public String getCuisine() {
            return cuisine;
        }

        public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }

        public boolean hasFoodCart() {
            return hasFoodCart;
        }

        public void setHasFoodCart(boolean hasFoodCart) {
            this.hasFoodCart = hasFoodCart;
        }

   //    Polymorphism - rewriting profileSetting method
        public String profileSetting() {
            return "StreetFood{" +
                    "name='" + getName() + '\'' +
                    ", location='" + getLocation() + '\'' +
                    ", rating=" + getRating() +
                    ", priceRange=" + getPriceRange() +
                    ", cuisine='" + cuisine + '\'' +
                    ", hasFoodCart=" + hasFoodCart +
                    '}';
        }

        // Aggregation - adding a List of MenuItems
        private List<MenuItem> menu = new ArrayList<>();

        public void addMenuItem(MenuItem item) {
            menu.add(item);
        }

        public List<MenuItem> getMenu() {
            return menu;
        }

        public void setMenu(List<MenuItem> menu) {
            this.menu = menu;
        }
    }

    class MenuItem {
        private String name;
        private String description;
        private double price;

        // Constructor
        public MenuItem(String name, String description, double price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

