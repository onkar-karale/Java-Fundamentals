package problem_solving.basics;

public class ReverseNumber {
    public static int reverse(int n) {
        int reversed = 0;

        while (n != 0) {
            int lastDigit = n % 10;
            reversed = (reversed * 10) + lastDigit;
            n = n / 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        IO.println("1234  -> " + reverse(1234));
        IO.println("1200  -> " + reverse(1200));
        IO.println("7     -> " + reverse(7));
        IO.println("0     -> " + reverse(0));
        IO.println("-567  -> " + reverse(-567));
    }
}
