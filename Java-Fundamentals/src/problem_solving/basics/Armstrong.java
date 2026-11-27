package problem_solving.basics;

public class Armstrong {

    public static void isArmstrong(int num) {
        int originalNum = num;
        int temp = num;
        int digits = String.valueOf(num).length();
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;

            // Java uses Math.pow(base, exp) which returns double, so cast to int
            sum = sum + (int) Math.pow(digit, digits);

            // Integer division in Java automatically drops decimals.
            temp = temp / 10;
        }

        if (sum == originalNum) {
            IO.println(originalNum + " is an Armstrong Number");
        } else {
            IO.println(originalNum + " is Not an Armstrong Number");
        }
    }

    void main() {
        isArmstrong(153);
    }
}

/*
Input: 153

Step 1:
originalNum = num -> 153

Step 2:
temp = num -> 153

Step 3:
digits = String.valueOf(153).length() -> 3

Step 4:
sum = 0

Step 5: Execute the while loop

Iteration 1:
temp = 153
digit = 153 % 10 -> 3
sum = 0 + (int) Math.pow(3, 3) -> 0 + 27 -> 27
temp = 153 / 10 -> 15

Iteration 2:
temp = 15
digit = 15 % 10 -> 5
sum = 27 + (int) Math.pow(5, 3) -> 27 + 125 -> 152
temp = 15 / 10 -> 1

Iteration 3:
temp = 1
digit = 1 % 10 -> 1
sum = 152 + (int) Math.pow(1, 3) -> 152 + 1 -> 153
temp = 1 / 10 -> 0

Step 6: Check the condition
sum == originalNum -> 153 == 153 -> true

Final Output:
153 is an Armstrong Number
*/