package com.example.minesweepergame.TopScoreView;

/**need to test this*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GameResults {
    private final String FILENAME = "gameResults.csv";
    private Map<String, Integer> playerResults;

    public GameResults() {
        playerResults = new HashMap<>();
        readFromFile();
    }

    public Map<String, Integer> getPlayerResults() {
        Map<String, Integer> sortedMap = new TreeMap<>(Comparator.comparingInt(playerResults::get).reversed());
        sortedMap.putAll(playerResults);
        return sortedMap;
    }

    public void addPlayer(String playerName, int score) {
        List<Player> players = new ArrayList<>();
        Player newPlayer = new Player(playerName, score);
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                players.add(new Player(data[0], Integer.parseInt(data[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int newIndex = 0;
        for (int i = 0; i < players.size(); i++) {
            if (newPlayer.getScore() > players.get(i).getScore()) {
                newIndex = i;
                break;
            } else {
                newIndex = i + 1;
            }
        }
        players.add(newIndex, newPlayer);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Player player : players) {
                bw.write(player.getName() + "," + player.getScore() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        playerResults.clear();
        readFromFile();
    }

    private void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                playerResults.put(data[0], Integer.parseInt(data[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getPlayerRank(String playerName) {
        Map<String, Integer> sortedResults = getPlayerResults();

        int rank = 1;
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            if (entry.getKey().equals(playerName)) {
                return rank;
            }
            rank++;
        }

        return -1;
    }
    private static class Player {
        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
}
