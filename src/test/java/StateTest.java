import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.javarush.quest.rbityutskih.entity.GameState;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {
    String time;
    SimpleDateFormat formatter;
    Date date;

    @BeforeEach
    public void init(){
        formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        date = new Date(System.currentTimeMillis());
    }

    @Test
    public void checkCurrentTime(){
        formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        date = new Date(System.currentTimeMillis());
        assertEquals(formatter.format(date), GameState.valueOf(String.valueOf(date)));
    }
}
