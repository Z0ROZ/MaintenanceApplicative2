package action;

import user.UserManager;

public class ConnectAction implements Action {
    private UserManager userManager;

    public ConnectAction(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void executer() {
        userManager.seConnecter();
    }

    @Override
    public String getName() {
        return " Se connecter";
    }

}
