package view;

import controller.MoodController;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.MoodEntry;

import java.util.List;

public class ChartView {
    private MoodController controller = new MoodController();

    public void showChart() {
        Stage stage = new Stage();
        stage.setTitle("Mood Trends");

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Mood Trend Over Time");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Mood Score");

        List<MoodEntry> entries = controller.getAllMoods();
        for (MoodEntry entry : entries) {
            int score = getMoodScore(entry.getMood());
            series.getData().add(new XYChart.Data<>(entry.getDate(), score));
        }

        lineChart.getData().add(series);
        VBox vbox = new VBox(lineChart);
        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private int getMoodScore(String mood) {
        return switch (mood.toLowerCase()) {
            case "happy" -> 5;
            case "excited" -> 4;
            case "okay" -> 3;
            case "tired" -> 2;
            case "sad", "anxious" -> 1;
            default -> 0;
        };
    }
}
