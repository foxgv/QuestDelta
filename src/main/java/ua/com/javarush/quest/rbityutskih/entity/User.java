package ua.com.javarush.quest.rbityutskih.entity;
import lombok.*;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "with")

public final class User extends Entity{

    Long id;
    String login;
    String password;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId() {

    }
}
