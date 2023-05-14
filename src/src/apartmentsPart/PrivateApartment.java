package src.apartmentsPart;

import java.util.List;

public class PrivateApartment extends Apartments{
    private int numberOfRooms;
    private boolean isKitchenAvailable;

    public PrivateApartment(String apartmentNumber, int numberOfBathrooms, double costRentPerNight, List<String> amenities) {
        super(apartmentNumber, numberOfBathrooms, costRentPerNight);
        this.numberOfRooms = numberOfRooms;
        this.isKitchenAvailable = isKitchenAvailable;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isKitchenAvailable() {
        return isKitchenAvailable;
    }

    public void setKitchenAvailable(boolean isKitchenAvailable) {
        this.isKitchenAvailable = isKitchenAvailable;
    }
}
