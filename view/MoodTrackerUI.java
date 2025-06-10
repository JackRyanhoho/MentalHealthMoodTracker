package view;

import controller.MoodController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.MoodEntry;
import model.QuoteHelper;

import java.time.LocalDate;

public class MoodTrackerUI extends Application {
    MoodController controller = new MoodController();
    ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        DatePicker datePicker = new DatePicker(LocalDate.now());
        ComboBox<String> moodBox = new ComboBox<>();
        moodBox.getItems().addAll("\uD83D\uDE0A Happy", "\uD83E\uDD29 Excited", "\uD83D\uDE10 Okay", "\uD83D\uDE34 Tired", "\uD83D\uDE22 Sad", "\uD83D\uDE1F Anxious");
        moodBox.setValue("Okay");

        TextArea notesArea = new TextArea();
        notesArea.setPromptText("What affected your mood today?");

        Label quoteLabel = new Label("💬 " + QuoteHelper.getRandomQuote());

        Button saveBtn = new Button("Save Mood");
        saveBtn.setOnAction(e -> {
            MoodEntry mood = new MoodEntry(datePicker.getValue().toString(), moodBox.getValue(), notesArea.getText());
            controller.addMood(mood);
            updateList();
        });

        Button chartBtn = new Button("Show Mood Chart");
        chartBtn.setOnAction(e -> new ChartView().showChart());

        VBox inputBox = new VBox(10, new Label("Date:"), datePicker,
                new Label("Mood:"), moodBox,
                new Label("Notes:"), notesArea,
                saveBtn, chartBtn, quoteLabel);
        inputBox.setPadding(new Insets(10));

        VBox listBox = new VBox(10, new Label("Mood History:"), listView);
        listBox.setPadding(new Insets(10));
        listBox.setPrefWidth(300);

        HBox root = new HBox(20, inputBox, listBox);
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setTitle("Mental Health Mood Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();

        updateList();
    }

    private void updateList() {
        listView.getItems().clear();
        controller.getAllMoods().forEach(entry -> listView.getItems().add(entry.toString()));
    }
}
