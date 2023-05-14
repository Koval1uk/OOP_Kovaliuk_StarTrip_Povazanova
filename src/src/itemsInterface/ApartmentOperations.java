package src.itemsInterface;

import src.apartmentsPart.Tenant;
import src.apartmentsPart.*;

import java.util.Date;
import java.util.List;

public interface ApartmentOperations {
    default double calculateTotalCost(double costRentPerNight, int numberOfNights) {
        return costRentPerNight * numberOfNights;
    }
}