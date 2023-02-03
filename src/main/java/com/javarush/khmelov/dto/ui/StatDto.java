package com.javarush.khmelov.dto.ui;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatDto {
    String login;
    long win;
    long lost;
    long play;
    long total;
}
