import user.message.UserOutput;

public class TestUserOutput implements UserOutput {
    private String lastMessage;
    private String lastError;

    @Override
    public void displayMessage(String message) {
        this.lastMessage = message;
    }

    @Override
    public void displayError(String error) {
        this.lastError = "Erreur: " + error;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getLastError() {
        return lastError;
    }
}