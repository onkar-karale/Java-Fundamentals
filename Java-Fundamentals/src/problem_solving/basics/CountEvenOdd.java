package problem_solving.basics;

public class CountEvenOdd {

    public static void countEvenOdd(int[] arr) {
        int even = 0;
        int odd = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        IO.println("Even numbers: " + even);
        IO.println("Odd numbers: " + odd);
    }

    void main() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        countEvenOdd(arr);
    }
}

/*
Input: {1, 2, 3, 4, 5, 6}

Step 1: even = 0, odd = 0
Step 2: i = 0, arr[0] = 1 -> 1 % 2 == 0 (FALSE) -> odd = 1
Step 3: i = 1, arr[1] = 2 -> 2 % 2 == 0 (TRUE)  -> even = 1
Step 4: i = 2, arr[2] = 3 -> 3 % 2 == 0 (FALSE) -> odd = 2
Step 5: i = 3, arr[3] = 4 -> 4 % 2 == 0 (TRUE)  -> even = 2
Step 6: i = 4, arr[4] = 5 -> 5 % 2 == 0 (FALSE) -> odd = 3
Step 7: i = 5, arr[5] = 6 -> 6 % 2 == 0 (TRUE)  -> even = 3
Step 8: Loop stops.

Final Output:
Even numbers: 3
Odd numbers: 3
*/
