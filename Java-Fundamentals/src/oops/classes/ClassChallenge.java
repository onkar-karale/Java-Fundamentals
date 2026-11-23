package oops.classes;

// =====================================================================
// TOPIC 4: JAVA CLASS CHALLENGE
// - Combines Classes, Objects, Attributes, and Methods into one
//   practical blueprint (modeling a real-world entity with state and
//   behavior).
// - Challenge goal: Create a Car/Product class with attributes, update
//   state via methods, and display formatted object info.
// =====================================================================

public class ClassChallenge {

    static class Car {
        String brand;
        String model;
        int year;
        int currentSpeed = 0;

        public void accelerate(int increase) {
            currentSpeed += increase;
            IO.println(brand + " " + model + " accelerated to " + currentSpeed + " km/h.");
        }

        public void brake(int decrease) {
            currentSpeed = Math.max(0, currentSpeed - decrease);
            IO.println(brand + " " + model + " slowed down to " + currentSpeed + " km/h.");
        }

        public void displayInfo() {
            IO.println("Car Details -> %d %s %s (Current Speed: %d km/h)"
                    .formatted(year, brand, model, currentSpeed));
        }
    }

    void main() {
        Car myCar = new Car();
        myCar.brand = "Honda";
        myCar.model = "Civic";
        myCar.year = 2026;

        myCar.displayInfo();
        myCar.accelerate(60);
        myCar.accelerate(40);
        myCar.brake(30);
        myCar.displayInfo();
    }
}

// SUMMARY:
// - Real OOP objects pair data (attributes) with behavior (methods)
//   that safely reads and updates that data.
