package oops.fourpillars;

// =====================================================================
// TOPIC 14: JAVA ABSTRACTION
// - Abstraction hides internal implementation details and exposes only
//   essential features to the user (achieved via abstract classes or interfaces).
// - Rules of 'abstract':
//   1. Abstract class: Restricted class that CANNOT be instantiated with 'new'.
//      To use it, another class must inherit it with 'extends'.
//   2. Abstract method: Can ONLY live in an abstract class and has NO body.
//      The subclass MUST provide the body (@Override).
//   3. An abstract class can contain BOTH abstract methods and regular
//      (concrete) methods with full bodies.
// =====================================================================
public class Abstraction {

    // Abstract parent class (cannot do: new Animal())
    static abstract class Animal {
        // Abstract method (no body—forces every subclass to define its own sound)
        public abstract void animalSound();

        // Regular (concrete) method inherited as-is by all subclasses
        public void sleep() {
            IO.println("Zzz...");
        }
    }

    // Subclass provides the missing implementation
    static class Pig extends Animal {
        @Override
        public void animalSound() {
            IO.println("The pig says: wee wee");
        }
    }

    void main() {
        // Animal a = new Animal(); // Compilation error: Animal is abstract; cannot be instantiated

        Pig myPig = new Pig();
        myPig.animalSound(); // Implemented by Pig
        myPig.sleep();       // Inherited regular method from Animal
    }
}

// SUMMARY:
// - Use 'abstract class' when subclasses share common code AND must implement
//   specific custom methods.
// - Abstract classes cannot be instantiated directly.
