package user.message;

public class ConsoleUserOutput implements UserOutput {
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayError(String error) {
        System.err.println("Erreur: " + error);
    }
}
