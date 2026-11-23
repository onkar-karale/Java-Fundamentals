package oops;

// =====================================================================
// TOPIC 15: JAVA INTERFACE
// - An interface is a completely "abstract contract" grouping related
//   methods with empty bodies.
// - Use 'implements' (NOT 'extends') for a class to fulfill an interface.
// - Key Rules:
//   1. Interfaces CANNOT be used to create objects directly and have NO constructors.
//   2. Interface methods are implicitly 'public' and 'abstract'.
//   3. Interface attributes are implicitly 'public', 'static', and 'final'.
//   4. On implementation, you MUST override all abstract methods.
//   5. Multiple Interfaces: Java does not allow extending multiple classes,
//      but a class CAN implement multiple interfaces separated by commas!
// =====================================================================

public class Interface {

    // Interface 1
    interface Animal {
        void animalSound(); // Implicitly public abstract
        void sleep();
    }

    // Implementing a single interface
    static class Pig implements Animal {
        @Override
        public void animalSound() {
            IO.println("The pig says: wee wee");
        }

        @Override
        public void sleep() {
            IO.println("Zzz");
        }
    }

    // Multiple Interfaces example
    interface FirstInterface {
        void myMethod();
    }

    interface SecondInterface {
        void myOtherMethod();
    }

    // A single class implementing TWO interfaces at once
    static class DemoClass implements FirstInterface, SecondInterface {
        @Override
        public void myMethod() {
            IO.println("Implemented from FirstInterface.");
        }

        @Override
        public void myOtherMethod() {
            IO.println("Implemented from SecondInterface.");
        }
    }

    void main() {
        Pig myPig = new Pig();
        myPig.animalSound();
        myPig.sleep();

        DemoClass multi = new DemoClass();
        multi.myMethod();
        multi.myOtherMethod();
    }
}

// SUMMARY:
// - Interfaces define pure contracts ('implements') and enable multiple inheritance.
// - Spring Boot uses interfaces heavily for Repositories and Services.
