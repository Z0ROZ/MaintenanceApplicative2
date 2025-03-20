package action;

import user.UserManager;

public class CreateAccountAction implements Action {
    private UserManager userManager;

    public CreateAccountAction(UserManager userManager) {
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
