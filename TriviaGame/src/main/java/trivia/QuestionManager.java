package trivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QuestionManager {
    private final Map<Category, LinkedList<String>> questionsMap;

    public QuestionManager() {
        questionsMap = new HashMap<>();
        for (Category category : Category.values()) {
            questionsMap.put(category, new LinkedList<>());
        }
        for (int i = 0; i < 50; i++) {
            questionsMap.get(Category.POP).addLast("Pop Question " + i);
            questionsMap.get(Category.SCIENCE).addLast("Science Question " + i);
            questionsMap.get(Category.SPORTS).addLast("Sports Question " + i);
            questionsMap.get(Category.ROCK).addLast("Rock Question " + i);
        }
    }

    public String getNextQuestion(Category category) {
        LinkedList<String> list = questionsMap.get(category);
        if (list.isEmpty()) {
            return "No more questions for " + category.getDisplayName();
        } else {
            return list.removeFirst();
        }
    }
}
