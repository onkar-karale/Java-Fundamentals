package problem_solving.basics;

public class Factorial {

    // Return type is 'long' because factorial grows fast (13! overflows 32-bit int)
    public static long findFactorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        long fact = 1; // Also handles 0! = 1 automatically

        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }

        return fact;
    }

    void main() {
        int number = 5;
        IO.println("Factorial of " + number + ": " + findFactorial(number));
    }
}

/*
Input: num = 5

Step 1:
num < 0 -> 5 < 0 is FALSE
fact = 1

Step 2: Execute the for loop

i = 1 -> fact = 1 * 1 = 1
i = 2 -> fact = 1 * 2 = 2
i = 3 -> fact = 2 * 3 = 6
i = 4 -> fact = 6 * 4 = 24
i = 5 -> fact = 24 * 5 = 120
i = 6 -> 6 <= 5 is FALSE -> Loop stops.

Step 3:
Return fact -> 120

Final Output:
Factorial of 5: 120
*/
