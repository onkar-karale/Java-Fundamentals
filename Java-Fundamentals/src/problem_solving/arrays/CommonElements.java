package problem_solving.arrays;

public class CommonElements {

    public static boolean findCommonElement(String[] array1, String[] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                // Always use .equals() for String comparison in Java (never ==)
                if (array1[i].equals(array2[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    void main() {
        String[] array1 = {"a", "b", "c", "d"};
        String[] array2 = {"k", "x", "c"};

        IO.println(findCommonElement(array1, array2));
    }
}

/*
Input:
array1 = {"a", "b", "c", "d"}
array2 = {"k", "x", "c"}

Step 1:
i = 0, array1[0] = "a"
Compare with array2:
"a".equals("k") -> FALSE
"a".equals("x") -> FALSE
"a".equals("c") -> FALSE

Step 2:
i = 1, array1[1] = "b"
Compare with array2:
"b".equals("k") -> FALSE
"b".equals("x") -> FALSE
"b".equals("c") -> FALSE

Step 3:
i = 2, array1[2] = "c"
Compare with array2:
"c".equals("k") -> FALSE
"c".equals("x") -> FALSE
"c".equals("c") -> TRUE

Common element found. Method returns true.

Final Output:
true
*/
