package oops.classes;

// =====================================================================
// TOPIC 16: JAVA ANONYMOUS CLASSES
// - An anonymous class is a class WITHOUT a name that is declared and
//   instantiated in a single expression.
// - Useful when you need a one-time object that overrides a method of
//   an existing class OR implements an interface on the fly—without
//   creating a whole separate named subclass file.
// =====================================================================

public class AnonymousClass {

    static class Animal {
        public void makeSound() {
            IO.println("Animal sound");
        }
    }

    interface Greeting {
        void sayHello();
    }

    void main() {
        // 1. Anonymous class extending an existing class and overriding a method
        Animal customAnimal = new Animal() {
            @Override
            public void makeSound() {
                IO.println("Anonymous override: Roar!");
            }
        }; // Notice the semicolon required at the end of the anonymous class expression
        customAnimal.makeSound();

        // 2. Anonymous class implementing an interface on the fly
        Greeting englishGreeting = new Greeting() {
            @Override
            public void sayHello() {
                IO.println("Hello from an anonymous interface implementation!");
            }
        };
        englishGreeting.sayHello();

        // Modern Java Note: For single-method interfaces (Functional Interfaces),
        // you can shorten the anonymous class above into a Lambda expression:
        Greeting lambdaGreeting = () -> IO.println("Hello from a modern Lambda!");
        lambdaGreeting.sayHello();
    }
}

// SUMMARY:
// - Anonymous classes create one-off subclasses or interface implementations inline.
// - Don't forget the closing semicolon '};' after the curly brace.
