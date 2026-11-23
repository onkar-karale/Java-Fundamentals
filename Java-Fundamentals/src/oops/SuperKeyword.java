package oops;

// =====================================================================
// TOPIC 12: JAVA 'super' KEYWORD
// - 'super' refers directly to the immediate parent (superclass) object.
// - Three core uses of 'super':
//   1. Access parent class attributes when shadowed by child (super.field).
//   2. Call a parent class method that was overridden (super.method()).
//   3. Invoke the parent class constructor (super(...))—MUST be the very
//      first line inside the child class constructor.
// =====================================================================

public class SuperKeyword {

    static class Animal {
        String type = "Generic Animal";
        String name;

        public Animal(String name) {
            this.name = name;
            IO.println("Parent Animal constructor called for: " + name);
        }

        public void makeSound() {
            IO.println("Animal makes a generic sound.");
        }
    }

    static class Dog extends Animal {
        String type = "Canine"; // Shadows parent's 'type' field

        public Dog(String name) {
            super(name); // Use 3: Must be line 1 to initialize parent state
            IO.println("Child Dog constructor called.");
        }

        @Override
        public void makeSound() {
            super.makeSound(); // Use 2: Calls parent's overridden method first
            IO.println(name + " says: Woof!");
        }

        public void showTypes() {
            IO.println("Child type  : " + this.type);
            IO.println("Parent type : " + super.type); // Use 1: Reads parent's field
        }
    }

    void main() {
        Dog dog = new Dog("Buddy");
        dog.showTypes();
        dog.makeSound();
    }
}

// SUMMARY:
// - 'super.field' reads shadowed parent fields.
// - 'super.method()' calls the parent's overridden version of a method.
// - 'super(...)' calls the parent constructor (must be line 1 in child constructor).
