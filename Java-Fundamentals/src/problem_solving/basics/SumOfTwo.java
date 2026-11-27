package problem_solving.basics;

public class SumOfTwo {
    public static int sumOfTwoNumbers(int a, int b) {
        int result = a + b;
        return result;
    }

    public static void main(String[] args){
        IO.println("Sum of two numbers are: " + sumOfTwoNumbers(10, 20));
    }
}
