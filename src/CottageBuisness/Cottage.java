package CottageBuisness;
import java.util.ArrayList;
import java.util.List;

public class Cottage {
    private final String type;
    private final List<Amenity> amenities;
    private final double price;
    private final int guests;

    public Cottage(String type, Amenity amenity, double price, int guests) {
        this.type = type;
        this.price = price > 0 ? price : (type.equals("Standard") ? 100 : type.equals("Lux") ? 250 : 0);
        this.guests = guests;
        this.amenities = new ArrayList<>();
        if (amenity != null) {
            addAmenity(amenity);
        }
    }

    public Cottage(String type, List<Amenity> amenities, int guests) {
        this.type = type;
        this.amenities = amenities != null ? new ArrayList<>(amenities) : new ArrayList<>();
        this.price = type.equals("Standard") ? 100 : type.equals("Lux") ? 250 : 0;
        this.guests = guests;
    }

    public void addAmenity(Amenity amenity) {
        if (amenity == null) {
            throw new IllegalArgumentException("Cannot add a null amenity.");
        }
        amenities.add(amenity);
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void displayInfo() {
        System.out.println("\nCottage type: " + type);
        System.out.println("Price: " + price);
        System.out.println("Guests: " + guests);
        System.out.println("Amenities:");
        for (Amenity amenity : amenities) {
            System.out.println("- " + amenity.getNameAmenity() +
                    ", Extra guest: " + amenity.getExtraGuest() +
                    ", Amenity price: " + amenity.getPrice());
        }
    }
}
