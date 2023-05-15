package com.example.minesweepergame.TopScoreView;

import com.example.minesweepergame.MainController;
import com.example.minesweepergame.ResultView.ResultView;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.List;

public class TopScoreViewController {
    private Pane topScoreView;

    public TopScoreViewController(MainController controller, HashMap<String, Integer> topPlayers, int currentRank){
        FXMLLoader fxmlLoader =
                new FXMLLoader(MainController.class.getResource("top-score-view.fxml"));
        try{
            fxmlLoader.load();}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        TopScoreView topScoreView = fxmlLoader.getController();
        List<String> playerNames = topPlayers.keySet().stream().toList();
        List<Integer> playerScores = topPlayers.values().stream().toList();
        topScoreView.setPlayerName1(playerNames.get(0));
        topScoreView.setPlayerName2(playerNames.get(1));
        topScoreView.setPlayerName3(playerNames.get(2));
        topScoreView.setTopScore1(playerScores.get(0));
        topScoreView.setTopScore2(playerScores.get(1));
        topScoreView.setTopScore3(playerScores.get(2));
        topScoreView.setCurrentRank(currentRank);
        this.topScoreView = fxmlLoader.getRoot();
    }
    public Pane getTopScoreView() {
        return this.topScoreView;
    }
}
