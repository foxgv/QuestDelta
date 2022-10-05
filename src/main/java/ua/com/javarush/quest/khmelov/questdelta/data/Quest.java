package ua.com.javarush.quest.khmelov.questdelta.data;

import java.net.InetAddress;
import java.util.List;

import static ua.com.javarush.quest.khmelov.questdelta.data.constants.MAX_LEVEL;

public class Quest {
    private int LEVEL;

    private String USER_NAME;

    private InetAddress USER_ADDRESS;
    private QuestLevels questLevel;

    public Quest(String name, InetAddress address) {
        LEVEL = 1;
        this.USER_NAME = name;
        this.USER_ADDRESS = address;
        questLevel = new QuestLevels();
    }

    public InetAddress getUserAddress() {
        return USER_ADDRESS;
    }

    public String getUserName() {
        return USER_NAME;
    }

    public int getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL(int LEVEL) {
        this.LEVEL = LEVEL;
    }

    public boolean checkLose(Integer userChoice){
        return userChoice == 0;
    }

    public boolean checkWin(int level){
        return level == MAX_LEVEL;
    }

    public List<String> getCurrentLevelText(int currentLevel){
        return questLevel.getLevelText(currentLevel);
    }

}
