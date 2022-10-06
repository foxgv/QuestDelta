package ua.com.javarush.quest.gribanov.questdelta.entity;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Game extends AbstractEntity {
    private final ZonedDateTime startingDate = ZonedDateTime.now();
    private long userID;
    private long currentQuestionID;
    private long questID;
    private GameState state;

    public Game(long userID, long currentQuestionID, long questID, GameState state) {
        this.userID = userID;
        this.currentQuestionID = currentQuestionID;
        this.questID = questID;
        this.state = state;
    }

    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public ZonedDateTime getStartingDate() {
        return startingDate;
    }



    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getCurrentQuestionID() {
        return currentQuestionID;
    }

    public void setCurrentQuestionID(long currentQuestionID) {
        this.currentQuestionID = currentQuestionID;
    }

    public long getQuestID() {
        return questID;
    }

    public void setQuestID(long questID) {
        this.questID = questID;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Game game = (Game) o;
        return userID == game.userID && currentQuestionID == game.currentQuestionID && questID == game.questID && Objects.equals(startingDate, game.startingDate) && state == game.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), startingDate, userID, currentQuestionID, questID, state);
    }

    public static class GameBuilder {
        private long userID;
        private long currentQuestionID;
        private long questID;
        private GameState state;

        GameBuilder() {
        }

        public GameBuilder userID(long userID){
            this.userID = userID;
            return this;
        }

        public GameBuilder currentQuestionID(long currentQuestionID){
            this.currentQuestionID = currentQuestionID;
            return this;
        }

        public GameBuilder questID(long questID){
            this.questID = questID;
            return this;
        }

        public GameBuilder state(GameState state){
            this.state = state;
            return this;
        }

        public Game build(){
            return new Game(userID, currentQuestionID, questID, state);
        }
    }
}
