package src.transportation;
import java.time.LocalDate;

public abstract class Transportation {
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private TransportationCostCalculator costCalculator;

    // Constructor
    public Transportation(String destination, LocalDate startDate, LocalDate endDate, TransportationCostCalculator costCalculator) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.costCalculator = costCalculator;
    }

    public Transportation(String destination, LocalDate startDate, LocalDate endDate) {
    }

    // Getters and setters
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Method to calculate transportation cost
    public double calculateTransportCost() {
        return costCalculator.calculateTransportCost(startDate, endDate);
    }

    // Nested interface for transportation cost calculator
    public interface TransportationCostCalculator {
        double calculateTransportCost(LocalDate startDate, LocalDate endDate);
    }

    // Nested class for distance-based transportation cost calculation
    public static class DistanceBasedTransportationCostCalculator implements TransportationCostCalculator {
        private double costPerKilometer;

        public DistanceBasedTransportationCostCalculator(double costPerKilometer) {
            this.costPerKilometer = costPerKilometer;
        }

        @Override
        public double calculateTransportCost(LocalDate startDate, LocalDate endDate) {
            // Implementation to calculate transportation cost based on distance goes here
            return 0.0;
        }
    }

    // Nested class for time-based transportation cost calculation
    public static class TimeBasedTransportationCostCalculator implements TransportationCostCalculator {
        private double costPerDay;

        public TimeBasedTransportationCostCalculator(double costPerDay) {
            this.costPerDay = costPerDay;
        }

        @Override
        public double calculateTransportCost(LocalDate startDate, LocalDate endDate) {
            // Implementation to calculate transportation cost based on time goes here
            return 0.0;
        }
    }
    // RTTI method
    public String getTransportType() {
        return this.getClass().getSimpleName();
    }
}

