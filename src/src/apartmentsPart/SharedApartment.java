package src.apartmentsPart;

import java.util.List;

public class SharedApartment extends Apartments{
    private int numberOfBeds;
    private boolean isMixedGenderAllowed;
    private List<Tenant> tenants;

    public SharedApartment(String apartmentNumber, int numberOfBathrooms, double costRentPerNight, List<String> amenities, int numberOfBeds, boolean isMixedGenderAllowed) {
        super(apartmentNumber, numberOfBathrooms, costRentPerNight, amenities);
        this.numberOfBeds = numberOfBeds;
        this.isMixedGenderAllowed = isMixedGenderAllowed;
        this.tenants = tenants;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isMixedGenderAllowed() {
        return isMixedGenderAllowed;
    }

    public void setMixedGenderAllowed(boolean isMixedGenderAllowed) {
        this.isMixedGenderAllowed = isMixedGenderAllowed;
    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }
}
