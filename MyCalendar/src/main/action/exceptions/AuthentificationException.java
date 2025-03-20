package action.exceptions;

public class AuthentificationException extends Exception {

    public AuthentificationException(String msg) {
        super(msg);
    }
    public AuthentificationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
