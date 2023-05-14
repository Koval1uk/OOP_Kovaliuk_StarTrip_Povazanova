package src.transportation;

import java.time.LocalDate;

public class Helicopter extends AirTravel{
    private int maxPassengers;

    // Constructor
    public Helicopter(String destination, LocalDate startDate, LocalDate endDate, String airlineName, int maxPassengers) {
        super(destination, startDate, endDate, airlineName);
        this.maxPassengers = maxPassengers;
    }

    // Getter and setter
    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
}
