package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MoodTrackerUI;
import model.DBHelper;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        DBHelper.initDB();
        new MoodTrackerUI().start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
