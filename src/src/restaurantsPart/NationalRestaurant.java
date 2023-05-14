package src.restaurantsPart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NationalRestaurant extends IndoorCusine implements Serializable {
        private static final long serialVersionUID = 1L;
        private String cuisine;
        private String countryOfOrigin;

// lambda a multithreading
    public List<TraditionalDish> filterDishes(String keyword) {
        Predicate<TraditionalDish> dishFilter = dish -> dish.getDescription().contains(keyword);

        // Use Executor framework to run filter in parallel
        int numCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numCores);
        List<Future<List<TraditionalDish>>> futures = new ArrayList<>();
        int chunkSize = dishes.size() / numCores;
        for (int i = 0; i < numCores; i++) {
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize;
            if (i == numCores - 1) {
                end = dishes.size();
            }
            List<TraditionalDish> subList = dishes.subList(start, end);
            Callable<List<TraditionalDish>> task = () -> subList.stream().filter(dishFilter).collect(Collectors.toList());
            futures.add(executor.submit(task));
        }
        List<TraditionalDish> filteredDishes = new ArrayList<>();
        for (Future<List<TraditionalDish>> future : futures) {
            try {
                filteredDishes.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        return filteredDishes;
    }

//         Lambda
//    public List<TraditionalDish> filterDishes(String keyword) {
//        Predicate<TraditionalDish> dishFilter = dish -> dish.getDescription().contains(keyword);
//        return dishes.stream().filter(dishFilter).collect(Collectors.toList());
//    }

        // Constructor
        public NationalRestaurant(String name, String location, int rating, double priceRange, String cuisine, String countryOfOrigin) {
            super(name, location, rating, priceRange);
            this.cuisine = cuisine;
            this.countryOfOrigin = countryOfOrigin;
        }

        // Getters and setters
        public String getCuisine() {
            return cuisine;
        }

        public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }

        public String getCountryOfOrigin() {
            return countryOfOrigin;
        }

        public void setCountryOfOrigin(String countryOfOrigin) {
            this.countryOfOrigin = countryOfOrigin;
        }

        // Polymorphism - rewriting profileSetting method
        public String profileSetting() {
            return "NationalRestaurant{" +
                    "name='" + getName() + '\'' +
                    ", location='" + getLocation() + '\'' +
                    ", rating=" + getRating() +
                    ", priceRange=" + getPriceRange() +
                    ", cuisine='" + cuisine + '\'' +
                    ", countryOfOrigin='" + countryOfOrigin + '\'' +
                    '}';
        }

        // Aggregation - adding a List of TraditionalDishes
        private List<TraditionalDish> dishes = new ArrayList<>();

        public void addDish(TraditionalDish dish) {
            dishes.add(dish);
        }

        public List<TraditionalDish> getDishes() {
            return dishes;
        }

        public void setDishes(List<TraditionalDish> dishes) {
            this.dishes = dishes;
        }
    }

    class TraditionalDish implements Serializable{
        private String name;
        private String description;
        private static final long serialVersionUID = 1L;

        // Constructor
        public TraditionalDish(String name, String description) {
            this.name = name;
            this.description = description;
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
    }

