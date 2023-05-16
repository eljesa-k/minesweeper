package com.example.minesweepergame;

import com.example.minesweepergame.TopScoreView.GameResults;

import java.util.Map;

public class TestGameResults {
    public static void main(String[] args) {
        String playerName1 = "eljesa";
        int score1 = 80;
        String playerName2 = "rona";
        int score2 = 100;
        GameResults gameResult = new GameResults();
        //gameResult.addPlayer(playerName1,score1);
        //gameResult.addPlayer(playerName2,score2);
        Map<String,Integer> results = gameResult.getPlayerResults();
        System.out.println(results.entrySet());
        System.out.println(gameResult.getPlayerRank("eljesa"));
    }
}
