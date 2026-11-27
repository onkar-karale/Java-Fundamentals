package problem_solving.basics;

public class IsPrime {

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    void main() {
        int number = 7;

        if (isPrime(number)) {
            IO.println(number + " is a Prime Number");
        } else {
            IO.println(number + " is Not a Prime Number");
        }
    }
}

/*
Input: num = 7

Step 1: Check if num <= 1 -> 7 <= 1 is FALSE -> continue.
Step 2: i = 2, 2 < 7 (TRUE) -> 7 % 2 == 0 is FALSE (remainder 1)
Step 3: i = 3, 3 < 7 (TRUE) -> 7 % 3 == 0 is FALSE (remainder 1)
Step 4: i = 4, 4 < 7 (TRUE) -> 7 % 4 == 0 is FALSE (remainder 3)
Step 5: i = 5, 5 < 7 (TRUE) -> 7 % 5 == 0 is FALSE (remainder 2)
Step 6: i = 6, 6 < 7 (TRUE) -> 7 % 6 == 0 is FALSE (remainder 1)
Step 7: i = 7, 7 < 7 (FALSE) -> Loop stops.
Step 8: Method returns true.

Final Output:
7 is a Prime Number
*/
