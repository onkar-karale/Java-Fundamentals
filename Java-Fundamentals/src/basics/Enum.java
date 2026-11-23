package basics;

// =====================================================================
// TOPIC 18: JAVA ENUMS & ENUM CONSTRUCTORS
// PART A - BASIC ENUMS:
// - An 'enum' is a special "class" representing a fixed group of constants
//   (unchangeable variables, written in UPPERCASE by convention).
// - Access constants with dot syntax (Level.MEDIUM).
// - Commonly used in 'switch' statements and looped using .values().
// - Differences from classes:
//   - Enum constants are implicitly public, static, and final.
//   - You CANNOT create enum objects with 'new', and enums cannot extend
//     other classes (though they CAN implement interfaces).
//
// PART B - ENUM CONSTRUCTORS:
// - Enums can have fields, constructors, and methods!
// - Enum constructors are ALWAYS 'private' (implicitly private if omitted).
// - If fields/methods follow constants, end the constant list with a ';'.
// =====================================================================

public class Enum {

    // PART A: Basic Enum
    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    // PART B: Enum with Constructor, Field, and Getter
    enum Priority {
        LOW(1, "Can wait"),
        MEDIUM(2, "Handle today"),
        HIGH(3, "Immediate action required"); // Semicolon required before fields!

        private final int code;
        private final String description;

        // Enum constructor is always private (called automatically for each constant above)
        Priority(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    void main() {
        // 1. Accessing a basic enum constant & using switch
        Level currentLevel = Level.MEDIUM;
        switch (currentLevel) {
            case LOW -> IO.println("Low level");
            case MEDIUM -> IO.println("Medium level");
            case HIGH -> IO.println("High level");
        }

        // 2. Looping through all constants with .values()
        IO.print("All levels: ");
        for (Level lvl : Level.values()) {
            IO.print(lvl + " ");
        }
        IO.println("\n");

        // 3. Using Enum Constructor fields and methods
        Priority ticket = Priority.HIGH;
        IO.println("Priority: %s (Code: %d) -> %s"
                .formatted(ticket, ticket.getCode(), ticket.getDescription()));
    }
}

// SUMMARY:
// - Use 'enum' for fixed sets of known values (days, order statuses, roles).
// - Attach metadata to constants using private enum constructors and getters.
