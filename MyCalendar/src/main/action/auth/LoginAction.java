package action.auth;

import action.Action;
import user.UserManager;

public class LoginAction implements Action {
    private UserManager userManager;

    public LoginAction(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        userManager.login();
    }

    @Override
    public String getName() {
        return " Se connecter";
    }

}
