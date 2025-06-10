# 🧠 Mental Health Mood Tracker

A simple JavaFX desktop application for promoting **mental wellness** through daily mood tracking, emotional awareness, and motivational support.
---
## 📋 Features

- ✅ **Daily Mood Check-ins**  
  Select your current mood from a list (with emoji), add notes, and log your entry.

- 📈 **Mood Trend Visualization**  
  View your mood patterns over time in a line chart using JavaFX's built-in `LineChart`.

- 💬 **Daily Inspirational Quotes**  
  A random motivational quote is shown each time you launch the app to encourage positive mental health.

- 💾 **Offline Storage via SQLite**  
  All data is stored locally in an embedded SQLite database (`mood_tracker.db`).

- 🎨 **Simple JavaFX UI**  
  Built entirely with JavaFX layouts and controls — no external CSS or FXML.

---

## 🛠️ Project Structure

MoodTrackerApp/

├── main/

│ └── Main.java # Entry point of the application

├── controller/

│ └── MoodController.java # Handles database operations and mood logic

├── model/

│ ├── DBHelper.java # Connects to SQLite and initializes DB

│ ├── MoodEntry.java # Represents a mood log entry (date, mood, notes)

│ └── QuoteHelper.java # Loads random quotes from a text file

├── view/

│ ├── MoodTrackerUI.java # Main UI window with form and list

│ └── ChartView.java # Mood trend chart visualization window

├── resources/
│ └── quotes.txt # Motivational quotes (one per line)
└── mood_tracker.db # Auto-created SQLite database file

