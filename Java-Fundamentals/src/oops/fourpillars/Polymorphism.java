package oops.fourpillars;

// =====================================================================
// TOPIC 11: JAVA POLYMORPHISM
// - Polymorphism means "many forms"—occurs when multiple classes are
//   related by inheritance and override the same method to behave differently.
// - Inheritance lets us inherit attributes/methods; Polymorphism lets us
//   use those methods to perform different tasks at runtime.
// - Parent type reference (Animal) can hold any child object (Pig, Dog),
//   and Java dynamically runs the child's overridden version (@Override).
// =====================================================================

public class Polymorphism {

    static class Animal {
        public void animalSound() {
            IO.println("The animal makes a sound");
        }
    }

    static class Pig extends Animal {
        @Override
        public void animalSound() {
            IO.println("The pig says: wee wee");
        }
    }

    static class Dog extends Animal {
        @Override
        public void animalSound() {
            IO.println("The dog says: bow wow");
        }
    }

    void main() {
        // Parent reference pointing to different child implementations
        Animal myAnimal = new Animal();
        Animal myPig = new Pig();
        Animal myDog = new Dog();

        myAnimal.animalSound(); // Runs Animal's version
        myPig.animalSound();    // Runs Pig's overridden version
        myDog.animalSound();    // Runs Dog's overridden version

        // Practical power: treat all subclasses uniformly in one array/loop
        Animal[] zoo = {myAnimal, myPig, myDog};
        IO.println("--- Loop using Polymorphism ---");
        for (Animal a : zoo) {
            a.animalSound();
        }
    }
}

// SUMMARY:
// - Same method call (a.animalSound()), different runtime behavior per subclass.
// - Always annotate overridden methods with @Override so the compiler checks signatures.
