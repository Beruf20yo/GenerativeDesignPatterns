package ru.example.singleton;

import java.util.List;

public class Filter {
    private final int i;

    public Filter(int i) {
        this.i = i;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();
        logger.log("Фильтруем список");
        return list.stream()
                .filter(x -> x < i)
                .toList();
    }
}
