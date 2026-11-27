package problem_solving.basics;

public class LargestDigit {

    public static int largestDigit(int num) {
        int largest = 0;

        while (num > 0) {
            int digit = num % 10;

            if (digit > largest) {
                largest = digit;
            }

            // Integer division drops the last digit automatically
            num = num / 10;
        }

        return largest;
    }

    void main() {
        int number = 5832;
        IO.println("Largest digit: " + largestDigit(number));
    }
}

/*
Input: num = 5832

Step 1:
largest = 0
5832 > 0 is TRUE
digit = 5832 % 10 -> 2
2 > 0 is TRUE -> largest = 2
num = 5832 / 10 -> 583

Step 2:
583 > 0 is TRUE
digit = 583 % 10 -> 3
3 > 2 is TRUE -> largest = 3
num = 583 / 10 -> 58

Step 3:
58 > 0 is TRUE
digit = 58 % 10 -> 8
8 > 3 is TRUE -> largest = 8
num = 58 / 10 -> 5

Step 4:
5 > 0 is TRUE
digit = 5 % 10 -> 5
5 > 8 is FALSE -> largest remains 8
num = 5 / 10 -> 0

Step 5:
0 > 0 is FALSE -> Loop stops.

Method returns 8.

Final Output:
Largest digit: 8
*/
