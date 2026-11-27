package problem_solving.arrays;

public class ArrayBasics {

    void main() {
        int[] myArr = {10, 20, 70, 40, 50, 28, 27, -35};

        // Case 1: Print array elements
        IO.println("--- Case 1: Array Elements ---");
        for (int i = 0; i < myArr.length; i++) {
            IO.println(myArr[i]);
        }

        // Case 2: Print the sum of array elements
        int sum = 0;
        for (int i = 0; i < myArr.length; i++) {
            sum = sum + myArr[i];
        }
        IO.println("Sum: " + sum);

        // Case 3: Print only positive numbers
        IO.println("--- Case 3: Positive Numbers ---");
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i] > 0) {
                IO.println(myArr[i]);
            }
        }

        // Case 4: Find the average of the integer array
        int res = 0;
        for (int i = 0; i < myArr.length; i++) {
            res += myArr[i];
        }
        // Cast to (double) so Java does not truncate 210 / 8 to 26
        double avg = (double) res / myArr.length;
        IO.println("Average of array elements: " + avg);

        // Case 5: Print the largest number in the array
        int largest = myArr[0];
        for (int i = 1; i < myArr.length; i++) {
            if (myArr[i] > largest) {
                largest = myArr[i];
            }
        }
        IO.println("Largest: " + largest);

        // Case 6: Print the second largest number
        if (myArr.length < 2) {
            IO.println("Array length can't be less than two");
        } else {
            int large = Integer.MIN_VALUE;
            int secLarge = Integer.MIN_VALUE;

            for (int i = 0; i < myArr.length; i++) {
                if (myArr[i] > large) {
                    secLarge = large;
                    large = myArr[i];
                } else if (myArr[i] > secLarge && myArr[i] != large) {
                    secLarge = myArr[i];
                }
            }

            if (secLarge == Integer.MIN_VALUE) {
                IO.println("Can't determine the 2nd largest because all elements are equal");
            } else {
                IO.println("Second largest element is: " + secLarge);
            }
        }
    }
}
