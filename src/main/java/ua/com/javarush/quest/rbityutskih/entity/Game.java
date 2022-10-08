package ua.com.javarush.quest.rbityutskih.entity;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")
public class Game extends  Entity {
    Long id;
    Long questId;
    Long userId;
    Long currentQuestonId;
    //GmaeState gameState;
    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId() {

    }
    private int gameCounter;
    private int gameWond;
}
