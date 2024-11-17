package CottageBuisness;
import java.util.ArrayList;
import java.util.List;

public class Village {
    private final List<Amenity> amenities;
    private final List<Cottage> cottages;

    public Village() {
        amenities = new ArrayList<>();
        cottages = new ArrayList<>();
    }

    public void addAmenity(Amenity amenity) {
        if (amenity == null) {
            throw new AmenityException("Cannot add a null amenity.");
        }
        amenities.add(amenity);
    }

    public void addCottage(Cottage cottage) {
        cottages.add(cottage);
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public int getAmenityCount() {
        return amenities.size();
    }

    public void displayInfo() {
        System.out.println("Amenities of the village:");
        for (Amenity amenity : amenities) {
            System.out.println("- " + amenity.getNameAmenity());
        }

        System.out.println("\nCottages in the village:");
        for (Cottage cottage : cottages) {
            cottage.displayInfo();
        }
    }
}
