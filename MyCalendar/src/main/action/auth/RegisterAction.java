package action.auth;

import action.Action;
import action.exceptions.AuthentificationException;
import user.UserManager;

public class RegisterAction implements Action {
    private final UserManager userManager;

    public RegisterAction(UserManager userManager) {
        this.userManager = userManager;
    }


    @Override
    public void execute(){
        userManager.register();
    }

    @Override
    public String getName() {
        return " Créer un compte";
    }
}
