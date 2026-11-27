package problem_solving.strings;

public class PalindromeString {

    public static boolean isPalindrome(String str) {
        String cleanStr = str.toLowerCase();
        StringBuilder reversed = new StringBuilder();

        for (int i = cleanStr.length() - 1; i >= 0; i--) {
            reversed.append(cleanStr.charAt(i));
        }

        // Always use .equals() to compare Strings in Java (never ==)
        return cleanStr.equals(reversed.toString());
    }

    void main() {
        String word = "madam";

        if (isPalindrome(word)) {
            IO.println(word + " is a Palindrome String");
        } else {
            IO.println(word + " is Not a Palindrome String");
        }
    }
}

/*
Input: str = "madam"

Step 1:
cleanStr = "madam"
reversed = ""

Step 2: Reverse the string using a backwards for loop

i = 4 -> 'm' -> reversed = "m"
i = 3 -> 'a' -> reversed = "ma"
i = 2 -> 'd' -> reversed = "mad"
i = 1 -> 'a' -> reversed = "mada"
i = 0 -> 'm' -> reversed = "madam"

Step 3: Compare original and reversed strings
"madam".equals("madam") -> true

Final Output:
madam is a Palindrome String
*/
