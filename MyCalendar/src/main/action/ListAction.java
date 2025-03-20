package action;

import java.util.ArrayList;
import java.util.List;

public class ListAction {
    private List<Action> actions;

    public ListAction() {
        this.actions = new ArrayList<>();
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public void displayActions() {
        for (int i = 0; i < this.actions.size(); i++) {
            System.out.println((i + 1) + " | " + this.actions.get(i).getName());
        }
    }

    public void execute(int index) {
        if(index >= 0 && index < actions.size()) {
            actions.get(index).execute();
        } else {
            System.out.println("Choix invalide.");
        }
    }
}
