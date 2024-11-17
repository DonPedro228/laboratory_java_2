package CottageBuisness;

public class CottageException extends CustomException {
    public CottageException(String message) {
        super("Cottage Error: " + message);
    }
}

