package oops.classes;

// =====================================================================
// TOPIC: JAVA METHOD OVERLOADING (COMPILE-TIME POLYMORPHISM)
// - With method overloading, multiple methods inside the same class can
//   share the EXACT SAME NAME as long as their parameter lists differ.
// - JavaScript Comparison:
//   - In JS, defining two functions with the same name overwrites the first.
//   - In Java, all overloaded versions coexist—the compiler picks the right
//     one based on the arguments you pass at call time.
// - Valid ways to overload a method:
//   1. Different parameter data types   -> add(int a, int b) vs add(double a, double b)
//   2. Different number of parameters   -> add(int a, int b) vs add(int a, int b, int c)
//   3. Different order of parameter types -> log(String msg, int code) vs log(int code, String msg)
// - IMPORTANT RULE:
//   - Changing ONLY the return type (e.g., int calc(int x) vs double calc(int x))
//     is NOT valid overloading and causes a compilation error.
// - Real-world use: Instead of inventing awkward names like addTwoInts(),
//   addThreeInts(), and addDoubles(), you expose one clean name: add().
// =====================================================================

public class MethodOverloading {

    // 1. Overloading by DIFFERENT DATA TYPES (int vs double)
    static int plusMethod(int x, int y) {
        return x + y;
    }

    static double plusMethod(double x, double y) {
        return x + y;
    }

    // 2. Overloading by DIFFERENT NUMBER OF PARAMETERS (3 ints instead of 2)
    static int plusMethod(int x, int y, int z) {
        return x + y + z;
    }

    // 3. Overloading by DIFFERENT PARAMETER ORDER
    static void printReceipt(String item, double price) {
        IO.println("Item: %s | Price: INR %.2f".formatted(item, price));
    }

    static void printReceipt(double price, String item) {
        IO.println("INR %.2f paid for %s".formatted(price, item));
    }

    // INVALID OVERLOADING EXAMPLE (Same parameters, only return type differs):
    // static double plusMethod(int x, int y) { return x + y; } // Compilation error!

    void main() {
        int sumTwoInts = plusMethod(8, 5);
        double sumTwoDoubles = plusMethod(4.3, 6.26);
        int sumThreeInts = plusMethod(8, 5, 10);

        IO.println("int (2 params)    : " + sumTwoInts);
        IO.println("double (2 params) : " + sumTwoDoubles);
        IO.println("int (3 params)    : " + sumThreeInts);

        IO.println("");

        // Compiler automatically matches parameter order
        printReceipt("Mechanical Keyboard", 4500.00);
        printReceipt(4500.00, "Mechanical Keyboard");
    }
}

// SUMMARY:
// - Method overloading = same method name, different parameter list (type, count, or order).
// - Decided by the compiler at compile time (Compile-Time Polymorphism).
// - Changing only the return type does NOT qualify as overloading.
// - Keeps APIs clean—just like System.out.println() / IO.println(), which are heavily overloaded
//   behind the scenes to accept String, int, double, boolean, and Object!
