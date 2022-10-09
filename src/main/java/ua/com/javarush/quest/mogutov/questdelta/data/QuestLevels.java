package ua.com.javarush.quest.mogutov.questdelta.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestLevels {

    public static Map<Integer, List<String>> LEVEL_TEXT;
    private static final List<String> LEVEL_ONE_TEXT = new ArrayList<>();
    private static final List<String> LEVEL_TWO_TEXT = new ArrayList<>();
    private static final List<String> LEVEL_THREE_TEXT = new ArrayList<>();

    public QuestLevels() {
        LEVEL_TEXT = new HashMap<>();
        initial();
    }

    private static void initial(){
        createListText();
        LEVEL_TEXT.put(1, LEVEL_ONE_TEXT);
        LEVEL_TEXT.put(2, LEVEL_TWO_TEXT);
        LEVEL_TEXT.put(3, LEVEL_THREE_TEXT);
    }

    private static void createListText(){

        LEVEL_ONE_TEXT.add("You've lost your memory. Accept the UFO challenge?");
        LEVEL_ONE_TEXT.add("Take the challenge");
        LEVEL_ONE_TEXT.add("Reject a call");

        LEVEL_TWO_TEXT.add("You accepted the challenge. Go up to the bridge to the captain?");
        LEVEL_TWO_TEXT.add("Go up to the bridge.");
        LEVEL_TWO_TEXT.add("Refuse to go up to the bridge.");

        LEVEL_THREE_TEXT.add("You have climbed the bridge. Who are you?");
        LEVEL_THREE_TEXT.add("Tell the truth about yourself");
        LEVEL_THREE_TEXT.add("Lie about yourself");

    }

    public List<String> getLevelText(int value) {
        return LEVEL_TEXT.get(value);
    }

}
