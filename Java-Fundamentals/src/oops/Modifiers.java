package oops;

// =====================================================================
// TOPIC 7: JAVA MODIFIERS (ACCESS & NON-ACCESS MODIFIERS)
// Modifiers are split into two groups:
//
// GROUP 1: ACCESS MODIFIERS (Control visibility)
// For top-level classes:
//   - public    : Accessible by any other class in any package.
//   - default   : (No keyword) Accessible ONLY within the same package.
// For attributes, methods, and constructors:
//   - public    : Accessible from everywhere.
//   - private   : Accessible ONLY inside the declared class.
//   - default   : Accessible ONLY inside the same package.
//   - protected : Accessible in the same package AND in subclasses.
//
// GROUP 2: NON-ACCESS MODIFIERS (Provide extra functionality)
// For classes:
//   - final     : Class cannot be inherited by other classes.
//   - abstract  : Class cannot be used to create objects directly.
// For attributes & methods:
//   - final     : Attributes cannot be modified; methods cannot be overridden.
//   - static    : Belongs to the class rather than individual objects.
//   - abstract  : Only in abstract classes; method has no body (implemented by subclass).
//   - transient : Skipped during object serialization.
//   - synchronized : Method accessible by only one thread at a time.
//   - volatile  : Value is always read from main memory, not thread-local cache.
// =====================================================================
public class Modifiers {

    // Abstract class (Non-Access Modifier: abstract)
    static abstract class PersonBase {
        public String name = "Aarav";          // Access: public
        protected String department = "Tech";  // Access: protected
        private final String ssn = "XXX-1234"; // Access: private + Non-Access: final

        // Static variable shared across all instances
        static String organization = "Rajlee Innovations";

        // Abstract method (no body; subclass must implement it)
        public abstract void study();

        // Public method accessing private field safely
        public String getMaskedSsn() {
            return ssn;
        }
    }

    // Final class cannot be extended further
    static final class Student extends PersonBase {
        public int graduationYear = 2026;

        @Override
        public void study() {
            IO.println(name + " (" + department + ") is studying Java for Spring Boot.");
        }
    }

    void main() {
        Student student = new Student();
        IO.println("Org (static): " + PersonBase.organization);
        IO.println("Name (public): " + student.name);
        IO.println("Grad Year: " + student.graduationYear);
        IO.println("Private field via getter: " + student.getMaskedSsn());
        student.study();
    }
}

// SUMMARY:
// - Access modifiers (public, private, protected, default) lock down visibility.
// - Non-access modifiers (final, static, abstract, etc.) define behavior rules.
