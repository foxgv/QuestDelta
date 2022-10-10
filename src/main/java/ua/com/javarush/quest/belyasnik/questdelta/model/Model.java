package ua.com.javarush.quest.belyasnik.questdelta.model;


import ua.com.javarush.quest.belyasnik.questdelta.entities.Statistic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static final Model instance = new Model();

    private List<Statistic> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(Statistic statistic) {
        model.add(statistic);
    }

    public List<String> list() {
        return model.stream()
                .map(Statistic::toString)
                .collect(Collectors.toList());
    }


}
