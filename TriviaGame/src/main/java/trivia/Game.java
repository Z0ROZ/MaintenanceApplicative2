package trivia;

import java.util.ArrayList;
import java.util.List;

// REFACTOR ME
public class Game implements IGame {
    private final List<Player> players = new ArrayList<>();
    private final QuestionManager questionManager;
    int currentPlayerIndex = 0;

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

        if (currentPlayer.getPenaltyBox()) {
            handleJail(currentPlayer, roll);
        } else {
            movePlayer(currentPlayer, roll);
        }

    }

    public void handleJail(Player currentPlayer, int roll) {
        if (roll % 2 != 0) {
            currentPlayer.exitJail();
            System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
            movePlayer(currentPlayer, roll);
        } else {
            System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
            currentPlayer.enterJail();
        }
    }

    private void movePlayer(Player player, int roll) {
        player.move(roll);
        Category category = questionManager.getCurrentCategory(player.getPosition());
        System.out.println(player.getName() + "'s new location is " + player.getPosition());
        System.out.println("The category is " + category.getDisplayName());
        askQuestion(category);
    }

    private void askQuestion(Category category) {
        String question = questionManager.getNextQuestion(category);
        System.out.println(question);
    }

    public boolean handleCorrectAnswer() {
        Player currentPlayer = players.get(currentPlayerIndex);

        if (currentPlayer.getPenaltyBox()) {
            nextPlayer();
            return true;
        }

        System.out.println("Answer was correct!!!!");
        currentPlayer.addPurses(1);
        System.out.println(currentPlayer.getName() + " now has " + currentPlayer.getPurses() + " Gold Coins.");

        nextPlayer();

        return currentPlayer.getPurses() != 6;
    }

    public boolean handleIncorrectAnswer() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer.getName() + " was sent to the penalty box");
        currentPlayer.enterJail();
        nextPlayer();
        return true;
    }

    public void nextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
    }
}
