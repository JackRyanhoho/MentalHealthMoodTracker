package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteHelper {
    private static final String QUOTE_FILE = "resources/quotes.txt";

    public static String getRandomQuote() {
        List<String> quotes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(QUOTE_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                quotes.add(line.trim());
            }
        } catch (Exception e) {
            return "Stay strong. Better days are coming!";
        }
        return quotes.isEmpty() ? "Keep going, you're doing great!" :
               quotes.get(new Random().nextInt(quotes.size()));
    }
}
