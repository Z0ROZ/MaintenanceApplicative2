package trivia;

public class Player {
    private final String name;
    private int purses = 0;
    private int position = 1;
    private boolean inPenaltyBox = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPurses() {
        return purses;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getPenaltyBox() {
        return inPenaltyBox;
    }

    public void addPurses(int purses) {
        this.purses += purses;
    }

    public void enterJail() {
        inPenaltyBox = true;
    }

    public void exitJail() {
        inPenaltyBox = false;
    }

}
