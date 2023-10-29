package ru.example.singleton;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private final int i;

    public Filter(int i) {
        this.i = i;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();
        logger.log("Фильтруем список");

        List<Integer> filtered = new ArrayList<>();
        for(int num : list){
            if(num < i){
                logger.log("Число " + num + " подходит");

                filtered.add(num);
                logger.log("Добавляем " + num + " в отфильтрованный список");
            }else {
                logger.log("Число " + num + " не подходит");
            }
        }
        return filtered;
    }
}
