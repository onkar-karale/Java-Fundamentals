package oops.fourpillars;

// =====================================================================
// TOPIC 10: JAVA INHERITANCE
// - Allows one class to inherit attributes and methods from another class.
// - Terminology:
//   - Superclass (parent): The class being inherited from.
//   - Subclass (child)   : The class that inherits using 'extends'.
// - 'protected' modifier: Allows subclasses to access parent fields directly.
// - 'final' class: Prevents any other class from extending it.
// - Why use it? Code reusability—write shared fields/methods once in parent.
// - Note: Java supports single class inheritance (a class can only extend
//   ONE parent class). For multiple inheritance, use Interfaces.
// =====================================================================

public class Inheritance {

    // Superclass (Parent)
    static class Vehicle {
        protected String brand = "Ford"; // Accessible to subclasses

        public void honk() {
            IO.println("Tuut, tuut!");
        }
    }

    // Subclass (Child) inherits brand and honk() from Vehicle
    static class Car extends Vehicle {
        private String modelName = "Mustang";

        public String getModelName() {
            return modelName;
        }
    }

    // Final class cannot be inherited
    static final class SealedTruck {
        String info = "Cannot be extended by any subclass.";
    }
    // static class MiniTruck extends SealedTruck {} // Compilation error!

    void main() {
        Car myCar = new Car();

        // Calling method inherited from Vehicle superclass
        myCar.honk();

        // Accessing inherited 'brand' field + Car's own 'modelName'
        IO.println(myCar.brand + " " + myCar.getModelName());
    }
}

// SUMMARY:
// - Use 'class Child extends Parent' to inherit fields and methods.
// - Use 'protected' for fields meant to be shared with subclasses.
// - Mark a class 'final' to block inheritance.
