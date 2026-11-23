package oops.classes;

// =====================================================================
// TOPIC 3: JAVA CLASS METHODS
// - Methods are declared inside a class to perform specific actions.
// - 'static' method: belongs to the class; called WITHOUT creating an object.
// - 'public' (non-static / instance) method: belongs to an object;
//   MUST be called on an instance created with 'new'.
// =====================================================================

public class ClassMethods {

    // Static method: belongs to ClassMethodsDemo itself
    static void myStaticMethod() {
        IO.println("Static methods can be called without creating objects.");
    }

    // Instance (non-static) methods inside a separate Car blueprint
    static class Car {
        public void fullThrottle() {
            IO.println("The car is going as fast as it can!");
        }

        // Method accepting a parameter
        public void speed(int maxSpeed) {
            IO.println("Max speed is: " + maxSpeed + " km/h");
        }
    }

    void main() {
        // 1. Calling a static method directly (no object required)
        myStaticMethod();

        // 2. Calling instance methods requires creating an object first
        Car myCar = new Car();
        myCar.fullThrottle();
        myCar.speed(200);
    }
}

// SUMMARY:
// - 'static' methods are called via ClassName.method() or directly inside the class.
// - Non-static (instance) methods require an object: myObj.method().
// - Methods can take parameters to customize behavior per call.
