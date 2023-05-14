package src.apartmentsPart;

import src.itemsInterface.ApartmentOperations;

import java.util.List;

public class Apartments implements ApartmentOperations {
    private String apartmentNumber;
    private int numberOfBathrooms;
    private double costRentPerNight;
    private List<String> amenities;
    //aggregation
    private List<Tenant> tenantes;
    public double calculateRentCost;

    public Apartments(String apartmentNumber, int numberOfBathrooms, double costRentPerNight, List<String> amenities, List<Tenant> tenantes) {
        this.apartmentNumber = apartmentNumber;
        this.numberOfBathrooms = numberOfBathrooms;
        this.costRentPerNight = costRentPerNight;
        this.amenities = amenities;
        this.tenantes = tenantes;
    }

    public Apartments(String apartmentNumber, int numberOfBathrooms, double costRentPerNight) {
    }

    public Apartments(String apartmentNumber, int numberOfBathrooms, double costRentPerNight, List<String> amenities) {
    }

    //for default method
    public double calculateTotalCost(int numberOfNights) {
        return ApartmentOperations.super.calculateTotalCost(costRentPerNight, numberOfNights);
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public double getCostRentPerNight() {
        return costRentPerNight;
    }

    public void setCostRentPerNight(double costRentPerNight) {
        this.costRentPerNight = costRentPerNight;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public List<Tenant> getTenantes() {
        return tenantes;
    }

    public void setTenantes(List<Tenant> tenants) {
        this.tenantes = tenantes;
    }
}
