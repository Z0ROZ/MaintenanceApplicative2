package trivia;

public class AnswerHandler {
    private final Game game;

    public AnswerHandler(Game game) {
        this.game = game;
    }


    public boolean correctAnswer() {
        Player currentPlayer = game.getCurrentPlayer();

        if (currentPlayer.isInPenaltyBox() && !game.getIsOutOfPenaltyBox()) {
            game.nextPlayer();
            return true;
        }

        System.out.println("Answer was correct!!!!");
        currentPlayer.addPurses(1);
        System.out.println(currentPlayer.getName() + " now has " + currentPlayer.getPurses() + " Gold Coins.");

        boolean winner =currentPlayer.getPurses() != 6;
        game.nextPlayer();
        return winner;
    }

    public boolean incorrectAnswer() {
        Player currentPlayer = game.getCurrentPlayer();
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer.getName() + " was sent to the penalty box");
        currentPlayer.enterPenaltyBox();
        game.nextPlayer();
        return true;
    }
}
