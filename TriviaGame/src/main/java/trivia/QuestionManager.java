package trivia;

import java.util.LinkedList;

public class QuestionManager {
    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();


    public QuestionManager() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public String getNextQuestion(String category) {
        switch (category) {
            case "Pop":
                return popQuestions.removeFirst();
            case "Science":
                return scienceQuestions.removeFirst();
            case "Sports":
                return sportsQuestions.removeFirst();
            case "Rock":
                return rockQuestions.removeFirst();
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}
