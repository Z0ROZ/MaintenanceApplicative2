package action.auth;

import action.Action;
import user.UserManager;

public class RegisterAction implements Action {
    private UserManager userManager;

    public RegisterAction(UserManager userManager) {
        this.userManager = userManager;
    }


    @Override
    public void executer() {
        userManager.creerCompte();
    }

    @Override
    public String getName() {
        return " Créer un compte";
    }
}
