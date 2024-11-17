package CottageBuisness;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final String clientName;
    private final int[] startDate;
    private final int[] endDate;
    private final Cottage cottage;
    private static final List<Booking> bookings = new ArrayList<>();

    public Booking(String clientName, int startDay, int startMonth, int startYear,
                   int endDay, int endMonth, int endYear, Cottage cottage) {
        this.clientName = clientName;
        this.startDate = new int[]{startDay, startMonth, startYear};
        this.endDate = new int[]{endDay, endMonth, endYear};
        this.cottage = cottage;
    }

    public static boolean isConflicting(Cottage cottage, int[] startDate, int[] endDate) {
        for (Booking booking : bookings) {
            if (booking.cottage.equals(cottage)) {
                int[] bStart = booking.startDate;
                int[] bEnd = booking.endDate;

                boolean noConflict =
                        (endDate[2] < bStart[2] ||
                                (endDate[2] == bStart[2] && endDate[1] < bStart[1]) ||
                                (endDate[2] == bStart[2] && endDate[1] == bStart[1] && endDate[0] < bStart[0]))
                                ||
                                (startDate[2] > bEnd[2] ||
                                        (startDate[2] == bEnd[2] && startDate[1] > bEnd[1]) ||
                                        (startDate[2] == bEnd[2] && startDate[1] == bEnd[1] && startDate[0] > bEnd[0]));

                if (!noConflict) return true;
            }
        }
        return false;
    }

    public static boolean book(String clientName, int startDay, int startMonth, int startYear,
                               int endDay, int endMonth, int endYear, Cottage cottage) {
        if (cottage == null) {
            throw new IllegalArgumentException("Cottage is null.");
        }

        int[] startDate = {startDay, startMonth, startYear};
        int[] endDate = {endDay, endMonth, endYear};

        if (isConflicting(cottage, startDate, endDate)) {
            throw new IllegalStateException("The cottage is already booked for the selected dates!");
        }

        Booking newBooking = new Booking(clientName, startDay, startMonth, startYear,
                endDay, endMonth, endYear, cottage);
        bookings.add(newBooking);
        newBooking.displayBookingInfo();
        return true;
    }

    public static boolean isAvailable(Cottage cottage, int startDay, int startMonth, int startYear,
                                      int endDay, int endMonth, int endYear) {
        for (Booking booking : bookings) {
            if (booking.cottage.equals(cottage)) {
                int bStartDay = booking.startDate[0];
                int bStartMonth = booking.startDate[1];
                int bStartYear = booking.startDate[2];

                int bEndDay = booking.endDate[0];
                int bEndMonth = booking.endDate[1];
                int bEndYear = booking.endDate[2];


                boolean doesNotOverlap =
                        (endYear < bStartYear ||
                                (endYear == bStartYear && endMonth < bStartMonth) ||
                                (endYear == bStartYear && endMonth == bStartMonth && endDay < bStartDay)) ||

                                (startYear > bEndYear ||
                                        (startYear == bEndYear && startMonth > bEndMonth) ||
                                        (startYear == bEndYear && startMonth == bEndMonth && startDay > bEndDay));

                if (!doesNotOverlap) {
                    return false;
                }
            }
        }
        return true;
    }



    public void displayBookingInfo() {
        System.out.println("Booking for client: " + clientName);
        System.out.println("Start date: " + startDate[0] + "/" + startDate[1] + "/" + startDate[2]);
        System.out.println("End date: " + endDate[0] + "/" + endDate[1] + "/" + endDate[2]);
        System.out.println("Cottage type: " + cottage.getType());
    }
}

