package model;

public class MoodEntry {
    private String date;
    private String mood;
    private String notes;

    public MoodEntry(String date, String mood, String notes) {
        this.date = date;
        this.mood = mood;
        this.notes = notes;
    }

    public String getDate() { return date; }
    public String getMood() { return mood; }
    public String getNotes() { return notes; }

    @Override
    public String toString() {
        return date + " - " + mood + " (" + notes + ")";
    }
}
