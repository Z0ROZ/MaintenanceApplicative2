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
        System.out.println("The category is " + currentCategory());
        askQuestion();
    }

    private void askQuestion() {
        String category = currentCategory();
        String question = questionManager.getNextQuestion(category);
        System.out.println(question);
    }

    private String currentCategory() {
        int position = (players.get(currentPlayerIndex).getPosition() - 1) % 4;
        switch (position) {
            case 0:
                return "Pop";
            case 1:
                return "Science";
            case 2:
                return "Sports";
            default:
                return "Rock";
        }
    }

    public boolean handleCorrectAnswer() {
        Player current = players.get(currentPlayerIndex);

        if (current.isInPenaltyBox() && !isGettingOutOfPenaltyBox) {
            currentPlayerIndex = nextPlayer();
            return true;
        }

        System.out.println("Answer was correct!!!!");
        current.addPurses(1);
        System.out.println(current.getName() + " now has " + current.getPurses() + " Gold Coins.");

        boolean winner = current.getPurses() != 6;
        currentPlayerIndex = nextPlayer();
        return winner;
    }

    public boolean wrongAnswer() {
        Player current = players.get(currentPlayerIndex);
        System.out.println("Question was incorrectly answered");
        System.out.println(current.getName() + " was sent to the penalty box");
        current.sendToPenaltyBox();
        currentPlayerIndex = nextPlayer();
        return true;
    }

    private int nextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) currentPlayerIndex = 0;
        return currentPlayerIndex;
    }
}
