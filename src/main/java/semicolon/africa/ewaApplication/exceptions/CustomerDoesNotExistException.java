package semicolon.africa.ewaApplication.exceptions;

public class CustomerDoesNotExistException extends EwaApplicationException {
    public CustomerDoesNotExistException(String message) {
        super(message);
    }
}
