package CottageBuisness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final String clientName;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Cottage cottage;
    private static final List<Booking> bookings = new ArrayList<>();

    public Booking(String clientName, int startDay, int startMonth, int startYear,
                   int endDay, int endMonth, int endYear, Cottage cottage) {
        this.clientName = clientName;
        this.startDate = LocalDate.of(startYear, startMonth, startDay);
        this.endDate = LocalDate.of(endYear, endMonth, endDay);
        this.cottage = cottage;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Cottage getCottage() {
        return cottage;
    }

    public static boolean isConflicting(Cottage cottage, LocalDate startDate, LocalDate endDate) {
        for (Booking booking : bookings) {
            if (booking.cottage.equals(cottage)) {
                boolean overlaps = !(startDate.isAfter(booking.getEndDate()) || endDate.isBefore(booking.getStartDate()));
                if (overlaps) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void book(String clientName, int startDay, int startMonth, int startYear,
                            int endDay, int endMonth, int endYear, Cottage cottage) {
        if (cottage == null) {
            throw new IllegalArgumentException("Cottage cannot be null.");
        }

        // Створюємо дати початку і кінця бронювання
        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        // Перевірка коректності діапазону дат
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must be before or equal to end date.");
        }

        // Перевірка на конфлікт з іншими бронюваннями для цього котеджу
        if (isConflicting(cottage, startDate, endDate)) {
            throw new IllegalStateException("The cottage is already booked for the selected dates!");
        }

        // Перевірка, чи клієнт вже має бронювання, що перетинається
        for (Booking booking : bookings) {
            if (booking.clientName.equals(clientName)) {
                boolean overlaps = !(startDate.isAfter(booking.getEndDate()) || endDate.isBefore(booking.getStartDate()));
                if (overlaps) {
                    throw new IllegalStateException("The client already has a booking during the selected dates!");
                }
            }
        }

        // Створюємо нове бронювання та додаємо його до списку
        Booking newBooking = new Booking(clientName, startDay, startMonth, startYear,
                endDay, endMonth, endYear, cottage);
        bookings.add(newBooking);

        // Виводимо інформацію про бронювання
        newBooking.displayBookingInfo();
    }

    public static boolean isAvailable(Cottage cottage, int startDay, int startMonth, int startYear,
                                      int endDay, int endMonth, int endYear) {
        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

        for (Booking booking : bookings) {
            if (booking.cottage.equals(cottage)) {
                boolean overlaps = !(startDate.isAfter(booking.getEndDate()) || endDate.isBefore(booking.getStartDate()));
                if (overlaps) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBookingInfo() {
        System.out.println("Booking added successfully!");
        System.out.println("Booking for client: " + clientName);
        System.out.println("Start date: " + startDate);
        System.out.println("End date: " + endDate);
        System.out.println("Cottage type: " + cottage.getType());
    }
}
