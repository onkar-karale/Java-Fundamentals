package basics;

import java.time.LocalDate;

public class Welcome {
    // ENTRY POINT (Where execution begins)
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        printWelcome("Onkar", today);
    }

    // HELPER METHODS & VARIABLES (Called from main)
    static void printWelcome(String name, LocalDate date) {
        System.out.println("Welcome " + name + " | Date: " + date);
    }
}
