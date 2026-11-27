package basics;

// =====================================================================
// TOPIC: JAVA 'static' KEYWORD & STATIC METHODS
// - 'static' means a member belongs to the CLASS itself, NOT to any
//   individual object instance.
// - Memory Model:
//   - Instance variables -> Each 'new' object gets its own copy on the Heap.
//   - Static variables   -> Loaded ONCE per class and shared by ALL objects.
// - 4 Main Uses of 'static':
//   1. Static Variables  : Shared state or constants (static final).
//   2. Static Methods    : Utility/helper methods called via ClassName.method().
//   3. Static Block      : static { ... } runs ONCE when the class loads.
//   4. Static Nested Class: Inner class usable without an outer class object.
// - THE GOLDEN RULE:
//   - Static methods CANNOT directly access non-static fields/methods or
//     use 'this' / 'super' (because no object is guaranteed to exist).
//   - Instance methods CAN freely access both static and non-static members.
// - WHY 'public static void main(String[] args)' IS STATIC:
//   - When a Java app launches, zero objects exist yet. Marking 'main'
//     static lets the JVM call ClassName.main(args) directly without
//     needing to call 'new ClassName()' first.
//   - (Modern JDK 25+ also allows shorthand 'void main()' by auto-creating
//     an instance behind the scenes, but classic static main remains the
//     standard in Spring Boot and enterprise codebases.)
// =====================================================================
public class StaticKeyword {

    // 1. STATIC CONSTANT (Best practice: UPPER_SNAKE_CASE with 'static final')
    public static final double DEFAULT_TAX_RATE = 0.18;

    // Instance variable on StaticKeyword itself (to demonstrate the Golden Rule)
    String instanceLabel = "I belong to a specific object";

    // 3. STATIC INITIALIZATION BLOCK
    // Runs automatically ONCE when JVM loads StaticKeyword (even BEFORE main!)
    static {
        IO.println("[Static Block] StaticKeyword class loaded into JVM memory.");
        IO.println("[Static Block] Default Tax Rate initialized: " + DEFAULT_TAX_RATE);
        IO.println("");
    }

    // 2. STATIC UTILITY METHOD (Pure calculation—no object state needed)
    public static double calculateTotalWithTax(double baseAmount) {
        // Direct access to static constant works cleanly:
        return baseAmount + (baseAmount * DEFAULT_TAX_RATE);
    }

    // Helper class demonstrating Static vs. Instance variables & methods
    static class Employee {
        // INSTANCE VARIABLES: Unique copy for every Employee object
        private final int id;
        private final String name;

        // STATIC VARIABLES: Single copy shared across ALL Employee objects
        private static String companyName = "JP Morgan";
        private static int totalEmployees = 0;

        public Employee(String name) {
            totalEmployees++;        // Increments the single shared counter
            this.id = totalEmployees;
            this.name = name;
        }

        // INSTANCE METHOD: Can access BOTH instance fields (id, name) AND static fields (companyName)
        public void displayProfile() {
            IO.println("Employee #%d: %s | Company: %s".formatted(id, name, companyName));
        }

        // STATIC METHOD: Belongs to Employee class; called as Employee.showCompanySummary()
        public static void showCompanySummary() {
            IO.println("Company: %s | Total Headcount: %d".formatted(companyName, totalEmployees));

            // IO.println(name);       // Error: Non-static field 'name' cannot be referenced from a static context
            // IO.println(this.id);    // Error: 'this' cannot be referenced from a static context
        }

        // STATIC METHOD updating shared static state for EVERY employee at once
        public static void updateCompanyName(String newName) {
            companyName = newName;
        }
    }

    // 4. STATIC NESTED CLASS (No 'new StaticKeyword()' needed to instantiate it)
    static class AppConfig {
        public static String getEnvironment() {
            return "PRODUCTION";
        }
    }

    // CLASSIC STATIC MAIN: JVM calls StaticKeyword.main(args) directly with zero objects created
    public static void main(String[] args) {
        // Calling static method directly without creating any object
        double bill = StaticKeyword.calculateTotalWithTax(1000.00);
        IO.println("1. Static Utility Method -> Bill with 18%% tax: INR %.2f%n".formatted(bill));

        // Creating multiple Employee objects to see shared vs. unique memory
        Employee emp1 = new Employee("Aarav");
        Employee emp2 = new Employee("Meera");
        Employee emp3 = new Employee("Onkar");

        IO.println("2. Initial Employee Profiles:");
        emp1.displayProfile();
        emp2.displayProfile();
        emp3.displayProfile();

        // Calling static method via ClassName (best practice—never call via emp1.showCompanySummary())
        Employee.showCompanySummary();
        IO.println("");

        // Changing static variable ONCE immediately reflects across ALL existing objects
        Employee.updateCompanyName("JP MORGAN CO. AND CHASE");
        IO.println("3. After Updating Static companyName Once:");
        emp1.displayProfile();
        emp2.displayProfile();
        emp3.displayProfile();
        IO.println("");

        // Demonstrating the Golden Rule fix inside static main():
        // IO.println(instanceLabel); // Compilation error! 'main' is static, 'instanceLabel' is not.
        StaticKeyword demoObj = new StaticKeyword(); // Fix: Create an object first
        IO.println("4. Accessing non-static field via object: " + demoObj.instanceLabel);

        // Accessing static nested class method
        IO.println("5. Static Nested Class Environment: " + AppConfig.getEnvironment());
    }
}

// SUMMARY:
// - 'static' ties a variable, method, or nested class to the Class rather than an Object.
// - Always call static members using ClassName.memberName (never objectName.memberName).
// - Static variables share one memory slot across all instances (ideal for 'static final' constants).
// - Static methods CANNOT directly read non-static fields/methods or use 'this'/'super'.
// - Static blocks run once when the class loads, before main() or any constructor.
// - Classic main() is static so the JVM can launch the program before any object is instantiated.
