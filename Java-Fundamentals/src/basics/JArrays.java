package basics;
import java.util.Arrays; // Built-in utility class for sorting, printing, and copying arrays

// =====================================================================
// TOPIC: JAVA ARRAYS
// - An array stores multiple values of the SAME DATA TYPE in a single
//   contiguous variable.
// - JavaScript Comparison (CRITICAL DIFFERENCES):
//   1. FIXED SIZE: Once created, a Java array's length CANNOT grow or
//      shrink (no .push() or .pop()). For dynamic lists, use ArrayList (Day 3).
//   2. SINGLE TYPE: An int[] can ONLY hold ints; a String[] only Strings.
// - INDEXING:
//   - Zero-based: first element is at index 0, last is at (length - 1).
//   - Accessing an invalid index throws ArrayIndexOutOfBoundsException.
// - LENGTH:
//   - Use array.length (a property—NO parentheses, unlike String.length()).
// - DEFAULT VALUES (when initialized with 'new Type[size]'):
//   - int/long -> 0 | double -> 0.0 | boolean -> false | Objects/String -> null.
// - MULTIDIMENSIONAL ARRAYS (2D Arrays):
//   - An array of arrays (e.g., int[][] matrix), useful for tables/grids.
// =====================================================================

public class JArrays {
    void main() {
        // 1. DECLARING & INITIALIZING ARRAYS (With known values)
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        int[] numbers = {10, 20, 30, 40};

        // Accessing elements (0-based index)
        IO.println("First car  : " + cars[0]);
        IO.println("Third num  : " + numbers[2]);

        // Modifying an element
        cars[0] = "Opel";
        IO.println("Updated car[0]: " + cars[0]);

        // Checking Array Length (.length has NO parentheses)
        IO.println("Total cars : " + cars.length);

        IO.println("");

        // 2. CREATING AN ARRAY WITH 'new' (Fixed size with default values)
        int[] scores = new int[4]; // Allocates 4 slots, all initialized to 0
        scores[0] = 85;
        scores[1] = 92;
        // scores[2] and scores[3] remain 0
        // scores[4] = 100; // Runtime Error: ArrayIndexOutOfBoundsException!
        IO.println("Fixed-size array: " + Arrays.toString(scores));

        IO.println("");

        // 3. LOOPING THROUGH AN ARRAY
        // Method A: Standard 'for' loop (use when you need the index 'i' or want to modify elements)
        IO.println("--- Standard for loop (with index) ---");
        for (int i = 0; i < cars.length; i++) {
            IO.println("Index " + i + ": " + cars[i]);
        }

        // Method B: Enhanced 'for-each' loop (cleaner when you only need to read values)
        IO.println("--- Enhanced for-each loop ---");
        for (String car : cars) {
            IO.println("Car: " + car);
        }

        IO.println("");

        // 4. REAL-LIFE EXAMPLE: Calculate Average & Lowest Age in One Pass
        int[] ages = {20, 22, 18, 35, 48, 26, 87, 70};
        int sum = 0;
        int lowestAge = ages[0];

        for (int age : ages) {
            sum += age;
            if (age < lowestAge) {
                lowestAge = age;
            }
        }
        double averageAge = (double) sum / ages.length; // Cast to double to avoid integer division!
        IO.println("Lowest age  : " + lowestAge);
        IO.println("Average age : %.2f".formatted(averageAge));

        IO.println("");

        // 5. MULTIDIMENSIONAL ARRAYS (2D Array = Rows & Columns)
        // Row 0: {1, 2, 3, 4}
        // Row 1: {5, 6, 7}     (Java allows jagged rows with different lengths!)
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7}
        };

        // Accessing element at Row 1, Column 2 -> 7
        IO.println("matrix[1][2] before update: " + matrix[1][2]);

        // Modifying a 2D element
        matrix[1][2] = 9;
        IO.println("matrix[1][2] after update : " + matrix[1][2]);

        // Looping through a 2D array with nested standard 'for' loops
        IO.println("--- 2D Array (nested for loop) ---");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                IO.print(matrix[row][col] + " ");
            }
            IO.println("");
        }

        // Looping through a 2D array with nested 'for-each' loops
        IO.println("--- 2D Array (nested for-each) ---");
        for (int[] row : matrix) {
            for (int value : row) {
                IO.print(value + " ");
            }
            IO.println("");
        }

        IO.println("");

        // 6. ESSENTIAL java.util.Arrays UTILITY METHODS
        // Printing an array directly (IO.println(ages)) prints an ugly memory hash like [I@5f184fc6!
        // Always use Arrays.toString() for 1D arrays and Arrays.deepToString() for 2D arrays.
        int[] unsorted = {42, 7, 19, 100, 3};
        IO.println("Before sort   : " + Arrays.toString(unsorted));

        Arrays.sort(unsorted); // Sorts in-place (ascending)
        IO.println("After sort    : " + Arrays.toString(unsorted));

        // Copying & resizing an array (since original arrays cannot resize)
        int[] expandedCopy = Arrays.copyOf(unsorted, 7); // Pads extra slots with 0
        IO.println("Expanded copy : " + Arrays.toString(expandedCopy));

        // Comparing two arrays by content (NEVER use arr1 == arr2 or arr1.equals(arr2)!)
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        IO.println("a == b                 : " + (a == b));               // false (different memory)
        IO.println("Arrays.equals(a, b)    : " + Arrays.equals(a, b));    // true (same content)

        // Printing 2D arrays cleanly
        IO.println("2D deepToString        : " + Arrays.deepToString(matrix));
    }
}

// SUMMARY:
// - Arrays hold a FIXED number of elements of ONE data type (0-based indexing).
// - Use arr.length (no parentheses) for size; use 'for' for indexes and 'for-each' for clean reads.
// - Always cast to (double) before dividing two ints if you want a decimal average.
// - Use java.util.Arrays helpers: Arrays.toString(), Arrays.deepToString(), Arrays.sort(),
//   Arrays.copyOf(), and Arrays.equals() (never compare arrays with ==).
// - Need a resizable list like JS arrays? Use ArrayList<T> (covered next in Collections!).
