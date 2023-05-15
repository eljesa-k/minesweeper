module com.example.minesweepergame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.minesweepergame to javafx.fxml;
    exports com.example.minesweepergame;
    exports com.example.minesweepergame.GameScreen;
    opens com.example.minesweepergame.GameScreen to javafx.fxml;
    exports com.example.minesweepergame.controller;
    opens com.example.minesweepergame.controller to javafx.fxml;
    exports com.example.minesweepergame.ResultView;
    opens com.example.minesweepergame.ResultView to javafx.fxml;
    exports com.example.minesweepergame.TopScoreView;
    opens com.example.minesweepergame.TopScoreView to javafx.fxml;
    exports com.example.minesweepergame.WelcomeScreen;
    opens com.example.minesweepergame.WelcomeScreen to javafx.fxml;
}