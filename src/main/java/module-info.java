module com.example.minesweepergame {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.minesweepergame.controller;
    opens com.example.minesweepergame.controller to javafx.fxml;
}