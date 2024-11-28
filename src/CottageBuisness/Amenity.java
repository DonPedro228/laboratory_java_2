package CottageBuisness;

public class Amenity {
    private final String nameAmenity;
    private final int extraGuest;
    private final double price;

    public Amenity(String nameAmenity, double price, int extraGuest) {
        this.nameAmenity = nameAmenity;
        this.price = price;
        this.extraGuest = extraGuest;
    }

    public String getNameAmenity() {
        return nameAmenity;
    }

    public int getExtraGuest() {
        return extraGuest;
    }


    public double getPrice() {
        return price;
    }
}

