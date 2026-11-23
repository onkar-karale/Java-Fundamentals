package basics;

// =====================================================================
// TOPIC 19: JAVA USER INPUT (Scanner)
// - The Scanner class (in java.util) reads keyboard input from System.in.
// - Common Scanner methods:
//   - nextLine()    : Reads an entire line of String text
//   - nextInt()     : Reads an int value
//   - nextDouble()  : Reads a double value
//   - nextBoolean() : Reads a boolean value (true/false)
//   - nextByte() / nextShort() / nextLong() / nextFloat()
// - IMPORTANT GOTCHA: Calling nextInt()/nextDouble() leaves a trailing
//   newline ('\n') in the buffer. Call an extra scanner.nextLine() before
//   reading another String line so it doesn't skip your input!
// - Wrong input type (e.g., typing "abc" for nextInt()) throws InputMismatchException.
// =====================================================================

import java.util.Scanner;

public class UserInput {
    void main() {
        // try-with-resources automatically closes the Scanner when finished
        try (Scanner scanner = new Scanner(System.in)) {
            IO.print("Enter your name: ");
            String name = scanner.nextLine();

            IO.print("Enter your age (int): ");
            int age = scanner.nextInt();

            IO.print("Enter your expected salary (double): ");
            double salary = scanner.nextDouble();

            // Consume the leftover newline character before calling nextLine() again
            scanner.nextLine();

            IO.print("Enter your favorite framework: ");
            String framework = scanner.nextLine();

            IO.println("""
                    --- User Input Summary ---
                    Name      : %s
                    Age       : %d
                    Salary    : %.2f
                    Framework : %s
                    """.formatted(name, age, salary, framework));
        }
    }
}

// SUMMARY:
// - Import java.util.Scanner and pass System.in to read console input.
// - Match the method (nextLine, nextInt, nextDouble) to the expected type.
// - Clear the buffer with scanner.nextLine() after numeric inputs if reading text next.
