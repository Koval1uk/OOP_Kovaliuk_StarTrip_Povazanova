package src.transportation;

import java.time.LocalDate;

public class RoadTrip extends Transportation{
    private String carType;

    // Constructor
    public RoadTrip(String destination, LocalDate startDate, LocalDate endDate, String carType) {
        super(destination, startDate, endDate);
        this.carType = carType;
    }

    // Getters and setters
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
