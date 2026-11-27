package problem_solving.basics;

public class SumOfNumbers {

    // Pattern A: Sum of first N natural numbers (1 + 2 + ... + n)
    public static int sumOfFirstN(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }

    // Pattern B: Sum of digits of a number (e.g., 1234 -> 1 + 2 + 3 + 4 = 10)
    public static int sumOfDigits(int num) {
        int sum = 0;
        int temp = Math.abs(num); // Handles negative inputs safely

        while (temp > 0) {
            int digit = temp % 10;
            sum = sum + digit;
            temp = temp / 10;
        }

        return sum;
    }

    void main() {
        int n = 5;
        int number = 1234;

        IO.println("Sum of numbers from 1 to " + n + ": " + sumOfFirstN(n));
        IO.println("Sum of digits of " + number + ": " + sumOfDigits(number));
    }
}

/*
--- DRY RUN A: sumOfFirstN(5) ---
Step 1: sum = 0
i = 1 -> sum = 0 + 1 = 1
i = 2 -> sum = 1 + 2 = 3
i = 3 -> sum = 3 + 3 = 6
i = 4 -> sum = 6 + 4 = 10
i = 5 -> sum = 10 + 5 = 15
i = 6 -> 6 <= 5 is FALSE -> Loop stops.
Returns: 15

--- DRY RUN B: sumOfDigits(1234) ---
Step 1: sum = 0, temp = 1234
Iteration 1: digit = 1234 % 10 = 4 -> sum = 0 + 4 = 4  -> temp = 123
Iteration 2: digit = 123 % 10  = 3 -> sum = 4 + 3 = 7  -> temp = 12
Iteration 3: digit = 12 % 10   = 2 -> sum = 7 + 2 = 9  -> temp = 1
Iteration 4: digit = 1 % 10    = 1 -> sum = 9 + 1 = 10 -> temp = 0
Loop stops.
Returns: 10
*/
