module com.example.minesweepergame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.minesweepergame to javafx.fxml;
    exports com.example.minesweepergame;
}