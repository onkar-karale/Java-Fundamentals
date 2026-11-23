package basics;

// =====================================================================
// JAVA VARIABLES, DATA TYPES, WRAPPERS, STRINGS & SCOPES
//
// 1. VARIABLES:
//    - Named containers that store data with a fixed type checked at compile time.
//    - Declared as: <type> <name> = <value>; (can be updated unless 'final').
//
// 2. DATA TYPES:
//    - Primitive Types (8) : byte, short, int, long (L), float (f), double,
//                            boolean, char. Fast raw values; CANNOT be null.
//    - Reference Types     : String, Arrays, Objects, Wrapper Classes. Store
//                            memory references; CAN be null.
//
// 3. 'final' & 'var':
//    - 'final' : Constant variable—can be assigned only once (like JS const).
//    - 'var'   : Local variable type inference—compiler locks the type once.
//
// 4. PRIMITIVES VS. WRAPPER CLASSES (Double, Integer, etc.):
//    - Every primitive has an Object counterpart (int -> Integer, double -> Double).
//    - Needed for null handling, Collections (List<Integer>), and utility methods
//      like Integer.parseInt(), Integer.valueOf(), Integer.max(), Integer.compare().
//    - Autoboxing converts primitive -> wrapper; Unboxing converts wrapper -> primitive.
//    - Always compare Wrapper objects (Integer/Long) using .equals(), NOT ==.
//
// 5. STRINGS & TEXT BLOCKS:
//    - Always compare String text using .equals(), never == (which compares memory).
//    - Text Blocks (""") with .formatted(...) build clean multi-line strings.
//
// 6. TYPES OF VARIABLES:
//    - Local Variable    : Declared inside a method/constructor/block.
//    - Instance Variable : Declared inside a class; each object gets its own copy.
//    - Static Variable   : Declared with 'static'; shared across all objects of a class.
//
// 7. SCOPE OF VARIABLES:
//    - Block Scope  : Accessible only inside the { ... } block where declared.
//    - Method Scope : Accessible only inside the method where declared.
// =====================================================================
public class VariablesAndTypes {
    void main() {
        // Variables allow programs to store and manipulate information.
        String employeeName = "Riya";
        int employeeAge = 28;
        double employeeSalary = 75000.50;
        boolean isActive = true;

        // Declaration and initialization of variables:
        int age = 25;
        IO.println(age);
        // Updating the existing variable
        age = 26;
        IO.println(age);

        IO.println(""); // Moves to a new line after the loop finishes

        // Primitive Data Types:
        byte smallNumber = 127;          // 8-bit signed integer
        short mediumNumber = 32000;      // 16-bit signed integer
        int number = 100000;             // 32-bit signed integer
        long largeNumber = 123456789L;   // 64-bit signed integer; L suffix indicates long type
        float piApprox = 3.14f;          // 32-bit floating-point; f suffix indicates float type
        double precisePi = 3.14159265359; // 64-bit floating-point
        boolean isJavaFun = true;        // Boolean type: true or false
        char initial = 'J';              // 16-bit Unicode character

        // Displaying primitive data types
        IO.println("Byte: " + smallNumber + ", Short: " + mediumNumber + ", Int: " + number);
        IO.println("Long: " + largeNumber + ", Float: " + piApprox + ", Double: " + precisePi);
        IO.println("Boolean: " + isJavaFun + ", Char: " + initial);

        IO.println("");

        // Reference Data Types
        String greeting = "Hello, Java!";  // String is a reference type
        int[] numbersArray = {1, 2, 3, 4, 5};  // Array is a reference type

        // Displaying reference data types
        IO.println("String value: " + greeting);

        IO.print("Array values: ");
        for (int num : numbersArray) {
            IO.print(num + " "); // Using IO.print() keeps all numbers on one line!
        }

        IO.println("");

        // Explicit types, final, and var
        final String appName = "PaymentGateway"; // A variable declared with final can be assigned only once.
        // appName = "Payment";  Compilation error because appName cannot be reassigned.

        // Type Inference with var:
        // Java supports local variable type inference using var.
        var retryLimit = 3; // Inferred as int
        var name = "Aarav"; // Inferred as string
        var salary = 75000.50; // Inferred as double

        long transactionId = 9_876_543_210L; // Underscores allowed for readability

        // Primitive vs Wrapper (null handling)
        double baseAmount = 499.50;
        Double discountAmount = null; // Wrapper can be null; primitive 'double' cannot
        double appliedDiscount = (discountAmount != null) ? discountAmount : 0.0;
        double finalAmount = baseAmount - appliedDiscount;

        IO.println("");

        // Integer Wrapper Class & Common Methods:
        // Integer is the Object wrapper for primitive 'int' (required for nullability & Collections like List<Integer>).
        int primitiveInt = 42;
        Integer boxedInt = primitiveInt;   // Autoboxing: primitive int -> Integer object
        int unboxedInt = boxedInt;         // Unboxing: Integer object -> primitive int
        Integer nullableScore = null;      // Allowed because Integer is a reference type

        // Useful Integer Constants (limits of a 32-bit int):
        IO.println("Integer MIN_VALUE: " + Integer.MIN_VALUE + ", MAX_VALUE: " + Integer.MAX_VALUE);

        // Parsing & Conversion Methods (heavily used when reading API/JSON strings):
        int parsedNumber = Integer.parseInt("250");        // String -> primitive int
        Integer wrapperFromString = Integer.valueOf("250");// String -> Integer object
        String intAsString = Integer.toString(boxedInt);   // int -> String

        // Comparison & Math Utility Methods:
        IO.println("Autoboxed: " + boxedInt + ", Unboxed: " + unboxedInt + ", Nullable: " + nullableScore);
        IO.println("parseInt: " + parsedNumber + ", valueOf: " + wrapperFromString + ", toString: " + intAsString);
        IO.println("Integer.max(10, 25): " + Integer.max(10, 25) + ", Integer.min(10, 25): " + Integer.min(10, 25));
        IO.println("Integer.sum(10, 25): " + Integer.sum(10, 25) + ", Integer.compare(10, 25): " + Integer.compare(10, 25));

        // Integer Equality Trap (same as String: always use .equals() for Wrapper objects):
        // Java caches Integer objects only from -128 to 127; outside that range, '==' returns false!
        Integer largeId1 = 200;
        Integer largeId2 = 200;
        IO.println("Integer using == (200 == 200): " + (largeId1 == largeId2));          // false!
        IO.println("Integer using .equals(): " + largeId1.equals(largeId2));            // true!

        // String equality trap (== vs .equals)
        String expectedRole = "ADMIN";
        String incomingRole = new String("ADMIN"); // Simulates dynamic input from an API
        boolean isAuthorized = expectedRole.equals(incomingRole);

        IO.println("");

        // Text Block combining all variables (like JS template literals)
        String receipt = """
                ====================================
                       %s RECEIPT
                ====================================
                Customer Name   : %s
                Declared Salary : %.2f
                Role Provided   : %s (Authorized: %b)
                ------------------------------------
                Transaction ID  : %d
                Retries Allowed : %d
                Base Amount     : %.2f
                Discount        : -%.2f
                Total Paid      : %.2f
                ====================================
                """.formatted(
                appName,
                name,
                salary,
                incomingRole,
                isAuthorized,
                transactionId,
                retryLimit,
                baseAmount,
                appliedDiscount,
                finalAmount
        );

        IO.println(receipt);

        // Types of Variables in Java:
        // 1. Local Variables: A local variable is declared inside a method, constructor, or block.
        // EXAMPLE:
        int value = 50;
        if (value > 0) {
            int result = value * 2; // Local to this 'if' block
            IO.println("Local variable result: " + result);
        }

        // 2. Instance variable: An instance variable is declared inside a class but outside any method, constructor, or block. Each object gets its own copy of instance variables.
        // EXAMPLE:
        Student firstStudent = new Student();
        firstStudent.name = "Aarav";
        firstStudent.age = 20;

        Student secondStudent = new Student();
        secondStudent.name = "Meera";
        secondStudent.age = 21;

        IO.println("Student 1: " + firstStudent.name + " (" + firstStudent.age + ")");
        IO.println("Student 2: " + secondStudent.name + " (" + secondStudent.age + ")");

        // 3. Static Variable: A static variable belongs to the class rather than to individual objects. It is declared using the static keyword.
        // EXAMPLE:
        Employee firstEmployee = new Employee("Aarav");
        Employee secondEmployee = new Employee("Meera");

        IO.println("Employee 1: " + firstEmployee.name);
        IO.println("Employee 2: " + secondEmployee.name);
        IO.println("Shared Company: " + Employee.companyName);

        IO.println("");

        // Scope of Variables:
        // Scope defines where a variable can be accessed.

        // 1. Block Scope: A variable declared inside a block exists only within that block.
        // EXAMPLE:
        int scopeNumber = 10;
        {
            int doubledNumber = scopeNumber * 2;
            IO.println("Block scope doubledNumber: " + doubledNumber);
        }
        // IO.println(doubledNumber); // Compilation error: doubledNumber is not accessible here.

        // 2. Method Scope: A local variable can be used only inside the method where it is declared.
        // EXAMPLE:
        int result = calculateSum();
        IO.println("Method scope calculateSum result: " + result);
        // IO.println(firstNumber); // Compilation error: firstNumber and secondNumber cannot be accessed directly from main.
    }

