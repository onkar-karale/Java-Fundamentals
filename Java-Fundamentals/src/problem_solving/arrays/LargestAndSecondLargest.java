package problem_solving.arrays;

public class LargestAndSecondLargest {

    public static int findLargest(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            IO.println("Array length can't be less than two");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            IO.println("Can't determine the 2nd largest because all elements are equal");
        } else {
            IO.println("Second largest element: " + secondLargest);
        }
    }

    void main() {
        int[] arr = {10, 20, 70, 40, 50};
        IO.println("Largest element: " + findLargest(arr));
        findSecondLargest(arr);
    }
}

/*
Input: {10, 20, 70, 40, 50}

Step 1:
largest = Integer.MIN_VALUE
secondLargest = Integer.MIN_VALUE

Step 2: Execute the for loop

i = 0, arr[0] = 10
10 > largest -> TRUE
secondLargest = Integer.MIN_VALUE, largest = 10

i = 1, arr[1] = 20
20 > 10 -> TRUE
secondLargest = 10, largest = 20

i = 2, arr[2] = 70
70 > 20 -> TRUE
secondLargest = 20, largest = 70

i = 3, arr[3] = 40
40 > 70 -> FALSE
40 > 20 && 40 != 70 -> TRUE
secondLargest = 40

i = 4, arr[4] = 50
50 > 70 -> FALSE
50 > 40 && 50 != 70 -> TRUE
secondLargest = 50

Final Output:
Largest element: 70
Second largest element: 50
*/
