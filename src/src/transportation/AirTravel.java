package src.transportation;

import java.time.LocalDate;

public class AirTravel extends Transportation{
    private String airlineName;

    // Constructor
    public AirTravel(String destination, LocalDate startDate, LocalDate endDate, String airlineName) {
        super(destination, startDate, endDate);
        this.airlineName = airlineName;
    }

    // Getters and setters
    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}
