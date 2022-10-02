package ua.com.javarush.quest.khmelov.questdelta.data;

import java.util.List;

import static ua.com.javarush.quest.khmelov.questdelta.data.constants.MAX_LEVEL;

public class Quest {
    private int LEVEL;
    private QuestLevels questLevel;

    public Quest() {
        LEVEL = 1;
        questLevel = new QuestLevels();
    }

    public int getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL(int LEVEL) {
        this.LEVEL = LEVEL;
    }

    public boolean checkLose(Integer userChoice){
        if(userChoice == 0){
            return true;
        } return false;
    }

    public boolean checkWin(int level){
        if(level == MAX_LEVEL){
            return true;
        } return false;
    }

    public List<String> getCurrentLevelText(int currentLevel){
        return questLevel.getLevelText(currentLevel);
    }


}
