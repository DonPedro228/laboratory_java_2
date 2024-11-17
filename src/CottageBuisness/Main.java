package CottageBuisness;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Amenity wifi = new Amenity("WiFi", 50, 1);
            Amenity kitchen = new Amenity("Kitchen", 150, 2);

            Amenity footballField = new Amenity("Football Field", 100, 0);
            Amenity bar = new Amenity("Bar", 200, 0);

            Cottage cottage1 = new Cottage("Lux", Arrays.asList(wifi), 4);
            Cottage cottage2 = new Cottage("Standard", Arrays.asList(kitchen), 2);

            Village village = new Village();
            village.addAmenity(footballField);
            village.addAmenity(bar);

            village.addCottage(cottage1);
            village.addCottage(cottage2);

            village.displayInfo();

            Booking.book("John Doe", 1, 12, 2024, 5, 12, 2024, cottage1);

            System.out.println("Checking availability for 3/12/2024 - 4/12/2024:");
            if (Booking.isAvailable(cottage1, 3, 12, 2024, 4, 12, 2024)) {
                System.out.println("Cottage is available!");
            } else {
                System.out.println("Cottage is not available.");
            }

            System.out.println("Checking availability for 6/12/2024 - 8/12/2024:");
            if (Booking.isAvailable(cottage1, 6, 12, 2024, 8, 12, 2024)) {
                System.out.println("Cottage is available!");
            } else {
                System.out.println("Cottage is not available.");
            }

            Finance finance = new Finance();

            finance.calculateAmenityExpenses(village);

            finance.calculateCottageIncome(cottage1, 5, 12, 1);
            finance.calculateCottageExpenses(cottage1, 200, 1);

            finance.calculateCottageIncome(cottage2, 5, 11, 2);
            finance.calculateCottageExpenses(cottage2, 100, 2);

            finance.displayStatistics();
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Standard Error: " + e.getMessage());
        }
    }
}
