package com.example.minesweepergame.GameScreen;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// this class uses Singleton Design
public class Difficulty {
    private static Map<Difficulties, Map> difficulties;

    private Difficulty() {
        difficulties = new LinkedHashMap<>();

        Map<String, Integer> easy_level = new HashMap<>();
        easy_level.put("nr_bombs", 10);
        easy_level.put("columns", 10);
        easy_level.put("rows", 8);
        difficulties.put(Difficulties.EASY, easy_level);

        Map<String, Integer> medium_level = new HashMap<>();
        medium_level.put("nr_bombs", 40);
        medium_level.put("columns", 18);
        medium_level.put("rows", 14);
        difficulties.put(Difficulties.MEDIUM, medium_level);

        Map<String, Integer> hard_level = new HashMap<>();
        hard_level.put("nr_bombs", 90);
        hard_level.put("columns", 24);
        hard_level.put("rows", 20);
        difficulties.put(Difficulties.HARD, hard_level);
    }
    public static Map<String, Integer>getDiff(Difficulties diff){
        if(difficulties == null)
            new Difficulty();
        return difficulties.get(diff);
    }
}
