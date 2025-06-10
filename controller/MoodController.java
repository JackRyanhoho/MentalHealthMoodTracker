package controller;

import model.DBHelper;
import model.MoodEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoodController {

    public void addMood(MoodEntry mood) {
        String sql = "INSERT INTO moods (date, mood, notes) VALUES (?, ?, ?)";
        try (Connection conn = DBHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mood.getDate());
            pstmt.setString(2, mood.getMood());
            pstmt.setString(3, mood.getNotes());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MoodEntry> getAllMoods() {
        List<MoodEntry> list = new ArrayList<>();
        String sql = "SELECT * FROM moods ORDER BY id DESC";

        try (Connection conn = DBHelper.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new MoodEntry(
                    rs.getString("date"),
                    rs.getString("mood"),
                    rs.getString("notes")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
