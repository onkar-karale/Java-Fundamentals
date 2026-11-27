package problem_solving.basics;

public class PalindromeNumber {

    public static boolean isPalindrome(int num) {
        // Negative numbers like -121 are not palindromes (reversed becomes 121-)
        if (num < 0) {
            return false;
        }

        int originalNum = num;
        int temp = num;
        int reversed = 0;

        while (temp > 0) {
            int digit = temp % 10;
            reversed = (reversed * 10) + digit;
            temp = temp / 10; // Integer division automatically drops decimals
        }

        return originalNum == reversed;
    }

    void main() {
        int number = 121;

        if (isPalindrome(number)) {
            IO.println(number + " is a Palindrome Number");
        } else {
            IO.println(number + " is Not a Palindrome Number");
        }
    }
}

/*
Input: num = 121

Step 1:
num < 0 -> 121 < 0 is FALSE
originalNum = 121, temp = 121, reversed = 0

Step 2: Execute the while loop

Iteration 1:
temp = 121
digit = 121 % 10 -> 1
reversed = (0 * 10) + 1 -> 1
temp = 121 / 10 -> 12

Iteration 2:
temp = 12
digit = 12 % 10 -> 2
reversed = (1 * 10) + 2 -> 12
temp = 12 / 10 -> 1

Iteration 3:
temp = 1
digit = 1 % 10 -> 1
reversed = (12 * 10) + 1 -> 121
temp = 1 / 10 -> 0

Step 3: Check condition
originalNum == reversed -> 121 == 121 -> true

Final Output:
121 is a Palindrome Number
*/
