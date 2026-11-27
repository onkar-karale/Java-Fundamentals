package problem_solving.strings;

public class CountStringChars {

    public static int countCharacters(String str) {
        int count = 0;

        // Note: String uses .length() with parentheses in Java
        for (int i = 0; i < str.length(); i++) {
            count++;
        }

        return count;
    }

    void main() {
        String str = "hello";
        IO.println("Total characters in the string: " + countCharacters(str));
    }
}

/*
Input: str = "hello"

Step 1: count = 0
Step 2: i = 0, str.charAt(0) = 'h' -> count = 1
Step 3: i = 1, str.charAt(1) = 'e' -> count = 2
Step 4: i = 2, str.charAt(2) = 'l' -> count = 3
Step 5: i = 3, str.charAt(3) = 'l' -> count = 4
Step 6: i = 4, str.charAt(4) = 'o' -> count = 5
Step 7: i = 5, 5 < 5 is FALSE -> Loop stops.

Method returns 5.

Final Output:
Total characters in the string: 5
*/
