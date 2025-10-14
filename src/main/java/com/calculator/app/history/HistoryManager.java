package com.calculator.app.history;
import com.calculator.app.core.EOperation;
import java.util.*;

/**
 * Manages the history of all calculations performed.
 * Demonstrates the use of Java Collections (List and Map).
 */
public class HistoryManager {

    // Each entry is stored as a HistoryRecord object
    private final List<HistoryRecord> historyList = new ArrayList<>();

    /**
     * Records a calculation result into the history.
     *
     * @param a        First operand
     * @param b        Second operand (if any)
     * @param operation Operation performed
     * @param result   Computed result
     */
    public void addRecord(double a, double b, EOperation operation, double result) {
        historyList.add(new HistoryRecord(a, b, operation, result));
    }

    /**
     * Displays all history records in a formatted way.
     */
    public void displayHistory() {
        if (historyList.isEmpty()) {
            System.out.println("\n No history available yet.");
            return;
        }

        System.out.println("\n Calculation History:");
        System.out.println("-----------------------------------------------------------");
        for (HistoryRecord record : historyList) {
            System.out.println(record);
        }
        System.out.println("-----------------------------------------------------------");
    }

    /**
     * Clears all stored history.
     */
    public void clearHistory() {
        historyList.clear();
        System.out.println("History cleared successfully.");
    }

    /**
     * Returns an unmodifiable view of the history (for testing or future UI).
     */
    public List<HistoryRecord> getHistory() {
        return Collections.unmodifiableList(historyList);
    }
}
