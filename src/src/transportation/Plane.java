package src.transportation;

import java.time.LocalDate;

public class Plane extends AirTravel{
    private String planeType;

    // Constructor
    public Plane(String destination, LocalDate startDate, LocalDate endDate, String airlineName, String planeType) {
        super(destination, startDate, endDate, airlineName);
        this.planeType = planeType;
    }

    // Getter and setter
    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }
}
