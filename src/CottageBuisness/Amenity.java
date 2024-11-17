package CottageBuisness;

public class Amenity {
    private String nameAmenity;
    private int extraGuest;
    private double price;

    public Amenity(String nameAmenity, double price, int extraGuest) {
        this.nameAmenity = nameAmenity;
        this.price = price;
        this.extraGuest = extraGuest;
    }

    public String getNameAmenity() {
        return nameAmenity;
    }

    public void setNameAmenity(String nameAmenity) {
        this.nameAmenity = nameAmenity;
    }

    public int getExtraGuest() {
        return extraGuest;
    }

    public void setExtraGuest(int extraGuest) {
        this.extraGuest = extraGuest;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

