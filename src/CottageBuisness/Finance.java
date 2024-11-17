package CottageBuisness;
import java.util.List;

public class Finance {
    private double totalIncome;
    private double totalExpenses;

    public Finance() {
        totalIncome = 0;
        totalExpenses = 0;
    }

    public void calculateCottageIncome(Cottage cottage, int nights, int month, int cottageId) {
        double pricePerNight = cottage.getPrice();
        double discountPrice = pricePerNight;

        if (month == 11 || month == 3) {
            discountPrice *= 0.8;
        }

        double lodgingIncome = discountPrice * nights;
        totalIncome += lodgingIncome;

        System.out.printf("\n[Cottage %d Income] Nights: %d, Month: %d, Price per night: %.2f, Discounted: %.2f, Lodging Income: %.2f%n",
                cottageId, nights, month, pricePerNight, discountPrice, lodgingIncome);

        double amenitiesIncome = cottage.getAmenities().stream()
                .mapToDouble(Amenity::getPrice)
                .sum();
        totalIncome += amenitiesIncome;

        System.out.printf("[Cottage %d Amenity Income] Amenities Income: %.2f%n", cottageId, amenitiesIncome);
    }

    public void calculateAmenityExpenses(Village village) {
        double amenityExpenses = village.getAmenities().stream()
                .mapToDouble(Amenity::getPrice)
                .sum();
        totalExpenses += amenityExpenses;

        System.out.printf("[Village Expenses] Total Amenity Expenses: %.2f%n", amenityExpenses);
    }

    public void calculateCottageExpenses(Cottage cottage, double utilities, int cottageId) {
        double amenityExpenses = cottage.getAmenities().stream()
                .mapToDouble(Amenity::getPrice)
                .sum();

        double totalCottageExpenses = utilities + amenityExpenses;
        totalExpenses += totalCottageExpenses;

        System.out.printf("[Cottage %d Expenses] Utilities: %.2f, Amenity Expenses: %.2f, Total Expenses: %.2f%n",
                cottageId, utilities, amenityExpenses, totalCottageExpenses);
    }

    public double calculateNetProfit() {
        return totalIncome - totalExpenses;
    }

    public void displayStatistics() {
        System.out.println("\n================= Financial Summary =================");
        System.out.printf("Total Income:    %.2f%n", totalIncome);
        System.out.printf("Total Expenses:  %.2f%n", totalExpenses);
        System.out.printf("Net Profit:      %.2f%n", calculateNetProfit());
        System.out.println("=====================================================");
    }
}