    // Helper method for Method Scope example
    public static int calculateSum() {
        int firstNumber = 10;
        int secondNumber = 20;

        return firstNumber + secondNumber;
    }
}

// Helper Class 1 (No 'public' keyword because it shares this file)
class Student {
    String name; // Instance variable
    int age;     // Instance variable
}

// Helper Class 2 (No 'public' keyword because it shares this file)
class Employee {
    String name;                               // Instance variable (unique per employee)
    static String companyName = "TechCorp";    // Static variable (shared by all employees)

    public Employee(String name) {
        this.name = name;
    }
}

// SUMMARY:
// - A variable stores data under a name.
// - Every Java variable has a type, name, value, scope, and lifetime.
// - Local variables are declared inside methods or blocks.
// - Instance variables belong to objects.
// - Static variables belong to classes and are shared.
// - Primitive variables store simple values.
// - Reference variables point to objects.
// - Wrapper classes (Integer, Double, Long) wrap primitives into Objects for nullability, Collections, and utility methods (parseInt, valueOf, max, min, compare).
// - Always use .equals()—not ==—when comparing String or Wrapper objects (like Integer/Long).
// - final variables cannot be reassigned.
// - Java is statically typed, so variable types are checked at compile time.
// - Local variables must be initialized before use.
// - Use descriptive names and follow Java naming conventions.
// - Widening conversions happen automatically, while narrowing conversions require casting.