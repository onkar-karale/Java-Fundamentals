package problem_solving.strings;

public class ReverseString {

    public static String reverseString(String str) {
        // StringBuilder avoids creating a new String object on every loop iteration
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }

    void main() {
        String str = "hello";
        IO.println("Original String : " + str);
        IO.println("Reversed String : " + reverseString(str));
    }
}

/*
Input: str = "hello" (length = 5, last index = 4)

Step 1:
reversed = ""

Step 2: Execute the for loop backwards (from index 4 down to 0)

i = 4 -> str.charAt(4) = 'o' -> reversed = "o"
i = 3 -> str.charAt(3) = 'l' -> reversed = "ol"
i = 2 -> str.charAt(2) = 'l' -> reversed = "oll"
i = 1 -> str.charAt(1) = 'e' -> reversed = "olle"
i = 0 -> str.charAt(0) = 'h' -> reversed = "olleh"
i = -1 -> -1 >= 0 is FALSE -> Loop stops.

Step 3:
Return reversed.toString() -> "olleh"

Final Output:
Original String : hello
Reversed String : olleh
*/
