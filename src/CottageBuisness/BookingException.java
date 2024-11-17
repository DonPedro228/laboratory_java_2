package CottageBuisness;

public class BookingException extends CustomException {
    public BookingException(String message) {
        super("Booking Error: " + message);
    }
}
