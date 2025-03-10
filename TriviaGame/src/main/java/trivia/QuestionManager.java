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
            for (Category category : Category.values()) {
                questionsMap.get(category).addLast(category.getDisplayName() + " Question " + i);
            }
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

    public Category getCurrentCategory(int position) {
        switch ((position - 1) % 4) {
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
}
