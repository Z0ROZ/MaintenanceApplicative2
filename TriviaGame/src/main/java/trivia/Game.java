package trivia;

import java.util.ArrayList;

// REFACTOR ME
public class Game implements IGame {
    ArrayList<Player> players = new ArrayList<>();
    private final QuestionManager questionManager;
    int currentPlayerIndex = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        this.questionManager = new QuestionManager();
    }

    public boolean add(String playerName) {
        Player newPlayer = new Player(playerName);
        players.add(newPlayer);
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public void roll(int roll) {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println(currentPlayer.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isInPenaltyBox()) {
            handlePenaltyBox(currentPlayer, roll);
        } else {
            movePlayer(currentPlayer, roll);
        }

    }

    public void handlePenaltyBox(Player currentPlayer, int roll) {
        if (roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;
            System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
            movePlayer(currentPlayer, roll);
        } else {
            System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
    }

    private void movePlayer(Player player, int roll) {
        player.move(roll);
        System.out.println(player.getName() + "'s new location is " + player.getPosition());
        System.out.println("The category is " + currentCategory().getDisplayName());
        askQuestion(currentCategory());
    }

    private void askQuestion(Category category) {
        String question = questionManager.getNextQuestion(category);
        System.out.println(question);
    }

    private Category currentCategory() {
        int position = (players.get(currentPlayerIndex).getPosition() - 1) % 4;
        switch (position) {
            case 0:
                return Category.POP;
            case 1:
                return Category.SCIENCE;
            case 2:
                return Category.SPORTS;
            default:
                return Category.ROCK;
        }
    }

    public boolean handleCorrectAnswer() {
        AnswerHandler answerHandler = new AnswerHandler(this);
        return answerHandler.correctAnswer();
    }

    public boolean wrongAnswer() {
        AnswerHandler answerHandler = new AnswerHandler(this);
        return answerHandler.incorrectAnswer();
    }

    public void nextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public boolean getIsOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }
}
