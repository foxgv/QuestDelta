package ua.com.javarush.quest.belyasnik.questdelta.entities;

import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Statistic {
    String login;
    String dateTime;
    Question lastQuestion;
    String result;

    public static String currentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    @Override
    public String toString() {
        return dateTime + "             " +result;
    }
}
