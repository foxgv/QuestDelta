package ua.com.javarush.quest.khmelov.questdelta.data;


public class QuestLevels {
    public static int LEVEL = 0;



    public static final String[] LEVEL_TEXT = new String[]{
            "<p>You've lost your memory. Accept the UFO challenge?</p>\n" + "\n" +
            "<p><input type=\"checkbox\" name=\"browser\" value=\"IE\" /> Take the challenge</p>\n" +
            "<p><input type=\"checkbox\" name=\"browser\" value=\"IE\" /> Reject a call</p>"+
            "<a href=\"/start\"><input type=\"button\" /> SUBMIT</a>",

            "<p>You accepted the challenge. Go up to the bridge to the captain?</p>\n" + "\n" +
            "<p><input type=\"checkbox\" name=\"browser\" value=\"IE\" /> Go up to the bridge.</p>\n" +
            "<p><input type=\"checkbox\" name=\"browser\" value=\"IE\" /> Refuse to go up to the bridge.</p>"+
            "<a href=\"/start\"><input type=\"button\" /> SUBMIT</a>"
    };

    public static String selectLevel(){
        String currentTextLevel = "";
        for (int j = 0; j < LEVEL_TEXT.length; j++) {
            if(j == LEVEL){
                currentTextLevel = LEVEL_TEXT[j];
                LEVEL++;
                break;
            }
        }
        return currentTextLevel;
    }
}
