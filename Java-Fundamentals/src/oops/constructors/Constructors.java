package oops.constructors;

// =====================================================================
// TOPIC 5: JAVA CONSTRUCTORS
// - A constructor is a special method used to initialize objects.
// - It is called automatically the moment an object is created with 'new'.
// - Rules:
//   1. Constructor name MUST match the exact class name.
//   2. It CANNOT have a return type (not even 'void').
//   3. All classes have a default no-arg constructor if you don't write one.
//      (If you define a parameterized constructor, Java stops generating
//      the default no-arg constructor unless you write it yourself.)
// - Constructor Overloading: A class can have multiple constructors with
//   different parameter lists.
// =====================================================================
public class Constructors {

    static class Car {
        int modelYear;
        String modelName;

        // 1. No-argument constructor (sets default initial values)
        public Car() {
            modelYear = 2025;
            modelName = "Standard Edition";
        }

        // 2. Parameterized constructor (initializes attributes dynamically)
        public Car(int year, String name) {
            modelYear = year;
            modelName = name;
        }
    }

    void main() {
        // Calls the no-arg constructor
        Car defaultCar = new Car();
        IO.println("Default Car: " + defaultCar.modelYear + " " + defaultCar.modelName);

        // Calls the parameterized constructor
        Car customCar = new Car(1969, "Mustang");
        IO.println("Custom Car: " + customCar.modelYear + " " + customCar.modelName);
    }
}

// SUMMARY:
// - Constructors initialize object attributes at creation time.
// - Exact same name as the class, zero return type.
// - Overload constructors to support different ways of building an object.
