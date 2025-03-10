package trivia;

public class Player {
    private static final int MAX_POSITION = 12;
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

    public boolean getPenaltyBox() {
        return inPenaltyBox;
    }

    public void addPurses(int purses) {
        this.purses += purses;
    }

    public void move(int roll) {
        position += roll;
        if (position > MAX_POSITION) position -= MAX_POSITION;
    }

    public void enterPenaltyBox() {
        inPenaltyBox = true;
    }

    public void exitPenaltyBox() {
        inPenaltyBox = false;
    }

}
